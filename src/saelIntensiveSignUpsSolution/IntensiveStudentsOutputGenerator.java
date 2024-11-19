/**
 * This class generates the output CSV file containing intensive and student data.
 * It formats the output to include the columns "INTENSIVES" and "STUDENTS".
 * The "STUDENTS" column lists students in the format "Last Name, First Name (Grade)".
 *
 * @author Haden Barrow
 * @version 1.0
 * @since 11/16/2024
 */
package saelIntensiveSignUpsSolution;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import com.opencsv.CSVWriter;

public class IntensiveStudentsOutputGenerator {
    public IntensiveStudentsOutputGenerator(List<Intensive> intensiveStudents, String outputFile) throws IOException {
        Writer writer = new FileWriter(outputFile);
        CSVWriter csvWriter = new CSVWriter(writer);

        // Write header
        String[] header = { "INTENSIVES", "STUDENTS" };
        csvWriter.writeNext(header);

        // Write rows
        for (Intensive intensive : intensiveStudents) {
            String intensiveName = intensive.getIntensive();
            StringBuilder studentsBuilder = new StringBuilder();

            for (Student student : intensive.getStudents()) {
                if (studentsBuilder.length() > 0) {
                    studentsBuilder.append("; ");
                }
                studentsBuilder.append(student.getLastName())
                               .append(", ")
                               .append(student.getFirstName())
                               .append(" (")
                               .append(student.getGrade())
                               .append(")");
            }

            String[] row = { intensiveName, studentsBuilder.toString() };
            csvWriter.writeNext(row);
        }

        csvWriter.close();
    }
}
