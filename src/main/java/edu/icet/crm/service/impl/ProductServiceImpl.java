package edu.icet.crm.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.ProductEntity;
import edu.icet.crm.model.Product;
import edu.icet.crm.repository.ProductRepository;
import edu.icet.crm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public Product createProduct(Product product){

        ProductEntity productEntity
                = mapper.convertValue(product, ProductEntity.class);

        ProductEntity savedProduct = repository.save(productEntity);

        product.setId(savedProduct.getId());
        return product;

    }

    @Override
    public List<Product> retriveProducts() {
        final Iterable<ProductEntity> allProducts = repository.findAll();

        List<Product> productList = new ArrayList<>();

        allProducts.forEach(productEntity -> {
            productList.add(
                    mapper.convertValue(productEntity,Product.class));
        });

        return productList;

    }

    @Override
    public void deleteProductId(Integer id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
    }

}
