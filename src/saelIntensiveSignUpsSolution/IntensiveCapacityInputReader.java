/**
 * This class reads the capacities and details of intensives from an input CSV file.
 * It parses the file into a list of {@link Intensive} objects.
 *
 * @author Haden Barrow
 * @version 1.0
 * @since 11/16/2024
 */

package saelIntensiveSignUpsSolution;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class IntensiveCapacityInputReader {
	private List<Intensive> Intensives;
	
	public IntensiveCapacityInputReader(String inputFilePath) {
		Intensives = new ArrayList<Intensive>();
		try {
			Intensives = new CsvToBeanBuilder<Intensive>(new FileReader(inputFilePath))
					.withType(Intensive.class)
					.build()
					.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Intensive> getIntensives(){
		return Intensives;
	}
}
