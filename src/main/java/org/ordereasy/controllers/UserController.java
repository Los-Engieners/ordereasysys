package org.ordereasy.controllers;
import org.ordereasy.models.User;
import org.ordereasy.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
//
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1) - 1;
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<User> users = userService.findAll(pageable);
        model.addAttribute("users", users);

        int totalPages = users.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "user/index";
    }
    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        User user = userService.findOneById(id).get();
        model.addAttribute("user", user);
        return "user/details";
    }

    @GetMapping("/create")
    public String create(User user){
        return "user/create";
    }

    @PostMapping("/save")
    public String save(User user, BindingResult result, Model model, RedirectAttributes attributes){
        if(result.hasErrors()){
            model.addAttribute(user);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "user/create";
        }

        userService.createOrEditOne(user);
        attributes.addFlashAttribute("msg", "usuario creado correctamente");
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        User user = userService.findOneById(id).get();
        model.addAttribute("user", user);

        return "user/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model){
        User user = userService.findOneById(id).get();
        model.addAttribute("user", user);
        return "user/delete";
    }

    @PostMapping("/delete")
    public String delete(User user, RedirectAttributes attributes){
        userService.deleteOneById(user.getId());
        attributes.addFlashAttribute("msg", "Usuario eliminado correctamente");
        return "redirect:/user";
    }
}
