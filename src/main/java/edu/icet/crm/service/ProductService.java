package edu.icet.crm.service;

import edu.icet.crm.model.Product;

import java.util.List;

public interface ProductService {

    public Product createProduct(Product product);

    List<Product> retriveProducts();

    void deleteProductId(Integer id);
}
