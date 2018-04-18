package com.example.StackExchange.service;

import java.util.ArrayList;
import java.util.List;

import com.example.StackExchange.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import com.example.StackExchange.model.Item;

@Service("employeeService")
public class ItemServiceImpl implements ItemService {

/*  @Autowired
  private EmployeeRepository employeeRepository;*/

  @Override
  public List<Item> getAllItems() {
//    return employeeRepository.findAll();
    List<Item> i = HelloWorld.getExample("").getItems();
    return i;
  }

}