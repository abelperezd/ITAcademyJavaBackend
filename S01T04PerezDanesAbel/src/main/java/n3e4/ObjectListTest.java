package n3e4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

//https://www.vogella.com/tutorials/AssertJ/article.html
public class ObjectListTest {
    @Test
    public void testContainsExactly() {
        Integer i = 1;
        Person p = new Person("ana", 7);
        String s = "a string";
        Car c = new Car("Opel", 4, "red");

        ArrayList<Object> list1 = new ArrayList<>(Arrays.asList(i, p, s, c));

        assertThat(list1).containsExactly(i, p, s, c);
    }

    @Test
    public void testContainsInAnyOrder() {
        Integer i = 1;
        Person p = new Person("ana", 7);
        String s = "a string";
        Car c = new Car("Opel", 4, "red");

        ArrayList<Object> list1 = new ArrayList<>(Arrays.asList(i, p, s, c));

        assertThat(list1).containsExactlyInAnyOrder(p, i, c, s);
    }

    @Test
    public void testContainsCustom() {
        Integer i = 1;
        Person p = new Person("ana", 7);
        String s = "a string";
        Car c = new Car("Opel", 4, "red");

        ArrayList<Object> list1 = new ArrayList<>(Arrays.asList(i, p, s));

        assertThat(list1).containsOnlyOnce(s);
        assertThat(list1).doesNotContain(c);
    }
}
