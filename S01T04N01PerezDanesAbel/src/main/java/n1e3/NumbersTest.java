package n1e3;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;
public class NumbersTest {

    @Test
    public void testException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            Numbers.getSomeNumbers(7);
        });
    }
}




