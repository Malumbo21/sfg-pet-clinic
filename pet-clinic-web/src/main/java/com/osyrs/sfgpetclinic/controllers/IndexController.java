package com.osyrs.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @Index
    public String index(){
        return "index";
    }

    @RequestMapping("/oups")
    public String notFoundPage(){
        return "notimplemented";
    }
}
