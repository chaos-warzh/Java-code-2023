package datastructures2;

import java.util.Vector;

public class MergeSort {
  //将起始下标为left~mid的子数组与下标为mid~right的子数组合并（升序
  private static void _merge(Vector<Integer> nums, int left, int mid, int right) {
    int l = left, m = mid, r = right;
    Vector<Integer> tmp = new Vector<>(right - left + 100);
    while (l <= mid - 1 && m <= right) {
      if (nums.get(l) < nums.get(m)) {
        tmp.add(nums.get(l++));
      } else if (nums.get(l) >= nums.get(m)) {
        tmp.add(nums.get(m++));
      }
    }
    while (l <= mid - 1) {
      tmp.add(nums.get(l++));
    }
    while (m <= right) {
      tmp.add(nums.get(m++));
    }

    for (int i = left, j = 0; i <= right; i++, j++) {
      nums.set(i, tmp.get(j));
    }
  }

  //将nums拆分成两部分分别处理后再调用_merge()合并
  private static void _mergeSort(Vector<Integer> nums, int left, int right) {
    if (left == right) {
      return;
    } else {
      int mid = (left - right) / 2 + right;
      _mergeSort(nums, left, mid - 1);
      _mergeSort(nums, mid, right);
      _merge(nums, left, mid, right);
    }
  }

  public static Vector<Integer> MergeSort(Vector<Integer> nums) {
    _mergeSort(nums, 0, nums.size() - 1);
    return nums;
  }

  public static void main(String[] args) {
    Tools.toolsMS();
  }
}