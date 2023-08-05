package exam.uu;

import java.util.Arrays;

public class q2 {
    public static void main(String[] args) {
        int[][] test1 = {{1,2,3},{3,4,2},{2,4,4}};
        System.out.println(maxValue(test1,2));
    }
    public static int maxValue(int[][] interviews, int K) {
        // 按照面试的结束时间进行排序
        Arrays.sort(interviews, (a, b) -> a[1] - b[1]);

        int n = interviews.length;
        int[][] dp = new int[n + 1][K + 1];
        int[] last = new int[n];
        last[0] = -1;

        // 找到每一个面试前最后一个结束时间小于当前面试开始时间的面试
        for (int i = 1; i < n; ++i) {
            last[i] = i - 1;
            while (last[i] >= 0 && interviews[last[i]][1] > interviews[i][0]) {
                last[i] = last[last[i] - 1];
            }
        }

        // 动态规划过程
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= K; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (last[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[last[i - 1] + 1][j - 1] + interviews[i - 1][2]);
                } else if (j == 1) {  // 这是第一个可以进行的面试
                    dp[i][j] = Math.max(dp[i][j], interviews[i - 1][2]);
                }
            }
        }

        return dp[n][K];
    }

}

