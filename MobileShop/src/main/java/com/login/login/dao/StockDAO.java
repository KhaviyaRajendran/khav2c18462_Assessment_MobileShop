package com.login.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.login.entity.Stock;


@Repository
public interface StockDAO extends JpaRepository<Stock,Long>{

}
