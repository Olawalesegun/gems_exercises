package gems.chapter3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HeartRatesCalculatorTest {
    private HeartRates heartRates=
            new HeartRates("Adeyemi", "Ajao", "9-Dec-1920");




    @Test
    public  void testThatAllArgsConstructorExistsInHeartRates(){
       assertNotNull(heartRates);
    }


    @Test
    public void testGetFirstName(){
        String name = heartRates.getFirstName();

        assertEquals("Adeyemi", name);
    }

    @Test
    public void testGetLastName(){
        String name = heartRates.getLastName();

        assertEquals("Ajao", name);
    }

    @Test
    public void testGetDateOfBirth(){
        String dateOfBirth = heartRates.getDateOfBirth();

        assertEquals("9-Dec-1920", dateOfBirth);
    }

    @Test
    public void testSetFirstName(){
        heartRates.setFirstName("Sultan");
        assertEquals("Sultan", heartRates.getFirstName());
    }

    @Test
    public void testSetLastName(){
        heartRates.setLastName("Buhari");
        assertEquals("Buhari", heartRates.getLastName());
    }

    @Test
    public void testSetDateOfBirth(){
        String date = "03-Dec-1997";
        heartRates.setDateOfBirth(date);
        assertEquals(date, heartRates.getDateOfBirth());
    }

    @Test
    public void getAgeTest(){
        heartRates.setDateOfBirth("03-Apr-2000");
        assertEquals(23, heartRates.getAge());
    }

    @Test
    public void getAgeTest2(){
        heartRates.setDateOfBirth("03-Apr-1922");
        assertEquals(101, heartRates.getAge());
    }

    @Test
    public void getMaximumHeartRateTest(){
        heartRates.setDateOfBirth("19-Apr-2000");
        assertEquals(197, heartRates.getMaximumHeartRate());
    }

    @Test
    public void getTargetHeartRate(){
        heartRates.setDateOfBirth("19-Apr-2000");
        assertEquals("98.5-167.45", heartRates.getTargetHeartRate());
    }
}
