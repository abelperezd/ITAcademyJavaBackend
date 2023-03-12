package n3e3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

//https://www.vogella.com/tutorials/AssertJ/article.html
public class ListEqualTest {
    @Test
    public void testEqualsTrue() {
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        for (int i = 0; i < list1.size(); i++) {
            assertThat(list1.get(i)).isEqualTo(list2.get(i));
        }
    }

}
