package com.fandp.dao;

import com.fandp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author: fandp
 * @create: 2020-05-07 09:16
 **/
public interface UserDao extends JpaRepository<User,Integer> {
}
