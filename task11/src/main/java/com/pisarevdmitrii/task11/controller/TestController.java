package com.pisarevdmitrii.task11.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class TestController {

    @GetMapping("/get")
    String getProductCategoryByListId() {
        return "test finished";
    }

}
