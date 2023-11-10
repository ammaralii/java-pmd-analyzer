package interviews.remotebase.coding_challenge_hackerrank.questions;

import interviews.remotebase.coding_challenge_hackerrank.question.Question1;
import org.junit.Assert;
import org.junit.Test;

public class Question1Test {
    @Test
    public void success_rearrange_test_0() {
        Assert.assertArrayEquals(Question1.rearrange(new int[]{21, 34, 5, 7, 9}), new int[]{9, 21, 5, 34, 7});
    }

    @Test
    public void success_rearrange_test_1() {
        Assert.assertArrayEquals(Question1.rearrange(new int[]{1, 2, 3, 4}), new int[]{2, 3, 1, 4});
    }

    @Test
    public void success_rearrange_test_2() {
        Assert.assertArrayEquals(Question1.rearrange(new int[]{}), new int[]{});
    }

    @Test
    public void success_rearrange_test_3() {
        Assert.assertArrayEquals(Question1.rearrange(new int[]{1}), new int[]{1});
    }

    @Test
    public void success_rearrange_test_4() {
        Assert.assertArrayEquals(Question1.rearrange(new int[]{1,2}), new int[]{1,2});
    }

    @Test
    public void success_rearrange_test_5() {
        Assert.assertArrayEquals(Question1.rearrange(new int[]{1,2,3}), new int[]{2,3,1});
    }

    @Test
    public void success_rearrange_test_6() {
        Assert.assertArrayEquals(Question1.rearrange(new int[]{1, -2, 3, -4, 5}), new int[]{1, 3, -4, 5, -2});
    }
}
