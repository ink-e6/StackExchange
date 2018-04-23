package com.tz.stackexchange.service;

import java.util.LinkedList;
import java.util.List;

import com.tz.stackexchange.DataProvider;
import org.springframework.stereotype.Service;

import com.tz.stackexchange.model.Item;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

  @Override
  public List<Item> getAllItems(String title) {
    List<Item> i;

    if (!title.isEmpty()) {
      i = DataProvider.getStackExchange(title).getItems();
    } else {
      i = new LinkedList<Item>();
    }
    return i;
  }

}