package org.ordereasy.controllers;

import org.ordereasy.models.Product;
import org.ordereasy.models.Role;
import org.ordereasy.services.interfaces.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ordereasy.models.Role;
import org.ordereasy.services.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public String index(Model model){
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);

        return "home/index";
    }
}
