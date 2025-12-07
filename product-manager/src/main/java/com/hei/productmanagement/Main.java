package com.hei.productmanagement;

import java.time.Instant;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataRetriever dataRetriever = new DataRetriever();
        // Method getAllCategories()
        List<Category> listCategories = dataRetriever.getAllCategories();

        for (int i = 0; i < listCategories.size(); i++){
            System.out.println(listCategories.get(i));
        }

        // Method getProductList()
        List<Product> listProducts1 = dataRetriever.getProductList(1, 10);
        for (int i = 0; i < listProducts1.size(); i++){
            System.out.println(listProducts1.get(i));
        }

        List<Product> listProducts2 = dataRetriever.getProductList(1, 5);
        for (int i = 0; i < listProducts2.size(); i++){
            System.out.println(listProducts2.get(i));
        }

        List<Product> listProducts3 = dataRetriever.getProductList(1, 3);
        for (int i = 0; i < listProducts3.size(); i++){
            System.out.println(listProducts3.get(i));
        }

        List<Product> listProducts4 = dataRetriever.getProductList(2, 2);
        for (int i = 0; i < listProducts4.size(); i++){
            System.out.println(listProducts4.get(i));
        }

        // Method getProductsByCriteria() without pagination
        List<Product> listProduitsByCriteria1 = dataRetriever.getProductsByCriteria("Dell", null, null, null);
        for (int i = 0; i < listProduitsByCriteria1.size(); i++){
            System.out.println(listProduitsByCriteria1.get(i));
        }

        List<Product> listProduitsByCriteria2 = dataRetriever.getProductsByCriteria(null, "info", null, null);
        for (int i = 0; i < listProduitsByCriteria2.size(); i++){
            System.out.println(listProduitsByCriteria2.get(i));
        }

        List<Product> listProduitsByCriteria3 = dataRetriever.getProductsByCriteria("iPhone", "mobile", null, null);
        for (int i = 0; i < listProduitsByCriteria3.size(); i++){
            System.out.println(listProduitsByCriteria3.get(i));
        }

        List<Product> listProduitsByCriteria4 = dataRetriever.getProductsByCriteria(null, null, Instant.parse("2024-02-01T00:00:00Z"), Instant.parse("2024-03-01T00:00:00Z"));
        for (int i = 0; i < listProduitsByCriteria4.size(); i++){
            System.out.println(listProduitsByCriteria4.get(i));
        }

        List<Product> listProduitsByCriteria5 = dataRetriever.getProductsByCriteria("Samsung", "bureau", null, null);
        for (int i = 0; i < listProduitsByCriteria5.size(); i++){
            System.out.println(listProduitsByCriteria5.get(i));
        }

        List<Product> listProduitsByCriteria6 = dataRetriever.getProductsByCriteria("Sony", "informatique", null, null);
        for (int i = 0; i < listProduitsByCriteria6.size(); i++){
            System.out.println(listProduitsByCriteria6.get(i));
        }

        List<Product> listProduitsByCriteria7 = dataRetriever.getProductsByCriteria(null, "audio", Instant.parse("2024-01-01T00:00:00Z"), Instant.parse("2024-12-01T00:00:00Z"));
        for (int i = 0; i < listProduitsByCriteria7.size(); i++){
            System.out.println(listProduitsByCriteria7.get(i));
        }

        List<Product> listProduitsByCriteria8 = dataRetriever.getProductsByCriteria(null, null, null, null);
        for (int i = 0; i < listProduitsByCriteria8.size(); i++){
            System.out.println(listProduitsByCriteria8.get(i));
        }

        // Method getProductsByCriteria() with pagination
        List<Product> listProductsByCriteria1 = dataRetriever.getProductsByCriteria(null, null, null, null, 1, 10);
        for (int i = 0; i < listProductsByCriteria1.size(); i++){
            System.out.println(listProductsByCriteria1.get(i));
        }

        List<Product> listProductsByCriteria2 = dataRetriever.getProductsByCriteria("Dell", null, null, null, 1, 5);
        for (int i = 0; i < listProductsByCriteria2.size(); i++){
            System.out.println(listProductsByCriteria2.get(i));
        }
        
        List<Product> listProductsByCriteria3 = dataRetriever.getProductsByCriteria(null, "informatique", null, null, 1, 10);
        for (int i = 0; i < listProductsByCriteria3.size(); i++){
            System.out.println(listProductsByCriteria3.get(i));
        }

    }
}