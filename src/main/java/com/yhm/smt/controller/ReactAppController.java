package com.yhm.smt.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class ReactAppController {
    @GetMapping("/")
    public String index() {
        return "index";
}
}
