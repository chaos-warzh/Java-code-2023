package hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PeekFinding {
  public int findPeakElement(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    if (nums.length == 2) {
      if (nums[0] > nums[1]) {
        return 0;
      }
      return 1;
    }

    int midIndex = nums.length / 2;
    boolean overL = nums[midIndex] > nums[midIndex - 1];
    boolean overR = nums[midIndex] > nums[midIndex + 1];
    if (overL && overR) {
      return midIndex;
    }
    if (overL) {
      return midIndex + findPeakElement(Arrays.copyOfRange(nums, midIndex , nums.length + 1 ));
    }
    return findPeakElement(Arrays.copyOfRange(nums, 0, midIndex + 1));
  }
  public static void main(String[] args) throws IOException {
    Integer t = 0;
    t = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

    for (int i = 0; i < t; i++) {

      BufferedReader bf2 = new BufferedReader(new InputStreamReader(System.in));
      int[] nums = Arrays.stream(bf2.readLine().split(" ")).map(Integer::parseInt).mapToInt(Integer::intValue).toArray();

      PeekFinding p = new PeekFinding();
      System.out.println(p.findPeakElement(nums));
    }

  }
}
