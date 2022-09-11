package task3;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

/**
 * @author Dm.Petrov
 * DATE: 10.09.2022
 */
public class CounterSumOfArrayElements extends RecursiveTask<Integer> {
    private int[] array;

    public CounterSumOfArrayElements(int[] array) {
        this.array = array;
    }

    @Override
    protected Integer compute() {
        if (array.length <= 16) {
            return Arrays.stream(array).sum();
        }
        CounterSumOfArrayElements firstHalfArrayValueSumCounter = new CounterSumOfArrayElements(Arrays.copyOfRange(array, 0, array.length / 2));
        CounterSumOfArrayElements secondHalfArrayValueSumCounter = new CounterSumOfArrayElements(Arrays.copyOfRange(array, array.length / 2, array.length));
        firstHalfArrayValueSumCounter.fork();
        secondHalfArrayValueSumCounter.fork();
        return firstHalfArrayValueSumCounter.join() + secondHalfArrayValueSumCounter.join();
    }

}

