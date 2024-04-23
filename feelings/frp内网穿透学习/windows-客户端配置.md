## 下载流程：
和服务端相似，下载解压相应的frp文件(文件内容其实是一样的，除了frps.ini)
然后是配置FRP客户端
    # [common]
    server_addr = 服务器ip
    # 与frps.ini的bind_port一致
    server_port = 7000
    # 与frps.ini的token一致
    token = 123456

    # 配置ssh服务
    [ssh]
    type = tcp
    # 也可以是当前设备局域网内的其它IP
    local_ip = 127.0.0.1
    local_port = 22
    # 这个自定义，之后再ssh连接的时候要用
    remote_port = 7002
    
在powershell中到frp文件所在位置使用下列命令启动
cd E:\app\frp
.\frpc.exe -c .\frpc.ini
## 检验：
3.1 测试方法一
找一台可以正常上公网的linux或者mac电脑，在终端执行

ssh 用户名@服务端ip -p 端口号
这里一定要注意，这里用的是服务端的ip和用户名，端口号用的frpc.ini文件中的remote_port。

3.2 测试方法二
找一台可以上网的windows机器，使用telnet命令

telnet 公网地址 上文的remote_port端口

如果可以连通，那就说明可以穿透通过。

## talnet知识补充

telnet是一个网络协议，也是一个在 UNIX 或类 UNIX 系统下使用这个协议的客户端程序。
它最初被设计用来通过命令行远程控制网络设备，但现在更常见的用途是**测试 TCP 连接。**

telnet [host] [port]
由于telnet不支持加密，所有通过telnet传输的数据都是明文的，包括你的登录凭据。因此，你不应该使用telnet连接到需要用户名和密码的服务，除非你完全信任你的网络环境。在需要远程控制服务器的情况下，更安全的选择是使用ssh。

但是我们很多时候使用telnet来做端口是否开通的检测，比如我们部署了自己的应用或者需要调用别人的接口出现问题时，
我首先可以用telnet来**判断端口是否监听，从而判断是不是应用未启动，被防火墙拦截了等。**(这个实用性很大)

### 打开telnet服务的详细步骤。

步骤一：打开控制面板，点击卸载程序
步骤二：点击“启动或关闭Windows功能”
步骤三：找到telnet服务，并打开。这里值得说明的是，在window10 之前的版本中，列表中有两个选项：“telnet服务器”和“telnet客户端”，
但是在window10 中“telnet服务器”是默认打开的，所以，在列表中只有“telnet客户端”，