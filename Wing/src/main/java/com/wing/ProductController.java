package com.wing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/pages/AddProduct")
    public String addProductPage() {
        return "jsp/pages/AddProduct";  // /WEB-INF/views/jsp/pages/AddProduct.jsp로 매핑됨
    }
}