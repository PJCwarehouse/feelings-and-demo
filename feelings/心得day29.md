Request中包含什么？
1.请求方式
主要有：GET/POST两种类型常用，另外还有HEAD/PUT/DELETE/OPTIONS
2.请求头
包含请求时的头部信息，如User-Agent,Host,Cookies等信息
3.请求体
请求是携带的数据，如提交表单数据时候的表单数据（POST）
请求URL
Response中包含了什么
所有HTTP响应的第一行都是状态行，依次是当前HTTP版本号，3位数字组成的状态代码，以及描述状态的短语，彼此由空格分隔。

响应状态
有多种响应状态，如：200代表成功，301跳转，404找不到页面，502服务器错误
XPath的语法
article 选取所有article元素的所有子节点

/article 选取根元素article

article/a 选取所有属于article的子元素的a元素

//div/ 选取所有div子元素（不论出现在文档任何地方）

article//div 选取所有属于article元素的后代的div元素，不管它出现在article下的任何位置

//@class 选取所有名为class的属性

/article/div[1] 选取属于article子元素的第一个div元素

/article/div[last()] 选取属于article子元素的最后一个div元素

/article/div[last()-1] 选取属于article子元素的倒数第二个div元素

//div[@class] 选取所有拥有class属性的div元素

//div[@class='article'] 选取所有class属性为article的div元素

//div[@class='article']/text() 选取所有class属性为article的div元素下的text值

/div/* 选取属于div元素的所有子节点

//* 选取所有元素

//div[@*] 选取所有带属性的div元素

//div/a|//div/p 选取所有div元素下的a和p元素

//span|//ul 选取文档中的span和ul元素

article/div/p|//span 选取所有属于article元素的div元素的p元素以及文档中所有的span元素