package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductCategoryDaoJDBC implements ProductCategoryDao, QueryHandler {
    private String connectionConfigPath = "src/main/resources/connection.properties";
    private static ProductCategoryDaoJDBC instance = null;

    public static ProductCategoryDaoJDBC getInstance() {
        if (instance == null) {
            instance = new ProductCategoryDaoJDBC();
        }
        return instance;
    }

    public ProductCategoryDaoJDBC(String connectionConfigPath) {
        this.connectionConfigPath = connectionConfigPath;
    }

    public ProductCategoryDaoJDBC() {
    }

    @Override
    public void add(ProductCategory category) {
        try (Connection conn = DriverManager.getConnection(
                "localhost:5432", "rebak16", "Balazs10");
             PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO categories (name, description, department) VALUES" +
                     " (?, ?, ?, ?);")) {

            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, category.getName());
            preparedStatement.setString(3, category.getDepartment());
            preparedStatement.setString(4, category.getDescription());

            int row = preparedStatement.executeUpdate();

            // rows affected
            System.out.println(row); //1

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProductCategory find(int id) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postresql://localhost:5432/codecoolshop", "rebak16", "Balazs10");
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM categories WHERE id=?;")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int ID = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                String department = resultSet.getString("Department");
                String description = resultSet.getString("Description");

                ProductCategory productCategory = new ProductCategory(name, department, description);
                productCategory.setId(ID);
                productCategory.setName(name);
                productCategory.setDepartment(department);
                // Timestamp -> LocalDateTime
                productCategory.setDescription(description);

                System.out.println(productCategory);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void remove(int id) {
        String query = "DELETE FROM categories WHERE id=?;";
        List<Object> parameters = new ArrayList<>();
        parameters.add(id);

        String tempQuery = "SELECT * FROM categories WHERE id=?;";
        List<Map<String, Object>> resultList = executeSelectQuery(tempQuery, parameters);
        if (resultList.size() == 0){
            throw new IllegalArgumentException("There is no product category with such id in the database.");
        }

        Integer result = executeDMLQuery(query, parameters);

    }

    @Override
    public void removeAll() {
        String query = "DELETE from categories;";
        executeDMLQuery(query);
    }

    @Override
    public Integer findIdByName(String name) {
        String query = "SELECT * FROM categories WHERE name=?;";
        List<Object> parameters = new ArrayList<>();
        parameters.add(name);
        List<Map<String, Object>> resultList = executeSelectQuery(query, parameters);

        Integer result = null;
        try {
            result = Integer.parseInt(resultList.get(0).get("id").toString());
        } catch (IndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return result;
    }


    @Override
    public List<ProductCategory> getAll() {
        List<ProductCategory> productCategories = new ArrayList<>();
        try (Connection conn = getConnection()){
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM categories;");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int ID = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                String department = resultSet.getString("Department");
                String description = resultSet.getString("Description");

                ProductCategory productCategory = new ProductCategory(name, department, description);
                productCategory.setId(ID);
                productCategories.add(productCategory);

            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productCategories;
    }

    @Override
    public String getConnectionConfigPath() {
        return connectionConfigPath;
    }
}
