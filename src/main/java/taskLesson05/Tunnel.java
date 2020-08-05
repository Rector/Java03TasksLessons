package taskLesson05;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore restrictionOfMovement;

    public Tunnel(int length, int limit) {
        this.length = length;
        restrictionOfMovement = new Semaphore(limit);
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);

                restrictionOfMovement.acquire();

                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);

                restrictionOfMovement.release();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
