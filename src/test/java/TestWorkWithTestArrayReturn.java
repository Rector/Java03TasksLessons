import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import taskLesson06.WorkWithTest;


public class TestWorkWithTestArrayReturn {
    WorkWithTest workWithTest;

    @Before
    public void init() {
        workWithTest = new WorkWithTest();
    }

    @Test
    public void testArrayReturn1() {
        Assert.assertArrayEquals(new int[]{6, 9}, workWithTest.arrayReturn(new int[]{4, 4, 6, 9}));
    }


    @Test
    public void testArrayReturn2() {
        Assert.assertArrayEquals(new int[]{8, 7}, workWithTest.arrayReturn(new int[]{1, 4, 8, 7}));
    }


    @Test
    public void testArrayReturn3() {
        Assert.assertArrayEquals(new int[]{5, 1, 1, 3}, workWithTest.arrayReturn(new int[]{1, 1, 2, 2}));
    }


    @Test
    public void testArrayReturn4() {
        Assert.assertArrayEquals(new int[]{3, 5}, workWithTest.arrayReturn(new int[]{4, 4, 3, 5}));
    }
}