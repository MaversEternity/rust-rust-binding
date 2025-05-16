package com.me;

import com.me.rust.RustBindings;

public class Main {
  public static void main(String[] args) throws Throwable {
    int result = RustBindings.addNumbers(10, 20);
    System.out.println("Result: " + result); // Output should be 30
  }
}