/**
 * This class is responsible for assigning students to intensives based on their preferences
 * and the availability of spots in the intensives.
 *
 * The assignment is made according to the first, second, and third choices provided by the students.
 *
 * @author Haden Barrow
 * @version 1.0
 * @since 11/16/2024
 */

package saelIntensiveSignUpsSolution;

import java.util.List;

public class IntensiveStudentsSelector {
	
	public IntensiveStudentsSelector() {
		
	}
	
	public List<Intensive> getIntensiveStudents(List<Student> students, List<Intensive> intensives){
		for (Student student : students) {
			if(!student.getIsEligible()) {
				continue;
			}
			placeStudentInIntensive(intensives, student);
		}
		return intensives;
	}
	
	private void placeStudentInIntensive(List<Intensive> intensives, Student student) {
		String firstChoice = student.getFirstChoice();
		String secondChoice = student.getSecondChoice();
		String thirdChoice = student.getThirdChoice();
		
		int firstChoiceIntensiveIndex = 0;
		int secondChoiceIntensiveIndex = 0;
		int thirdChoiceIntensiveIndex = 0;
		
		for(int i = 0; i < intensives.size(); i++) {
			if(intensives.get(i).getIntensive().equals(firstChoice)) {
				firstChoiceIntensiveIndex = i;
			}
			if(intensives.get(i).getIntensive().equals(firstChoice)) {
				secondChoiceIntensiveIndex = i;
			}
			if(intensives.get(i).getIntensive().equals(firstChoice)) {
				thirdChoiceIntensiveIndex = i;
			}
		}
		
		if(!intensives.get(firstChoiceIntensiveIndex).isFull()) {
			intensives.get(firstChoiceIntensiveIndex).addStudent(student);
			return;
		}
		else if(!intensives.get(secondChoiceIntensiveIndex).isFull()) {
			intensives.get(secondChoiceIntensiveIndex).addStudent(student);
			return;
		}
		else if (!intensives.get(thirdChoiceIntensiveIndex).isFull()){
			intensives.get(secondChoiceIntensiveIndex).addStudent(student);
			return;
		}
		return;
	}
}
