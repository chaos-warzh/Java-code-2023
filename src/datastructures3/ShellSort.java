package datastructures3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

public class ShellSort{

  public static Vector<Integer> ShellSort(Vector<Integer> nums) {
    //write ur code here.
    // Hibbard sequence
    // 2^k - 1
    int size = nums.size(); // find the element that
    int k = Integer.toBinaryString(size).length() - 2;
    int d = (1 << k) - 1; // 2 ^ k - 1
    while (d >= 1) {
      for (int i = 0; i < d; i++) {
        // insertion sort
        LinkedList<Integer> subList = new LinkedList<>();
        for (int j = i; j < size; j += d) {
          int numsJ = nums.get(j);
          if (subList.isEmpty())
            subList.add(numsJ);
          else {
            int listIdx = 0;
            for (Integer num : subList) {
              if (numsJ < num) {
                subList.add(listIdx, numsJ);
                break;
              }
              listIdx++;
              if (listIdx == subList.size()) {
                subList.addLast(numsJ);
                break;
              }
            }
          }
        }

        for (int j = i, idx = 0; j < size; j += d, idx++) {
          nums.set(j, subList.get(idx));
        }
      }
      d = (d + 1) / 2 - 1;
    }

    return nums;
  }

  public static void main(String[] args) {
    System.out.println(ShellSort.ShellSort(new Vector<>(Arrays.asList(5, 1, 1, 2, 0, 0))));
    System.out.println(ShellSort.ShellSort(new Vector<>(Arrays.asList(5, 1, 4, 1, 1, 4, 19, 199, 8, 1, 0))));
    System.out.println(ShellSort.ShellSort(new Vector<>(Arrays.asList(1))));
    System.out.println(ShellSort.ShellSort(new Vector<>(Arrays.asList())));

    System.out.println(ShellSort.ShellSort(new Vector<>(Arrays.asList(114, 51, 4, 19, 191, 114, 19, 199, 81, 1, 0))));
  }

}