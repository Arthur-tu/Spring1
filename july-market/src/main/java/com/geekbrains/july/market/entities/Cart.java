package com.geekbrains.july.market.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;

@Component
@Data
@NoArgsConstructor
public class Cart {
    private HashMap<Product, Integer> products;

    @PostConstruct
    public void init() { this.products = new HashMap<>(); }

    public void addProduct(Product product, Integer quantity) {
        if (products.containsKey(product)) products.put(product, products.get(product) + 1);
        else products.put(product, 1);
    }

}
