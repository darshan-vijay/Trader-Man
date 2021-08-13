package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Stock;
import com.example.demo.repository.StockRepository;

@Controller
public class StockController {
	@Autowired
	StockRepository repo;
	
	@PostMapping("/add/")
	public @ResponseBody String insertTransaction(
			
	 @RequestParam String stockTicker,
	 @RequestParam double price,
	 @RequestParam int volume,
	 @RequestParam String buyOrSell,
	 @RequestParam int statusCode) {
		Stock newStock = new Stock();
		
		newStock.setStockTicker(stockTicker);
		newStock.setBuyOrSell(buyOrSell);
		newStock.setStatusCode(statusCode);
		newStock.setVolume(volume);
		newStock.setPrice(price);	
		newStock.setDate(LocalDateTime.now());
		repo.save(newStock);
		return "Transaction recorded.";
	}
}
