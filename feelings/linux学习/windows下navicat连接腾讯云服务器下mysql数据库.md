navicat下点击新建连接
1. 配置ssh
    主机地址：云服务器公网地址
    用户名使用云服务器登录的用户名
    密码使用公钥
2. 常规配置
    主机地址：这里直接使用localhost，因为已经通过ssh连接上了云服务器，直接连接云服务器的mysql数据库即可
    用户名和密码 直接使用mysql设置的用户名和密码
    这里的用户切记要设置可以远程访问，即访问权限为 '%'
设置权限操作如下：
    mysql -uroot -p
    use mysql;    ## 选择mysql数据库
    select user,host from user;    ## 查看用户访问端口
    #修改host允许任何ip访问,继续在命令面板输入以下指令：
    update user set host = '%' where user = 'root';
    select user,host from user;    ## 查看用户访问端口,验证
    FLUSH PRIVILEGES;    ## 刷新服务配置项
    ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'root_pwd'; ## 授权root远程登录 后面的root_pwd代表登录密码