package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class DrawMoney {

  // doing what to find the max? 1: 枚举 -> 最简单, 最直接, 是否可以dp实现?
  // 已经拿了一个, 拿2个, 状态转移函数? 这个算法不行.
  // 假设 最后一个栈注定不拿, 那么前6个里面有一个最优方案; base case, 如果6个栈都不拿, 那么只拿一个栈, 就是尽可能的拿 (可能拿不满钱包)
  // 转移函数是什么样的呢? 若没拿满, 则先拿新的拿一个栈; 若拿满了, 从已拿的里面最小的开始pop, pop掉一个, push进一个, 直到最后, 用一个数组记忆拿的过程, 把增的最大的(也可能是维持原状)留下,继续转移.

  static final int STACK_NUM = 1003;
  static Stack[] canisters = new Stack[STACK_NUM];
  static Stack[] poppedOut = new Stack[STACK_NUM]; // 构造有记忆栈
  static int maxMoney = 0;
  static int coinGained = 0;

  public static int findMinInHistory(int nowStack) {
    int toCheck = nowStack; // 恰好是这样的, 检查 [0, toCheck)

    int min_index = 0;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < toCheck; i++) {
      if (!poppedOut[i].empty() && (int)poppedOut[i].peek() < min) {
        min = (int)poppedOut[i].peek();
        min_index = i;
      }
    }
    return min_index;
  }

  public static void adjustToNewMax(int nowStack, int cap) { // 刷新max, 重新建构栈的格局
    Integer[] canLength = new Integer[nowStack]; // 原始的记忆
    for (int i = 0; i < nowStack; i++) {
      canLength[i] = canisters[i].size();
    }

    // 下面考虑将用maxValue和深度数组来记忆途中的最大钱数
    int nowRaising = 0;
    int maxRaising = 0;
    int[] canLengthDiff = new int[nowStack]; // 记录调整方案, 初始全为0; 不用调整
    int[] bestCanLengthDiff = new int[nowStack]; // 最优化的调整方案, 初始全为0; 不用调整
    Integer newTakeNum = 0;
    Integer bestTakeNum = 0;

    // 准备开始遍历
    while ( ! canisters[nowStack].empty() && newTakeNum < cap) {
      Integer take = (int)canisters[nowStack].pop();
      poppedOut[nowStack].push(take);

      int rtrIndex = findMinInHistory(nowStack);
      Integer rtr = (int)poppedOut[rtrIndex].pop();
      canisters[rtrIndex].push(rtr);

      canLengthDiff[rtrIndex]++; // Cuz returned 1
      newTakeNum++; //

      nowRaising += take - rtr;

      if (nowRaising > maxRaising) {
        maxRaising = nowRaising;
        bestCanLengthDiff = canLengthDiff.clone(); // 深拷贝, 记录此时的数值!
        bestTakeNum = newTakeNum;
      }
    }

    // 此时, 得到了最优的方案, 只需要按最优信息恢复就行
    maxMoney += maxRaising;
    // 恢复每一个栈
    // 先恢复最近的栈
    while (poppedOut[nowStack].size() > bestTakeNum) {
      canisters[nowStack].push(poppedOut[nowStack].pop());
    }

    // 再按序恢复前面的所有栈
    for (int i = 0; i < nowStack; i++) {
      while (canisters[i].size() > canLength[i] + bestCanLengthDiff[i]) {
        poppedOut[i].push(canisters[i].pop());
      }
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int[] ags = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int cap = ags[1];

    for (int i = 0; i < ags[0]; i++) {
      canisters[i] = new Stack();

      int[] ctts = Arrays.stream(bf.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
      for (int j = ctts.length - 1; j > 0; j--) { // 把 第一个数(栈元素数量) 给丢掉
        canisters[i].push(ctts[j]);
      }
    }

    int nowStack = 0; // 表示当前考虑到的Stack数量 - 1, 从第0个stack开始, 直到nowStack = ags[0] - 1 终止

    for (int i = 0; i < ags[0]; i++, nowStack++) {
      poppedOut[nowStack] = new Stack();

      if (nowStack == 0) {
        for (int j = 0; j < cap; j++) {
          if (canisters[nowStack].empty()) {
            break;
          }
          int coin = (int)canisters[nowStack].pop(); // 依次弹出储钱罐的硬币
          poppedOut[nowStack].push(coin); // 放到弹出 (拿走的) 硬币历史记录中
          coinGained++;
          maxMoney += coin;
        }
      } else {
        if (coinGained < cap) {
          while (coinGained < cap) {
            if (canisters[nowStack].empty()) {
              break;
            }
            int coin = (int)canisters[nowStack].pop();
            poppedOut[nowStack].push(coin);

            coinGained++;
            maxMoney += coin;
          }
          if (canisters[nowStack].empty()) {
            continue;
          } else {
            adjustToNewMax(nowStack, cap);
          }
        } else if (coinGained == cap) {
          adjustToNewMax(nowStack, cap);
        } else {
          assert false;
        }
      }
    }
    System.out.println(maxMoney);
  }
}
