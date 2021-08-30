package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Stock;
import com.example.demo.repository.StockRepository;
@Service
public class StockService {
	@Autowired
	StockRepository repo;
	
	public void insertTransaction(String stockTicker, double price, int volume, String buyOrSell, int statusCode,
			LocalDateTime date) {

		Stock newStock = new Stock();
		
		newStock.setId(0);
		newStock.setStockTicker(stockTicker);
		newStock.setBuyOrSell(buyOrSell);
		newStock.setStatusCode(statusCode);
		newStock.setVolume(volume);
		newStock.setPrice(price);	
		newStock.setDate(LocalDateTime.now());
		
		repo.save(newStock);
	}
	
}
