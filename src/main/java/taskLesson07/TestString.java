package taskLesson07;


public class TestString {


    @BeforeSuite
    public void begin() {
        System.out.println("Начало тестов!");
    }


    @Test(priority = 10)
    public void test1(){
        System.out.println("test1 String");
    }


    @Test(priority = 9)
    public void test2(){
        System.out.println("test2 String");
    }


    @Test (priority = 8)
    public void test3(){
        System.out.println("test3 String");
    }


    @Test (priority = 7)
    public void test4(){
        System.out.println("test4 String");
    }


    @Test (priority = 6)
    public void test5(){
        System.out.println("test5 String");
    }


    @AfterSuite
    public void end() {
        System.out.println("Тесты завершены!");
    }
}
