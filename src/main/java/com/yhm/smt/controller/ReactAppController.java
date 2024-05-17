package com.yhm.smt.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ReactAppController {
    @RequestMapping(value = "/{path:[^\\.]*}")
    public String index() {
        return "index";
}
}
