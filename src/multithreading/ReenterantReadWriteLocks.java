package multithreading;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReenterantReadWriteLocks {
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static final String[] data = new String[10];

    public static void main(String[] args) {
        // This means multiple threads can read the data at the same time but only one thread can write the data in the thread
        Thread writerThread = new Thread(() -> {
            for (int i = 0; i < data.length; i++) {
                lock.writeLock().lock();
                try {
                    data[i] = "Data -> " + i;
                    System.out.println("Data written: " + data[i]);
                } finally {
                    lock.writeLock().unlock();
                }
            }
        });
        Thread readerThread = new Thread(() ->{
            int count  = 2;
            while(count > 0){
                count--;
                lock.readLock().lock();
                try{
                    for(String str: data){
                        System.out.println("Data read: " + str);
                    }
                }finally {
                    lock.readLock().unlock();
                }
            }
        });

        Thread readerThread2 = new Thread(() ->{
            int count = 2;
            while(count>0){
                count--;
                lock.readLock().lock();
                try{
                    for(String str: data){
                        System.out.println("Data read by thread 2: " + str);
                    }
                }finally {
                    lock.readLock().unlock();
                }
            }
        });

        readerThread.start();
        readerThread2.start();
        writerThread.start();
    }
}
