/**
 * This class reads student responses from an input CSV file.
 * It parses the data into a list of {@link Student} objects.
 *
 * @author Haden Barrow
 * @version 1.0
 * @since 11/16/2024
 */
package saelIntensiveSignUpsSolution;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opencsv.bean.CsvToBeanBuilder;

public class StudentResponsesInputReader {
	private List<Student> students;
	
	public StudentResponsesInputReader(String inputFilePath) {
		students = new ArrayList<Student>();
		try {
			students = new CsvToBeanBuilder<Student>(new FileReader(inputFilePath))
					.withType(Student.class)
					.build()
					.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Student> getStudents(){
		return students;
	}
}
