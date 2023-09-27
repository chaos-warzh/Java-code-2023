package datastructures;

class ListNode {
  int val;
  ListNode next;
  public ListNode() { val = 0; next = null; }
  public ListNode(int value) { val = value; next = null; }
  public ListNode(int value, ListNode node) { val = value; next = node; }
}

public class LinkedList {
  private ListNode head;

  public LinkedList() {
    head = null; // single linked list
  }

  // 在链表头部插入一个整数值
  public void pushFront(int value) {
    //write ur code here.
//    ListNode tmp = head;
    head = new ListNode(value, head);
  }

  // 在链表尾部插入一个整数值
  public void pushBack(int value) {
    //write ur code here.
    for (ListNode iter = head; iter != null; iter = iter.next) {
      if (iter.next == null) {
        iter.next = new ListNode(value);
        break;
      }
    }
  }

  // 检查链表中是否存在指定的整数值，如果存在返回true，否则返回false
  public boolean search(int value) {
    //write ur code here.
    for (ListNode iter = head; iter != null; iter = iter.next) {
      if (iter.val == value) {
        return true;
      }
    }
    return false;
  }

  // 从链表中删除指定的整数值，如果链表中不存在该值，则不执行任何操作
  public void remove(int value) {
    //write ur code here.
    if (head.val == value) {
      head = head.next;
      return;
    }

    for (ListNode iter = head; iter != null; iter = iter.next) {
      if (iter.next != null && iter.next.val == value) {
        iter.next = iter.next.next;
        return;
      }
    }
  }

  // 打印链表的内容，空格分隔
  public void print() {
    //write ur code here.
    for (ListNode iter = head; iter != null; iter = iter.next) {
      System.out.printf("%d ", iter.val);
    }
    System.out.println();

  }

  public static void main(String[] args) {
    Tools.toolsLL();
  }
}
