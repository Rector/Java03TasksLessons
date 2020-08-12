package taskLesson07;

public class TestInteger {

    @BeforeSuite
    public void begin() {
        System.out.println("Начало тестов!");
    }


    @Test(priority = 10)
    public void test1(){
        System.out.println("test1 Integer");
    }


    @Test(priority = 8)
    public void test2(){
        System.out.println("test2 Integer");
    }


    @Test (priority = 8)
    public void test3(){
        System.out.println("test3 Integer");
    }


    @Test (priority = 8)
    public void test4(){
        System.out.println("test4 Integer");
    }


    @Test (priority = 1)
    public void test5(){
        System.out.println("test5 Integer");
    }


    @AfterSuite
    public void end() {
        System.out.println("Тесты завершены!");
    }
}
