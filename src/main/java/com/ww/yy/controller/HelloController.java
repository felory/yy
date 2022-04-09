package com.ww.yy.controller;

import com.ww.yy.model.Person;
import com.ww.yy.model.User;
import com.ww.yy.repository.UserRepository;
import com.ww.yy.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@ResponseBody 放到class上面表示该类的所有方法，返回的数据都直接写给浏览器（若是对象就转换为json）
//@Controller
@RestController
public class HelloController {
    @Autowired
    private HelloService hs;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/hello/{id}")
    public Person getPerson(@PathVariable Integer id){
        return hs.getP(id);
    }


    @PostMapping("/hello/p")
    public Integer postPerson(@RequestBody  Map<String, String> body){
        String n = body.get("name");
        String a = body.get("age");
        Integer age = Integer.parseInt(a);
        Person p = new Person();
        p.setName(n);
        p.setAge(age);
        return hs.saveP(p);
    }

    @PutMapping("/hello/p/{id}")
    public Integer putPerson(@PathVariable Integer id, @RequestBody Map<String, String> body){
        //要注入？？ new Person p =
//        Blog blog = blogRespository.findOne(blogId);
//        blog.setTitle(body.get("title"));
//        blog.setContent(body.get("content"));
        Person p = new Person();
        p.setId(id);
        return hs.saveP(p);
    }

    @DeleteMapping("p/{id}")
    public boolean delete(@PathVariable Integer id){
//        blogRespository.delete(blogId);
        return true;
    }

    @GetMapping("/getByUserName")
    public User getByUserName(String userName){
        User user = userRepository.findByUserName(userName);
        return user;
    }

}
