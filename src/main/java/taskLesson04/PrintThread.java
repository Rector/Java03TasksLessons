package taskLesson04;

public class PrintThread {
    private final Object MONITOR = new Object();
    private volatile char symbol = 'A';
    private String letterA = "A";
    private String letterB = "B";
    private String letterC = "C";
    private final int SCORE = 5;


    public void printLetterA() {
        synchronized (MONITOR) {
            try {
                for (int i = 0; i < SCORE; i++) {
                    while (symbol != 'A') {
                        MONITOR.wait();
                    }
                    System.out.print(letterA);
                    symbol = 'B';
                    MONITOR.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void printLetterB() {
        synchronized (MONITOR) {
            try {
                for (int i = 0; i < SCORE; i++) {
                    while (symbol != 'B') {
                        MONITOR.wait();
                    }
                    System.out.print(letterB);
                    symbol = 'C';
                    MONITOR.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void printLetterC() {
        synchronized (MONITOR) {
            try {
                for (int i = 0; i < SCORE; i++) {
                    while (symbol != 'C') {
                        MONITOR.wait();
                    }
                    System.out.print(letterC);
                    symbol = 'A';
                    MONITOR.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
