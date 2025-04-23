import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        // Tạo hàng đợi với kích thước tối đa là 2
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

        // Producer thread
        new Thread(() -> {
            try {
                queue.put("Task 1");
                System.out.println("Produced: Task 1");
                queue.put("Task 2");
                System.out.println("Produced: Task 2");
                queue.put("Task 3"); // Bị chặn vì hàng đợi đầy
                System.out.println("Produced: Task 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        System.out.println(queue);

        // Consumer thread
        new Thread(() -> {

            try {
                Thread.sleep(1000); // Giả lập độ trễ 1 giây
                System.out.println("Consumed: " + queue.take());
                System.out.println("Consumed: " + queue.take());
                System.out.println("Consumed: " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println(queue);


    }
}