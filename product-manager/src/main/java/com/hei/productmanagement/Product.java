package com.hei.productmanagement;

import java.time.Instant;

public class Product{
    private int id;
    private String name;
    private double price;
    private Instant creationDateTime;
    private Category category;
    public Product(int id, String name, Instant creationDateTime, Category category, double price){
        this.id = id;
        this.name = name;
        this.category = category;
        this.creationDateTime = creationDateTime;
        this.price = price;
    }
    public Product(){}

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Instant getCreationDateTime(){
        return creationDateTime;
    }
    public Category getCategory(){
        return category;
    }
    public double getPrice(){
        return price;
    }

    public String getCategoryName(){
        return category.getName();
    }

    @Override
    public String toString() {
        return "id : " + id + "\n" + "name : " + name + "\n" + "price : " + price + "\n" + "create Date : " + creationDateTime + "\n" + "category : " + category + "\n";
    }
}