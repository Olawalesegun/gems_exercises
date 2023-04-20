package gems.chapter3;
import java.util.Scanner;
public class HeartRateByShegs {
    private String firstName;
    private String lastName;
    private String dob;

    public HeartRateByShegs(String firstName, String lastName, String dob){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public static void main(String[] args) {

    }

    public void prompt(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Kindly Enter an first Name");
        firstName = userInput.nextLine();
        System.out.println("Kindly Enter your Last Name");
        lastName = userInput.nextLine();
        System.out.println("Kindly enter your Date of Birth in this format --> 10-17-1990");
        dob = userInput.nextLine();
        HeartRateByShegs heart = new HeartRateByShegs(firstName, lastName, dob);
        System.out.println(firstName + "age is" + getYear());
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }
    /*public void setDob(String dob){
        this.dob = dob;
    }*/
    public int getYear(){
        this.dob = dob;
        int[] arrayCollectingDate = new int[dob.length()];
        for(int loopInAge=0; loopInAge<dob.length(); loopInAge++)
            arrayCollectingDate[loopInAge] = (int)dob.charAt(loopInAge) - '0';
        int year = Integer.parseInt(arrayCollectingDate[-5] + "" + arrayCollectingDate[-4] + "" + arrayCollectingDate[-3] +
                "" + arrayCollectingDate[-2]);
        return year;
    }
    public int calcAge(int yearBorn){
        yearBorn = getYear();
        int currentYear = 2023;
        int currentAge = currentYear - yearBorn;
        return currentAge;
    }
}
