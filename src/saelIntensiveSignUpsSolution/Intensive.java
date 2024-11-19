/**
 * This class represents an Intensive program.
 * It includes details such as the name of the intensive, its capacity, 
 * and the list of students assigned to it.
 *
 * @author Haden Barrow
 * @version 1.0
 * @since 11/16/2024
 */
package saelIntensiveSignUpsSolution;

import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;

@JavaBean
public class Intensive {
	@CsvBindByName(column = "Intensive")
	private String Intensive;
	private int OccupiedSpots;
	@CsvBindByName(column = "Capacity")
	private int Capacity;
	private boolean isFull;
	@CsvBindAndSplitByName(elementType = Student.class)
	private List<Student> Students;
	
	public Intensive() {
		isFull = false;
		OccupiedSpots = 0;
		Students = new ArrayList<Student>();
	}
	
	public String getIntensive() {
		return Intensive;
	}
	public void setIntensive(String name) {
		Intensive = name;
	}
	public int getCapacity() {
		return Capacity;
	}
	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
	public boolean isFull() {
		return OccupiedSpots >= Capacity;
	}
	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}
	public int getOccupiedSpots() {
		return OccupiedSpots;
	}
	public void setOccupiedSpots(int spots) {
		OccupiedSpots = spots;
	}
	public List<Student> getStudents(){
		return Students;
	}
	public void addStudent(Student student) {
		if(!isFull) {
			Students.add(student);
			OccupiedSpots++;
		}
	}
	
}
