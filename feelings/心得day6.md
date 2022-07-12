列表推导式
[表达式 for 变量 in 列表] 
或者 
[表达式 for 变量 in 列表 if 条件]
例一：过滤掉长度小于或等于3的字符串列表，并将剩下的转换成大写字母：
names = ['Bob','Tom','alice','Jerry','Wendy','Smith']
new_names = [name.upper()for name in names if len(name)>3]
print(new_names)
['ALICE', 'JERRY', 'WENDY', 'SMITH']
例二：计算 30 以内可以被 3 整除的整数：
multiples = [i for i in range(30) if i % 3 == 0]
print(multiples)
[0, 3, 6, 9, 12, 15, 18, 21, 24, 27]
range函数的用法：
过滤掉长度小于或等于3的字符串列表，并将剩下的转换成大写字母：
range函数原型：range(start,end,scan)
参数含义：
start：计数的开始位置，默认是从0开始。
end：计数的结束位置。
scan：每次跳跃的间距，默认为1。
用法一：当range（）函数内只有一个参数，则表示会产生从0开始计数到输入参数（前一位整数）结束的整数列表
用法二：当range（）函数传入两个参数时，则将第一个参数作为起始位，第二个参数为结束位
用法三：当range（）函数内填入第三个参数时，第三个参数为递增或递减值。默认为0