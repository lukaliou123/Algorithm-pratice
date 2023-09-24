package thread;

/**
 * 用两个线程各跑奇偶
 * 这里的代码通过两个线程和一个共享变量（value）实现了奇偶数的交替打印。
 * 当value是奇数时，奇数线程进行打印，偶数线程等待；当value是偶数时，
 * 偶数线程进行打印，奇数线程等待。通过synchronized块来确保互斥，
 * 并使用wait和notify来实现线程之间的协作。
 */
public class PrintOddEven {

    private int value = 1; // 当前需要打印的值
    private final Object lock = new Object(); // 锁对象

    // 打印奇数的线程
    public void printOdd() {
        while (value <= 100) {
            synchronized (lock) {
                if (value % 2 == 0) { // 如果是偶数，则等待
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (value <= 100) {
                    System.out.println("奇数：" + value);
                    value++;
                    lock.notify(); // 唤醒偶数线程
                }
            }
        }
    }

    // 打印偶数的线程
    public void printEven() {
        while (value <= 100) {
            synchronized (lock) {
                if (value % 2 != 0) { // 如果是奇数，则等待
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (value <= 100) {
                    System.out.println("偶数：" + value);
                    value++;
                    lock.notify(); // 唤醒奇数线程
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintOddEven printer = new PrintOddEven();

        // 创建奇数线程
        Thread oddThread = new Thread(printer::printOdd);

        // 创建偶数线程
        Thread evenThread = new Thread(printer::printEven);

        oddThread.start();
        evenThread.start();
    }
}
