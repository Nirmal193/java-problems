package multithreading;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread producerThread = new Thread(() -> {
            try {
                String message = "Hello from the Producer!";
                System.out.println("Producer sends: " + message);
                String receivedMessage = exchanger.exchange(message);
                System.out.println("Producer receives: " + receivedMessage);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                String message = "Hello from the Consumer!";
                System.out.println("Consumer sends: " + message);
                String receivedMessage = exchanger.exchange(message);
                System.out.println("Consumer receives: " + receivedMessage);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
