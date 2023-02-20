package n1e2;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoDniTest {
    @ParameterizedTest
    @ValueSource(strings = {"45933873K", "43434489R", "72019499J", "25647220N", "74164205S",
            "58218603Z", "00742090H", "65805853R", "91207253V", "99519527E"})
    void testDniVerification(String candidate) {
        Assert.assertEquals(candidate.charAt(8), CalculoDni.computeDniLetter(candidate.substring(0, 8)));
    }
}
