分支结构
如果a,b是数值变量，则&,|表示位运算，and,or则是依据是否非0来决定输出
and：当a,b中至少有一个为0时，返回0，否则返回后一个值，例如：2 and 3，返回值为3；
&会将左右两个整数转换为二进制进行计算，**当同位都为1时取1，否则取0。** 
例如 2&3可化为10&11=10
**&和and的小差别，and在a错误时会直接返回，而&会继续将b转化为2进制继续判断，当b有错误时，使用and不会报错而使用&会报错**
#python的缩进
1.在 Python 中，对于类定义、函数定义、流程控制语句、异常处理语句等，行尾的冒号和下一行的缩进，表示下一个代码块的开始，而缩进的结束则表示此代码块的结束。
2.注意，Python 中实现对代码的缩进，可以使用空格或者 Tab 键实现。但无论是手动敲空格，还是使用 Tab 键，通常情况下都是采4个空格长度作为一个缩进量（默认情况下，一个 Tab 键就表示 4 个空格）。