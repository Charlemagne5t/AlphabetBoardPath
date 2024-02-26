import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        String target = "leet";
        String expected = "DDR!UURRR!!DDD!";
        String actual = new Solution().alphabetBoardPath(target);
        Assert.assertEquals(expected, actual);
    }
}
