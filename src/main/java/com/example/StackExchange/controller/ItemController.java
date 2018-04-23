package com.example.StackExchange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemController {

  @RequestMapping(path = "/", method = RequestMethod.GET)
  public String goHome() {
    return "index.html";
  }

}