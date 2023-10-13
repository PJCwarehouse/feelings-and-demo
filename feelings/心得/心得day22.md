Ping的作用
Ping是用来探测本机与网络另一主机之间是否可达的命令，如果两台主机之间Ping不同，则表明这两台主机不能建立连接，Ping是定位网络通不通的重要手段。
ping 命令是基于 ICMP 协议来工作的，「 ICMP 」全称为 Internet 控制报文协议（ Internet Control Message Protocol）。ping 命令会发送一份ICMP回显请求报文给目标主机，并等待目标主机返回ICMP回显应答。因为ICMP协议会要求目标主机在收到消息之后，必须返回ICMP应答消息给源主机，如果源主机在一定时间内收到了目标主机的应答，则表明两台主机之间网络是可达的。
格式：在终端中ping ip