package tree;

import java.util.*;

public class Postorder {
    /**
     * 后序遍历在遍历顺序上是左右中反过来，那么我们让存储顺序变为中右左，然后反过来就行
     */
    Deque<TreeNode> stack = new LinkedList<>();
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(TreeNode root){
        TreeNode cur = root;
        stack.push(cur);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if(pop.left!=null) stack.push(pop.left);
            if(pop.right!=null) stack.push(pop.right);
        }
        Collections.reverse(res);
        return res;
    }
}
