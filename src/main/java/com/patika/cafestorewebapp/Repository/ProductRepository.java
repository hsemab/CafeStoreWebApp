package com.patika.cafestorewebapp.Repository;

import com.patika.cafestorewebapp.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
