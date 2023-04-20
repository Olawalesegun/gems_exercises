package gems.chapter3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeartRateByShegsTest {
    HeartRateByShegs heartRate = new HeartRateByShegs("Segun", "Olawale", "17/10/1990");
    @Test
    public void heartRateConstructorTest(){
        assertNotNull(heartRate);
    }

    @Test
    public void heartRateAgeTest(){
        int year = heartRate.calcAge(1992);
        assertEquals(1992, year);
    }
}