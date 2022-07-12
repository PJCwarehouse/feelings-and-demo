split()：就是将一个字符串分隔成多个字符串组成的列表
语法格式：
#split(sep, num)
**1.sep为分隔符，不写sep时，默认表示用 空格，\n，\t 分隔字符串：**
string = "abc abc\ndef\t"
print(string.split())
打印结果：['abc', 'abc', 'def']
**2.num为分隔次数，有sep时按sep的值分隔：**
string1 = "sdwgfeahuidafhaiufaa"
print(string1.split("a", 1))
打印结果：['sdwgfe', 'huidafhaiufaa']
**3.当分隔符在字符串第一个或最后一个位置时，需要注意结果（当不写sep时，没有该影响），前后多了个空字符：**
string2 = "124565145621"
print(string2.split("1"))
打印结果：['', '24565', '4562', '']
string3 = "\nabc abc\ndef\t"
print(string3.split())
打印结果：['abc', 'abc', 'def']
**4.当分隔符连续出现多次时，需要注意结果：**
string4 = "aaabcaadfeaaabc"
print(string4.split("a"))
打印结果：['', '', '', 'bc', '', 'dfe', '', '', 'bc']
**5.多次分隔，获取需要的结果：**
message = 'https://mp.csdn.net/'
print(message.split("//")[1].split("/")[0].split("."))//首先取根据'//'分割的[1]，即是'mp.csdn.net/',然后依次向右计算
打印结果：['mp', 'csdn', 'net']
#Split()[1]中的[1]是什么意思
split('.')[1] 是一种缩写形式，把它拆开来看实际就是
先用split('.')方法将字符串以"."开割形成一个字符串数组，然后再通过索引[1]取出所得数组中的第二个元素的值
例如：
string str = "aa.bb.cc.dd";
那么str.split('.')[1],即是'bb'.
**split（）切割功能，切割后 形成的是列表。**
1，按照特定内容切割，‘’引号里可以是空格、字符(默认是空格）
2，可以指定切割次数
3，可以从右面切割
4，按行切割,换行符切割
例如：
>>>t='I love you more than I can say'
>>>t.split(' ')                                              按空格切割
>>>t.split(' ',3)                                    按空格切割 并指定切割次数，3次
['I','love','you','more than I can say']
>>>t.rsplit(' ',2)                                   从右面开始切割，切割2次
['I love you more than I','can','say']

>>>l='''江畔何人初见月
        江月何年初照人
        人生代代无穷已
        江月年年望相似'''
>>>l.splitlines()                                     splitlines()  按行切割
['江畔何人初见月','江月何年初照人','人生代代无穷已','江月年年望相似']
6.字符串的删除strip（）函数
7.python中find() 函数查找字符串下标位置