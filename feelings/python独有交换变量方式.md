python特有的交换方式：a,b=b,a
涉及知识点：元组
元组的定义：元组和列表类似，不同之处在于元组的元素不能修改，列表是列表名[],元组是元组名（）
访问元组和数组相似，用下标的方式
python中的交换，实际上是先运算等式的右边，将b，a交给元组c，这样c=b，a
然后左边就是a，b=c
就相当于交换了a，b的值
交换变量表达式实际分为两步： 一是通过表达式 b, a 生成固定值的元组，元组再赋值给表达式a,b，没有发生a = b 直接赋值过程。