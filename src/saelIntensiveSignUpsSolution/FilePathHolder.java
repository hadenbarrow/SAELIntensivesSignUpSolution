/**
 * This class holds the file paths required for the SAEL Intensive application.
 * It includes paths for input and output files and methods to check if the paths are configured.
 *
 * @author Haden Barrow
 * @version 1.0
 * @since 11/16/2024
 */
package saelIntensiveSignUpsSolution;

import java.util.Date;

public class FilePathHolder {

	private String studentResponsesInputFilePath = "";
	private String intensivesAndCapacityInputFilePath = "";
	private String outputFilePath = "";
	
	public FilePathHolder() {
		setStudentResponsesInputFilePath("");
		setIntensivesAndCapacityInputFilePath("");
		setOutputFilePath("");
	}
	
	public String getStudentResponsesInputFilePath() {
		return studentResponsesInputFilePath;
	}
	public void setStudentResponsesInputFilePath(String studentResponsesInputFilePath) {
		this.studentResponsesInputFilePath = studentResponsesInputFilePath;
	}
	public String getIntensivesAndCapacityInputFilePath() {
		return intensivesAndCapacityInputFilePath;
	}
	public void setIntensivesAndCapacityInputFilePath(String intensivesAndCapacityInputFilePath) {
		this.intensivesAndCapacityInputFilePath = intensivesAndCapacityInputFilePath;
	}
	public String getOutputFilePath() {
		return outputFilePath;
	}
	public void setOutputFilePath(String outputFilePath) {
		Date date = new Date(System.currentTimeMillis());
		String dateString = date.toString().replace(":", "");
		this.outputFilePath = outputFilePath + "\\SAELIntensiveStudentList-" + dateString + ".csv" ;
	}
	public boolean isAllPathsConfigured() {
		return isStudentResponseInputFilePathConfigured() && isIntensivesAndCapacityInputFilePath() && isOutputFilePath();
	}
	public boolean isStudentResponseInputFilePathConfigured() {
		return !studentResponsesInputFilePath.equals("");
	}
	public boolean isIntensivesAndCapacityInputFilePath() {
		return !intensivesAndCapacityInputFilePath.equals("");
	}
	public boolean isOutputFilePath() {
		return !outputFilePath.equals("");
	}
}
