package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class DrawMoney {

  static final int CANI_NUM = 1004;
  static final int COIN_NUM = 2004;
  static Integer[][] canisters = new Integer[CANI_NUM][];
  static int[] maxGainList = new int[COIN_NUM];

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int[] ags = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int cap = ags[1];

    for (int i = 0; i < ags[0]; i++) {

      int[] ctts = Arrays.stream(bf.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
      canisters[i] = Arrays.stream(ctts).boxed().toArray(Integer[]::new);

      int[] preSum = new int[ctts.length];
      // 算出前缀和
      for (int j = 1; j < preSum.length; j++) {
        preSum[j] = preSum[j - 1] + canisters[i][j];
      }
      // 更新maxGainList
      int[] nowMaxGainList = new int[cap + 1];

      for (int j = 1; j < preSum.length && j <= cap; j++) {
        for (int k = j; k <= cap; k++)
          nowMaxGainList[k] = Integer.max(nowMaxGainList[k], preSum[j] + maxGainList[k - j]);
      }
      for (int j = 1; j <= cap ; j++) {
        maxGainList[j] = Integer.max(maxGainList[j], nowMaxGainList[j]);
      }

    }

    System.out.println(maxGainList[cap]);
  }
}
