package taskLesson04;

public class MFP extends Thread {
    private volatile boolean lockCopy = true;
    private volatile boolean lockXerocopy = true;
    private volatile boolean lockPrint = true;

    private final Object OBJ = new Object();

    public void print(String nameUser) throws InterruptedException {
        synchronized (OBJ) {
            if (lockPrint && lockXerocopy) {
                lockPrint = false;
                lockXerocopy = false;
                System.out.println("print start " + nameUser);
                System.out.println("print end " + nameUser);

                lockPrint = true;
                lockXerocopy = true;
            }
        }
    }

    public void copy(String nameUser) throws InterruptedException {
        synchronized (OBJ) {
            if (lockCopy && lockXerocopy) {
                lockCopy = false;
                lockXerocopy = false;
                System.out.println("scanning start " + nameUser);
                System.out.println("scanning end " + nameUser);

                lockCopy = true;
                lockXerocopy = true;
            }
        }

    }

    public void xerocopy(String nameUser) throws InterruptedException {
        synchronized (OBJ) {
            if (lockXerocopy && lockCopy) {
                lockXerocopy = false;
                lockCopy = false;
                System.out.println("xerox start " + nameUser);
                System.out.println("xerox end " + nameUser);
                lockXerocopy = true;
                lockCopy = true;
            }
        }
    }
}
