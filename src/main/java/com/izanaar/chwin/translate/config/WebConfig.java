package com.izanaar.chwin.translate.config;

import com.izanaar.chwin.translate.web.TranslateApiController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan(basePackageClasses = TranslateApiController.class)
class WebConfig {


}
