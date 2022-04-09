package com.ww.yy.repository;

import com.ww.yy.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRep {
    private List<Person> personList = new ArrayList();
//持久化
    public PersonRep(){
        personList.add(new Person(23));
    }

    private Integer id = 0;
    public Person getP(Integer id){
       for(Person p: personList){
           if(p.getId()==id){
               return p;
           }
       }
       return null;
    }

    public Integer saveP(Person p){
        id++;
        p.setId(id);
        personList.add(p);
        return id;
    }

}
