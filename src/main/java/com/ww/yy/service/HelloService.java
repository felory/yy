package com.ww.yy.service;
import com.ww.yy.model.Person;
import com.ww.yy.repository.PersonRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private PersonRep pr;

    public Person getP(Integer id){
        return pr.getP(id);
    }

    public Integer saveP(Person p){
        return pr.saveP(p);
    }

}
