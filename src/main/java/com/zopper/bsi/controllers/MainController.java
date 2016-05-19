package com.zopper.bsi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class MainController {

  @RequestMapping("/")
  public String index() {
    return "redirect:swagger-ui.html";
  }

}
