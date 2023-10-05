package hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Equation {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int[] pQ = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int p = pQ[0], q = pQ[1];

    double p0 = Math.pow(q / 2.0, 2) + Math.pow(p / 3.0, 3);
    double p1 = Math.cbrt(-q / 2.0 + Math.sqrt(p0));
    double p2 = Math.cbrt(-q / 2.0 - Math.sqrt(p0));
    double x = p1 + p2;
    System.out.printf("%.3f%n", x);

  }
}
