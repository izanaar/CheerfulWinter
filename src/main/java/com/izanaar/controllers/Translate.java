package com.izanaar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Translate {

    @RequestMapping("/")
    public void home(HttpServletResponse response) {
        try {
            response.getOutputStream().print("Hello World!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
