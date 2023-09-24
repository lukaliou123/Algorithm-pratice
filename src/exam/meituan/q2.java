package exam.meituan;
import java.util.*;
public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //找出最大的两个数，做乘
        int n = sc.nextInt();
        long[] arr = new long[n];
        long sum = 0;
        //第一次遍历数组
        long max1 = Long.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            sum += arr[i];
            if (arr[i] > max1) {
                max1 = arr[i];
                idx = i;
            }
        }
        // //第二次找最大
        // long max2 = Long.MIN_VALUE;
        // for (int i = 0; i < n; i++) {
        //     if (i != idx && arr[i] > max2) {
        //         max2 = arr[i];
        //     }
        // }
        Arrays.sort(arr);
        long max2 = arr[n-2];
        if(max1<=1 || max2<=1 || max1+max2 >= max1*max2){
            System.out.println(sum);
        }else{
            sum=sum-max1-max2+max1*max2;
            System.out.println(sum);
        }

    }
}
