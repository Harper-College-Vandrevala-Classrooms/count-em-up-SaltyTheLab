package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGroceryCounter {

  GroceryCounter counter;

  @BeforeEach
  void setUp() {
    counter = new GroceryCounter();
  }

  @Test
  void teninhcrement() {
    counter.ten();
    counter.ten();
    assertEquals("$20.00", counter.total());
  }

  @Test
  void tenincrementwithoverflow() {
    for (int i = 0; i < 100; i++)
      counter.ten();
    assertEquals(10, counter.number_of_overflows());
  }

  @Test
  void hundredpennies() {
    for (int i = 0; i < 100; i++) {
      counter.hundreths();
    }
    assertEquals("$1.00", counter.total());
  }

  @Test
  void decrement() {
    counter.hundreths();
    counter.decrementhundreths();
    counter.tenths();
    counter.decrementtenths();
    counter.ones();
    counter.decrementones();
    counter.ten();
    counter.decrementtens();
    assertEquals("$0.00", counter.total());
  }

  @Test
  void hundred() {
    for (int i = 0; i < 1; i++)
      counter.ten();
    for (int i = 0; i < 150; i++)
      counter.decrementhundreths();
    assertEquals("$8.50", counter.total());
  }
}
