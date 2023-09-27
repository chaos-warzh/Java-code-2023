package datastructures;

public class CircularQueue {
  private int[] arr;
  private int frontIdx;
  private int backIdx;
  private int size;

  public CircularQueue (int capacity) {
    arr = new int[capacity];
    frontIdx = 0;
    backIdx = -1; // 初始时队列为空
    size = 0;
  }

  // 入队列，若队列已满则不添加
  public void enqueue(int value) {
    //write ur code here.
    if (size < arr.length) {
      backIdx++;
      backIdx %= arr.length; // circular
      arr[backIdx] = value;
      size++;
    }
  }

  // 出队列
  public void dequeue() {
    //write ur code here.
    if (this.isEmpty()) {
      System.out.println("Warning: Don't dequeue the null!");
      return;
    }

    frontIdx++;
    frontIdx %= arr.length;
    size--;
  }

  // 返回队首元素
  public int front() {
    //write ur code here.

    return arr[frontIdx];
  }

  // 返回队尾元素
  public int rear() {
    //write ur code here.
    return arr[backIdx];
  }

  // 检查是否为空
  public boolean isEmpty() {
    //write ur code here.
    return size == 0;
  }

  // 检查是否已满
  public boolean isFull() {
    //write ur code here.
    return size == arr.length;
  }

  public static void main(String[] args) {
    Tools.toolsCQ();
  }
}
