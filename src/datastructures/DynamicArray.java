package datastructures;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DynamicArray {
  private int[] _arr;
  private int _capacity;
  private int _currentSize;

  public DynamicArray() {
    _capacity = 10; // 初始容量为10
    _arr = new int[_capacity];
    _currentSize = 0;
  }

  // 向数组末尾添加元素，如果数组已满，扩展容量，扩展为原来的两倍
  public void append(int value) {
    //write ur code here.
    Integer[] box = Arrays.stream(_arr).boxed().toArray(Integer[]::new);
    List<Integer> tmp = new ArrayList<>(Arrays.asList(box));

    if (_capacity <= _currentSize) {
      Stream<Integer> integers = Stream.iterate(0, x -> x).limit(_capacity + 1);
      tmp.addAll(integers.collect(Collectors.toList()));
      _capacity *= 2;
    }

    assert _capacity > _currentSize;

    tmp.set(_currentSize, value);
    _currentSize++;

    _arr = tmp.stream().mapToInt(Integer::intValue).toArray();
  }

  // 删除指定索引的元素，如果剩余元素不足capacity的一半，将capacity缩小一半，最小容量为10
  public void erase(int index) {
    //write ur code here.
    Integer[] box = Arrays.stream(_arr).boxed().toArray(Integer[]::new);
    List<Integer> tmp = new ArrayList<>(Arrays.asList(box));

    tmp.remove(index);
    _currentSize--;
    if (_capacity > 10 && _currentSize * 2 < _capacity) {
      //
      tmp.subList(_capacity / 2 - 1, _capacity).clear();
      _capacity /= 2;
    }

    _arr = tmp.stream().mapToInt(Integer::intValue).toArray();
  }

  // 获取指定索引的元素
  public int get(int index) {
    //write ur code here.
    return _arr[index];
  }

  // 设置指定索引的元素值
  public void set(int index, int value) {
    //write ur code here.
    _arr[index] = value;
  }

  // 返回数组当前大小
  public int size() {
    //write ur code here.
    return _currentSize;
  }

  // 返回数组当前容量
  public int capacity() {
    //write ur code here.
    return _capacity;
  }

  // 打印数组的所有元素
  public void print() {
    //write ur code here.
    for (int i = 0; i < _currentSize; i++) {
      System.out.printf("%d ", _arr[i]);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Tools.toolsDA();
  }
}
