"""100求和
a=0
for i in range(101):
    a+=i
print('%d' % a) 
"""
"""判断素数
def panduan(a):
    if a==1:
        print('a不是一个素数')
    else:
        for i in range(2,a):
            if a%i==0:
                print('a不是一个素数')
                break
        else:
            print('a是一个素数')

a=int(input('请输入你想判断的数:'))
panduan(a)
"""
"""猜数字游戏
from random import randrange
number = randrange(1,100)
while True:
    wanjia = int(input('请输入你的猜测(整数)'))
    if wanjia > number:
        print('猜大了！')
    elif wanjia < number:
        print('猜小了！')
    else:
        print('猜对了！')
        break
"""
"""百钱白鸡问题
for i in range(1,15):
    for j in range(1,30):
        for k in range(1,100):
            if i+j+k==100 and 5*i+3*j+k/3==100:
                print("买了%d只公鸡，%d只母鸡，%d只小鸡" % (i,j,k))
"""
"""水仙花数
for i in range(100,1000):
    a=i%10
    b=i//10%10
    c=i//100
    if a**3+b**3+c**3==i:
        print('%d' % i)
"""
"""
m=0
for i in range(1,1000):
    for a in range(1,i):
        if i%a==0:
            m=m+a
    if m==i:
        print("%d是完美数" % i)
    m=0
"""