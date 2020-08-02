package taskLesson04;

public class WorkWithThread {

    public static void main(String[] args) {

// 1. Создать три потока, каждый из которых выводит определенную букву
// (A, B и C) 5 раз (порядок – ABСABСABС). Используйте wait/notify/notifyAll.

        PrintThread go = new PrintThread();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                go.printLetterA();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                go.printLetterB();
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                go.printLetterC();
            }
        });


        thread1.start();
        thread2.start();
        thread3.start();

// 2. Создать модель MFU (c возможность сканирования, печати и ксерокопии)

        MFP mfp = new MFP();
        User user1 = new User("Felix", mfp);
        User user2 = new User("Dorotheus", mfp);
        User user3 = new User("Aristarch", mfp);
        User user4 = new User("Cassandra", mfp);
        User user5 = new User("Kira", mfp);

    }

}
