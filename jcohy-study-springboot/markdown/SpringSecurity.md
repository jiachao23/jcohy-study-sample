#### 作者网页：[www.jcohy.com](http://www.jcohy.com)
> #### PS:待开发中。。。。
>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。
>
> #### PS:我的学习笔记,点击可以跳转到相应分类

# Spring Security

## Spring Security介绍

### Spring Security支持的认证模式

#### Basic：

	Basic 认证是HTTP 中非常简单的认证方式，因为简单，所以不是很安全，不过仍然非常常用。

	当一个客户端向一个需要认证的HTTP服务器进行数据请求时，如果之前没有认证过，HTTP服务器会返回401状态码，要求客户端输入用户名和密码。用户输入用户名和密码后，用户名和密码会经过BASE64加密附加到请求信息中再次请求HTTP服务器，HTTP服务器会根据请求头携带的认证信息，决定是否认证成功及做出相应的响应。

#### Digest:http://www.faqs.org/rfcs/rfc2617.html

	摘要认证（ Digest authentication）是一个简单的认证机制，最初是为HTTP协议开发的，因而也常叫做HTTP摘要，在[RFC2617](http://www.faqs.org/rfcs/rfc2617.html)中描述。其身份验证机制很简单，它采用杂凑式（hash）加密方法，以避免用明文传输用户的口令。

摘要认证就是要核实，参与通信的双方，都知道双方共享的一个秘密（即口令）。

#### x.509:

	数字证书的格式遵循[X.509标准](https://baike.baidu.com/item/X.509%E6%A0%87%E5%87%86)。X.509是由[国际电信联盟](https://baike.baidu.com/item/%E5%9B%BD%E9%99%85%E7%94%B5%E4%BF%A1%E8%81%94%E7%9B%9F/502493)（ITU-T）制定的数字证书标准。

#### LDAP:

	LDAP是轻量[目录访问协议](https://baike.baidu.com/item/%E7%9B%AE%E5%BD%95%E8%AE%BF%E9%97%AE%E5%8D%8F%E8%AE%AE)，英文全称是Lightweight Directory Access Protocol，一般都简称为LDAP。它是基于X.500标准的，但是简单多了并且可以根据需要定制。与X.500不同，LDAP支持TCP/IP，这对访问Internet是必须的。LDAP的核心规范在RFC中都有定义，所有与LDAP相关的RFC都可以在LDAPman RFC网页中找到。

#### Form:

	表单认证

![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-springboot/images/ss.jpg)

### Spring Security提供了的过滤器

![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-springboot/images/ss2.jpg)

#### SecurityContextPersistenceFilter

	SecurityContextPersistenceFilter主要是在SecurityContextRepository中保存更新一个securityContext，并将securityContext给以后的过滤器使用

​	本质上就是在session中生成一个securityContext——httpSession.setAttribute(springSecurityContextKey, context);

它的逻辑是这样的

SecurityContextPersistenceFilter：

```java
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		if (request.getAttribute(FILTER_APPLIED) != null) {
			// ensure that filter is only applied once per request
			chain.doFilter(request, response);
			return;
		}

		final boolean debug = logger.isDebugEnabled();

		request.setAttribute(FILTER_APPLIED, Boolean.TRUE);

		if (forceEagerSessionCreation) {
			HttpSession session = request.getSession();
		}

		HttpRequestResponseHolder holder = new HttpRequestResponseHolder(request,
				response);

    	//获取SecurityContext
		SecurityContext contextBeforeChainExecution = repo.loadContext(holder);

		try {

            //将securiryContext放入SecurityContextHolder中
			SecurityContextHolder.setContext(contextBeforeChainExecution);
			//执行下面的过滤器chain.doFilter(holder.getRequest(), holder.getResponse());
			chain.doFilter(holder.getRequest(), holder.getResponse());

		}
		finally {
			SecurityContext contextAfterChainExecution = SecurityContextHolder
					.getContext();
			//清空SecurityContextHolder中的securityContext
			SecurityContextHolder.clearContext();
            //，并将securityContext（这个securityContext保存有后面过滤器生成的数据）放入SecurityContextRepository中，也就是执行SecurityContextRepository.saveContext()；
			repo.saveContext(contextAfterChainExecution, holder.getRequest(),
					holder.getResponse());
			request.removeAttribute(FILTER_APPLIED);
		}
	}
```
HttpSessionSecurityContextRepository：

```java
public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
		HttpServletRequest request = requestResponseHolder.getRequest();
		HttpServletResponse response = requestResponseHolder.getResponse();
		HttpSession httpSession = request.getSession(false);

    	/*判断session是否存在，如果存在先尝试从session中
    	 * httpSession.getAttribute(springSecurityContextKey）获取securityContext，获取不		    *到或则session不存在，返回null
    	 */
		SecurityContext context = readSecurityContextFromSession(httpSession);
		//判断securityContext是否为null，为null则新建一个securityContextImpl
		if (context == null) {
			context = generateNewContext();
		}
		//将当前的securityContext的信息备份到SaveToSessionResponseWrapper，用户在后面的saveContext进行比较处理
		SaveToSessionResponseWrapper wrappedResponse = new SaveToSessionResponseWrapper(
				response, request, httpSession != null, context);
		requestResponseHolder.setResponse(wrappedResponse);

		if (isServlet3) {
			requestResponseHolder.setRequest(new Servlet3SaveToSessionRequestWrapper(
					request, wrappedResponse));
		}
		//返回一个securityContext
		return context;
	}

protected void saveContext(SecurityContext context) {
			final Authentication authentication = context.getAuthentication();
			HttpSession httpSession = request.getSession(false);
			//判断SecurityContext中的authentication是否为空或者是不是Anonymous角色，
    		//这个的作用是如果你的权限过期了或者不具有权限，那么session就不不应该还存在securityContext
			if (authentication == null || trustResolver.isAnonymous(authentication)) {
				//如果是的话再判断session是否存在，如果session存在并且securityContext不为空的话，就从session将securityContext删除
				if (httpSession != null && authBeforeExecution != null) {

					httpSession.removeAttribute(springSecurityContextKey);
				}
				return;
			}

			if (httpSession == null) {
				httpSession = createNewSessionIfAllowed(context);
			}
//判断session是否为空，如果不为空，则比较securityContext是否有更新过（会与SaveToSessionResponseWrapper中的securityContext内容作比较），有的话，就更新下一下httpSession.setAttribute(springSecurityContextKey, context);
			if (httpSession != null) {
				if (contextChanged(context)
						|| httpSession.getAttribute(springSecurityContextKey) == null){
					httpSession.setAttribute(springSecurityContextKey, context);


				}
			}
		}

```

#### LogoutFilter

用来处理url为“/logout”的请求，LogoutFilter首先把请求交给SecurityContextLogoutHandler来处理, 而SecurityContextLogoutHandler只做了两件事, 1) 把当前session无效化, 2) 从SecurityContext里注销当前授权用户。3)重定向到注销成功页面

