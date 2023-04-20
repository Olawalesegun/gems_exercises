package gems.chapter3;

import java.util.Scanner;

public class HeartRatesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your firstName: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter your lastName: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter your date of Birth: ");
        String dateOfBirth = scanner.nextLine();
       HeartRates heartRate = new HeartRates(firstName,lastName,dateOfBirth);
       heartRate.setFirstName(firstName);
       heartRate.setLastName(lastName);
       heartRate.setDateOfBirth(dateOfBirth);
        System.out.println("Your first name is: " + heartRate.getFirstName());
        System.out.println();
    }


}
