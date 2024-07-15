package edu.icet.crm.model;

import lombok.Data;

@Data
public class Product {


    Integer id;
    private String name;
    private  String description;
    private  String category;
    private String price;
}
