package mix;

import java.util.HashMap;

public class LengthOfLongestSubstring {

    //寻找最长不重复子串

    /**
     *
     使用哈希表来记录每个字符最后出现的位置，
     并用一个滑动窗口来表示当前的子串，
     这样可以在遍历过程中动态地更新子串的范围，
     进而找到最长的不重复字符的子串
     */
    public int lengthOfLongestSubstring(String s){
        //一个存储字符最后出现位置的字符串
        HashMap<Character,Integer> map = new HashMap<>();
        //初始话滑动窗口的左边界
        int left = 0; //-1方便计算
        //初始化长度
        int maxLength = 0;

        //遍历字符串中所有字符
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);

            //如果当前字符出现过，并且其位置在滑动窗口内，就需要更新滑动窗口
            //这是为了保证滑动窗口内的字符都是不重复的
            if(map.containsKey(c) && map.get(c)>left){
                left = map.get(c)+1;
                //直接将这个数字前一次出现过的位置的下一个作为新的left边界
            }
            //将这个字符更新进去,带状态
            map.put(c,i);
            //更新最大长度
            maxLength = Math.max(maxLength,i-left+1);
        }

        //返回最大长度
        return maxLength;

    }
}
