package org.ordereasy.controllers;

import org.ordereasy.models.Product;
import org.ordereasy.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1) - 1; // si no está seteado se asigna 0
        int pageSize = size.orElse(5); // tamaño de la página, se asigna 5
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<Product> products = productService.findAll(pageable);
        model.addAttribute("products", products);

        int totalPages = products.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "product/index";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        Product product = productService.findOneById(id).get();
        model.addAttribute("product", product);
        return "product/details";
    }

    @GetMapping("/create")
    public String create(Product product){
        return "product/create";
    }

    @PostMapping("/save")
    public String save(Product product, BindingResult result, Model model, RedirectAttributes attributes){
        if(result.hasErrors()){
            model.addAttribute(product);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "product/create";
        }

        productService.createOrEditOne(product);
        attributes.addFlashAttribute("msg", "Producto creado correctamente");
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Product product = productService.findOneById(id).get();
        model.addAttribute("product", product);
        return "product/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model){
        Product product = productService.findOneById(id).get();
        model.addAttribute("product", product);
        return "product/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes attributes){
        productService.deleteOneById(product.getId());
        attributes.addFlashAttribute("msg", "Producto eliminado correctamente");
        return "redirect:/products";
    }
}
