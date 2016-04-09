package com.izanaar.web.translate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

    @RequestMapping("/template")
    public String template(){
        return "dictionary/dictionary";
    }

}
