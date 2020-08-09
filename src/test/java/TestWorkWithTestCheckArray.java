import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import taskLesson06.WorkWithTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestWorkWithTestCheckArray {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {true,new int[] {1, 1, 1, 1}},
                {true, new int[] {1, 1, 4, 4}},
                {true, new int[] {1, 2, 1, 4}},
                {true, new int[] {4, 4, 4, 4}}
        });
    }

    private boolean result;
    private int[] array;


    public TestWorkWithTestCheckArray(boolean result, int[] array) {
        this.result = result;
        this.array = array;
    }

    WorkWithTest workWithTest;

    @Before
    public void init() {
        workWithTest = new WorkWithTest();
    }


    @Test
    public void testArrayReturn() {
        Assert.assertEquals(result, workWithTest.checkArray(array));
    }
}
