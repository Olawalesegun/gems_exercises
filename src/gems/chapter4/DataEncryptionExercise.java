package gems.chapter4;

import java.util.Scanner;

public class DataEncryptionExercise {

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DataEncryptionExercise dataEncryptionExercise = new DataEncryptionExercise();
        String encryption = run(dataEncryptionExercise);
        System.out.println(encryption);
    }

    private static String run(DataEncryptionExercise dataEncryptionExercise) {
        boolean isUserInputValidationResponse;
        String userInput;
        do {
           userInput = dataEncryptionExercise.collectUserInput();
            isUserInputValidationResponse = dataEncryptionExercise.validateUserInput(userInput);
        }while (!isUserInputValidationResponse);

        String  encryption = dataEncryptionExercise.encryptData(userInput);
        return encryption;
    }


    private void prompt(){
        System.out.println("Enter four digit integer: ");
    }

    private String collectUserInput(){
        prompt();
        return scanner.nextLine();
    }


    private boolean validateUserInput(String userInput){
        return userInput.length()==4;
    }

    public String encryptData(String data){
        int firstEncryptedDigit=0;
        int secondEncryptedDigit=0;
        int thirdEncryptedDigit=0;
        int fourthEncryptedDigit=0;

        if (data.length()!=4) return "alaye enter a four digit number!!!";
        for (int index = 0; index < data.length(); index++) {
            char currentCharacter = data.charAt(index); //'0'
            int currentDigit=currentCharacter-'0'; //0
            System.out.println("digit==> "+currentDigit);

            int encryptedDigit=(currentDigit+7)%10;
            if (index==0) firstEncryptedDigit=encryptedDigit;
            if (index==1) secondEncryptedDigit=encryptedDigit;
            if (index==2) thirdEncryptedDigit=encryptedDigit;
            if (index==3) fourthEncryptedDigit=encryptedDigit;
        }



        String finalEncryption = thirdEncryptedDigit+""+fourthEncryptedDigit+""+firstEncryptedDigit+""+secondEncryptedDigit;

        return finalEncryption;
    }

    public String decryptData(String encryption){
        int firstDecryptedDigit=0;
        int secondDecryptedDigit=0;
        int thirdDecryptedDigit=0;
        int fourthDecryptedDigit=0;

        if (encryption.length()!=4) terminateApplication();
        for (int index = 0; index < encryption.length(); index++) {
            char currentCharacter = encryption.charAt(index); //'0'
            int currentDigit = currentCharacter-'0';
            int decryptedDigit=(currentDigit+10-7)%10;
            if (index==0) firstDecryptedDigit=decryptedDigit;
            if (index==1) secondDecryptedDigit=decryptedDigit;
            if (index==2) thirdDecryptedDigit=decryptedDigit;
            if (index==3) fourthDecryptedDigit=decryptedDigit;
        }
        String decryption = thirdDecryptedDigit+""+fourthDecryptedDigit+""+firstDecryptedDigit+""+secondDecryptedDigit;

        return decryption;
    }

    private void terminateApplication() {
        System.out.println("alaye enter a four digit number!!!");
        System.exit(1);
    }


}
