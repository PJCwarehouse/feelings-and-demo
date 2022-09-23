java中的接口是一种特殊的抽象类
https://www.jianshu.com/p/d1f327c3fdb9
接口存在的意义：一个Java类中可以实现多个Java接口，可以避免子类的单继承局限。在这种情况情况下，该类必须实现所有所实现接口声明中的所有方法。这里有个示例：
>public class MyInterfaceImpl
    implements MyInterface, MyOtherInterface {
    public void sayHello() {
        System.out.println("Hello");
    }
    public void sayGoodbye() {
        System.out.println("Goodbye");
    }
}

这个类实现了MyInterface和MyOtherInterface两个接口，在implements关键词之后列出需要实现的接口的名称，使用逗号分隔。

使用一个接口有三步
可以先写应用层和接口层，最后再实现
应用层
>MyInterface myInterface = new MyInterfaceImpl();
myInterface.sayHello();

接口层(定义接口的)(接口内public和void/abstract可以缺省)
>public interface MyInterface {
    public String hello = "hello";
    public void sayHello();
}

实现层(实现接口中的所有方法，可以根据需求添加其他方法)
>public class MyInterfaceImpl implements MyInterface {
    public void sayHello() {
        System.out.println(MyInterface.hello);
    }
}

**接口的多态**
同一个接口，通过不同的类实现，创建一个对象，检测这个对象所属的类来选择使用哪个类来实现
多态综合案例：https://www.jianshu.com/p/a09c9dac4264 (文章末尾)

instanceof可以检测某个对象是不是另一个对象的实例；

var Person = function() {};

var student = new Person();

console.log(student instanceof Person);