package com.example.demo.service;

import com.example.demo.controller.Holding;
import com.example.demo.entity.Stock;
import com.example.demo.repository.StockRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {
	@Autowired
	StockRepository stockRepo;

	private static final Logger LOGGER=LoggerFactory.getLogger(StockService.class);

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

	public Stock getStock(int id) {
		return stockRepo.getStockById(id);
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

	public List<Holding> getHoldings() throws JsonProcessingException {
		List<Stock> trades = stockRepo.findAll();
		List<Holding> holdings = new ArrayList<>();

		WebClient client = WebClient.create();
		ObjectMapper mapper = new ObjectMapper();

		for (var trade : trades) {
			if (trade.getStatusCode() == 1) {
				ResponseSpec responseSpec = client.get()
						.uri("https://qz4sxjl623.execute-api.us-east-1.amazonaws.com/default/tradeAdvisor?ticker="+trade.getStockTicker().toUpperCase())
						.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
						.retrieve();
				String jsonresp = responseSpec.bodyToMono(String.class).block();
				Holding h = mapper.readValue(jsonresp, Holding.class);

				if (trade.getBuyOrSell().equals("buy")) h.setPosition("LONG");
				else h.setPosition("SHORT");

				h.setDate(trade.getDate());
				h.setVolume(trade.getVolume());
				h.setPrice(trade.getPrice());

				if(trade.getBuyOrSell().equals("buy")){
					h.setPl((h.getLastClose() - h.getPrice()) * h.getVolume());
				} else {
					h.setPl((h.getPrice() - h.getLastClose())*h.getVolume());
				}

				holdings.add(h);
			}
		}
		return holdings;
	}
}
