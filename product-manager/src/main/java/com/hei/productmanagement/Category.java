package com.hei.productmanagement;

public class Category {
    private int id;
    private String name;
    public Category(int id, String name){
        this.id = id;
        this.name = name;
    }
    public Category(){}

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return id + "-" + name;
    }
}
