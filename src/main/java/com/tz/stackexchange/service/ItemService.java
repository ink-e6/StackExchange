package com.tz.stackexchange.service;

import java.util.List;

import com.tz.stackexchange.model.Item;

public interface ItemService {

  public List<Item> getAllItems(String title);
}
