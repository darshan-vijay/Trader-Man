package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Stock;
import com.example.demo.repository.StockRepository;

@Service
public class StockService {
	@Autowired
	StockRepository stockRepo;

	public void insertTransaction(String stockTicker, double price, int volume, String buyOrSell, int statusCode) {

		Stock newStock = new Stock();

		newStock.setId(0);
		newStock.setStockTicker(stockTicker);
		newStock.setBuyOrSell(buyOrSell);
		newStock.setStatusCode(statusCode);
		newStock.setVolume(volume);
		newStock.setPrice(price);
		newStock.setDate(LocalDateTime.now());

		stockRepo.save(newStock);
	}

	public Boolean updateTrade(Integer Id, String ticker, Integer price, Integer volume, String buyOrSell) {
		Stock stock = stockRepo.findById(Id).orElse(null);
		if (stock == null)
			return false;

		stock.setStockTicker(ticker);
		stock.setPrice(price);
		stock.setVolume(volume);
		stock.setBuyOrSell(buyOrSell);

		stockRepo.save(stock);
		return true;
	}

	public List<Stock> getAllTransactions() {
		return stockRepo.findAll();
	}
}
