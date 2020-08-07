package taskLesson05v2;

public class WorkWithLambda {


    public static void sum(int addendum1, int addendum2 ) {
        Operationable operation;
        operation = (x, y) -> x + y;

        int sum = operation.forOperation(addendum1, addendum2);
        System.out.printf("%d + %d = %d\n", addendum1, addendum2, sum);
    }


    public static void difference(int minuend, int subtrahend ) {
        Operationable operation;
        operation = (x, y) -> x - y;

        int difference = operation.forOperation(minuend, subtrahend);
        System.out.printf("%d - %d = %d\n", minuend, subtrahend, difference);
    }


    public static void composition(int multiplicand, int multiplier ) {
        Operationable operation;
        operation = (x, y) -> x * y;

        int composition = operation.forOperation(multiplicand, multiplier);
        System.out.printf("%d * %d = %d\n", multiplicand, multiplier, composition);
    }


    public static void quotient(int dividend, int divider ) {
        Operationable operation;
        operation = (x, y) -> x / y;

        int quotient = operation.forOperation(dividend, divider);
        System.out.printf("%d / %d = %d\n", dividend, divider, quotient);
    }


    public static void main(String[] args) {

// 2. Создать консольный калькулятор с использованием лямбды
// (у калькулятора должно быть 4 функции: сложение, вычитание,
// умножение, деления, достаточно сделать реализацию для двух чисел в одной операции)

        sum(100,10);

        difference(100, 10);

        composition(100, 10);

        quotient(100, 10);
    }

}
