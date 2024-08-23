package org.ordereasy.controllers;

import org.ordereasy.models.Restaurant;
import org.ordereasy.models.Role;
import org.ordereasy.models.User;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("restaurant")
public class RestaurantController {
    @Autowired
    private IRestaurantService restaurantService;
    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1) - 1;
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<Restaurant> restaurants = restaurantService.findAll(pageable);
        model.addAttribute("restaurants", restaurants);

        int totalPages = restaurants.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "restaurant/index";

    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        Restaurant restaurant = restaurantService.findOneById(id).get();
        model.addAttribute("restaurant", restaurant);
        return "restaurant/details";
    }

    private String guardarImagen(MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            String nombreArchivo = file.getOriginalFilename();
            Path ruta = Paths.get("src/main/resources/static/img").resolve(nombreArchivo);

            Files.createDirectories(ruta.getParent());


            Files.copy(file.getInputStream(), ruta, StandardCopyOption.REPLACE_EXISTING);

            return "/img/" + nombreArchivo;
        }
        return null;
    }



    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "restaurant/create";
    }

    @PostMapping("/save")
    public String save(@RequestParam String name, @RequestParam String address,
                       @RequestParam String phone, @RequestParam String schedule,
                       @RequestParam String description, @RequestParam("image") MultipartFile file,
                       @RequestParam("logo") MultipartFile file2, @RequestParam Integer state,
                       RedirectAttributes attributes) {

        try {
            String imageUrl = guardarImagen(file);
            String logoUrl = guardarImagen(file2);

            Restaurant restaurant = new Restaurant();
            restaurant.setName(name);
            restaurant.setAddress(address);
            restaurant.setPhone(phone);
            restaurant.setSchedule(schedule);
            restaurant.setDescription(description);
            restaurant.setImage(imageUrl);
            restaurant.setLogo(logoUrl);
            restaurant.setState(state);

            restaurantService.createOrEditOne(restaurant);
            attributes.addFlashAttribute("msg", "Restaurante creado correctamente");

        } catch (Exception e) {
            attributes.addFlashAttribute("msg", "Error al crear restaurante: " + e.getMessage());
        }

        return "redirect:/restaurant";
    }



    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Restaurant restaurant = restaurantService.findOneById(id).get();
        model.addAttribute("restaurant", restaurant);

        return "restaurant/edit";
    }

    @PostMapping("/update")
    public String update(@RequestParam Integer id, @RequestParam String name, @RequestParam String address,
                         @RequestParam String phone, @RequestParam String schedule, @RequestParam String description,
                         @RequestParam String image, @RequestParam String logo, @RequestParam Integer state,
                         RedirectAttributes attributes) {

        // Crear una nueva instancia de Restaurant o encontrar la existente
        Restaurant restaurant = new Restaurant();
        restaurant.setId(id);
        restaurant.setName(name);
        restaurant.setAddress(address);
        restaurant.setPhone(phone);
        restaurant.setSchedule(schedule);
        restaurant.setDescription(description);
        restaurant.setImage(image);
        restaurant.setLogo(logo);
        restaurant.setState(state);

        // Guardar o actualizar el restaurant
        restaurantService.createOrEditOne(restaurant);
        attributes.addFlashAttribute("msg", "Restaurante modificado correctamente");

        return "redirect:/restaurant";
    }


    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model){
        Restaurant restaurant = restaurantService.findOneById(id).get();
        model.addAttribute("restaurant", restaurant);
        return "restaurant/delete";
    }

    @PostMapping("/delete")
    public String delete(Restaurant restaurant, RedirectAttributes attributes){
        restaurantService.deleteOneById(restaurant.getId());
        attributes.addFlashAttribute("msg", "Restaurante eliminado correctamente");
        return "redirect:/restaurant";
    }



}
