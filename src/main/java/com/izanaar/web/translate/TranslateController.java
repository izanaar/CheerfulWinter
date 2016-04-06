package com.izanaar.web.translate;

import com.izanaar.dto.Translation;
import com.izanaar.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/translation")
public class TranslateController {

    @RequestMapping("/page_template")
    public String index() {
        return "translate/translate";
    }

    @RequestMapping(value = "/translate_get", method = RequestMethod.GET)
    public @ResponseBody Translation translate2(){
        return null;
    }

    @RequestMapping(value = "/translate", method = RequestMethod.POST)
    public @ResponseBody Translation translate(@RequestBody String textToTranslate){
       return null;
    }
}
