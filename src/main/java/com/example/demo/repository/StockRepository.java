package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Stock;

public interface StockRepository extends CrudRepository<Stock, Integer> {
	Optional<Stock> findById(Integer id);
}
