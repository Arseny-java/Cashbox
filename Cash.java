import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Cash implements Runnable {
    LongAdder count;
    int numbers;
    String shopName;

    public Cash(int numbers, LongAdder count,String shopName) {
        this.count = count;
        this.numbers = numbers;
        this.shopName = shopName;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int bound = 100;
        List<Integer> list = new ArrayList<>();

        Thread.currentThread().setName(shopName);
        for (int i = 0; i < numbers; i++) {
            list.add(rand.nextInt(bound));
        }
        System.out.printf("%s имеет в кассе %s%n", Thread.currentThread().getName(), list);
        for (Integer i : list) {
            count.add(i);
        }
    }
}
