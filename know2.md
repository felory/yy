### Jackson JSON library （已经默认包含在 web starter中）
使用jackson库，将model class自动封送成==》JSON。

### @RequestParam（value="" defaultValue=""） 绑定query的参数到方法里。

###@RestController 返回一个对象，而不是一个view（像MVC controller）。
这个对象，必须被转换为JSON（到方法体中）, Spring‘HTTP message converter,
Jackson 2 is on the classpath自动被选择用来转化。



####
使用持久化工具的时候，一般都有一个【对象】来操作数据库，
* 在原生的Hibernate中叫做Session，
* 在JPA中叫做EntityManager，
* 在MyBatis中叫做SqlSession


#### 由于Spring boot默认已经集成了Hibernate, 所在我们只需在pom.xml引用jpa及mysql连接库.

<dependency>  
  <groupId>org.springframework.boot</groupId>  
  <artifactId>spring-boot-starter-data-jpa</artifactId>  
</dependency>  

<dependency>
  <groupId>mysql</groupId>  
  <artifactId>mysql-connector-java</artifactId>  
</dependency>
查询mysql驱动包版本： https://mvnrepository.com/artifact/mysql/mysql-connector-java

###JPA 是一套规范，不是一套产品 ====> 解脱了 DAO 层的操作
Jpa (Java Persistence API) 是 Sun 官方提出的 Java 持久化规范。
提供一种【对象/关联映射工具】来管理 Java 应用中的【关系数据】。
====》用极简的代码即可实现对数据的访问和操作。
====》它提供了包括增删改查等在内的常用功能，且易于扩展。

##JPA拥有哪些注解:
@Entity  声明类为实体或表
@Table  声明表名。
@Id  指定的类的属性，用于识别（一个表中的主键）。
@Column  指定持久属性栏属性。


## 基本查询： 2种方法
# 1.默认方法 。 SpringBoot JPA默认预先生成了一些CRUD的方法。
* 需要 继承JpaRepository
public interface UserRepository extends JpaRepository<User, Long> {
  @Test
  public void testBaseQuery() throws Exception {
  User user=new User();
  userRepository.findAll();  //默认方法
  userRepository.save(user);
  }
}

# 2.根据查询方法，自动生成解析成 SQL 。
* 自定的简单查询 ====> 根据方法名来自动生成 SQL
(语法是findXXBy,readAXXBy,queryXXBy,countXXBy, getXXBy后面跟属性名称XX)
  User findByUserNameOrEmail(String username, String email);
  Long deleteById(Long id);

* 复杂查询（分页、删选、连表等查询）
* JPA帮我们实现了分页功能，查询的时候，传入参数Pageable既可。
  Pageable pageable = new PageRequest(page, size, sort);
  Page<User> findALL(Pageable pageable);
  Page<User> findByUserName(String userName,Pageable pageable);
  

* 在SQL查询方法上，使用@Query注解，在删除、修改上加上@Modifying
* 添加 @Transactional对事物的支持，查询超时的设置

@Modifying
@Query("update User u set u.userName = ?1 where u.id = ?2")
int modifyByIdAndUserId(String  userName, Long id);

@Transactional
@Modifying
@Query("delete from User where id = ?1")
void deleteByUserId(Long id);

@Transactional(timeout = 10)
@Query("select u from User u where u.emailAddress = ?1")
User findByEmailAddress(String emailAddress)

* 多表查询（两种方式1.利用 Hibernate 的级联查询来实现； 2.创建一个结果集的接口来接收连表查询后的结果）

### 连接DB：2种方式
####1.使用JdbcTemplate，  <artifactId>mysql-connector-java
List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
for (Map<String, Object> map : list)

####2.m集成Mybatis   <artifactId>mybatis-spring-boot-starter









