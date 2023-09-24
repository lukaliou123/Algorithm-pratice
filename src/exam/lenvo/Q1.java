package exam.lenvo;
import java.util.*;
/**
 * 复制粘贴
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 输入一个长度为n的仅包含英文字母的字符串，下标从 1 开始。你对这个字符串进行如下操作Q次，第i次操作如下：
 *
 * • li，ri，k，表示复制原串中下标为li，li+1，…，ri的字符串，之后：如果k=0，则将其粘贴在字符串的前面；如果k=1，则将其粘贴在字符串的末尾。
 *
 * 你需要输出经过Q次操作之后得到的字符串。
 *
 *
 *
 * 输入描述
 * 第一行两个正整数 n，Q(1≤n，Q≤2×104)。
 *
 * 第二行一个长度为n的仅包含英文字母的字符串。
 *
 * 第三行包含Q个正整数：l1，l2，…，lQ；
 *
 * 第四行包含Q个正整数：r1，r2，…，rQ；
 *
 * 第五行包含Q个正整数：k1，k2，…，kQ。
 *
 * 数据保证：1≤li≤ri≤n，0≤ ri - li ＜10，ki∈｛0,1｝，且输入的区间范围合法。
 *
 * 输出描述
 * 输出一行，表示最后得到的字符串。
 *
 *
 * 样例输入
 * 7 2
 * XabcdeZ
 * 2 1
 * 4 7
 * 0 1
 * 样例输出
 * abcXabcdeZXabcdeZ
 *
 * 提示
 * 第一次操作为 l1=2，r1=4，k1=0，复制的子串为 abc，将其粘贴在字符串开头，此时字符串为 abcXabcdeZ。
 *
 * 第二次操作为 l2=1，r2=7，k2=1，复制的子串为 XabcdeZ，即整个原串，将其粘贴在字符串末尾，此时字符串为abcXabcdeZXabcdeZ。
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int Q = sc.nextInt();
        String s = sc.next();

        int[] l = new int[Q];
        int[] r = new int[Q];
        int[] k = new int[Q];
        for(int i = 0;i<Q;i++){
            l[i] = sc.nextInt();
        }
        for(int i = 0;i<Q;i++){
            r[i] = sc.nextInt();
        }
        for(int i = 0;i<Q;i++){
            k[i] = sc.nextInt();
        }
        List<String> res = copyPaste(l,r,s);
        for(int i = 0;i<Q;i++){
            if(k[i]==0){
               s = res.get(i)+s;
            }else{
                s = s+res.get(i);
            }
        }
        System.out.printf(s);
    }
    public static List<String> copyPaste(int[] l, int[] k,String s){
        int n = l.length;
        List<String> res = new ArrayList<>();
        for(int i = 0;i<n;i++){
            String s1 = s.substring(l[i]-1,k[i]);
            res.add(s1);
        }
        return res;
    }
}
