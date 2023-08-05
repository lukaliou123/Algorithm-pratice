package mix;

import java.util.*;

public class GenerPar {

    public List<String> generateParenthesis(int n){
        List<String> res = new ArrayList<>();
        //回溯，参数剩余左括号和有括号的数量，以及当前已经产生的字符
        backtrack("",n,n,res);
        return res;
    }

    /**
     *
     * @param curStr 代表要存放的字符
     * @param left  代表左括号的数量
     * @param right 代表右括号的数量
     * @param res  代表要存放的List
     */
    public static void backtrack(String curStr, int left, int right, List<String> res){
        //终止条件
        //如果左右括号的数量都消耗完的话
        if(left==0&&right==0){
            res.add(curStr);
            return;
        }

        //如果还有左括号，我们就添加一个左括号，并将剩余的左括号数量减一
        if(left > 0){
            backtrack(curStr+"(",left-1,right,res);
        }

        //如果还有右括号，我们就添加一个右括号，将剩余的右括号数量减一
        if(right > left){
            backtrack(curStr+")",left,right-1,res);
        }
    }
}
