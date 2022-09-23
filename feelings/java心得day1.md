JAVA实例对象 和引用变量的区别
Object obj1=new Object();

拆分:

Object obj1; '''在栈内存里面开辟了空间给引用变量obj1，这时obj1=null

obj1=new Object();

new Object()在堆内存里面开辟了空间给Object类的对象，这个对象没有名字

Object()随即调用了Object类的构造函数

把对象的地址在堆内存的地址给引用变量obj1,此时obj1就是Object的实例化对象.