package exam.uu;

import java.util.Arrays;

public class q3 {
    public static void main(String[] args) {
        int[][] test1 = {{1,2,5},{1,3,6},{2,3,1}};
        System.out.println(minimumCost(3,test1));
    }
    public static int minimumCost(int N, int[][] connections) {
        // 并查集初始化
        int[] parent = new int[N + 1];
        for (int i = 0; i <= N; ++i) {
            parent[i] = i;
        }

        // 按照权重排序所有的边
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);

        int totalCost = 0, count = 1;
        for (int[] connection : connections) {
            int rootX = find(parent, connection[0]);
            int rootY = find(parent, connection[1]);
            if (rootX != rootY) {
                // 如果两个节点未被连接，添加这条边到最小生成树
                totalCost += connection[2];
                parent[rootX] = rootY;  // 合并两个节点
                ++count;
            }
        }

        // 如果所有的节点都被联通，返回最小的花费；否则，返回-1
        return count == N ? totalCost : -1;
    }

    // 查找节点的根节点
    private static int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

}
