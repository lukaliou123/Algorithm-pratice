package thread;

import java.util.concurrent.Semaphore;

public class ABCPrinterWithSemaphore {
    private static Semaphore semA = new Semaphore(1);
    private static Semaphore semB = new Semaphore(0);
    private static Semaphore semC = new Semaphore(0);

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    semA.acquire();
                    System.out.print("A");
                    semB.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    semB.acquire();
                    System.out.print("B");
                    semC.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    semC.acquire();
                    System.out.print("C");
                    semA.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
