package com.fandp.dao;
import com.fandp.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: fandp
 * @create: 2020-05-07 09:16
 **/
@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {

}
