package datastructures2;

import java.util.Vector;
import java.util.Scanner;

public class Tools {
  public static void toolsMS() {
    MergeSort ma = new MergeSort();

    Scanner scanner = new Scanner(System.in);
    int len = scanner.nextInt();
    Vector<Integer> nums = new Vector<>();

    for (int i = 0; i < len; i++) {
      int val = scanner.nextInt();
      nums.addElement(val);
    }
    ma.MergeSort(nums);
    for (int val : nums) {
      System.out.print(val + " ");
    }
    scanner.close();
  }

  private static int N;
  public static int check(int n) {
    if (n < N) return -1;
    else if (n > N) return 1;
    return 0;
  }

  public static void toolsGN() {
    Scanner scanner = new Scanner(System.in);
    N = scanner.nextInt();
    GuessNumber ma = new GuessNumber();
    System.out.print(ma.guessNumber());
  }

  public static void toolsMH() {
    Scanner scanner = new Scanner(System.in);
    scanner.next();
    String input_1;
    int input_2;
    MyHeap hp = new MyHeap();
    while (scanner.hasNext()) {
      input_1 = scanner.next();
      if (input_1.equals("push")) {
        input_2 = scanner.nextInt();
        hp.push(input_2);
      }
      else if (input_1.equals("pop")) {
        hp.pop();
      }
      else if (input_1.equals("top")) {
        System.out.println(hp.top());
      }
      else if (input_1.equals("size")) {
        System.out.println(hp.size());
      }
    }
    scanner.close();
  }
}
