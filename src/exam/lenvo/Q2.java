package exam.lenvo;
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        System.out.println(getMax(k,s));
    }
    public static String getMax(int k, String s){
        char[] arr = s.toCharArray();
        int len = arr.length;
        int i = 0;
        for(char c:arr){
            int cNum = Character.getNumericValue(c);
            if(k>=cNum){
                break;
            }else{
                i++;
            }
        }
        //System.out.println(i);
        StringBuilder sb = new StringBuilder(s);
        sb.insert(i,k);
        return sb.toString();
    }
}
