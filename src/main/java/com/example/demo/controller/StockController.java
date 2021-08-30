package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.StockService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import java.util.List;
import com.example.demo.repository.StockRepository;
@RestController
@RequestMapping("/api")
@Validated
public class StockController {

	@Autowired
	StockService stockService;


	@GetMapping(value="/trades")
     List getAll(){
        stockService.getAllTransactions();
     }


	
	@PostMapping("/add")
	public @ResponseBody String insertTransaction(
			@RequestBody InsertBody insertBody)
	{
		stockService.insertTransaction(insertBody.getStockTicker(),insertBody.getPrice(),insertBody.getVolume(),insertBody.getBuyOrSell(),insertBody.getStatusCode(),insertBody.getDate());
		return "Transaction recorded.";
	}
	
	@PutMapping(path="/update")
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
