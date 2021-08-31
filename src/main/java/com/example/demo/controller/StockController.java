package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Stock;
import com.example.demo.service.StockService;

@RestController
@RequestMapping("/api")
@Validated
@CrossOrigin
public class StockController {
	private static final Logger LOG = LoggerFactory.getLogger(StockController.class);

	@Autowired
	StockService stockService;

	@GetMapping(value = "/trades")
	List<Stock> getAll() {
		return stockService.getAllTransactions();
	}

	@GetMapping(value = "/{id}")
	public Stock getStockById(@PathVariable("id") int id) {
		LOG.debug("getStockById, id=[" + id + "]");
		return stockService.getStock(id);
	}

	@PostMapping("/add")
	public @ResponseBody String insertTransaction(@RequestBody InsertBody insertBody) {
		stockService.insertTransaction(insertBody.getStockTicker(), insertBody.getPrice(), insertBody.getVolume(),
				insertBody.getBuyOrSell(), insertBody.getStatusCode(), insertBody.getDate());
		return "Transaction recorded.";
	}

	@PutMapping(path = "/update")
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
