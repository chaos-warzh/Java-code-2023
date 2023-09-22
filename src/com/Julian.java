package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Julian {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int[] ags = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int a = (int) ((14 - ags[1]) / 12.0);
    int y = ags[0] + 4800 - a;
    int m = ags[1] + 12 * a - 3;
    int jdn = ags[2] + (int)((153 * m + 2) / 5.0) + 365 * y + (int)(y / 4.0) - (int)(y / 100.0) + (int)(y / 400.0) - 32045;

    System.out.println(jdn);
  }
}
