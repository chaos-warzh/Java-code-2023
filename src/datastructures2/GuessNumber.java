package datastructures2;

public class GuessNumber {
  //check已在Tools.java中定义，你可以通过Tools.check(int)调用
  public static int guessNumber() {
    //write ur code here.

    if (Tools.check(Integer.MAX_VALUE) == 0) {
      return Integer.MAX_VALUE;
    }


    Integer min = Integer.MIN_VALUE;
    Integer max = Integer.MAX_VALUE;
    while (true) {
      Integer guess = 0;
      if (max >> 31 == min >> 31) {
        guess = (max - min) / 2 + min;
      } else {
        guess = (max + min) / 2;
      }
      switch (Tools.check(guess)) {
        case 1:
          max = guess;
          break;
        case -1:
          min = guess;
          break;
        case 0:
          return guess;
      }
    }
  }

  public static void main(String[] args) {
    Tools.toolsGN();
  }
}
