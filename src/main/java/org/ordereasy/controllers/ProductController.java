package org.ordereasy.controllers;

import org.ordereasy.models.Product;
import org.ordereasy.models.Restaurant;
import org.ordereasy.models.User;
import org.ordereasy.services.interfaces.IProductService;
import org.ordereasy.services.interfaces.IRestaurantService;
import org.ordereasy.services.interfaces.IRoleService;
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

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IRestaurantService restaurantService;

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
    public String create(Model model){
        model.addAttribute("restaurants", restaurantService.getAll());
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/save")
    public String save(@RequestParam String name, @RequestParam String description,
                       @RequestParam Double price, @RequestParam String category,
                       @RequestParam String image1, @RequestParam String image2,
                       @RequestParam String image3, @RequestParam Integer restaurant_id,
                       @RequestParam Integer state, RedirectAttributes attributes) {

        try {
            // Buscar el restaurante por ID
            Restaurant restaurant = restaurantService.findOneById(restaurant_id).orElse(null);

            if (restaurant == null) {
                attributes.addFlashAttribute("msg", "Restaurante no encontrado");
                return "redirect:/product";
            }

            // Crear y configurar el producto
            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setCategory(category);
            product.setImage1(image1);
            product.setImage2(image2);
            product.setImage3(image3);
            product.setRestaurant(restaurant);
            product.setState(state);

            // Guardar el producto
            productService.createOrEditOne(product);
            attributes.addFlashAttribute("msg", "Producto creado correctamente");

        } catch (Exception e) {
            // Manejo de excepciones
            attributes.addFlashAttribute("msg", "Error al crear el producto: " + e.getMessage());
        }

        return "redirect:/product";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Product product = productService.findOneById(id).get();
        model.addAttribute("restaurants", restaurantService.getAll());
        model.addAttribute("product", product);

        return "user/edit";
    }

    @PostMapping("/update")
    public String update(@RequestParam Integer id, @RequestParam String name, @RequestParam String description,
                         @RequestParam Double price, @RequestParam String category,
                         @RequestParam String image1, @RequestParam String image2,
                         @RequestParam String image3, @RequestParam Integer restaurantId,
                         @RequestParam Integer state, RedirectAttributes attributes) {

        try {
            // Buscar el restaurante por ID
            Restaurant restaurant = restaurantService.findOneById(restaurantId).orElse(null);

            if (restaurant == null) {
                attributes.addFlashAttribute("msg", "Restaurante no encontrado");
                return "redirect:/product";
            }

            // Crear una nueva instancia de Product o encontrar la existente
            Product product = new Product();
            product.setId(id);
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setCategory(category);
            product.setImage1(image1);
            product.setImage2(image2);
            product.setImage3(image3);
            product.setRestaurant(restaurant);
            product.setState(state);

            // Guardar o actualizar el producto
            productService.createOrEditOne(product);
            attributes.addFlashAttribute("msg", "Producto modificado correctamente");

        } catch (Exception e) {
            // Manejo de excepciones
            attributes.addFlashAttribute("msg", "Error al modificar el producto: " + e.getMessage());
        }

        return "redirect:/product";
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
        return "redirect:/product";
    }
}
