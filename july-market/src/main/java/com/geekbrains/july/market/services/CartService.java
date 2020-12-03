package com.geekbrains.july.market.services;

import com.geekbrains.july.market.entities.Cart;
import com.geekbrains.july.market.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private Cart cart;

    public void addProduct(Product product, int quantity, int price) {cart.addProduct(product, quantity,price);}

    public void deleteProduct(Product product, int amount, int price) {
        cart.removeProduct(product, amount, price);
    }

    public ArrayList<ProductInCart> getAllProducts() {
        return cart.getProductsInCart();
    }
}