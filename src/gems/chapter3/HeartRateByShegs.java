package gems.chapter3;
import java.util.Scanner;
public class HeartRateByShegs {
    private static String firstName;
    private static String lastName;
    private static String dob;
    private static int year;

    public HeartRateByShegs(String firstName, String lastName, String dob){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Kindly Enter an first Name");
        firstName = userInput.nextLine();
        System.out.println("Kindly Enter your Last Name");
        lastName = userInput.nextLine();
        System.out.println("Kindly enter your Date of Birth in this format --> 10-17-1990");
        dob = userInput.nextLine();
        HeartRateByShegs heart = new HeartRateByShegs(firstName, lastName, dob);
        heart.getYear(dob);
        System.out.println(firstName + "\'s" + " age is" + calcAge());
    }


    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public static int getYear(String dob){
        int[] arrayCollectingDate = new int[dob.length()];
        for(int loopInAge=0; loopInAge<dob.length(); loopInAge++)
            arrayCollectingDate[loopInAge] = (int)dob.charAt(loopInAge) - '0';
        year = Integer.parseInt(arrayCollectingDate[6] + "" + arrayCollectingDate[7] + "" + arrayCollectingDate[8] +
                "" + arrayCollectingDate[9]);
        return year;
    }

    public static int calcAge(){
        int currentYear = 2023;
        int currentAge = currentYear - year;
        return currentAge;
    }
}
