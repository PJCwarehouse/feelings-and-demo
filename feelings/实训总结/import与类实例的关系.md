单纯的import语句只是将其他包中的类引入到当前的Java文件中，以便在代码中使用这些类而不需要使用完整的包路径。但是，它并不会自动创建这些类的实例。

在Spring应用程序中，可以使用@Autowired注解来将其他Bean注入到目标类中，这样Spring容器会自动为目标类创建这些Bean的实例。但是，要使@Autowired注解生效，被注入的类必须是Spring管理的Bean，并且已经注册到IOC容器中。

因此，单纯的import语句只是为了可以在代码中使用被引入的类，但要实际使用该类的实例，需要确保它已经被正确注册为Spring Bean，并且可以被@Autowired注解注入到目标类中。

当一个包被import进来后，直接调用它的实例而不使用@autowired有可能会导致空指针异常

总结：
使用一个类实例的两个条件：
1. 该类已经被注册到IOC容器中，是Spring管理的Bean。例如：@Service，@Controller，@Component
2. import该类