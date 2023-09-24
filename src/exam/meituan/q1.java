package exam.meituan;
import java.util.*;
public class q1 {
    //似乎本质是mod
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for(int i = 0;i<q;i++){
            long m = sc.nextLong();
            long x = sc.nextLong();

            System.out.println(x%m == 0? m:x%m);
        }
    }
}
