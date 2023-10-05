package hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Change {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    Integer money = Integer.parseInt(bf.readLine());

    System.out.println(money / 50);
    money %= 50;
    System.out.println(money / 20);
    money %= 20;
    System.out.println(money / 10);
    money %= 10;
    System.out.println(money / 5);
    money %= 5;
    System.out.println(money);

  }
}
