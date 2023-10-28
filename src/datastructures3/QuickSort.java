package datastructures3;

import java.util.Arrays;
import java.util.Vector;

public class QuickSort {
  //选定一个pivot并将left到right之间的元素通过pivot划分成两部分，然后返回pivot的下标
  private static int _partition(Vector<Integer> nums, int left, int right) {
    //write ur code here.
    int pivot = nums.get(left);
    int l = left;
    int r = right;

    Vector<Integer> cl = (Vector<Integer>) nums.clone();
    for (int i  = left + 1; i <= right; i++) {
      int num = cl.get(i);
      if (num <= pivot) {
        nums.set(l++, num);
      } else {
        nums.set(r--, num);
      }
    }
    nums.set(l, pivot);
    return l;
  }

  //将nums通过_partition划分成两部分，对每个部分调用_quick_sort
  private static void _quick_sort(Vector<Integer> nums, int left, int right) {
    //write ur code here.
    if (left >= right)
      return;
    int idx = _partition(nums, left, right);
    _quick_sort(nums, left, idx - 1);
    _quick_sort(nums, idx + 1, right);

  }

  public static Vector<Integer> QuickSort(Vector<Integer> nums) {
    _quick_sort(nums, 0, nums.size() - 1);
    return nums;
  }

  public static void main(String[] args) {
    System.out.println(QuickSort.QuickSort(new Vector<>(Arrays.asList(5, 1, 1, 2, 0, 0))));
    System.out.println(QuickSort.QuickSort(new Vector<>(Arrays.asList(5, 1, 4, 1, 1, 4, 19, 199, 8, 1, 0))));
  }
}
