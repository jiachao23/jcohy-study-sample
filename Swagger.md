#  Swagger
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。
## Swagger
>   * [Swagger简介](#what)
>   * [Swagger的使用](#how)
>   * [Swagger在Java中常用注解](#annotations)
>   * [Swagger在SpringBoot集成](#jicheng)


<p id="what">

##  Swagger简介

>  *  Swagger是全球最大的OpenAPI规范（OAS）API开发工具框架，支持从设计和文档到测试和部署的整个API生命周期的开发。提高服务端和前端以及移动端的对接效率。
>  *  Swagger-editor：在一个功能强大的编辑器中设计新的API或编辑现有的API，这种编辑器可以通过简洁，实时的反馈和错误处理直观地呈现OAS/Swagger定义。就是一个在线编辑文档说明文件（swagger.json或swagger.yaml文件）的工具，以方便生态中的其他小工具（swagger-ui）等使用。
>  *  Swagger-ui:从OAS/Swagger定义中可视化您的API资源，并生成可在任何环境中托管的漂亮的交互式文档，从而使最终用户可以轻松开始使用API。就是用来显示Api文档接口的
>  *  Swagger-Inspector：是一款超快的API测试工具，可轻松调用和验证基于REST，GraphQL和SOAP的Web服务，以确保它们正常运行。类型是Redis最基本的数据类型，一个redis中字符串value最多可以是512M。就是用来测试文档的。
>  *  Swagger-codegen：通过将OAS / Swagger定义转换为代码，以40多种不同语言生成服务器存根和客户端库，从而快速构建API，从而实现开发和原型设计。就是代码生成器，脚手架。可以根据swagger.json或者swagger.yml文件生成指定的计算机语言指定框架的代码。
>  *  有关Swagger和这些工具的的详情请访问 [Swagger官网](https://swagger.io/)

<p id="how">

##  Swagger的使用

>  *  Swagger的使用方式有两种，一种是通过Swagger-editor定义YAML文件，然后可以生成各种语言的代码框架，对于后台程序员来说，较少人会愿意写出一堆YAML格式。
>  *  swagger有各种语言的插件，可以集成到你的项目之中，通过配置及少量代码，生成接口文档及测试界面。

<p id="annotations">

##  Swagger在Java中常用注解

>  *  @Api：修饰整个类，描述Controller的作用
>  *  @ApiOperation：描述一个类的一个方法，或者说一个接口,表示一个http请求的操作。
>  *  @ApiParam：单个参数描述(用于方法，参数，字段说明)，表示对参数的添加元数据（说明或是否必填等）。
>  *  @ApiModel：表示对类进行说明，用于参数用实体类接收。
>  *  @ApiModelProperty：用于方法，字段，表示对model属性的说明或者数据操作更改。
>  *  @ApiIgnore: 用于类，方法，方法参数,表示这个方法或者类被忽略。
>  *  @ApiImplicitParam: 用于方法 表示单独的请求参数。
>  *  @ApiImplicitParams: 用于方法，包含多个 @ApiImplicitParam
>  *  @ApiResponse：HTTP响应其中1个描述
>  *  @ApiResponses：HTTP响应整体描述
>  *  详细描述至 [Swagger注解](https://www.jianshu.com/p/12f4394462d5)

<p id="jicheng">

##  Swagger在SpringBoot集成

[Swagger在SpringBoot集成](http://www.cnblogs.com/woshimrf/p/swagger.html)