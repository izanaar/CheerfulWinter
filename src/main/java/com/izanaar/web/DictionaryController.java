package com.izanaar.web;

import com.izanaar.dto.translate.DicResult;
import com.izanaar.domain.Translation;
import com.izanaar.service.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    private Dictionary dictionary;

    @RequestMapping("/template")
    public String template(){
        return "dictionary/dictionary";
    }

    @RequestMapping("/src_langs")
    public @ResponseBody Set<String> getSrcLangs(){
        return dictionary.getSourceLanguages();
    }

    @RequestMapping("/trn_langs")
    public @ResponseBody Set<String> getTrnLangs(@RequestParam String src){
        return dictionary.getTranslationLanguages(src);
    }

    @RequestMapping("/lookup")
    public @ResponseBody
    DicResult lookup(String text, String src, String dst){
        return dictionary.translate(new Translation(text, src, dst));
    }

}
