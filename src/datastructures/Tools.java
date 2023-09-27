package datastructures;

import java.util.Scanner;

public class Tools {
  public static void toolsDA() {
    Scanner scanner = new Scanner(System.in);
    String in1;
    scanner.next();
    DynamicArray arr = new DynamicArray();
    int in2;
    int in3;
    while (scanner.hasNext()) {
      in1 = scanner.next();
      if (in1.equals("append")) {
        in2 = scanner.nextInt();
        arr.append(in2);
      }
      if (in1.equals("erase")) {
        in2 = scanner.nextInt();
        arr.erase(in2);
      }
      else if (in1.equals("get")) {
        in2 = scanner.nextInt();
        System.out.println(arr.get(in2));

      }
      else if (in1.equals("set")) {
        in2 = scanner.nextInt();
        in3 = scanner.nextInt();
        arr.set(in2, in3);
      }
      else if (in1.equals("size")) {
        System.out.println(arr.size());
      }
      else if (in1.equals("capacity")) {
        System.out.println(arr.capacity());
      }
      else if (in1.equals("print")) {
        arr.print();
      }
    }

    scanner.close();
  }

  public static void toolsLL() {
    Scanner scanner = new Scanner(System.in);
    String in1 = scanner.next();
    int in2;
    LinkedList l = new LinkedList();
    while (scanner.hasNext()) {
      in1 = scanner.next();
      if (in1.equals("pushFront")) {
        in2 = scanner.nextInt();
        l.pushFront(in2);
      } else if (in1.equals("pushBack")) {
        in2 = scanner.nextInt();
        l.pushBack(in2);
      } else if (in1.equals("search")) {
        in2 = scanner.nextInt();
        if (l.search(in2)) {
          System.out.println(1);
        } else {
          System.out.println(0);
        }
      } else if (in1.equals("remove")) {
        in2 = scanner.nextInt();
        l.remove(Integer.valueOf(in2));
      } else if (in1.equals("print")) {
        l.print();
      }
    }
    scanner.close();
  }

  public static void toolsCQ() {
    Scanner scanner = new Scanner(System.in);
    String in1;
    int in2;
    int in3;
    scanner.next();
    in2 = scanner.nextInt();
    CircularQueue cq = new CircularQueue(in2);

    while (scanner.hasNext()) {
      in1 = scanner.next();

      if (in1.equals("enqueue")) {
        in2 = scanner.nextInt();
        cq.enqueue(in2);
      }
      else if (in1.equals("dequeue")) {
        cq.dequeue();
      }
      else if (in1.equals("front")) {
        System.out.println(cq.front());
      }
      else if (in1.equals("rear")) {
        System.out.println(cq.rear());
      }
      else if (in1.equals("isEmpty")) {
        if (cq.isEmpty()) {
          System.out.println("1");
        }
        else {
          System.out.println("0");
        }
      }
      else if (in1.equals("isFull")) {
        if (cq.isFull()) {
          System.out.println("1");
        }
        else {
          System.out.println("0");
        }
      }
    }
    scanner.close();
  }
}
