package com.itheima;


import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
public class test {
    @Autowired
    ProductService productService;
    @Test
    public void testService() {

        List<Product> productList = productService.findAll();
        for (Product product : productList) {
            System.out.println(product.getProductName());
        }

    }

}
