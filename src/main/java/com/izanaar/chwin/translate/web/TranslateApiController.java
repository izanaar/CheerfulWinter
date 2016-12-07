package com.izanaar.chwin.translate.web;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class TranslateApiController {

    public @ResponseBody String test(HttpServletResponse response) throws IOException {
        return ("The world says hello.");
    }

}
