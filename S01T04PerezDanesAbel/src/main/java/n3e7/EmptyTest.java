package n3e7;

import org.junit.Test;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

//https://www.baeldung.com/assertj-exception-assertion
public class EmptyTest {
    @Test
    public void testIsEmpty() {
        Optional<Integer> o = Optional.ofNullable(null);
        assertThat(o).isEmpty();
    }
}
