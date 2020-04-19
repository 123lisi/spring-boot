package com.guoge.springboot.repository;

import com.guoge.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//数据操作的类
public interface UserRepository extends JpaRepository<User,Integer> {

}
