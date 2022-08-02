import socket
server = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
port = 12345
server.bind(('localhost',12345))
server.listen(5)
print(f'正在监听:{port}')
while True:
    conn,addr = server.accept()
    print(f'{addr}已连接')
    while True:
        data = conn.recv(1024)#接受数据
        print('recive:',data.decode())#打印接收到的数据
        conn.send(data.upper())#然后再发送数据
        print('我收到了')
    conn.close()