package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.StockService;

@Controller
@RequestMapping(path="/trade")
public class StockController {
	@Autowired StockService stockService;
	
	@PutMapping(path="/")
	public String updateTrade(@RequestBody UpdateBody updateBody) {
		Integer id = updateBody.getId();
		String stockTicker = updateBody.getStockTicker();
		Integer price = updateBody.getPrice();
		Integer volume = updateBody.getVolume();
		String buyOrSell = updateBody.getBuyOrSell();
		
		stockService.updateTrade(id, stockTicker, price, volume, buyOrSell);
		return "Updated";
	}
}
