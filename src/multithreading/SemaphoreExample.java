package multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private static final int MAX_CONCURRENT_THREADS = 3;
    private static final Semaphore semaphore = new Semaphore(MAX_CONCURRENT_THREADS);

    public static void main(String[] args) {
        for(int i=0;i<=5;i++){
            Thread thread = new Thread(() ->{
                try{
                    System.out.println("Thread "+ Thread.currentThread().getName()
                            + " is trying to acquire the permit. ");
                    semaphore.acquire();
                    System.out.println("Thread "+ Thread.currentThread().getName()
                            + " has acquired the permit");
                    Thread.sleep(2000);
                    System.out.println("Thread "+ Thread.currentThread().getName() +
                            " is releasing the permit. ");
                    semaphore.release();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }
}
