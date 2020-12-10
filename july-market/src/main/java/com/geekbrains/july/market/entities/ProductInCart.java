package com.geekbrains.july.market.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductInCart {
    private Product product;
    private int quantity;
    private int price;

    public ProductInCart(Product product, int quantity, int price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
}
