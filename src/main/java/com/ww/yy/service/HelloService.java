package com.ww.yy.service;
import com.ww.yy.model.Person;
import com.ww.yy.repository.PersonRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloService {

    @Autowired
    private PersonRep pr;

    public Person getP(Integer id) throws Exception{
        return pr.getP(id);
    }

    public Integer saveP(Person p) throws Exception {
        Person pp = pr.getPeronByName(p.getName());
        if(pp!=null){ //exist
            return -1;
        }else{
            return pr.saveP(p);
        }
    }

}
