package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
@Entity
@Getter 
@Setter 
@Accessors(chain = true)
@NoArgsConstructor


@AllArgsConstructor
public class Stock {
	@Id
	
	private int id;
	private String stockTicker;
	private double price;
	private int volume;
	private String buyOrSell;
	private int statusCode;

	}