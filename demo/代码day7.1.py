#通过半径计算圆的周长和面积
PI=3.14159
R=input("请输入圆的半径： ")
R=float(R)
L=2*PI*R
S=PI*R*R
print('周长：%.2f' % L)
print('面积：%.2f' % S)
#判断年份是否为闰年
R=input("请输入年份： ")
R=int(R)
if R%4==0 and R%400!=0:
 print("R是闰年")
else:
 print("R不是闰年") 
