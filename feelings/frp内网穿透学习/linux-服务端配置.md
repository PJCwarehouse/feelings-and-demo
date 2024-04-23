## 下载流程：
下载和解压frp文件
wget https://github.com/fatedier/frp/releases/download/v0.45.0/frp_0.45.0_linux_amd64.tar.gz
tar -zxvf frp_0.45.0_linux_amd64.tar.gz
然后修改配置
vim frps.ini

# FRP服务端
[common]
# frp监听的端口，默认是7000，可以改成其他的
bind_port = 7000
# 授权码，请改成更复杂的
token = 12345  # 这个token之后在客户端会用到

# frp管理后台端口，请按自己需求更改
dashboard_port = 7001
# frp管理后台用户名和密码，请改成自己的
dashboard_user = pjc
dashboard_pwd = 123456
enable_prometheus = true

# frp日志配置
log_file = /var/log/frps.log
log_level = info
log_max_days = 3

直接启动
./frps -c frps.ini

注意：
frps.ini是服务端配置，frpc.ini是客户端配置。这里可以将客户端配置删掉，也可以不删
记得在云服务器中打开防火墙放开端口

## 检验：
验证服务端是否成功启动：在浏览器中输入：http://服务器公网IP:FRP后台端口号，如：http://1.X.X.X:7001

http://111.229.182.26:7001