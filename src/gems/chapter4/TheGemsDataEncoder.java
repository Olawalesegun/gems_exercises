package gems.chapter4;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DataEncryptionExercise {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        DataEncryptionExercise dataEncryptionExercise = new DataEncryptionExercise();
        String encryption = run(dataEncryptionExercise);
        System.out.println(encryption);
    }

    private static String run(DataEncryptionExercise dataEncryptionExercise) throws InterruptedException {
        dataEncryptionExercise.displayMenu();
        String selection = dataEncryptionExercise.collectUserInput();
        boolean isValidSelection = isValidSelection(selection);
        if (!isValidSelection) processInvalidSelection(dataEncryptionExercise);
        switch (selection) {
            case "1" -> {
                return processEncryption(dataEncryptionExercise);
            }
            case "2" -> {
                return processDecryption(dataEncryptionExercise);
            }
            default -> dataEncryptionExercise.exit();
        }
        throw new RuntimeException("You Just no get sense");
    }

    private static String processDecryption(DataEncryptionExercise dataEncryptionExercise) {
        boolean isUserInputValidationResponse;
        String userInput;
        do {
            dataEncryptionExercise.prompt();
            userInput = dataEncryptionExercise.collectUserInput();
            isUserInputValidationResponse = dataEncryptionExercise.validateUserInput(userInput);
        }while (!isUserInputValidationResponse);

        return dataEncryptionExercise.decryptData(userInput);
    }

    private static String processEncryption(DataEncryptionExercise dataEncryptionExercise) {
        boolean isUserInputValidationResponse;
        String userInput;
        do {
            dataEncryptionExercise.prompt();
           userInput = dataEncryptionExercise.collectUserInput();
            isUserInputValidationResponse = dataEncryptionExercise.validateUserInput(userInput);
        }while (!isUserInputValidationResponse);

        String  encryption = dataEncryptionExercise.encryptData(userInput);
        return encryption;
    }

    private static void processInvalidSelection(DataEncryptionExercise dataEncryptionExercise) throws InterruptedException {
        System.out.println("invalid selection, try again later");
        dataEncryptionExercise.exit();
    }

    private void exit() throws InterruptedException {
        System.out.print("Shutting down.");
        for (int i = 0; i < 5; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
        }
        System.out.println();
        System.out.println("Bye");
        System.exit(1);
    }

    private static boolean isValidSelection(String selection) {
        return selection.length()==1&&selection.charAt(0)>=49 && selection.charAt(0)<=51;
    }

    private void displayMenu(){
        System.out.println(
                """
                        1->Encrypt Data
                        2->Decrypt Data
                        3->Exit
                        """
        );
    }


    private void prompt(){
        System.out.println("Enter four digit integer: ");
    }

    private String collectUserInput(){
        return scanner.nextLine();
    }


    private boolean validateUserInput(String userInput){
        return userInput.length()==4 && isValidFourDigitInteger(userInput);
    }

    private boolean isValidFourDigitInteger(String userInput) {
        for (int i = 0; i <userInput.length() ; i++) {
            if (userInput.charAt(i)<48||userInput.charAt(i)>57) return false;
        }
        return true;
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
