package com.izanaar.chwin.web;

import com.izanaar.chwin.dto.TranslationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/translation")
public class TranslateController {

    @RequestMapping("/page_template")
    public String index() {
        return "translate/translate";
    }

    @RequestMapping(value = "/translate_get", method = RequestMethod.GET)
    public @ResponseBody
    TranslationDTO translate2(){
        return null;
    }

    @RequestMapping(value = "/translate", method = RequestMethod.POST)
    public @ResponseBody
    TranslationDTO translate(@RequestBody String textToTranslate){
       return null;
    }
}
