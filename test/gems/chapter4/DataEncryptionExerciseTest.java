package gems.chapter4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DataEncryptionExerciseTest {
    private DataEncryptionExercise dataEncryptionExercise;

    @BeforeEach
    void setUp() {
        dataEncryptionExercise=new DataEncryptionExercise();
    }

    @Test
    public void testEncryptData(){
       //TODO 1. given: I have data=>0149 and a method encryptData that encrypts data
       //TODO 2. a. when: I call encryptData and pass data from 1 to it as argument,
        // TODO b. encryptData returns encrypted data
       //TODO 3. assert: that I get encrypted data => 1678

       //given
       String data = "0149";
       //when
       String encryptedData = dataEncryptionExercise.encryptData(data);
        System.out.println("encryption:: "+encryptedData);
        //assert
       assertEquals("1678", encryptedData);

    }


    @Test
    public void testDecryptData(){
        //TODO 1. given: I have encryptedData=>1678 and a method decryptData that decrypts encryptedData
        //TODO 2. a. when: I call decryptData and pass encryptedData from 1 to it as argument,
        // TODO b. decryptData returns raw data
        //TODO 3. assert: that I get raw data => 0149

        String decryption = dataEncryptionExercise.decryptData("1678");

        assertEquals("0149", decryption);

    }

    @Test
    public void testDecryptData1(){

        String decryption = dataEncryptionExercise.decryptData("16666666678");

        assertNotNull(decryption);
    }


}