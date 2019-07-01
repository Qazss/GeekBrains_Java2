import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class getElementTest {
    private ArrayReformer arrayReformer;

    @Before
    public void init(){
        arrayReformer = new ArrayReformer();
    }

    @Test
    public void trueTest(){
        int[] a = {1,2,3,4,5};
        Assert.assertTrue(arrayReformer.containNums(a));
    }

    @Test
    public void falseTest(){
        int[] a = {2,3,5,8};
        Assert.assertFalse(arrayReformer.containNums(a));
    }

    @Test
    public void nullTest(){
        int[] a = null;
        Assert.assertFalse(arrayReformer.containNums(a));
    }

    @Test
    public void emptyArray(){
        int[] a = new int[0];
        Assert.assertFalse(arrayReformer.containNums(a));
    }
}
