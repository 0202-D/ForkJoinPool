package task3;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * @author Dm.Petrov
 * DATE: 10.09.2022
 */
public class Main {
    public static void main(String[] args) {
        int [] array = generate();
        long time =System.currentTimeMillis();
        System.out.println("Сумма элементов массива - "+sumElementArray(array));
        System.out.println("Время выполнения в однопоточной среде - "+(System.currentTimeMillis()-time)+"mls");
        CounterSumOfArrayElements counter = new CounterSumOfArrayElements(array);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long time2 = System.currentTimeMillis();
        System.out.println("Сумма элементов массива - "+forkJoinPool.invoke(counter));
        System.out.println("Время выполнения в многопоточной среде - "+(System.currentTimeMillis()-time2)+"mls");
        // Казалось , что в многопоточной среде будет быстрее , но нет ...
    }
    public static int [] generate(){
        int [] array = new int [1000];
        Random r = new Random();
        for (int i = 0; i <1000 ; i++) {
            array[i]=r.nextInt(5000);
        }
        return array;
    }
    public static long sumElementArray(int [] array){
        return Arrays.stream(array).sum();
    }

}
