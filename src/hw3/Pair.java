package hw3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pair {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int[] s = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int n = s[0], m = s[1], t = s[2];
    int[] a = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[] b = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int gap = Integer.MAX_VALUE;
    for (int i = 0; i < m; i++) {
      int key = t - b[i];
      int begin = 0, end = n - 1;
      while (true) {
        // wrong search
        if (begin > end)
          break;
        int mid = (begin + end) / 2;
        if (a[mid] > key) {
          end = mid - 1;
        } else if (a[mid] < key) {
          begin = mid + 1;
        } else {
          System.out.println(0);
          return;
        }
      }

      if (end >= 0) {
        int pair = a[end];
        gap = Integer.min(gap, key - pair);
      }

    }
    if (gap == Integer.MAX_VALUE)
      System.out.println(-1);
    else
      System.out.println(gap);
  }
}
