package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoJDBC;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.BaseModel;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Arrays;

@WebListener
public class Initializer implements ServletContextListener {

    private boolean isDataAvailable = false;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStoreJdbc = ProductCategoryDaoJDBC.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        if (productCategoryDataStoreJdbc.getAll().size() > 0) {
            this.isDataAvailable = true;
        }

        if (!this.isDataAvailable) {

            //setting up a new supplier
            Supplier amazon = new Supplier("Amazon", "Digital content and services");
            supplierDataStore.add(amazon);
            Supplier lenovo = new Supplier("Lenovo", "Computers");
            supplierDataStore.add(lenovo);
            Supplier hp = new Supplier("HP", "Computers");
            supplierDataStore.add(hp);

            //setting up a new product category
            ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
            productCategoryDataStore.add(tablet);
            ProductCategory laptop = new ProductCategory("Laptop", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
            productCategoryDataStore.add(laptop);
            productCategoryDataStoreJdbc.add(tablet);
            productCategoryDataStoreJdbc.add(laptop);
        /*ProductCategory phone = new ProductCategory("Phone", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDataStore.add(phone);*/


            //setting up products and printing it
            productDataStore.add(new Product("Amazon Fire", 49.9f, "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon));
            productDataStore.add(new Product("Lenovo IdeaPad Miix 700", 479, "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", tablet, lenovo));
            productDataStore.add(new Product("Amazon Fire HD 8", 89, "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", tablet, amazon));
            productDataStore.add(new Product("HP EliteBook 850 G5 Laptop ", 599, "USD", "Beautifully crafted with the modern professional in mind, the highly secure and manageable HP EliteBook 850 offers powerful collaboration tools, so you can be as productive as ever, on the go or at the office.", laptop, hp));
        }
    }
}
