### idea创建一个tomcat项目
(前置条件：下载tomcat)
参考文章："https://www.jianshu.com/p/2f8eec345749"
新建项目
创建项目类型选择Jakarta EE
模版选择Web应用程序(Servlet,web.xml,index.jsp)
下一步
jar版本是java8的话就选择JavaEE 8
创建之后在设置中的"Build,Execution,Deployment"中的应用服务选择添加应用服务"tomcat"，然后配置tomcat的位置
配置好之后在启动旁边的编辑器中编辑配置
点击+号，添加新配置->tomcat(本地)->部署->修复
最后点击运行，运行成功会自动跳转到tomcat的默认界面