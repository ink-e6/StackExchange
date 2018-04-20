package com.example.StackExchange.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.example.StackExchange.model.SimpleItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.StackExchange.model.Item;
        import com.example.StackExchange.service.ItemService;

@RestController
public class ItemRestController {

  @Autowired
  private ItemService employeeService;

  @RequestMapping(path="/items", method=RequestMethod.GET)
  public List<SimpleItem> getAllEmployees(@RequestParam(value = "title", required = false) String title){

    List<Item> i = employeeService.getAllItems(title);
    List<SimpleItem> simpleItems = new ArrayList<>();

    for(Item item:i){
    SimpleItem temp = new SimpleItem(item.getOwner().getDisplayName(), item.getIsAnswered(), new Date(item.getCreationDate()).toString(), item.getLink(), item.getTitle());
    simpleItems.add(temp);
    }

    System.out.println(i.size());

    return simpleItems;
  }

}