package com.izanaar.web;

import com.izanaar.dao.TranslationKeeper;
import com.izanaar.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private TranslationKeeper translationKeeper;

    @RequestMapping("/page_template")
    public String pageTemplate(){
        return "review/review";
    }

    @RequestMapping("/translations")
    public @ResponseBody
    Set<Translation> getTranslations(){
        return translationKeeper.getTranslations();
    }

}
