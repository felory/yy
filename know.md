


## resources下面

### 1.static 
保存所有静态资源（js css image）
### 2.template
保存所有模板页面（由于springBoot 默认jar包使用嵌入式Tomcat,默认不支持JSP页面）
（所以可以使用模板引擎（freemarker, thymeleaf））
### 3.springboot 的配置文件名字固定：
application.properties：  server.port=8081
或者application.yml：键值对。
```
server:
    port:8081
```                                
* 用于修改默认配置。 yml是以数据为中心，比json,xml 更适合做配置文件。
* 语法： ```key: value``` ， 大小写敏感，注意冒号后面有空格。
* 字符串默认不用加上引号
* 双引号 不转义 特殊字符 
* 单引号 会转义 特殊字符 'hi \n en'
* 对象（缩进，多行）（或者行内用 a: {b: xx, c: yy}）
* 数组 （横杠 空格 跟一个元素）（行内 ）
* ```
  pets:
    - cat
    - dog
    - pig
  行内： pets: [cat, dog, pig]
*
*之前常用的是xml：
```
<server>
    <port>8081</port>
</server>
```
### 将配置文件的值，映射到javaBean组件中
===》1、 用注解  @ConfigurationProperties() 从全局文件获取值
在要映射的组件类上方，写上这个注解。
* 注意指定是绑定 配置中的哪个属性：(prefix  = "person在配置中的key值")
* 单元测试里 使用@Autowired 自动注入组件类。并在@Test装饰下的contextLoads里面打印。

2、@**PropertySource**(value={"classpath:path.properties"}) 从指定文件获取值
只能指定properties哦

@importResource：导入spring的配置文件并生效。
可标注在main类上。
===》
test:
@Autowired
ApplicationContext ioc;
@Test
public void testHelloService(){
	ioc.containsBean("helloService"); //Ioc容器中是否注册了id为helloService的bean 【从beans.xml导入成功了吗】
}




