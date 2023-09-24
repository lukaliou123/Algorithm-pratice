package thread;

import java.io.File;
import java.util.concurrent.CountDownLatch;

/**
 * 题目：并发文件处理
 *
 * 假设有一个程序需要读取和处理10个大文件。每个文件的处理都是独立的，可以并行执行。每个文件的处理包括读取文件、对文件内容进行一些复杂的计算，并将结果写回到一个新的文件中。
 *
 * 请使用CountDownLatch来确保：
 *
 * 所有文件都被处理完成后，主线程打印出“所有文件处理完毕！”的消息。
 * 在所有文件开始处理之前，主线程打印出“开始处理文件...”的消息。
 * 你可以假设有一个processFile(File file)的方法，该方法负责处理单个文件。
 *
 * 这个题目测试了候选人使用CountDownLatch来协调多个线程的能力。要正确解决这个问题，候选人需要创建两个CountDownLatch对象：一个用于等待所有线程开始执行，另一个用于等待所有线程执行完毕。
 *
 * 在解决这类题目时，候选人需要确保：
 *
 * 正确初始化CountDownLatch的计数器。
 * 在每个文件处理线程的开始和结束时正确调用countDown方法。
 * 在主线程中正确使用await方法来等待所有文件处理线程开始执行和执行完毕
 */

public class FileProcessor {

    public static void processFile(File file) {
        // 假设这是处理文件的函数
        System.out.println("Processing file: " + file.getName());
    }

    public static void main(String[] args) {
        int fileCount = 10; // 假设有10个文件需要处理
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch doneLatch = new CountDownLatch(fileCount);

        for (int i = 0; i < fileCount; i++) {
            final int finalI = i;
            new Thread(() -> {
                try {
                    // 等待开始信号
                    startLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 处理文件
                processFile(new File("File" + finalI));
                // 文件处理完毕，计数器减1
                doneLatch.countDown();
            }).start();
        }

        // 确保所有线程都已准备好
        System.out.println("开始处理文件...");
        startLatch.countDown();

        try {
            // 等待所有线程完成文件处理
            doneLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 所有文件都已处理完毕
        System.out.println("所有文件处理完毕！");
    }
}
