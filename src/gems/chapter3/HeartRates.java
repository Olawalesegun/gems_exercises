package gems.chapter3;

import java.time.LocalDate;

public class HeartRates {
    private String firstName;
    private String lastName;
    private String dateOfBirth;

    public HeartRates(String firstName, String lastName, String dateOfBirth){
        this.firstName=firstName;
        this.lastName=lastName;
        this.dateOfBirth=dateOfBirth;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getDateOfBirth(){
        return dateOfBirth;
    }

    public  void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth=dateOfBirth;
    }

    public int getAge(){
        String yearOfBirth = "";
        for (int index = dateOfBirth.length()-4; index < dateOfBirth.length() ; index++)
            yearOfBirth = getYear(yearOfBirth, index);

        int userYearOfBirth = Integer.parseInt(yearOfBirth);
        LocalDate currentDate = LocalDate.now();
        int age = currentDate.getYear() - userYearOfBirth;
        return age;
    }

    public int getMaximumHeartRate(){
        return 220 -getAge();
    }

    public String getTargetHeartRate(){
        String targetHeartRate = "";
        double targetHeartRateLowerBound = ((double)50/100) * getMaximumHeartRate();
        double targetHeartRateUpperBound = ((double)85/100) * getMaximumHeartRate();;
        return  targetHeartRate + targetHeartRateLowerBound + "-"+targetHeartRateUpperBound;
    }

    private String getYear(String yearOfBirth, int index){
        yearOfBirth+=dateOfBirth.charAt(index);
        return yearOfBirth;
    }
}
