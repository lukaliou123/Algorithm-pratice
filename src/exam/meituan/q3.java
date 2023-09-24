package exam.meituan;
import java.util.*;
public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans = 0;
        for(int i = 0;i<s.length();i++){
            for(int j = 1;j<s.length();j++){
                ans+=getWeight(s.substring(i,j+1));
            }
        }
        System.out.println(ans);
    }
    public static int getWeight(String s){
        int count = 0;
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
                i++;
            }
        }
        return count;
    }
}
