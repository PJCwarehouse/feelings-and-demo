**linux系统下的maven配置：**
在/usr/local/下创建maven文件夹来放置文件
下载maven安装包到/usr/local/maven
解压缩
配置环境变量
vim /etc/profile

export MAVEN_HOME=/usr/local/maven/apache-maven-3.3.9
export PATH=${PATH}:${MAVEN_HOME}/bin

修改完成后用source /etc/profile应用
创建Maven本地仓库
mkdir -p /usr/local/maven/repository

打开Maven的settings.xml配置文件，配置相应的仓库路径以及国内仓库地址
cd /usr/local/maven/apache-maven-3.9.4/conf
vim setting.xml
保存退出

在任何地方用mvn -v检验

相关博客url：https://blog.csdn.net/qq_37488998/article/details/111683904


**linux下java配置**
在 /opt下上传
安装时需要root权限
su root
获取管理员权限后上传

解压，然后 vim /etc/profile
配置环境变量
例如：
export JAVA_HOME=/opt/jdk1.8.0_381
export JRE_HOME=$JAVA_HOME/jre
export PATH=/opt/jdk1.8.0_381/bin:$PATH
export CLASSPATH=.=$JAVA_HOME/jre/lib/rt.jar:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/t
ools.jar

修改后使用source /etc/profile应用
java -version检验

**linux下mysql配置**

检测mysql状态：
sudo systemctl status mysql
（没有sudo就会报错Unit mysqld.service could not be found.
原因：版本不兼容，也有可能是可能是因为 MySQL 服务在系统上使用不同的 systemd 单元名称）

安装路径为/usr/bin/mysql
https://www.bilibili.com/video/BV12q4y1U7sZ/?spm_id_from=333.880.my_history.page.click&vd_source=f5ee65d2d3fb9935030869afd39512d7

常用命令：
连接服务器mysql -u root -p
密码12345678
之后操作后面加“;”，不然系统不知道命令已经完成
常用命令：https://www.dbs724.com/391589.html


