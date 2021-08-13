package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Stock;
import com.example.demo.repository.StockRepository;

@Service
public class StockService {
	@Autowired StockRepository stockRepo;
	
	public Boolean updateTrade(Integer Id ,String ticker ,Integer price,Integer volume, String buyOrSell) {
		Stock stock = stockRepo.findById(Id).orElse(null);
		if(stock == null) return false;
		
		stock.setStockTicker(ticker);
		stock.setPrice(price);
		stock.setVolume(volume);
		stock.setBuyOrSell(buyOrSell);
		
		stockRepo.save(stock);
		return true;
	}
}
