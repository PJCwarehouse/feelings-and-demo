import socket
client = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
host = socket.gethostname()
port = 12345
client.connect((host,12345))
while True:
    msg = input('请输入你想发送的数据')
    client.send(msg.encode('utf-8'))#发送一条信息 python3 只接收btye流
    data = client.recv(1024)#接收一个信息，并指定接收的大小 为1024字节
    print('recv:',data.decode())#输出我接收的信息
client.close()
