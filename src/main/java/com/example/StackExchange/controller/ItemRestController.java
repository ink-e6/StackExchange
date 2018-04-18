package com.example.StackExchange.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RestController;

        import com.example.StackExchange.model.Item;
        import com.example.StackExchange.service.ItemService;

@RestController
public class ItemRestController {

  @Autowired
  private ItemService employeeService;

  @RequestMapping(path="/items", method=RequestMethod.GET)
  public List<Item> getAllEmployees(){

    List<Item> i = employeeService.getAllItems();
    System.out.println(i.size());

    return i;
  }

}