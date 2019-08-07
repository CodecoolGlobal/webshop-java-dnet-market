package com.codecool.shop.dao.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductCategoryDaoMemTest {

    private static ProductCategoryDaoMem testDao;
    private static String testProperties = "test_resources/connection.properties";

    @BeforeEach
    public void setup() {
        testDao = new ProductCategoryDaoMem(testProperties);
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
    public void findNameById() {
        assertEquals("Amazon Fire", testDao.find(1).getName());
    }

}