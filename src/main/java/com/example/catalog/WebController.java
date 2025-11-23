
package com.example.catalog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    private final ProductRepository repo;
    public WebController(ProductRepository repo) { this.repo = repo; }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", repo.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String add(@RequestParam String name, @RequestParam Double price) {
        repo.save(new Product(name, price));
        return "redirect:/";
    }
}
