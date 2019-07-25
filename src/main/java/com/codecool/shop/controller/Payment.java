package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.OrderDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.model.OrderedItems;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/payment"})
public class Payment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao productSupplierDataStore = SupplierDaoMem.getInstance();
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());



        String summPrice = req.getParameter("summPrice");
        int summPriceInt = getPrice(summPrice);
        context.setVariable("summPrice", summPriceInt);
        /*
        Map<String, Object> params = new HashMap<>();
        params.put("summPrice", productCategoryDataStore.find(1));
        params.put("products", productDataStore.getBy(productCategoryDataStore.find(1)));
        params.put("suppliers", productDataStore.getBy(productCategoryDataStore.find(1)));
        context.setVariables(params);
         */
        engine.process("product/payment.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<OrderedItems> orderedItems = OrderDaoMem.getInstance().getAll();
        OrderDaoMem orderedItemDataStore = OrderDaoMem.getInstance();
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());


        float summPriceInt = orderedItemDataStore.getPriceForAll();
        context.setVariable("summPrice", summPriceInt);
        engine.process("product/payment.html", context, resp.getWriter());
    }

    private int getPrice(String summPrice) {
        int summPriceInt;
        if (summPrice == null) {
            summPriceInt = 10000;
        } else {
            summPriceInt = Integer.parseInt(summPrice);
        }
        return summPriceInt;
    }

}
