package com.example.StackExchange.service;

import java.util.List;

import com.example.StackExchange.model.Item;

public interface ItemService {

  public List<Item> getAllItems(String title);
}
