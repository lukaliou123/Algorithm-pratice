package exam.meituan;
import java.util.*;
public class q4 {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for(int i = 0;i<n;i++){
            a[i]=sc.nextInt();
            sum+=a[i];
        }
        long[][] dp = new long[n+1][sum+1];
        dp[0][0] = 1;
        for(int i = 1;i<=n;i++){
            for(int j =0;j<=sum;j++){
                for(int k =1;k<=300;k++){
                    if(k!=a[i-1] && j>=k){
                        dp[i][j] = (dp[i][j] + dp[i-1][j-k])%MOD;
                    }
                }
            }
        }
        System.out.println(dp[n][sum]);
    }
}
