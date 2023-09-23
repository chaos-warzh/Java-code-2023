package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ascii {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    Integer num = Integer.parseInt(bf.readLine());
    System.out.printf("%d %c%n", num, num);
    System.out.printf("%d %c%n", num + 97 - 65, num + 97 - 65);

  }

}
