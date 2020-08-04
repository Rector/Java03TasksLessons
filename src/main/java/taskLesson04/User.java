package taskLesson04;

public class User extends Thread {
    String name;
    private MFP mfp;

    User(String name, MFP mfp) {
        this.name = name;
        this.mfp = mfp;
        start();
    }

    @Override
    public void run() {
        try {
            mfp.copy(name);
            mfp.xerocopy(name);
            mfp.print(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
