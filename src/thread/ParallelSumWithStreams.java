package thread;
import java.util.Arrays;

public class ParallelSumWithStreams {

    public static void main(String[] args) {
        final int SIZE = 1_000_000;
        int[] numbers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = i + 1; // 1, 2, 3, ..., 1000000
        }

        long startTime = System.nanoTime();

        long sum = Arrays.stream(numbers).parallel().asLongStream().sum();

        long endTime = System.nanoTime();

        System.out.println("Sum: " + sum);
        System.out.printf("Time taken: %.2f seconds%n", (endTime - startTime) / 1e9);
    }
}

