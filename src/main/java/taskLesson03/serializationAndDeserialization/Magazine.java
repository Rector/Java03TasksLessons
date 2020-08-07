package taskLesson03.serializationAndDeserialization;

import java.io.Serializable;

public class Magazine implements Serializable {
    private String name;
    private int page;

    public Magazine(String name, int page) {
        this.name = name;
        this.page = page;
    }

    public void info(){
        System.out.printf("Name magazine: %s\nQuantity page: %d\n", name, page);
    }
}
