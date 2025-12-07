package com.hei.productmanagement;

import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {
    DBConnection db = new DBConnection();

    public List<Category> getAllCategories(){
        List<Category> listCategories = new ArrayList<>();
        String sql = "select id, name from product_category";

        try {
            Connection connection = db.getDBConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Category category = new Category(resultSet.getInt("id"), resultSet.getString("name"));
                listCategories.add(category);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCategories;
    }

    public List<Product> getProductList(int page, int size){
        List<Product> listProducts = new ArrayList<>(); 
        String sql = "select p.id, p.name, p.price, p.creation_datetime, pc.id as category_id, pc.name as category_name from product p join product_category pc on pc.product_id = p.id order by p.id limit ? offset ?";
        
        try {
            Connection connection = db.getDBConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            int offset = (page - 1) * size;
            preparedStatement.setInt(1, size);
            preparedStatement.setInt(2, offset);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Category category = new Category(resultSet.getInt("category_id"), resultSet.getString("category_name"));
                Product product = new Product(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getTimestamp("creation_datetime").toInstant(), category, resultSet.getDouble("price"));

                listProducts.add(product);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProducts;
    }

    public List<Product> getProductsByCriteria(String productName, String categoryName, Instant creationMin, Instant creationMax){
        List<Product> listProducts = new ArrayList<>();
        String sql = "select p.id, p.name, p.price, p.creation_datetime, pc.id as category_id, pc.name as category_name from product p join product_category pc on pc.product_id = p.id where 1 = 1";

        List<Object> criteria = new ArrayList<>();

        if(productName != null){
            sql += " and p.name ilike ?";
            criteria.add("%" + productName + "%");
        }
        if(categoryName != null){
            sql += " and pc.name ilike ?";
            criteria.add("%" + categoryName + "%");
        }
        if(creationMin != null){
            sql += " and p.creation_datetime >= ?";
            criteria.add(Timestamp.from(creationMin));
        }
        if(creationMax != null){
            sql += " and p.creation_datetime <= ?";
            criteria.add(Timestamp.from(creationMax));
        }
        try {
            Connection connection = db.getDBConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            for(int i=0; i < criteria.size(); i++){
                preparedStatement.setObject(i + 1, criteria.get(i));
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Category category = new Category(resultSet.getInt("category_id"), resultSet.getString("category_name"));
                Product product = new Product(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getTimestamp("creation_datetime").toInstant(), category, resultSet.getDouble("price"));

                listProducts.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listProducts;
    }

    public List<Product> getProductsByCriteria(String productName, String categoryName, Instant creationMin, Instant creationMax, int page, int size){
        List<Product> listProducts = new ArrayList<>();
        String sql = "select p.id, p.name, p.price, p.creation_datetime, pc.id as category_id, pc.name as category_name from product p join product_category pc on pc.product_id = p.id where 1 = 1";

        List<Object> criteria = new ArrayList<>();

        if(productName != null){
            sql += " and p.name ilike ?";
            criteria.add("%" + productName + "%");
        }
        if(categoryName != null){
            sql += " and pc.name ilike ?";
            criteria.add("%" + categoryName + "%");
        }
        if(creationMin != null){
            sql += " and p.creation_datetime >= ?";
            criteria.add(Timestamp.from(creationMin));
        }
        if(creationMax != null){
            sql += " and p.creation_datetime <= ?";
            criteria.add(Timestamp.from(creationMax));
        }

        sql += " order by p.id limit ? offset ?";
        try {
            Connection connection = db.getDBConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            for(int i=0; i < criteria.size(); i++){
                preparedStatement.setObject(i + 1, criteria.get(i));
            }

            int offset = (page - 1) * size;
            preparedStatement.setInt(criteria.size() + 1, size);
            preparedStatement.setInt(criteria.size() + 2, offset);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Category category = new Category(resultSet.getInt("category_id"), resultSet.getString("category_name"));
                Product product = new Product(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getTimestamp("creation_datetime").toInstant(), category, resultSet.getDouble("price"));

                listProducts.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listProducts;
    }
}
