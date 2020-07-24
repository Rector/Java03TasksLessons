package taskLesson01.fruit;

public abstract class Fruit {
    private float fruitWeight;


    public Fruit(float fruitWeight){
        this.fruitWeight = fruitWeight;
    }


    public float getFruitWeight() {
        return fruitWeight;
    }
}
