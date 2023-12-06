application.properties
    路径浅解
    上级目录:../
    同级目录:./或者直接写文件名



`spring.mvc.static-path-pattern`配置项是用于指定静态资源的访问路径模式，它并不直接与classpath有关。它定义了URL路径模式，用于映射到你的静态资源。

当你设置`spring.mvc.static-path-pattern=/static/**`时，它的含义是所有以`/static/`开头的URL路径都会映射到静态资源。这是一个URL模式而不是classpath的路径。所以，它表示访问静态资源的路径是相对于应用的根路径。

如果你的静态资源放在`src/main/resources/static/`目录下，而且设置了`spring.mvc.static-path-pattern=/static/**`，那么访问`/static/css/style.css`将会映射到`src/main/resources/static/css/style.css`。

**简单来说就是只要是访问`/static/`开头的URL路径就会映射到`src/main/resources/static/css/style.css`。**


## classpath浅解
确切地说，`classpath`是一个用于指定类路径的前缀，而在Spring Boot中，默认情况下，`src/main/resources`目录下的内容会被打包到类路径中。所以，你可以将`classpath:`前缀看作是`src/main/resources`的缩写。

当你使用类似`classpath:masteryy.top.jks`这样的路径时，Spring Boot会在类路径中寻找`masteryy.top.jks`文件。这种方式可以让你使用相对路径，而不用担心文件的具体位置。

因此，`classpath:`前缀提供了一种方便的方式，可以根据类路径来定位资源，而无需关心具体的文件系统路径。这对于构建可移植的应用程序和打包在JAR文件中的应用程序特别有用。