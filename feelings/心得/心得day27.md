一.网络请求
所需知识：
1.使用requests模块（requests是一个Python第三方的网络请求模块，是学习网络爬虫最基础的模块，他比Python自带的urllib模块使用起来简单的很多，该模块可以非常简单的使用一行代码就能够对url发起请求）
2.以下是一个发起一共get请求的示例：
>import requests
response = requests.get(url="http://www.baidu.com")
print(response.text)#输出请求后的网页

这样子子就请求到了目标网页的数据
想要拿到请求到的网页只需要调用text方法就行如：
post方法的使用：
>data = {"xxx":xxx,"xxx":xxxx} #data：字典、字节序列或文件对象，作为Requests的内容
response =  requests.post(url="http://xxxxx",data=data)

二.数据解析（json）
所需知识：
1.通过requests库向网站请求网页，获得网页源代码之后，下一步的工作就需要对网页代码进行解析，方便后面的提取工作。
2.通常进行网页解析、提取数据组合会是这样：bs4 + lxml 或者 lxml+xpath
bs4、lxml主要针对的是html语言编写的代码，有时候请求的内容返回是Json代码，就需要用到Json库。
JSON 的全称是 Java Script Object Notation，即 JavaScript 对象符号，它是一种轻量级的数据交换格式。
3.常用的方法就是json.loads，用于解码 JSON 数据。该函数返回 Python 字段的数据类型。
>import json
jsonData = '{"a":1,"b":2,"c":3,"d":4,"e":5}';
text = json.loads(jsonData)
print text

三.数据保存
所需知识：
1.将数据保存为 json格式和 csv格式
2.
>JSON(JavaScript Object Notation, JS 对象简谱) 是一种轻量级的数据交换格式。它基于 ECMAScript (欧洲计算机协会制定的js规范)的一个子集，采用完全独立于编程语言的文本格式来存储和表示数据。简洁和清晰的层次结构使得 JSON 成为理想的数据交换语言。 易于人阅读和编写，同时也易于机器解析和生成，并有效地提升网络传输效率。

>json的格式和 python中的字典很像，也是由键值对组成，但是 python中的值可以为任何对象（列表、字典、字符串、数字等等），而 json中的值只能是数组（列表）、字典、字符串、数组、布尔值中的一中或几种。

其格式就像下面这样：

注意：json中的引号必须是双引号，否则会报错
>{
    "key1": "value1",
    "key2": [1,2,"value2"],
    "key3": 
    {
        "key31": "value1",
        "key32": [1,2,"value2"],
        "key33": true,
    },
}

3.json库一共有三个方法，分别是 dump、dumps、load、loads。

其中 dump和 dumps是用来把把字典和数组转换为 json格式的，dump把转换结果直接写入文件，dumps返回字符串。

load和 loads是把 json格式的数据转换为字典格式，load直接从 json文件中读取数据并返回字典对象，loads把字符串形式的 json数据转换成字典格式。

dump和 dumps

dump的函数原型是 dump(obj, fp) 第一个参数 obj是要转换的对象，第二个参数 fp是要写入数据的文件对象。

dumps的函数原型是 dumps(obj) 参数是要转换的对象

load和 loads

load的函数原型是 load(fp) 参数 fp是要读取的文件对象

loads的函数原型是 loads(string) 参数 string是要转换成 python对象的 json字符串，通常用来将网页中的 json数据转换为 python对象

注意：如果要转换的对象里有中文字符的话，要把 ensure_ascii设置为 False否则中文会被编码为 ascii格式

四.发送邮件
所需知识：
1.首先需要设置QQ邮箱POP3/SMTP服务
2.用到的库是 smtplib 和 email，将存储到数据库的数据保存在附件中，发送到指定邮箱