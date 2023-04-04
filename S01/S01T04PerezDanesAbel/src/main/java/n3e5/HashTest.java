package n3e5;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//https://www.vogella.com/tutorials/AssertJ/article.html
public class HashTest {
    @Test
    public void testContainsExactly() {
        HashMap<Integer, String> map = new HashMap<>(Map.of(0, "a", 1, "b", 2, "c"));
        assertThat(map).containsKey(0);
    }
}
