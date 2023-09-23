package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Time {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] ags = bf.readLine().split(" ");
    System.out.printf("%s %s %02d %02d:%02d:%02d %04d ", ags[3].substring(0, 3), ags[0].substring(0, 3), Integer.parseInt(ags[1])
        , Integer.parseInt(ags[4]), Integer.parseInt(ags[5]), Integer.parseInt(ags[6]), Integer.parseInt(ags[2]));
  }
}
