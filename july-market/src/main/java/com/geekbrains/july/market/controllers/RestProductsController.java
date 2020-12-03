package com.geekbrains.july.market.controllers;

import com.geekbrains.july.market.entities.Product;
import com.geekbrains.july.market.entities.dtos.ProductDto;
import com.geekbrains.july.market.services.CartService;
import com.geekbrains.july.market.exceptions.ProductNotFoundException;
import com.geekbrains.july.market.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.geekbrains.july.market.entities.ProductInCart;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/products")
public class RestProductsController {
    private ProductsService productsService;
    private CartService cartService;

    @Autowired
    public RestProductsController(ProductsService productsService, CartService cartService) {
        this.productsService = productsService;
        this.cartService = cartService;
    }

    @GetMapping("/dto")
    public List<ProductDto> getAllProductsDto() {
        return productsService.getDtoData();
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productsService.findAll();
    }

    @GetMapping("/cart")
    public ArrayList<ProductInCart> getAllProductsInCart() { return cartService.getAllProducts(); }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneProducts(@PathVariable Long id) {
        if (!productsService.existsById(id)) {
            throw new ProductNotFoundException("Product not found, id: " + id);
        }
        return new ResponseEntity<>(productsService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping
    public String deleteAllProducts(@PathVariable Long id) {
        productsService.deleteAll();
        return "OK";
    }

    @DeleteMapping("/{id}")
    public String deleteOneProducts(@PathVariable Long id) {
        productsService.deleteById(id);
        return "OK";
    }

    @DeleteMapping("/cart/{id}")
    public String deleteProductFromCart(@PathVariable Long id, Integer quantity, Integer price) {
        cartService.deleteProduct(productsService.findById(id), quantity, price);
        return "OK";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveNewProduct(@RequestBody Product product) {
        if (product.getId() != null) {
            product.setId(null);
        }
        return productsService.saveOrUpdate(product);
    }

    @PostMapping("/cart/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public String addNewProductToCart(@PathVariable Long id, @RequestParam(name = "quantity") Integer quantity, @RequestParam(name = "price") Integer price) {
        cartService.addProduct(productsService.findById(id), quantity, price);
        return "OK";
    }

    @PutMapping
    public ResponseEntity<?> modifyProduct(@RequestBody Product product) {
        if (product.getId() == null || !productsService.existsById(product.getId())) {
            throw new ProductNotFoundException("Product not found, id: " + product.getId());
        }
        if (product.getPrice() < 0) {
            return new ResponseEntity<>("Product's price can not be negative", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productsService.saveOrUpdate(product), HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(ProductNotFoundException exc) {
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.NOT_FOUND);
    }
}