package com.geekbrains.july.market.services;

import com.geekbrains.july.market.entities.Cart;
import com.geekbrains.july.market.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class CartService {
    @Autowired
    private Cart cart;

    public void addProduct(Product product) { cart.addProduct(product, 1);}

}
