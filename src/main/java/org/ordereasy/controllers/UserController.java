package org.ordereasy.controllers;
import org.ordereasy.models.Role;
import org.ordereasy.models.User;
import org.ordereasy.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.ordereasy.services.interfaces.IRoleService;
import org.springframework.format.annotation.DateTimeFormat;

//
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;


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
    public String create(Model model){
        model.addAttribute("roles", roleService.getAll());
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping("/save")
    public String save(@RequestParam Integer role_id, @RequestParam String name,
                       @RequestParam String lastname, @RequestParam String email,
                       @RequestParam String password, @RequestParam String phone,
                       @RequestParam String address, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate registrationdate,
                       @RequestParam int state, RedirectAttributes attributes){

        try {
            // Verifica si el rol existe
            Role role = roleService.findOneById(role_id).orElse(null);

            if (role == null) {
                attributes.addFlashAttribute("msg", "Rol no encontrado");
                return "redirect:/user";
            }

            // Crea y configura el usuario
            User user = new User();
            user.setRole(role);
            user.setName(name);
            user.setLastname(lastname);
            user.setEmail(email);
            user.setPassword(password);
            user.setPhone(phone);
            user.setAddress(address);
            user.setRegistrationdate(registrationdate);
            user.setState(state);

            // Guarda el usuario
            userService.createOrEditOne(user);
            attributes.addFlashAttribute("msg", "Usuario creado correctamente");

        } catch (Exception e) {
            // Maneja la excepción y muestra el mensaje de error
            attributes.addFlashAttribute("msg", "Error al crear usuario: " + e.getMessage());
        }

        return "redirect:/user";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        User user = userService.findOneById(id).get();
        model.addAttribute("roles", roleService.getAll());
        model.addAttribute("user", user);

        return "user/edit";
    }

    @PostMapping("/update")
    public String update(@RequestParam Integer id, @RequestParam Integer role_id, @RequestParam String name,
                         @RequestParam String lastname, @RequestParam String email, @RequestParam String password,  @RequestParam String phone,
                         @RequestParam String address,@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate registrationdate,
                         @RequestParam int state, RedirectAttributes attributes){
        Role role = roleService.findOneById(role_id).get();


        if(role != null){
            User user = new User();
            user.setId(id);
            user.setRole(role);
            user.setName(name);
            user.setLastname(lastname);
            user.setEmail(email);
            user.setPassword(password);
            user.setPhone(phone);
            user.setRegistrationdate(registrationdate);
            user.setAddress(address);
            user.setState(state);

            userService.createOrEditOne(user);
            attributes.addFlashAttribute("msg", "Usuario modificado correctamente");
        }

        return "redirect:/user";
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
