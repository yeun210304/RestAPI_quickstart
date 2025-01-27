package com.helloworld.quickstart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helloworld.quickstart.entity.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, String> {

    
}
