package com.tz.stackexchange.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import com.tz.stackexchange.model.SimpleItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tz.stackexchange.model.Item;
import com.tz.stackexchange.service.ItemService;

@RestController
public class ItemRestController {

  @Autowired
  private ItemService employeeService;

  @RequestMapping(path = "/items", method = RequestMethod.GET)
  public List<SimpleItem> getAllEmployees(@RequestParam(value = "title", required = false) String title) {

    List<Item> i = employeeService.getAllItems(title);
    List<SimpleItem> simpleItems = new ArrayList<>();

    SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy, hh:mm a");
    Calendar calendar = Calendar.getInstance();
    String creationDate;

    for (Item item : i) {
      creationDate = item.getCreationDate();
      calendar.setTimeInMillis(Long.parseLong(creationDate) * 1000);
      creationDate = formatter.format(calendar.getTime());
      SimpleItem temp = new SimpleItem(item.getOwner().getDisplayName(), item.getIsAnswered(), creationDate.toString(), item.getLink(), item.getTitle());
      simpleItems.add(temp);
    }

    System.out.println(i.size());

    return simpleItems;
  }

}