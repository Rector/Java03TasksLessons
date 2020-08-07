package taskLesson05;

import java.util.concurrent.CountDownLatch;

public class MainClass {
//    1. Организуем гонки:
//    Все участники должны стартовать одновременно, несмотря на то, что на подготовку у каждого из них уходит разное время.
//    В туннель не может заехать одновременно больше половины участников (условность).
//    Попробуйте всё это синхронизировать.
//    Только после того как все завершат гонку, нужно выдать объявление об окончании.
//    Можете корректировать классы (в т.ч. конструктор машин) и добавлять объекты классов из пакета util.concurrent.

    public static final int CARS_COUNT = 4;
    public static final int LAST_STAGE = 40;
    static CountDownLatch readinessInRace = new CountDownLatch(CARS_COUNT);
    static CountDownLatch endRace = new CountDownLatch(CARS_COUNT);


    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(80, 2), new Road(LAST_STAGE));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }


        try {
            readinessInRace.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            endRace.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
