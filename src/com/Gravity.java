package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Gravity {
  static double G = 6.674E-11;
  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    double[] mR = Arrays.stream(bf.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

    double M = 77.15;

    double f = G * M * mR[0] / (mR[1] * mR[1]);

    System.out.printf("%.3e%n", f);
  }

}
