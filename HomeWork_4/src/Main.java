public class Main {
    private final Object obj = new Object();
    private volatile char letter = 'A';

    public static void main(String[] args) {
        Main m = new Main();
        Thread thread1 = new Thread(() -> {m.printA();});
        Thread thread2 = new Thread(() -> {m.printB();});
        Thread thread3 = new Thread(() -> {m.printC();});

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private void printA(){
        synchronized (obj){
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'A') {
                        obj.wait();
                    }
                    System.out.print("A");
                    letter = 'B';
                    obj.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printB(){
        synchronized (obj){
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'B') {
                        obj.wait();
                    }
                    System.out.print("B");
                    letter = 'C';
                    obj.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printC(){
        synchronized (obj){
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'C') {
                        obj.wait();
                    }
                    System.out.print("C");
                    letter = 'A';
                    obj.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
