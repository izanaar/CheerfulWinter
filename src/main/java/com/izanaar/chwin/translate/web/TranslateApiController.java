package com.izanaar.chwin.translate.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class TranslateApiController {

    @RequestMapping
    public String test() throws IOException {
        return "translate";
    }

}
