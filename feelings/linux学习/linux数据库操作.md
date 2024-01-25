#数据库的删除和下载
`dpkg` 和 `rpm` 是两个不同的包管理系统，用于管理软件包在不同的Linux发行版上。`dpkg` 是Debian和Ubuntu等系统中使用的包管理工具，而 `rpm` 是Red Hat、Fedora、CentOS等系统中使用的包管理工具。

`sudo dpkg --get-selections | grep mysql` 命令可以在Debian和Ubuntu等系统上列出已安装的与 MySQL 相关的软件包，因为它使用了 `dpkg` 这个包管理工具。

`rpm -qa | grep -i mysql` 命令用于列出已安装的与 MySQL 相关的软件包，但只适用于Red Hat、Fedora、CentOS等使用 `rpm` 包管理工具的系统。

所以，如果你在一个Debian或Ubuntu系统上运行 `rpm -qa | grep -i mysql` 是找不到相关软件包的，因为该命令不适用于这些系统。同样地，如果你在一个Red Hat、Fedora或CentOS系统上运行 `sudo dpkg --get-selections | grep mysql` 也找不到相关软件包，因为这个命令不适用于这些系统。

要查找MySQL软件包，你需要使用适用于你的Linux发行版的包管理工具，例如在Debian或Ubuntu上使用 `dpkg` 或 `apt`，在Red Hat、Fedora或CentOS上使用 `rpm` 或 `yum`。如果你使用不同的发行版，你需要查找相应的包管理工具命令来列出已安装的软件包。

#刚下载mysql需要设置密码
设置MySQL root密码： 在第一次安装MySQL时，root用户没有密码。为了保护数据库的安全，必须设置一个root密码。使用以下命令登录到MySQL控制台：

mysql -u root
然后，运行以下SQL语句来设置密码：

ALTER USER 'root'@'localhost' IDENTIFIED BY 'your_new_password';



#导入数据库
1、首先建空数据库
mysql>create database dbname ;
2、导入数据库

导入前把文件中的所有的utf8mb4_0900_ai_ci替换为utf8_general_ci
以及utf8mb4替换为utf8
方法一：
（1）选择数据库
mysql>use dbname ;
（2）设置数据库编码
mysql>set names utf8;
（3）导入数据（注意sql文件的路径）
mysql>source /home/xxxx/dbname.sql;
//好使
方法二：

mysql -u 用户名 -p 密码 数据库名 < 数据库名.sql
也即是
mysql -u root -p wndb < /home/ubuntu/wndb.sql

删除数据库
DROP DATABASE your_database_name;
