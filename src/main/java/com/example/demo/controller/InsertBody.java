package com.example.demo.controller;


public class InsertBody {
	
	 String stockTicker;
	private double price;
	int volume;
	private String buyOrSell;
	private int statusCode;
	

	public InsertBody() {
		super();
	}
	
	 public InsertBody( String stockTicker, double price, int volume, String buyOrSell, int statusCode) {
		super();
		this.stockTicker = stockTicker;
		this.price = price;
		this.volume = volume;
		this.buyOrSell = buyOrSell;
		this.statusCode = statusCode;
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
}
