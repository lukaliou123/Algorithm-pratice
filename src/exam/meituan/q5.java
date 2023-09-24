package exam.meituan;
import java.util.*;
public class q5 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        HashMap<Integer,Integer> countMap = new HashMap<>();

        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
            countMap.put(arr[i],countMap.getOrDefault(arr[i],0)+1);
        }
        int mode = 0;
        int maxCount = 0;
        for(int key:countMap.keySet()){
            if(countMap.get(key) > maxCount){
                maxCount = countMap.get(key);
                mode = key;
            }
        }
        long operations = 0;
        for(int key:countMap.keySet()){
            if(key<mode){
                operations += (mode-key-1)*countMap.get(key);
            }else if(key>mode){
                operations += (key-mode-1)*countMap.get(key);
            }

        }
        System.out.println(operations);
    }
}
