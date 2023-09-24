package tree;
import java.util.*;

public class NTreeTarget {
    List<Node> path = new ArrayList<>();

    public boolean findPath(Node root, Node target) {
        if (root == null) return false;

        // 加入路径
        path.add(root);

        // 找到目标节点
        if (root == target) return true;

        // 递归子节点
        for (Node child : root.children) {
            if (findPath(child, target)) {
                return true;
            }
        }

        // 未找到，回退
        path.remove(path.size() - 1);
        return false;
    }
}
