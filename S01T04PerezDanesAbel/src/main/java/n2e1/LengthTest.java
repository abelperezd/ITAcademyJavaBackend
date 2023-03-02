package n2e1;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class LengthTest {
    @Test
    public void testEquals() {
        assertThat("Mordor", StringLengthMatcher.hasLength((IsEqual<Integer>) equalTo(8)));
        // assertThat("Mordor".length(), new StringLenghtIsEqual(8));
    }

}
