package taskLesson06;

public class WorkWithTest {

    public int[] arrayReturn(int[] array) {
        boolean check = false;
        int place = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                place = i;
                check = true;
            }
        }

        if (!check) {
            throw new RuntimeException("В массиве отсутствует цифра 4");
        }

        int[] arrayNew = new int[array.length - (place + 1)];

        System.arraycopy(array, (place + 1), arrayNew, 0, array.length - (place + 1));

        return arrayNew;
    }


    public boolean checkArray(int[] array){
        boolean check = true;

        for (int i = 0; i < array.length; i++) {
            if(array[i] != 1 && array[i] != 4){
             check = false;
            }
        }
        return check;
    }
}
