package com.codecool.shop.dao.implementation;

import com.codecool.shop.model.ProductCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductCategoryDaoMemTest {

    private static ProductCategoryDaoJDBC testDao;
    private static String testProperties = "test_resources/connection.properties";

    @BeforeEach
    public void setup() {
        testDao = new ProductCategoryDaoJDBC(testProperties);
    }

    @Test
    public void findId0() {
        assertEquals(null, testDao.find(0));
    }

    @Test
    public void findIdNegative() {
        assertEquals(null, testDao.find(-2));
    }


    @Test
    public void findIdByName() {
        assertEquals("Tablet", testDao.find(1).getName());
    }

    @Test
    public void testFindIdTooBig() {
        assertEquals(null, testDao.find(Integer.MAX_VALUE));
    }

    @Test
    public void findIdByDepartment() {
        assertEquals("Hardware", testDao.find(1).getDepartment());
    }

}