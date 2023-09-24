package mix;

import java.util.Arrays;

public class MaximumNumberUnderTarget {
    /**
     * 给定一个target和数字数组，
     * 找出由数字数组组成的小于target的最大值，
     * 23121 {2,4,9} -> 22999
     */

    /**
     * 解法：
     * 1.转换目标数： 首先，将目标数转换为数组形式，以便我们可以逐位比较。
     *
     * 2.回溯搜索： 我们可以从目标数的最高位开始，
     * 逐位确定最终结果的每一位数字。
     * 如果某一位的数字在数字数组中可以找到，
     * 则在该位置尝试使用此数字。如果该数字小于目标数在相同位置的数字，
     * 则我们可以递归地在下一位尝试所有可能的数字。如果该数字等于目标数在相同位置的数字，则
     * 我们应继续验证下一位，直到找到一个比目标数小的数字或达到目标数的末尾。
     *
     * 3.构造结果： 通过回溯搜索，我们可以构造一个小于目标数的最大值。
     */

    /**
     *我的理解：
     * 考虑一个简单的例子 targetDigits = [2, 3, 1, 2, 1] 和 digits = [2, 4, 9]。
     * 当你在第一个位置选择 2，在第二个位置选择 2（小于 3）时，
     * 你可以立即确定剩下的位都应该选择 9 来构建最大可能的值 22999，
     * 所以你可以立即返回这个解，不需要进一步的递归。
     *
     * 就是把digits数组从大到小与目标char组进行比较，要是找到最大的也更小，
     * 那剩下的都按最大来处理，如果相等，就继续递归，不过digits的位置要往前进一位，是吗？
     */

    public static int maxNumber(int target, int[] digits){
        //将target数字转成char array
        char[] targetDigits = Integer.toString(target).toCharArray();
        Arrays.sort(digits); //排序，方便后续查找
        String res =findMax(targetDigits,digits,0);
        return res.isEmpty() ? -1 : Integer.parseInt(res); // 如果找不到解，返回-1，否则返回结果
    }

    /**
     *回溯三部曲
     * 1.确定递归函数返回值
     * 2.确定终止条件
     * 3.确认单层递归逻辑
     */
    //回溯数组,index表示当前添加到什么位置了
    public static String findMax(char[] targetDigits, int[] digits,int index){
        //如果到达目标数字得末尾，说明压根没找到复合的，返回空字符串
        if(index == targetDigits.length){
            return "";
        }
        //从最小位开始算，保证每一位都最大
        for(int i = digits.length-1;i>=0;i--){
            //如果找到的数字小于目标数字的当前位
            if(digits[i]<targetDigits[index]-'0'){
                //试试下一位
                StringBuilder res = new StringBuilder();
                res.append(digits[i]);
                // 填充剩下的位为最大可能的数字
                for (int j = index + 1; j < targetDigits.length; j++) {
                    res.append(digits[digits.length - 1]);
                }
                return res.toString();
            }else if(digits[i] == targetDigits[index]-'0'){
                //如果找到的数等于目标数字得当前位
                String nextPart = findMax(targetDigits, digits,index+1);
                if(!nextPart.isEmpty()){
                    return digits[i]+nextPart; //如果下一位找到了合适的数字，将其添加到结果中
                }
            }

        }return "";//如果没有找到合适的数字，返回null
    }

    public static void main(String[] args) {
        int[] digits = {2,4,9};
        System.out.println(maxNumber(23121,digits));
    }
}
