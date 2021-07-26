import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LongAdder counter = new LongAdder();
        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(processors);

        Cash shop1 = new Cash(5, counter, "Пятерочка");
        Cash shop2 = new Cash(5, counter, "Магнит");
        Cash shop3 = new Cash(5, counter, "Мария-Ра");

        executorService.submit(shop1);
        executorService.submit(shop2);
        executorService.submit(shop3);

        executorService.awaitTermination(3, TimeUnit.SECONDS);

        System.out.println("Сумма по трём магазинам: " + counter.sum());
        executorService.shutdown();

    }
}
