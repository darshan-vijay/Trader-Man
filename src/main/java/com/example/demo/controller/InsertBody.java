package com.example.demo.controller;

import java.time.LocalDateTime;

public class InsertBody {
	
	 String stockTicker;
	private double price;
	int volume;
	private String buyOrSell;
	private int statusCode;
	private LocalDateTime date;
	

	public InsertBody() {
		super();
	}
	
	 public InsertBody( String stockTicker, double price, int volume, String buyOrSell, int statusCode,
			LocalDateTime date) {
		super();
		this.stockTicker = stockTicker;
		this.price = price;
		this.volume = volume;
		this.buyOrSell = buyOrSell;
		this.statusCode = statusCode;
		this.date = date;
	}
	 
	public String getStockTicker() {
		return stockTicker;
	}
	public void setStockTicker(String stockTicker) {
		this.stockTicker = stockTicker;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public String getBuyOrSell() {
		return buyOrSell;
	}
	public void setBuyOrSell(String buyOrSell) {
		this.buyOrSell = buyOrSell;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
