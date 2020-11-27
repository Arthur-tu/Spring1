package com.geekbrains.july.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JulyMarketApplication {
	// + 1) Добавить категории товаров (создать сущность category и связь с товаром)
	// + 2) Сделать поисковый фильтр по одной категории
	public static void main(String[] args) {
		SpringApplication.run(JulyMarketApplication.class, args);
	}
}
