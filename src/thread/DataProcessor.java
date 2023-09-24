package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 题目描述
 * 设想一个场景，有4个线程分别从不同的数据源获取数据进行处理，每个线程处理一部分数据。当所有线程都完成各自的数据处理后，再合并所有的数据进行最终的处理。
 *
 * 使用CyclicBarrier实现这个场景。
 */
public class DataProcessor {

    // 假设这是从数据源获取并处理数据的函数
    public static String fetchDataAndProcess(int id) {
        System.out.println("Thread " + id + " is processing data...");
        return "Data from Thread " + id;
    }

    public static void main(String[] args) {
        int threadCount = 4;
        CyclicBarrier barrier = new CyclicBarrier(threadCount, () -> {
            // 当所有线程都到达屏障时执行的合并任务
            System.out.println("All threads have finished processing. Merging data now...");
        });

        for (int i = 0; i < threadCount; i++) {
            final int threadID = i;
            new Thread(() -> {
                try {
                    String processedData = fetchDataAndProcess(threadID);
                    // 等待其他线程
                    barrier.await();
                    // 合并数据
                    System.out.println("Merging data from Thread " + threadID + ": " + processedData);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

