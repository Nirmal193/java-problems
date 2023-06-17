package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i=0;i<3;i++)
            executorService.submit(new Task(phaser));
        executorService.shutdown();
    }
    static class Task implements Runnable{
        private Phaser phaser;

        Task(Phaser phaser){
            this.phaser = phaser;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName());
            phaser.arriveAndDeregister();
        }

    }
}
