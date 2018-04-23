package com.example.StackExchange.service;

import java.util.List;

import com.example.StackExchange.DataProvider;
import org.springframework.stereotype.Service;

        import com.example.StackExchange.model.Item;

@Service("employeeService")
public class ItemServiceImpl implements ItemService {

/*  @Autowired
  private EmployeeRepository employeeRepository;*/

  @Override
  public List<Item> getAllItems(String title) {
//    return employeeRepository.findAll();
    List<Item> i = DataProvider.getStackExchange(title).getItems();
    return i;
  }

}