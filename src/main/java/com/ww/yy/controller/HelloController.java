package com.ww.yy.controller;

import com.ww.yy.model.Person;
import com.ww.yy.model.Result;
import com.ww.yy.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    @Autowired
    private HelloService hs;

    @GetMapping("/hello/{id}")
    public Result getPerson(@PathVariable Integer id) throws Exception{
        Result r = new Result();
        r.setStatusCode("200");
        Person p =  hs.getP(id);
        if(p==null) {
            r.setData(null);
            r.setMsg("error");
            return r;
        }
        Map<String,Object> m = new HashMap();
        m.put("person",p);
        r.setData(m);
        r.setMsg("success");
        return r;
    }

    @PostMapping("/hello")
    public Integer savePerson(@RequestBody Person p) throws Exception{
        Integer id = hs.saveP(p);
        return id;
    }

}
