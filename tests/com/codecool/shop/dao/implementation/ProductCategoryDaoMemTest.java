package com.codecool.shop.dao.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductCategoryDaoMemTest {

    private static ProductCategoryDaoMem testDao;

    @BeforeEach
    public void setup() {
        testDao = new ProductCategoryDaoMem();
    }

    @Test
    public void findId0() {
        assertEquals(null, testDao.find(0));
    }

    @Test
    public void findIdNegative() {
        assertEquals(null, testDao.find(-2));
    }



}