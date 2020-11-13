package com.geekbrains.spring.mvc.controllers;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.services.ProcuctsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// root: http://localhost:8189/app/products

@Controller
@RequestMapping("/products")
public class ProductsController {
private ProcuctsService procuctsService;

    @Autowired
    public ProductsController(ProcuctsService procuctsService) {
        this.procuctsService = procuctsService;
    }

    @GetMapping
    public String showAllProducts(Model model) {
        List<Product> products = procuctsService.getAllProducts();
        model.addAttribute("products", products);
        return "all_products";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add_product_form";
    }

    @PostMapping("/add")
    public String saveNewProduct(@ModelAttribute Product newProduct) {
        procuctsService.saveOrUpdateProduct(newProduct);
        return "redirect:/products/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", procuctsService.findById(id));
        return "edit_product_form";
    }

    @PostMapping("/edit")
    public String modifyProduct(@ModelAttribute Product modifiedProduct) {
        procuctsService.saveOrUpdateProduct(modifiedProduct);
        return "redirect:/products/";
    }

    @GetMapping("/json/{id}")
    @ResponseBody
    public Product showJsonProduct(@PathVariable Long id) {
        return  procuctsService.findById(id);
    }
}

