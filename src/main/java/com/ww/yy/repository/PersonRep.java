package com.ww.yy.repository;

import com.ww.yy.model.Person;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRep {
    private Integer id = 0;
//    public Person getP(Integer id){
//       for(Person p: personList){
//           if(p.getId()==id){
//               return p;
//           }
//       }
//       return null;
//    }

    public Person getP(Integer id) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","0000");
        Statement state = conn.createStatement();

        ResultSet resultSet = state.executeQuery("select * from person where id = "+id);
        Person p = new Person(); //{ }

        if(resultSet.next()){
            String name = resultSet.getString("name");
            Integer age = resultSet.getInt("age");
            p.setId(id);
            p.setName(name);
            p.setAge(age);
        }else{
            state.close();
            conn.close();
            return null;
        }

        state.close();
        conn.close();
        return p;//
    }

    public Integer saveP(Person p) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","0000");

        String name = p.getName();
        Integer age = p.getAge();
        String insertSql ="insert into person values("+null+",'"+name+"','"+age+"')";
//error: You need to specify Statement.RETURN_GENERATED_KEYS to Statement.executeUpdate()
        Statement state =  conn.prepareStatement(insertSql,Statement.RETURN_GENERATED_KEYS);
        int resultSetRow = state.executeUpdate(insertSql);
        if(resultSetRow>0){
            ResultSet rs = state.getGeneratedKeys();
            if(rs.next()){
                Integer id = rs.getInt("id");
                state.close();
                conn.close();
                return id;
            }else{
                return -1;
            }

        }else{
            state.close();
            conn.close();
            return -1;
        }
    }

    public Person getPeronByName(String name1) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","0000");
        Statement state = conn.createStatement();

        Person p = new Person();
        ResultSet resultSet = state.executeQuery("select * from person where name = '"+name1+"'");//+name+"'");
        if(resultSet.next()){
            Integer id = resultSet.getInt("id");
            Integer age = resultSet.getInt("age");
            p.setName(name1);
            p.setId(id);
            p.setAge(age);
            state.close();
            conn.close();
            return p;
        }else{
            state.close();
            conn.close();
            return null;
        }
    }

}
