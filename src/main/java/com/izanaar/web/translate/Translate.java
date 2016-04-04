package com.izanaar.web.translate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Translate {

    @RequestMapping("/translate")
    public String index() {
        return "translate/translate";
    }

}
