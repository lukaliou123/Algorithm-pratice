package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Preorder {
    /**
     * 先序遍历比较简单，将节点放进去，然后左右节点排入再排出即可
     * 唯一需要注意的是因为栈的特性，进入的时候要先右再左
     */
    Deque<TreeNode> stack = new LinkedList<>();
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(TreeNode root){
        TreeNode cur = root;
        stack.push(cur);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if(pop.right!=null) stack.push(pop.right);
            if(pop.left!=null) stack.push(pop.left);
        }
        return res;
    }
}
