package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {
	Optional<Stock> findById(Integer id);
}
