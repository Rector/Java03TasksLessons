package taskLesson07;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WorkWithAnnotation {
    public static void main(String[] args) {
// 1. Создать класс, который может выполнять «тесты»,
// в качестве тестов выступают классы с наборами методов с аннотациями @Test.
// Для этого у него должен быть статический метод start(), которому в качестве
// параметра передается или объект типа Class, или имя класса. Из «класса-теста»
// вначале должен быть запущен метод с аннотацией @BeforeSuite, если такой имеется,
// далее запущены методы с аннотациями @Test, а по завершению всех тестов –
// метод с аннотацией @AfterSuite. К каждому тесту необходимо также добавить приоритеты (int числа от 1 до 10),
// в соответствии с которыми будет выбираться порядок их выполнения, если приоритет одинаковый, то порядок не имеет значения.
// Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре,
// иначе необходимо бросить RuntimeException при запуске «тестирования».

        try {
            Class testString = TestString.class;
            start(testString);

            System.out.println();

            start(TestInteger.class.getName());


        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }


    }

    private static void start(String className) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
            Class cls = Class.forName(className);
            start(cls);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static void start(Class cls) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Method[] methods = cls.getDeclaredMethods();
        int countBeforeSuite = 0;
        int countAfterSuite = 0;
        Object obj = cls.newInstance();
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                m.invoke(obj);
                countBeforeSuite++;
                if (countBeforeSuite > 1 || countBeforeSuite == 0) {
                    throw new RuntimeException("Аннотация BeforeSuite отсутствует или указана более 1 раза");
                }
            }
        }

        for (int i = 10; i >= 1; i--) {
            for (Method m : methods) {
                if (m.isAnnotationPresent(Test.class) && m.getAnnotation(Test.class).priority() == i) {
                    m.invoke(obj);
                }
            }
        }


        for (Method m : methods) {
            if (m.isAnnotationPresent(AfterSuite.class)) {
                m.invoke(obj);
                countAfterSuite++;
                if (countAfterSuite > 1 || countAfterSuite == 0) {
                    throw new RuntimeException("Аннотация AfterSuite отсутствует или указана более 1 раза");
                }
            }
        }
    }
}
