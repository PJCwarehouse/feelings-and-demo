a, b, c, d = 20, 5.5, True, 4+3j #内置type函数可以查看变量所指的对象类型
print(type(a), type(b), type(c), type(d))
str='123456789'
print("str[-1::-1]")
def reverseWords(input):#反向输出字符串
    inputWords = input.split(" ")
    inputWords=inputWords[-1::-1]
    output = ' '.join(inputWords)
    return output
if __name__ == "__main__":
    input = 'I like runoob'
    rw = reverseWords(input)
    print(rw)