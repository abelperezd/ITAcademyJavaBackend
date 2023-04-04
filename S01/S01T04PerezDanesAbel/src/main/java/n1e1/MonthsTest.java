package n1e1;

import org.junit.Test;
import static org.junit.Assert.*;
public class MonthsTest {

    @Test
    public void testMesos() {
        Months months = new Months();
        assertNotNull(months.getMonthsList());
        assertEquals(12,months.getMonthsList().size());
        assertEquals("Agost".toLowerCase(), months.getMonthsList().get(7).toLowerCase());
    }
}
