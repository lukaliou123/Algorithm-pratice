package tree;


import java.util.Deque;
import java.util.*;


public class Inorder {
    /**
     * 二叉树的中序迭代遍历
     * 大致写法就是使用栈，
     * 1.先创造一个栈，然后在root不为null或者stack不为空的情况下进行运行。前者是保证一直能输入节点，后者是保证stack能一直输出。
     * 2.将节点在while里放入，先一直插入左子树，直到到null，接着将第一个左节点排出，将这个左节点的右子树放进去，直到跑完整个树为止
     */
    //创建一个栈和一个用来输出答案的list
    Deque<TreeNode> stack = new LinkedList<>();
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorder(TreeNode root){
        TreeNode cur  = root;
        //root不为null或者stack不为空的情况下进行运行
        while(cur!=null || !stack.isEmpty()){
            //一直遍历左子树，直到没有
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            //如果没有了，就把peak的节点弹出，放到res里
            TreeNode pop = stack.pop();
            res.add(pop.val);

            //这样子，就会将叶子节点开始往上，直到有右节点的节点为止
            cur = pop.right;
        }
        return res;
    }
}



