package com.ww.yy.repository;

import com.ww.yy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//must be abstract function ==> such as interface
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName); //JPA根据方法名自动生成SQL
}


