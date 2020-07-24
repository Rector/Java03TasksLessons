package taskLesson01;

import taskLesson01.fruit.Fruit;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> fruit;


    public Box(T... fruit) {
        this.fruit = new ArrayList<T>(Arrays.asList(fruit));
    }


    public float getWeight() {
        float sum = 0.0F;
        for (int i = 0; i < fruit.size(); i++) {
            sum += fruit.get(i).getFruitWeight();
        }
        return sum;
    }


    public boolean compare(Box<?> anotherBox){
        return this.getWeight() == anotherBox.getWeight();
    }


    public void shiftFruit(Box<? super T> anotherBox){
        anotherBox.fruit.addAll(this.fruit);
        fruit.clear();
    }


    public void addFruit(T fruit){
        this.fruit.add(fruit);
    }
}
