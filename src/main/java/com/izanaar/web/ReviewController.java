package com.izanaar.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @RequestMapping("/page_template")
    public String pageTemplate(){
        return "review/review";
    }

}
