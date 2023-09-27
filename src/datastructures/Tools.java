package datastructures;

import java.util.Scanner;

public class Tools {
  public static void tools() {
    Scanner scanner = new Scanner(System.in);
    String in1;
    scanner.next();
    DynamicArray arr = new DynamicArray();
    int in2;
    int in3;
    while (scanner.hasNext()) {
      in1 = scanner.next();
      if (in1.equals("append")) {
        in2 = scanner.nextInt();
        arr.append(in2);
      }
      if (in1.equals("erase")) {
        in2 = scanner.nextInt();
        arr.erase(in2);
      }
      else if (in1.equals("get")) {
        in2 = scanner.nextInt();
        System.out.println(arr.get(in2));

      }
      else if (in1.equals("set")) {
        in2 = scanner.nextInt();
        in3 = scanner.nextInt();
        arr.set(in2, in3);
      }
      else if (in1.equals("size")) {
        System.out.println(arr.size());
      }
      else if (in1.equals("capacity")) {
        System.out.println(arr.capacity());
      }
      else if (in1.equals("print")) {
        arr.print();
      }
    }

    scanner.close();
  }
}
