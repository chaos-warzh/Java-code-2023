package hw2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Obstacle {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int[] x = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    /* 0 1 0 2 -> */
//    Map<Integer[], String> findDir = new HashMap<>;
    String.join("", Collections.nCopies(10, "1"));
    StringBuilder path;

  }
}
