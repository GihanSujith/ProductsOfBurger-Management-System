package edu.icet.crm.controller;


import edu.icet.crm.service.ProductService;
import edu.icet.crm.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    final ProductService service;

    ProductController(ProductService service){
        this.service = service;
    }


    @PostMapping()
    Product save(@RequestBody Product product){
        return service.createProduct(product);

    }

    @GetMapping()
    List<Product> retrive(){
        return service.retriveProducts();

    }

    @DeleteMapping("/delete-product/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteProduct(@PathVariable Integer id){
        service.deleteProductId(id);
        return "Deleted";
    }

}
