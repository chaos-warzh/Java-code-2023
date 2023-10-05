package hw1;

public class Pi {
  static Double TEMP = 640320.0;
  static Double pi1 = Math.log(TEMP*TEMP*TEMP + 744) / Math.sqrt(163);
  static Double pi2 = 4 * (4 * Math.atan(1.0 / 5) - Math.atan(1.0 / 239));

  public static void main(String[] args) {
    System.out.printf("%.15f%n", pi1);
    System.out.printf("%.15f%n", pi2);

  }
}
