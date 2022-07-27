import socket
server = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
host = socket.gethostname()
port = 12345
server.bind(host,12345)
server.listen(5)
while True:
    conn,addr = server.accept()
    while True:
        data = conn.recv(1024)#接受数据
        print('recive',data.decode())#打印接收到的数据
        conn.send(data.upper())#然后再发送数据
        print('我收到了')
    conn.close()