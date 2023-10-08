package hw2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StandUp {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int max = Integer.parseInt(bf.readLine());
    int[] ags = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int cal = 0;
    int borrow = 0;
    for (int i = 0; i < ags.length; i++) {
      if (ags[i] != 0) {
        if (cal < i) {
          borrow += i - cal;
          cal = i;
        }
        cal += ags[i];
      }
    }
    System.out.println(borrow);
  }

}
