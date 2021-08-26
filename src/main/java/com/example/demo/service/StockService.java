package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Stock;
import com.example.demo.repository.StockRepository;

public class StockService {
	@Autowired
	StockRepository repo;
	
	public void insertTransaction(String stockTicker, double price, int volume, String buyOrSell, int statusCode,
			LocalDateTime date) {

		Stock newStock = new Stock();
		
		newStock.setStockTicker(stockTicker);
		newStock.setBuyOrSell(buyOrSell);
		newStock.setStatusCode(statusCode);
		newStock.setVolume(volume);
		newStock.setPrice(price);	
		newStock.setDate(LocalDateTime.now());
		
		repo.save(newStock);
	}
	
}
