# JAVA实例对象 和引用变量的区别
Object obj1 = new Object();

拆分:

Object obj1; '''在栈内存里面开辟了空间给引用变量obj1，这时obj1=null

obj1=new Object();

new Object()在堆内存里面开辟了空间给Object类的对象，这个对象没有名字

Object()随即调用了Object类的构造函数

把对象的地址在堆内存的地址给引用变量obj1,此时obj1就是Object的实例化对象.


# java中可以使用 != null 的数据类型：

1.引用类型（Reference Types）：如对象、数组等。
2.String 类型。
3.任何继承自 Object 的类。
4.原始数据类型（Primitive Types）：需要使用它们的包装类（如 Integer, Double）来表示。(int和float就不行)