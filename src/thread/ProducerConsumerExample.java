package thread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {

    public static void main(String[] args) {
        SharedQueue sharedQueue = new SharedQueue();

        Thread producerThread = new Thread(() -> {
            try {
                sharedQueue.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                sharedQueue.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}

class SharedQueue {
    private static final int CAPACITY = 5;
    private final Queue<Integer> queue = new LinkedList<>();

    void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (queue.size() == CAPACITY) {
                    wait();
                }
                System.out.println("Produced: " + value);
                queue.add(value++);
                notify();
                Thread.sleep(1000); //模拟生产过程
            }
        }
    }

    void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.isEmpty()) {
                    wait();
                }
                int value = queue.poll();
                System.out.println("Consumed: " + value);
                notify();
                Thread.sleep(1500); //模拟消费过程
            }
        }
    }
}
