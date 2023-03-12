package n3e2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

//https://www.vogella.com/tutorials/AssertJ/article.html
public class EqualObjectsTest {
    @Test
    public void testEqualsTrue() {
        Person p1 = new Person("Pau", 12);
        Person p1_copy = new Person("Pau", 12);

        assertThat(p1).isEqualTo(p1);
    }

    @Test
    public void testNotEquals() {

        Person p1 = new Person("Pau", 12);
        Person p1_copy = new Person("Pau", 12);

        assertThat(p1).isNotEqualTo(p1_copy);
    }
}
