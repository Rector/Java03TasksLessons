package taskLesson05;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
//    1. Организуем гонки:
//    Все участники должны стартовать одновременно, несмотря на то, что на подготовку у каждого из них уходит разное время.
//    В туннель не может заехать одновременно больше половины участников (условность).
//    Попробуйте всё это синхронизировать.
//    Только после того как все завершат гонку, нужно выдать объявление об окончании.
//    Можете корректировать классы (в т.ч. конструктор машин) и добавлять объекты классов из пакета util.concurrent.

    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        CyclicBarrier barrier = new CyclicBarrier(CARS_COUNT + 1);
        Race race = new Race(new Road(60), new Tunnel(40, 2), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), barrier);
            new Thread(cars[i]).start();
        }
        try {
            barrier.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            barrier.await();
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}