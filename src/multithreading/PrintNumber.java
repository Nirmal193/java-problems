package multithreading;

public class PrintNumber {
    public static void main(String[] args) {
        NumberPrinter printer1 = new NumberPrinter(1, 5);
        NumberPrinter printer2 = new NumberPrinter(6, 10);

        // Start both threads
        printer1.start();
        printer2.start();


        Thread thread = new Thread(()->{
            System.out.println("some value to printed");
        });
        thread.start();
    }
}
 class NumberPrinter extends Thread{
    private int start;
    private int end;
     public NumberPrinter(int start, int end) {
         this.start = start;
         this.end = end;
     }
    @Override
     public void run(){
        for(int i=start;i<=end;i++){
            synchronized (NumberPrinter.class) {
                System.out.println(i);
                NumberPrinter.class.notify();
                try {
                    // Wait for the other thread to print its number
                    if (i != end) {
                        NumberPrinter.class.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
