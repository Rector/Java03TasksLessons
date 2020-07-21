package taskLesson01;

import taskLesson01.fruit.Apple;
import taskLesson01.fruit.Fruit;
import taskLesson01.fruit.Orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

// 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);

        Fruit[] fruits = {new Apple(), new Orange()};
        System.out.println("До замены элементов массива: " + fruits[0].getClass() + "\n" + fruits[1].getClass());

        Fruit fr;
        for (int i = 0; i < fruits.length / 2; i++) {
            fr = fruits[fruits.length - i - 1];
            fruits[fruits.length - i - 1] = fruits[i];
            fruits[i] = fr;
        }
        ;
        System.out.println("После замены элементов: " + fruits[0].getClass() + "\n" + fruits[1].getClass());
        System.out.println();

// 2. Написать метод, который преобразует массив в ArrayList;

        List<Fruit> listFruits = new ArrayList<>(Arrays.asList(fruits));
        for (Fruit f : listFruits) {
            System.out.println(f.getClass());
        }

// 3. Большая задача:
//a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
//b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
// поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//c. Для хранения фруктов внутри коробки можете использовать ArrayList;
//d. Сделать метод getWeight() который высчитывает вес коробки,зная количество фруктов
// и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
//e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку
// с той, которую подадут в compare в качестве параметра, true - если их веса равны,
// false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
//f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
// (помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
// соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты,
// которые были в этой коробке;
//g. Не забываем про метод добавления фрукта в коробку.

        Apple apple = new Apple();
        Orange orange = new Orange();
        Box<Apple> boxWithApples = new Box<Apple>(apple, apple, apple, apple);
        Box<Orange> boxWithOranges = new Box<Orange>(orange, orange);

        System.out.println(boxWithApples.getWeight());
        System.out.println(boxWithOranges.getWeight());

        System.out.println(boxWithOranges.compare(boxWithApples));

        boxWithApples.addFruit(apple);
        boxWithOranges.addFruit(orange);

        System.out.println(boxWithOranges.compare(boxWithApples));

        Box<Apple> boxWithApples2 = new Box<Apple>(apple, apple);
        Box<Orange> boxWithOranges2 = new Box<Orange>(orange, orange);

        boxWithApples2.shiftFruit(boxWithApples);
        boxWithOranges2.shiftFruit(boxWithOranges);

        System.out.println(boxWithApples.getWeight());
        System.out.println(boxWithOranges.getWeight());

        System.out.println(boxWithApples2.getWeight());
        System.out.println(boxWithOranges2.getWeight());
    }

}
