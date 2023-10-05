package datastructures2;

import java.util.ArrayList;
import java.util.List;

public class MyHeap {
  private List<Integer> arr;
  private int size;

  public MyHeap() {
    arr = new ArrayList<>();
    size = 0;
  }

  public void floatUp() {
    int tmpIdx = arr.size() - 1;
    while (true) {
      if (tmpIdx == 0) {
        return;
      }
      int dad = (tmpIdx - 1) / 2;

      if (arr.get(tmpIdx) < arr.get(dad)) {
        // swap
        int tmp = arr.get(dad);
        arr.set(dad, arr.get(tmpIdx));
        arr.set(tmpIdx, tmp);
        tmpIdx = dad;
      } else {
        return;
      }

    }
  }


  public void push(int val) {
    //write ur code here.
    arr.add(val);
    // adjust
    floatUp();
  }

  public void sink() {
    int tmpIdx = 0;
    while (true) {
      int childL = 2 * tmpIdx + 1;
      int childR = childL + 1;
      int childMin = 0;

      if (childR >= arr.size()) {
        if (childL >= arr.size()) {
          return;
        } else {
          childMin = childL;
        }
      } else {
        childMin = arr.get(childL) < arr.get(childR) ? childL : childR; // let the minimum float up
      }

      if (arr.get(tmpIdx) > arr.get(childMin)) {
        // swap
        int tmp = arr.get(childMin);
        arr.set(childMin, arr.get(tmpIdx));
        arr.set(tmpIdx, tmp);
        tmpIdx = childMin;
      } else {
        return;
      }

    }
  }

  public void pop() {
    //write ur code here.
    arr.set(0, arr.get(arr.size() - 1));
    arr.remove(arr.size() - 1);
    // the 0 node -> sinking
    sink();
  }

  public int top() {
    //write ur code here.
    return arr.get(0);
  }

  public int size() {
    //write ur code here.
    return arr.size();
  }

  public static void main(String[] args) {
    Tools.toolsMH();
  }
}