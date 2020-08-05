package taskLesson05;

import java.util.concurrent.atomic.AtomicInteger;

import static taskLesson05.MainClass.LAST_STAGE;

public class Road extends Stage {
    private AtomicInteger winner = new AtomicInteger(0);


    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);


            if(length == LAST_STAGE){
                MainClass.endRace.countDown();
                if(winner.incrementAndGet() == 1){
                    System.out.println(c.getName() + " Победитель!!!");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
