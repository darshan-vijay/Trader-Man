package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.StockService;

@Controller
public class StockController {
	@Autowired
	StockService service;
	
	@PostMapping("/add/")
	public @ResponseBody String insertTransaction(
			@RequestBody InsertBody insertBody)
	{
		service.insertTransaction(insertBody.getStockTicker(),insertBody.getPrice(),insertBody.getVolume(),insertBody.getBuyOrSell(),insertBody.getStatusCode(),insertBody.getDate());
		return "Transaction recorded.";
	}
	
	
	
	
}
