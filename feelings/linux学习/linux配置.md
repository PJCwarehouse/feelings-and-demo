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

**linux下nginx配置**

###### 基于Debian/Ubuntu的系统上的安装步骤：

更新软件包列表：
sudo apt update

安装Nginx：
sudo apt install nginx

安装完成后，启动Nginx服务：
sudo service nginx start


在使用 Nginx 作为 Web 服务器时，可以通过配置实现 HTTP 自动跳转 HTTPS。这可以确保用户始终使用 HTTPS 访问网站，从而提高网站的安全性。

###### 以下是如何配置 Nginx 实现 HTTP 自动跳转 HTTPS 的步骤：
安装 SSL 证书
在启用 HTTPS 之前，需要为域名安装 SSL 证书。可以从证书颁发机构（CA）购买 SSL 证书，或使用自签名证书。

修改 Nginx 配置文件
在安装了 SSL 证书之后，需要修改 Nginx 的配置文件以启用 HTTPS 和 HTTP 自动跳转 HTTPS。

打开 Nginx 配置文件（通常位于 /etc/nginx/nginx.conf），找到的网站配置块。在该配置块中添加以下内容：

perlCopy codeserver {
    listen 80;
    server_name example.com;
    return 301 https://$server_name$request_uri;//这里是强制转换为https
}
server {
    listen 443 ssl;
    server_name example.com;
    ssl_certificate /path/to/ssl/certificate;
    ssl_certificate_key /path/to/ssl/certificate_key;
    # other SSL configuration options
    # ...
    # other server configuration options
    # ...
}
复制
该配置块包括两个部分：

第一个部分监听 HTTP（端口 80），并将所有的 HTTP 请求重定向到 HTTPS。
第二个部分监听 HTTPS（端口 443），并包括 SSL 证书和其他 SSL 配置。
请将 example.com 替换为您自己的域名，并将 /path/to/ssl/certificate 和 /path/to/ssl/certificate_key 替换为 SSL 证书和证书密钥的实际路径。

重新加载 Nginx 配置文件 

执行以下命令，验证配置文件是否存在问题。
sudo nginx -t
完成配置文件的修改之后，需要重新加载 Nginx 配置文件以使更改生效。可以使用以下命令重新加载 Nginx 配置文件：
sudo systemctl reload nginx
这将重新加载 Nginx 并应用刚才的更改。现在，网站就应该可以通过 HTTPS 访问，并且所有的 HTTP 请求都会自动重定向到 HTTPS。
