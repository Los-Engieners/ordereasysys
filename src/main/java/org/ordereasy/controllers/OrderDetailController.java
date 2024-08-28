package org.ordereasy.controllers;

import org.ordereasy.models.OrdrDetail;
import org.ordereasy.services.interfaces.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ordereasy.models.Ordr;
import org.ordereasy.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("ordrdetail")
public class OrderDetailController {
    @Autowired
    private IOrdrDetailService ordrDetailService;

    @Autowired
    private IOrdrService ordrService;

    @Autowired
    private IProductService productService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1) - 1;
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<OrdrDetail> ordrDetails = ordrDetailService.findAll(pageable);
        model.addAttribute("ordrDetails", ordrDetails);

        int totalPages = ordrDetails.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "ordrdetail/index";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model) {
        OrdrDetail ordrDetail = ordrDetailService.findOneById(id).orElse(null);
        if (ordrDetail == null) {
            model.addAttribute("msg", "Detalle de orden no encontrado");
            return "redirect:/ordrdetail";
        }
        model.addAttribute("ordrdetail", ordrDetail);
        return "ordrdetail/details";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("orders", ordrService.getAll());
        model.addAttribute("products", productService.getAll());
        model.addAttribute("ordrdetail", new OrdrDetail());
        return "ordrdetail/create";
    }


    @PostMapping("/save")
    public String save(@RequestParam Integer amount, @RequestParam Double unitprice,
                       @RequestParam Double total, @RequestParam Integer ordr_id,
                       @RequestParam Integer product_id, @RequestParam Integer state,
                       RedirectAttributes attributes) {

        try {
            Ordr ordr = ordrService.findOneById(ordr_id).orElse(null);
            if (ordr == null) {
                attributes.addFlashAttribute("msg", "Orden no encontrada");
                return "redirect:/ordrdetail";
            }

            Product product = productService.findOneById(product_id).orElse(null);
            if (product == null) {
                attributes.addFlashAttribute("msg", "Producto no encontrado");
                return "redirect:/ordrdetail";
            }

            OrdrDetail ordrDetail = new OrdrDetail();
            ordrDetail.setAmount(amount);
            ordrDetail.setUnitPrice(unitprice);
            ordrDetail.setTotal(total);
            ordrDetail.setOrdr(ordr);
            ordrDetail.setProduct(product);
            ordrDetail.setState(state);

            ordrDetailService.createOrEditOne(ordrDetail);
            attributes.addFlashAttribute("msg", "Detalle de orden creado correctamente");

        } catch (Exception e) {
            attributes.addFlashAttribute("msg", "Error al crear el detalle de la orden: " + e.getMessage());
        }

        return "redirect:/ordrdetail";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        OrdrDetail ordrDetail = ordrDetailService.findOneById(id).orElse(null);
        if (ordrDetail == null) {
            model.addAttribute("msg", "Detalle de orden no encontrado");
            return "redirect:/ordrdetail";
        }
        model.addAttribute("orders", ordrService.getAll());
        model.addAttribute("products", productService.getAll());
        model.addAttribute("ordrdetail", ordrDetail);

        return "ordrdetail/edit";
    }

    @PostMapping("/update")
    public String update(@RequestParam Integer id, @RequestParam Integer amount, @RequestParam Double unitprice,
                         @RequestParam Double total, @RequestParam Integer ordr_id,
                         @RequestParam Integer product_id, @RequestParam Integer state,
                         RedirectAttributes attributes) {

        try {
            Ordr ordr = ordrService.findOneById(ordr_id).orElse(null);
            if (ordr == null) {
                attributes.addFlashAttribute("msg", "Orden no encontrada");
                return "redirect:/ordrdetail";
            }

            Product product = productService.findOneById(product_id).orElse(null);
            if (product == null) {
                attributes.addFlashAttribute("msg", "Producto no encontrado");
                return "redirect:/ordrdetail";
            }

            OrdrDetail ordrDetail = ordrDetailService.findOneById(id).orElse(null);
            if (ordrDetail == null) {
                attributes.addFlashAttribute("msg", "Detalle de orden no encontrado");
                return "redirect:/ordrdetail";
            }

            ordrDetail.setAmount(amount);
            ordrDetail.setUnitPrice(unitprice);
            ordrDetail.setTotal(total);
            ordrDetail.setOrdr(ordr);
            ordrDetail.setProduct(product);
            ordrDetail.setState(state);

            ordrDetailService.createOrEditOne(ordrDetail);
            attributes.addFlashAttribute("msg", "Detalle de orden modificado correctamente");

        } catch (Exception e) {
            attributes.addFlashAttribute("msg", "Error al modificar el detalle de la orden: " + e.getMessage());
        }

        return "redirect:/ordrdetail";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model) {
        OrdrDetail ordrDetail = ordrDetailService.findOneById(id).orElse(null);
        if (ordrDetail == null) {
            model.addAttribute("msg", "Detalle de orden no encontrado");
            return "redirect:/ordrdetail";
        }
        model.addAttribute("ordrdetail", ordrDetail);
        return "ordrdetail/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes attributes) {
        ordrDetailService.deleteOneById(id);
        attributes.addFlashAttribute("msg", "Detalle de orden eliminado correctamente");
        return "redirect:/ordrdetail";
    }
}
