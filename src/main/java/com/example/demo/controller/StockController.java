package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
	

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.StockService;


import java.util.List;
import com.example.demo.repository.StockRepository;
@RestController
@RequestMapping("/api")
@Validated
public class StockController {
	@Autowired
	private StockRepository stockRepository;
	 @GetMapping(value="/trades")
     List getAll(){
         return stockRepository.findAll();
     }


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
