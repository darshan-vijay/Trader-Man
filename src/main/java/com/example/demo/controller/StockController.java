package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

	
}