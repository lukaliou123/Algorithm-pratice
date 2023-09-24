package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public boolean isCompleteBT(Node root) {
        if (root == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        boolean flag = false; // 标记找到第一个没有左孩子或右孩子的节点

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left != null) {
                if (flag) { // 如果标记为true，但我们仍然找到了一个左孩子，那么它不是完全二叉树
                    return false;
                }
                queue.add(temp.left);
            } else {
                flag = true; // 没有左孩子，设置标记为true
            }

            if (temp.right != null) {
                if (flag) { // 如果标记为true，但我们仍然找到了一个右孩子，那么它不是完全二叉树
                    return false;
                }
                queue.add(temp.right);
            } else {
                flag = true; // 没有右孩子，设置标记为true
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        if (tree.isCompleteBT(root)) {
            System.out.println("The tree is a complete binary tree");
        } else {
            System.out.println("The tree is not a complete binary tree");
        }
    }
}
