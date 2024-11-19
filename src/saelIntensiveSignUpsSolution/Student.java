/**
 * This class represents a student in the SAEL Intensive program.
 * It includes details such as the student's name, grade, choices for intensives,
 * and eligibility status.
 *
 * @author Haden Barrow
 * @version 1.0
 * @since 11/16/2024
 */
package saelIntensiveSignUpsSolution;

import java.sql.Timestamp;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

public class Student implements Comparable<Student> {
	
	@CsvDate(value = "MM/dd/yyyy HH:mm:ss")
	@CsvBindByName(column = "Timestamp")
	private Timestamp TimeStamp;
	@CsvBindByName(column = "Email Address")
	private String EmailAddress;
	@CsvBindByName(column = "Last Name")
	private String LastName;
	@CsvBindByName(column = "First Name")
	private String FirstName;
	@CsvBindByName(column = "Grade")
	private String Grade;
	@CsvBindByName(column = "Crew Advisor")
	private String CrewAdvisor;
	@CsvBindByName(column = "FIRST choice for Enrichment Intensives")
	private String FirstChoice;
	@CsvBindByName(column = "SECOND choice for Enrichment Intensives")
	private String SecondChoice;
	@CsvBindByName(column = "THRID choice for Enrichment Intensives")
	private String ThirdChoice;
	private boolean IsEligible;
	private Intensive CurrentIntensive;
	
	public Student() {
		IsEligible = true;
	}
	
	public Timestamp getTimeStamp() {
		return TimeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		TimeStamp = timeStamp;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
	public String getCrewAdvisor() {
		return CrewAdvisor;
	}
	public void setCrewAdvisor(String crewAdvisor) {
		CrewAdvisor = crewAdvisor;
	}
	public String getFirstChoice() {
		return FirstChoice;
	}
	public void setFirstChoice(String fristChoice) {
		FirstChoice = fristChoice;
	}
	public String getSecondChoice() {
		return SecondChoice;
	}
	public void setSecondChoice(String secondChoice) {
		SecondChoice = secondChoice;
	}
	public String getThirdChoice() {
		return ThirdChoice;
	}
	public void setThirdChoice(String thirdChoice) {
		ThirdChoice = thirdChoice;
	}
	public boolean getIsEligible() {
		return IsEligible;
	}
	public void setIsEligible(boolean isEligible) {
		IsEligible = isEligible;
	}
	public Intensive getCurrentIntensive() {
		return CurrentIntensive;
	}
	public void setCurrentIntensive(Intensive intensive) {
		CurrentIntensive = intensive;
	}
	@Override
	public int compareTo(Student o) {
		if(this.TimeStamp.before(o.getTimeStamp())) {
			return -1;
		}
		if(this.TimeStamp.after(o.getTimeStamp())){
			return 1;
		}
		return 0;
	}
	@Override 
	public String toString(){ 
		return LastName + ", " + FirstName + ", " + Grade + ", " + CrewAdvisor + ", " + TimeStamp + ", " + EmailAddress + ", ";
	}
	
}
