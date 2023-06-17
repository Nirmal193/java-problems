package multithreading;

import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {
    private static final StampedLock lock = new StampedLock();
    private static final double[] cordinates = new double[2];

    public static void main(String[] args) {
        Thread writeThread = new Thread(()->{
            for(int i=0;i<=1000;i++){
                long stamp = lock.writeLock();
                try{
                    cordinates[0] = i;
                    cordinates[1] = i*2;
                }finally {
                    lock.unlockWrite(stamp);
                }
            }
        });
        Thread readerThread = new Thread(()->{
            int count = 20;
            while(true){
                count--;
                long stamp = lock.tryOptimisticRead();
                double x = cordinates[0];
                double y = cordinates[1];
                if(!lock.validate(stamp)){
                    stamp = lock.readLock();
                    try{
                        x = 500;
                        y = 321321321;
                    }finally {
                        lock.unlockRead(stamp);
                    }
                }
                System.out.println("Cordinates Read: ( "+ x +", " + y + ")");
            }
        });
        writeThread.start();
        readerThread.start();
    }
}
