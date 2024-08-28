package org.ordereasy.controllers;

import org.ordereasy.models.Ordr;
import org.ordereasy.models.Restaurant;
import org.ordereasy.models.User;
import org.ordereasy.services.interfaces.IOrdrService;
import org.ordereasy.services.interfaces.IRestaurantService;
import org.ordereasy.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("ordr")
public class OrdrController {

    @Autowired
    private IOrdrService ordrService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRestaurantService restaurantService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1) - 1;
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<Ordr> orders = ordrService.findAll(pageable);
        model.addAttribute("orders", orders);

        int totalPages = orders.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "ordr/index";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model) {
        Ordr ordr = ordrService.findOneById(id).orElse(null);
        if (ordr == null) {
            model.addAttribute("msg", "Orden no encontrada");
            return "redirect:/ordr";
        }
        model.addAttribute("ordr", ordr);
        return "ordr/details";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("restaurants", restaurantService.getAll());
        model.addAttribute("ordr", new Ordr());
        return "ordr/create";
    }

    @PostMapping("/save")
    public String save(@RequestParam LocalDate ordrdate, @RequestParam String deliverytime,
                       @RequestParam String state, @RequestParam Double total, @RequestParam Integer user_id,
                       @RequestParam Integer restaurant_id, @RequestParam Integer estate,
                       RedirectAttributes attributes) {

        try {

            User user = userService.findOneById(user_id).orElse(null);
            if (user == null) {
                attributes.addFlashAttribute("msg", "Usuario no encontrado");
                return "redirect:/ordr";
            }


            Restaurant restaurant = restaurantService.findOneById(restaurant_id).orElse(null);
            if (restaurant == null) {
                attributes.addFlashAttribute("msg", "Restaurante no encontrado");
                return "redirect:/ordr";
            }


            Ordr order = new Ordr();
            order.setOrdrdate(ordrdate);
            order.setDeliverytime(deliverytime);
            order.setState(state);
            order.setTotal(total);
            order.setUser(user);
            order.setRestaurant(restaurant);
            order.setEstate(estate);


            ordrService.createOrEditOne(order);
            attributes.addFlashAttribute("msg", "Orden creada correctamente");

        } catch (Exception e) {
            attributes.addFlashAttribute("msg", "Error al crear la orden: " + e.getMessage());
        }

        return "redirect:/ordr";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Ordr ordr = ordrService.findOneById(id).orElse(null);
        if (ordr == null) {
            model.addAttribute("msg", "Orden no encontrada");
            return "redirect:/ordr";
        }
        model.addAttribute("users", userService.getAll());
        model.addAttribute("restaurants", restaurantService.getAll());
        model.addAttribute("ordr", ordr);

        return "ordr/edit";
    }

    @PostMapping("/update")
    public String update(@RequestParam Integer id, @RequestParam LocalDate ordrdate, @RequestParam String deliverytime,
                         @RequestParam String state, @RequestParam Double total, @RequestParam Integer user_id,
                         @RequestParam Integer restaurant_id, @RequestParam Integer estate,
                         RedirectAttributes attributes) {

        try {

            User user = userService.findOneById(user_id).orElse(null);
            if (user == null) {
                attributes.addFlashAttribute("msg", "Usuario no encontrado");
                return "redirect:/ordr";
            }


            Restaurant restaurant = restaurantService.findOneById(restaurant_id).orElse(null);
            if (restaurant == null) {
                attributes.addFlashAttribute("msg", "Restaurante no encontrado");
                return "redirect:/ordr";
            }


            Ordr ordr = ordrService.findOneById(id).orElse(null);
            if (ordr == null) {
                attributes.addFlashAttribute("msg", "Orden no encontrada");
                return "redirect:/ordr";
            }


            ordr.setOrdrdate(ordrdate);
            ordr.setDeliverytime(deliverytime);
            ordr.setState(state);
            ordr.setTotal(total);
            ordr.setUser(user);
            ordr.setRestaurant(restaurant);
            ordr.setEstate(estate);

            
            ordrService.createOrEditOne(ordr);
            attributes.addFlashAttribute("msg", "Orden modificada correctamente");

        } catch (Exception e) {
            attributes.addFlashAttribute("msg", "Error al modificar la orden: " + e.getMessage());
        }

        return "redirect:/ordr";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model) {
        Ordr ordr = ordrService.findOneById(id).orElse(null);
        if (ordr == null) {
            model.addAttribute("msg", "Orden no encontrada");
            return "redirect:/ordr";
        }
        model.addAttribute("ordr", ordr);
        return "ordr/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes attributes) {
        ordrService.deleteOneById(id);
        attributes.addFlashAttribute("msg", "Orden eliminada correctamente");
        return "redirect:/ordr";
    }
}
