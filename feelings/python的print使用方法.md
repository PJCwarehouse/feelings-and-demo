在C语言中，我们可以使用printf("%-.4f",a)之类的形式，实现数据的的格式化输出。
和C语言的区别在于，Python中格式控制符和转换说明符用%分隔，C语言中用逗号。
例如：
s='Duan Yixuan'
x=len(s)
print('The length of %s is %d' %(s,x))
 
'''
'The length of %s is %d' 这部分叫做：格式控制符
(s,x) 这部分叫做：转换说明符
% 字符，表示标记转换说明符的开始
输出如下：
The length of Duan Yixuan is 11