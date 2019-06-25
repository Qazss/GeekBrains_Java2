import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class ContainNumsTest {
    private ArrayReformer arrayReformer;

    @Before
    public void init(){
        arrayReformer = new ArrayReformer();
    }

    @Test
    public  void correctArrayTest(){
        int[] a = {1, 3, 4, 5, 4, 2, 3};
        Assert.assertTrue(Arrays.equals(new int[]{2, 3}, arrayReformer.getElementsAfter4(a)));
    }

    @Test
    public  void correctLongArrayTest(){
        int[] a = {1, 3, 4, 5, 4, 2, 3, 34, 231, 4, 1, 87, 56, 55, 989, 34};
        Assert.assertTrue(Arrays.equals(new int[]{1, 87, 56, 55, 989, 34}, arrayReformer.getElementsAfter4(a)));
    }

    @Test(expected = RuntimeException.class)
    public  void wrongArrayTest(){
        int[] a = {3, 1, 9, 5, 2, 3};
        arrayReformer.getElementsAfter4(a);
    }
}
