#### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	
> #### PS:待开发中。。。。

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

> #### PS:我的学习笔记,点击可以跳转到相应分类

## BCryptPasswordEncoder


### BCryptPasswordEncoder加解密源码分析

#### 
在使用Spring Security管理用户帐号密码的中，我们经常会用到BCryptPasswordEncoder来对密码进行加密(encode)与密码匹配(matches)。因为
BCryptPasswordEncoder提供了一种强哈希算法来对密码进行加密，也就是说即使是密码相同，每次加密后的值都不相同。增强了密码的安全性。
为什么会这样？他采用的算法究竟是什么样子的？每次的密码加密后的值不同，又是如何来验证的？

bcrypt是Blowfish加密算法的一个变体，并引入了一个工作因子，允许您确定哈希函数的开销


[How To Safely Store A Password](https://codahale.com/how-to-safely-store-a-password/)
