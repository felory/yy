### Spring
### 用 XML 配置 bean； 或者用"注解"配置bean
* bean是对象,app由一个个bean构建，bean由SpringIoc容器管理。
Ioc会自动完成@bean对象的实例化。
Ioc维护【bean定义注册表，bean缓存池】

* 管理方式： 注册 + 装配（管理对象间协作关系）
* 1.自动配置
使用组件注册注解【@Component,@Controller,@Repository】，告诉Spring我是一个bean，你要来管理我。
使用@AutoWired或者resource来 装配bean。
 ===》
组件扫描开启之后，去寻找带有@Component的类，并为其创建bean。

* 2.用JavaConfig  @Configuration告诉Spring,让Ioc去怎么配置bean。
* 3.XML配置：标签告诉spring怎么获取这个bean,并手动配置关系。
  <xmlns=表示默认命名空间。
  <bean的id（第一个是标识符，后面的id都叫别名）,class指定类名com.xx.AClass。
  * 静态工厂 实例化bean
  <bean factory-method="newInstance"
  <constructor-arg name="prodName">使用静态工厂实例化Bean，并指定传参。
  
  * 实例化工厂
    <bean > 不指定factory-method，有个id就行了。
    <constructor-arg index="0" value="Hello" ></constructor-arg>

  * 作用域（scope）
    <bean scope="singleton" 单例
    <bean scope="propotype" 每次调用都返回 全新的实例 
  * scope还有request 每次http请求的时候创建一个新实例，Session, Global session
  还可以自定义。
  * 
* ## 用注解，让Spring自动扫描bean，并配置。
* ## @configuration 指明当前类是Spring配置类（之前是用<bean>来添加）
*@Bean将方法的返回值，添加到容器中（容器中此组件的id默认是方法名）。



配置注入
1、定义
@Component ==>定义了一个Bean,名称默认是该类的小写a。创建一个单例（Singleton）。
public class A {
  B b;
  A(@Autowired B b0) { this.b = b0; }
}
2、装配注入，可以写在 set函数上，构造函数中，还可以直接写在字段上。
@Autowired

自定义bean：
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // @Scope("prototype")
public class MailSession {
...
}
对于重复bean定义报错，需要给bean加别名：@Bean("name")指定别名。（也可以用@Bean+@Qualifier("name")指定别名。）


