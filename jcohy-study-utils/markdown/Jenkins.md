
# Jenkins
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## ArrayList
> * [概述](#gaishu)
> * [安装](#install)
> * [配置](#config)
> * [创建工程](#create)
> * [创建webhook](#webhook)

<p class="gaishu"></p>

##  概述

####  什么是持续集成？

持续集成是一个开发的实践，需要开发人员定期集成代码到共享存储库。这个概念是为了消除发现的问题，后来出现在构建生命周期的问题。持续集成要求开发人员有频繁的构建。最常见的做法是，每当一个代码提交时，构建应该被触发。

#### Jenkins是什么?
Jenkins是一款开源CI&CD软件，用于自动化各种任务，包括构建、测试和部署软件。
Jenkins支持各种运行方式，可通过系统包,Docker或者通过一个独立的Java程序。

#### Jenkins特性

- ##### 持续集成和持续交付

  作为一个可扩展的自动化服务器，Jenkins可以用作简单的CI服务器，或者变成任何项目的连续交付中心。

- ##### 简易安装

  Jenkins是一个独立的基于Java的程序，可以立即运行，包含Windows，Mac OS X和其他类Unix操作系统。

- ##### 配置简单

  Jenkins可以通过其网页界面轻松设置和配置，其中包括即时错误检查和内置帮助。

- ##### 插件

  通过更新中心中的1000多个插件，Jenkins集成了持续集成和持续交付工具链中几乎所有的工具。

- ##### 扩展

  Jenkins 可以通过其插件架构进行扩展，从而为 Jenkins 可以做的事提供几乎无限的可能性。

- ##### 分布式

  Jenkins可以轻松地在多台机器上分配工作，帮助更快速地跨多个平台推动构建，测试和部署。
  
#### 传统J2EE项目部署方式对比

1. 手动部署

   ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins01.jpg)

2. 自动化部署

“自动化”的具体体现：向版本库提交新的代码后，应用服务器上自动部署，用户
或测试人员使用的马上就是最新的应用程序。

![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins02.jpg)


<p class="install"></p>

## 安装

Jenkins的安装可参考官方文档，里面有很详细的安装教程

[Jenkins安装](https://jenkins.io/zh/doc/book/installing/)

#### 您的jenkins处于离线模式

在安装后打开网页时可能会出现这个问题，解决方法如下:

1. 解决方法1：进入：ip:端口/pluginManager/advanced 修改升级站点中的地址，把https: 改成http: 并且点那个提交按钮。

  该文件为jenkins下载插件的源地址，改地址默认jenkins默认为：https://updates.jenkins.io/update-center.json，就是因为https的问题，此处我们将其改为http即可，之后重启jenkins服务即可。

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins03.jpg)

2. 解决方法2：修改/var/lib/jenkins/updates/default.json，所以图下的google改为www.baidu.com即可，更改完重启服务。

  jenkins在下载插件之前会先检查网络连接，其会读取这个文件中的网址。默认是访问谷歌

![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins04.jpg)

<p class="config"></p>

## 常用配置

#### 全局安全配置

![全局安全配置](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins05.jpg)

![全局安全配置](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins06.jpg)

#### 全局工具配置

![全局工具配置](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins12.jpg)

	配置下面这些工具时，请确保服务上已安装此工具。

![全局工具配置](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins07.jpg)

 * JDK

   ![JDK](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins08.jpg)

 * Maven

   ![Maven](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins10.jpg)

 * Gradle

   ![Gradle](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins09.jpg)

 * Git

	![Git](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins11.jpg)
	
#### 安装插件

![安装插件](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins13.jpg)

![安装插件](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins14.jpg)

安装插件时受到网络状况的时候可能会失败，可以多尝试几次。

#### 配置邮件发送

[配置邮件发送](http://www.cnblogs.com/imyalost/p/8781759.html)

<p class="create"></p>

## 创建工程

 * 创建工程

   ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins15.jpg)

 * 指定工程名称和工程类型

   ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins16.jpg)

 * 源码管理

   ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins17.jpg)

 * 构建

   ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins18.jpg)

   ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins20.jpg)

 * 构建后操作

   构建后我们可以执行一些操作，例如将构建后的war包放到一个servlet容器中，执行shell等，我们之前配置了邮件服务器，就以发送为例。即构建完成后发送邮件给指定人。

   ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins0719.jpg)

 * 保存，手动构建

   ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins21.jpg)

 * 构建状态

   ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-utils/image/jenkins22.jpg)
   
<p class="webhook"></p>

## 创建webhook

[创建webhook](https://blog.csdn.net/boling_cavalry/article/details/78943061)



## 关于jenkins更多详细的内容，[请参考官方文档](https://jenkins.io/zh/doc/)