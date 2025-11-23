
package com.example.catalog;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductApiController {
    private final ProductRepository repo;
    public ProductApiController(ProductRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Product> all() { return repo.findAll(); }

    @PostMapping
    public Product create(@RequestBody Product p) { return repo.save(p); }
}