LogoutFilter：

```java

public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
		throws IOException, ServletException {
	HttpServletRequest request = (HttpServletRequest) req;
	HttpServletResponse response = (HttpServletResponse) res;

	if (requiresLogout(request, response)) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (logger.isDebugEnabled()) {
			logger.debug("Logging out user '" + auth + "' and transferring to logout destination");
		}

		// 此处的handler是一个SecurityContextLogoutHandler的实例
		for (LogoutHandler handler : handlers) {
			handler.logout(request, response, auth);
		}

		// logoutSuccessHandler就是在<logout>标签里指定的自定义handler
		logoutSuccessHandler.onLogoutSuccess(request, response, auth);

		return;
	}

	chain.doFilter(request, response);
}
```

SecurityContextLogoutHandler：

```java
public void logout(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) {
   Assert.notNull(request, "HttpServletRequest required");
   if (invalidateHttpSession) {
      HttpSession session = request.getSession(false);
      if (session != null) {
         logger.debug("Invalidating session: " + session.getId());
         session.invalidate();
      }
   }

   if (clearAuthentication) {
      SecurityContext context = SecurityContextHolder.getContext();
      context.setAuthentication(null);
   }

   SecurityContextHolder.clearContext();
}
```

#### AbstractAuthenticationProcessingFilter

​	AbstractAuthenticationProcessingFilter 是处理form登录的过滤器。 与form登录有关的所有从操作都在里面进行的

#### DefaultLoginPageGeneratingFilter

​	用来生成一个默认的登录页面

#### BasicAuthenticationFilter

​	用来进行Basic认证

#### SecurityContextHolderAwareRequestFilter

​	用来包装客户的请求，并提供一些额外的数据

#### RememberMeAuthenticationFilter

​	实现RemenberMe功能

#### AnonymousAuthenticationFilter

​	匿名用户

#### ExceptionTranslationFilter

​	异常

#### SessionManagementFilter

​	为了防御会话伪造攻击

#### FilterSecurityIntercptor

​	1）、用过用户尚未登录，抛出尚未认证的异常

​	2）、用过用户尚已登录，但没有访问当前资源的权限，抛出拒绝访问的异常

​	3）、用过用户尚已登录，并且有访问当前资源的权限则通过


