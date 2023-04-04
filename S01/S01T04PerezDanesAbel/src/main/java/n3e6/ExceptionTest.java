package n3e6;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

//https://www.baeldung.com/assertj-exception-assertion
public class ExceptionTest {
    @Test
    public void testExceptionThrown() {
        assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class).isThrownBy(() -> new ListWithException());
    }
}
