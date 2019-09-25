package scratch;

import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;

    private volatile int value = 0;
    private volatile int temp = 0;

//    private volatile boolean lastOdd = false;
//    private volatile boolean lastEven = true;
//    private volatile boolean lastZero = false;


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        synchronized(this) {
            while(true) {
                if (value == n) return;
                if (value == 0) {
                    printNumber.accept(0);
                    value = temp + 1;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        synchronized(this) {
            while(true) {
                if (value == n+1) return;
                if (value != 0 && value%2 == 0) {
                    printNumber.accept(value);
                    temp = value;
                    value = 0;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        synchronized(this) {
            while(true) {
                if (value == n+1) return;
                if (value%2 != 0) {
                    printNumber.accept(value);
                    temp = value;
                    value = 0;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }



    public static void main(String ar[]){

        ZeroEvenOdd obj = new ZeroEvenOdd(1);
        IntConsumer consumer = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println("."+value);
            }
        };

        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    obj.zero(consumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                try {
                    obj.odd(consumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t3 = new Thread(){
            @Override
            public void run() {
                try {
                    obj.even(consumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        t3.start();
        t2.start();

    }
}