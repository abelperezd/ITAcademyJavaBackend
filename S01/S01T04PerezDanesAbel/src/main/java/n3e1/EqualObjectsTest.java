package n3e1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

//https://www.vogella.com/tutorials/AssertJ/article.html
public class EqualObjectsTest {
    @Test
    public void testEqualsTrue() {
        assertThat(new Person("Pau", 12)).usingRecursiveComparison().isEqualTo(new Person("Pau", 12));
    }
    @Test
    public void testNotEquals() {
        assertThat(new Person("Pau", 12)).usingRecursiveComparison().isNotEqualTo(new Person("Pau", 13));
    }
}
