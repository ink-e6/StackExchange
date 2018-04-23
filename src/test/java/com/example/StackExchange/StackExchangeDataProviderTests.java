package com.example.StackExchange;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StackExchangeDataProviderTests {

  @Test
  public void searchWithEmptyString() {
    assertTrue("Search with Empty string failed", DataProvider.getStackExchange("") == null);
  }

  @Test
  public void searchWithNoEmptyString() {
    assertTrue("Search with correct string failed", DataProvider.getStackExchange("java").getItems().size() > 0);
  }

  @Test
  public void searchWithNullString() {
    assertTrue("Search with NULL string failed", DataProvider.getStackExchange(null) == null);
  }
}
