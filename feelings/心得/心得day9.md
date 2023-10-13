#whlie循环语句知识点
1.使用break语句，即使while条件为true，我们也可以停止循环：
例如：
i等于3退出循环：
>i = 1
while i < 6:
    print(i)
    if i == 3:
        break
    i += 1

2.continue语句
使用continue语句，我们可以停止当前迭代，然后继续下一个迭代：
例如：
如果i等于3，则停止当前迭代，继续进行下一个迭代：
>i = 0
while i < 6:
    i += 1
    if i == 3:
        continue
    print(i)

3.else语句
使用else语句，当条件不再成立时，我们可以运行一次代码块：
例如：
条件为False时，打印输出一条消息：
>i = 1
while i < 6:
    print(i)
    i += 1
else:
    print("i 不小于 6")
#for循环语句知识点
计数器循环：range

print(help(range))
class range(object)
range(stop) -> range object
range(start, stop[, step]) -> range object

>0到9
for x in range(10):
	print(x,end=',')
print('')
 输出 0,1,2,3,4,5,6,7,8,9,
 
>1到9
for x in range(1,10):
	print(x,end=',')
print('')
输出 1,2,3,4,5,6,7,8,9,
 
>1到9，间隔为2
for x in range(1,10,2):
	print(x,end=',')
print('')
输出 1,3,5,7,9,
 
 
>1到9，间隔为3
for x in range(1,10,3):
	print(x,end=',')
print('')
输出 1,4,7,

**c中的for(i;i<n;i++)在python中变成了for i in range(n)** 