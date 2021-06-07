package com.login.login.userdetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.login.dao.StockDAO;
import com.login.login.entity.Stock;



@Service
public class StockService {
	@Autowired
    private StockDAO stockDAO;
	
	public List<Stock> listAll() {
        return stockDAO.findAll();
    }
     
    public void save(Stock stock) {
    	stockDAO.save(stock);
    }
     
    public Stock get(long id) {
        return stockDAO.findById(id).get();
    }
     
    public void delete(long id) {
    	stockDAO.deleteById(id);
    }
 
}
