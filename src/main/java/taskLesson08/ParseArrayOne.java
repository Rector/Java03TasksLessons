package taskLesson08;

import java.util.*;

public class ParseArrayOne {


    public static void main(String[] args) {
//   Представьте, что лесник пытается сосчитать сосны, ели и березы на участке леса. Он может обойти весь участок трижды,
// сосчитав сначала только сосны, потом только ели и в третий раз только березы.
//   Конечно, более эффективно обойти лес только один раз, отмечая крестиками сосны на одной странице блокнота,
// ели на другой и березы на третьей. Потом останется только сосчитать количество крестиков на каждой странице.
//   Аналогичная идея работает для подсчета схожих элементов в последовательности или наборе,
// с использованием массива счетчиков (в качестве блокнота со страницами).
//   Дан массив длины M с числами в диапазоне 1 ... N, где N не больше 20. Вам нужно пройти по этому массиву и
// сосчитать сколько раз встречается каждое число.
//   Пожалуйста, не используйте 20 отдельных переменных для счетчиков, а сделайте один массив из них.
//
//   Пример
// входные данные:
// 1 2 3 2 3 1 1 1 1 3
//
//   ответ:
// 5 2 3
//
//   Входные данные для задачи
//
//   5 1 5 2 2 4 1 4 5 1 5 3 2 4 4 4 5 1 3 4 2 2 1 2 4 4 4 5 4 3 5 4 4 5 5 1 4 1 5 3 1 4 5 3 3 4 2 2 4 4 5 5 1 1 1 4 5 5
//   4 4 2 4 3 1 3 3 1 1 3 1 3 4 4 3 2 2 1 3 4 4 2 3 4 2 4 4 1 4 4 4 2 1 2 4 1 5 2 2 5 4 2 2 3 1 5 5 3 5 3 1 4 5 4 2 1 3
//   1 2 1 4 1 3 4 2 2 5 2 3 1 1 2 3 3 4 4 2 4 1 2 2 2 5 1 5 1 2 2 1 3 3 4 3 5 3 5 1 2 1 3 3 2 4 1 4 3 5 1 2 1 2 3 2 1 3
//   2 2 4 3 2 1 5 1 4 5 4 4 5 5 4 2 3 5 1 3 4 3 2 4 5 2 5 2 4 1 4 5 2 3 3 4 4 3 5 2 2 3 5 1 2 4 3 4 4 3 2 2 1 4 5 5 1 5
//   2 4 5 5 4 2 2 1 5 1 3 4 2 4 2 2 4 3 5 2 2 4 4 4 5 5 2 5 5 2 5 1 1 5 5 4 1 2 4 1 2 2 5 4 5 1 5 4 4 5 5 5 3 3 4 3 3 5
//   3 2 2 2 2 2 1 2 5 2 3 4 3 5 5 2 4 5 3 4 3 1 3 2 1 1 5 4 4 2 3 1 3 4 2 4 1 3 5 1 5 3 5 2 3 4 4 1 3 1 5 5 1 2 2 1 3 1
//   5 1 2 2 1 5 1 3 3 2 1 3 2 5 1 1 2 3 5 5 4 3 1 3 3 1 5 4 2 3 4

        String date = "5 1 5 2 2 4 1 4 5 1 5 3 2 4 4 4 5 1 3 4 2 2 1 2 4 4 4 5 4 3 5 4 4 5 5 1 4 1 5 3 1 4 5 3 3 4 2 2 4 4 5 5 1 1 1 4 5 5" +
                " 4 4 2 4 3 1 3 3 1 1 3 1 3 4 4 3 2 2 1 3 4 4 2 3 4 2 4 4 1 4 4 4 2 1 2 4 1 5 2 2 5 4 2 2 3 1 5 5 3 5 3 1 4 5 4 2 1 3" +
                " 1 2 1 4 1 3 4 2 2 5 2 3 1 1 2 3 3 4 4 2 4 1 2 2 2 5 1 5 1 2 2 1 3 3 4 3 5 3 5 1 2 1 3 3 2 4 1 4 3 5 1 2 1 2 3 2 1 3" +
                " 2 2 4 3 2 1 5 1 4 5 4 4 5 5 4 2 3 5 1 3 4 3 2 4 5 2 5 2 4 1 4 5 2 3 3 4 4 3 5 2 2 3 5 1 2 4 3 4 4 3 2 2 1 4 5 5 1 5" +
                " 2 4 5 5 4 2 2 1 5 1 3 4 2 4 2 2 4 3 5 2 2 4 4 4 5 5 2 5 5 2 5 1 1 5 5 4 1 2 4 1 2 2 5 4 5 1 5 4 4 5 5 5 3 3 4 3 3 5" +
                " 3 2 2 2 2 2 1 2 5 2 3 4 3 5 5 2 4 5 3 4 3 1 3 2 1 1 5 4 4 2 3 1 3 4 2 4 1 3 5 1 5 3 5 2 3 4 4 1 3 1 5 5 1 2 2 1 3 1" +
                " 5 1 2 2 1 5 1 3 3 2 1 3 2 5 1 1 2 3 5 5 4 3 1 3 3 1 5 4 2 3 4";

        String[] arrayString = date.split(" ");

        int[] arrayNumber = new int[arrayString.length];

        for (int i = 0; i < arrayString.length; i++) {
            arrayNumber[i] = Integer.parseInt(arrayString[i]);
        }

        HashMap<Integer, Integer> mapCounter = new HashMap<>();

        parseElementInArray(arrayNumber, mapCounter);
        printHashMap(mapCounter);

    }


    private static void parseElementInArray(int[] arrayNumber, HashMap<Integer, Integer> mapCounter) {
        for (int i = 0; i < arrayNumber.length; i++) {
            if (arrayNumber[i] < 1 || arrayNumber[i] > 20) {
                throw new RuntimeException("В массиве содержится число(а) вне диапазона от 1 до 20");
            }
            if (!mapCounter.containsKey(arrayNumber[i])) {
                int firstCount = 1;
                mapCounter.put(arrayNumber[i], firstCount);
            } else if (mapCounter.containsKey(arrayNumber[i])) {
                int counter = mapCounter.get(arrayNumber[i]);
                counter++;
                mapCounter.put(arrayNumber[i], counter);
            }
        }
    }


    private static void printHashMap(HashMap<Integer, Integer> mapCounter) {
        for (Map.Entry<Integer, Integer> m : mapCounter.entrySet()) {
            System.out.printf("Цифра %d встречается в массиве %d раз(а)\n", m.getKey(), m.getValue());
        }
    }
}
