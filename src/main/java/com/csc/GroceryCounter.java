package com.csc;

import java.util.Scanner;

public class GroceryCounter {
  Scanner input = new Scanner(System.in);
  int ten = 0;
  int one = 0;
  int tenths = 0;
  int hundreths = 0;
  int overflow = 0;

  GroceryCounter() {
    System.out.println("enter your starting value with spaces:");
    this.ten = input.nextInt();
    this.one = input.nextInt();
    this.tenths = input.nextInt();
    this.hundreths = input.nextInt();
    while (this.ten < 0 || this.ten > 9 || this.one < 0 || this.one > 9 ||
        this.tenths < 0 || this.tenths > 9
        || this.hundreths < 0 || this.hundreths > 9) {
      System.out.print("invalid starting number. Please renter:");
      this.ten = input.nextInt();
      this.one = input.nextInt();
      this.tenths = input.nextInt();
      this.hundreths = input.nextInt();
    }
  };

  public void ten() {
    if (this.ten == 9) {
      this.ten = 0;
      this.one = 0;
      this.tenths = 0;
      this.hundreths = 0;
      this.overflow += 1;
    } else
      this.ten += 1;
  }

  public void ones() {
    if (this.one == 9) {
      this.one = 0;
      ten();
    } else
      this.one += 1;
  }

  public void hundreths() {
    if (this.hundreths == 9) {
      this.hundreths = 0;
      tenths();
    } else
      this.hundreths += 1;
  }

  public void tenths() {
    if (this.tenths == 9) {
      this.tenths = 0;
      ones();
    } else
      this.tenths += 1;
  }

  public void clear() {
    this.ten = 0;
    this.one = 0;
    this.tenths = 0;
    this.hundreths = 0;
    this.overflow = 0;
  }

  public int number_of_overflows() {
    return this.overflow;
  }

  public void decrementtens() {
    this.ten -= 1;
  }

  public void decrementones() {
    this.one -= 1;
    if (this.one < 0) {
      decrementtens();
      this.one = 9;
    }
  }

  public void decrementtenths() {
    this.tenths -= 1;
    if (this.tenths < 0) {
      decrementones();
      this.tenths = 9;
    }
  }

  public void decrementhundreths() {
    this.hundreths -= 1;
    if (this.hundreths < 0) {
      decrementtenths();
      this.hundreths = 9;
    }
  }

  public String total() {
    if (this.ten == 0)
      return (String.format("$%d.%d%d", this.one, this.tenths, this.hundreths));
    return (String.format("$%d%d.%d%d", this.ten, this.one, this.tenths, this.hundreths));
  }

  public static void main(String[] args) {
    GroceryCounter bob = new GroceryCounter();
    bob.tenths();
    bob.tenths();
    bob.tenths();
    bob.tenths();
    bob.tenths();
    System.out.print(bob.total());
    for (int i = 0; i < 100; i++)
      bob.ones();
    bob.clear();
    bob.total();
  }
}