package com.izanaar.web.translate;

import com.izanaar.dto.Translation;
import com.izanaar.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/translate")
public class TranslateController {

    @Autowired
    private TranslateService translateService;

    @RequestMapping("/")
    public String index() {
        return "translate/translate";
    }

    @RequestMapping(value = "/translate", method = RequestMethod.POST)
    public @ResponseBody Translation translate(@RequestBody String textToTranslate){
        return new Translation(translateService.translate(textToTranslate));
    }
}
