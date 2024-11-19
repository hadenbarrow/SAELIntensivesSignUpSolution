/**
 * This class orchestrates the main operations of the SAEL Intensive application.
 * It manages the reading of input data, processing of students and intensives,
 * and the generation of output files.
 *
 * @author Haden Barrow
 * @version 1.0
 * @since 11/16/2024
 */
package saelIntensiveSignUpsSolution;

import java.io.IOException;
import java.util.List;

public class Orchestrator {
	public String Version = "1.0.1";
	public FilePathHolder filePathHolder;
	public List<Student> students;
	
	public Orchestrator() {
		filePathHolder = new FilePathHolder();
	}
	
	public List<Student> getStudents(){
		return students;
	}
	
	public void populateStudentsList() {
		this.students = readStudentResponseInput();
	}
	
	public void OrchestrateAndGenerate() {
		if(!filePathHolder.isAllPathsConfigured()) {
			return;
		}
		
		IntensiveStudentsSelector selector = new IntensiveStudentsSelector();
		List<Intensive> intensiveStudents = selector.getIntensiveStudents(this.students, readIntensiveCapacityInput());
		
		try {
			new IntensiveStudentsOutputGenerator(intensiveStudents, filePathHolder.getOutputFilePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Student> readStudentResponseInput() {
		StudentResponsesInputReader srReader = new StudentResponsesInputReader(filePathHolder.getStudentResponsesInputFilePath());
		List<Student> students = srReader.getStudents();
		students.sort(null);
		return students;
	}
	
	public List<Intensive> readIntensiveCapacityInput() {
		IntensiveCapacityInputReader icReader = new IntensiveCapacityInputReader(filePathHolder.getIntensivesAndCapacityInputFilePath());
		List<Intensive> intensives = icReader.getIntensives();
		return intensives;
	}
	
	
}
