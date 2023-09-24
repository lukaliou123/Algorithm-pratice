package sort;

import java.util.*;

/**
 * 拓扑排序是针对有向无环图（Directed Acyclic Graph, 简称 DAG）的顶点的线性排序。这样的排序满足：对于图中的每一条有向边 U → V，顶点 U 都在顶点 V 之前。
 *
 * 简单来说，拓扑排序就是要将图中的所有节点排列成一个线性序列，使得对于任何一对节点 U 和 V，如果图中存在从 U 到 V 的有向边，那么 U 就出现在 V 之前。
 *
 * 下面是拓扑排序的基本步骤，我们经常使用的是基于入度的方法：
 *
 * 计算每个节点的入度：入度就是指向该节点的边的数量。
 * 1.将入度为 0 的节点放入队列：这些节点没有任何依赖关系，可以放心选择。
 * 2.从队列中移除节点并输出：即选择这个节点，然后将其从图中移除。
 * 3.移除已选择节点的所有出边：这意味着需要更新与这些边相连的其他节点的入度。
 * 4.如果因为移除出边导致某节点入度变为 0，则将该节点加入队列。
 * 5.重复步骤 3~5，直到队列为空。
 * 如果图中所有节点都被输出，那么说明图是一个 DAG，并且输出的序列是有效的拓扑排序。但如果图中还有节点没有被输出，那么图中存在环。
 *
 * 需要注意的是，DAG 可能有多个合法的拓扑排序序列。
 *
 * 例如，考虑下面的简单情境：你要做三件事，B 依赖于 A（你必须在做 A 之后做 B），而 C 是独立的。那么，合法的拓扑排序序列可以是 A->B->C 或 C->A->B，但不可以是 B->A->C。
 */

public class TopologicalSort {
    public static void main(String[] args) {
        // 模拟一个有向图: 0->1, 0->2, 1->3, 2->3
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(3);

        List<Integer> result = topologicalSort(graph);

        // 打印拓扑排序结果
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> topologicalSort(List<List<Integer>> graph) {
        List<Integer> result = new ArrayList<>();
        int[] indegree = new int[graph.size()];

        // 1. 计算每个节点的入度
        for (List<Integer> neighbors : graph) {
            for (int v : neighbors) {
                indegree[v]++;
            }
        }

        // 2. 将入度为 0 的节点放入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            // 3. 从队列中移除节点并输出
            int u = queue.poll();
            result.add(u);

            // 4. 移除已选择节点的所有出边
            for (int v : graph.get(u)) {
                indegree[v]--;

                // 5. 如果因为移除出边导致某节点入度变为 0，则将该节点加入队列
                if (indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        if (result.size() != graph.size()) {
            System.out.println("图中存在环，没有合法的拓扑排序！");
            return new ArrayList<>();
        }

        return result;
    }
}