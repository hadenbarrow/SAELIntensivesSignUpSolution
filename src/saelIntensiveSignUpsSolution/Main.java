/**
 * The main entry point of the SAEL Intensive application.
 * It initializes the {@link Orchestrator} and launches the GUI window.
 *
 * @author Haden Barrow
 * @version 1.0
 * @since 11/16/2024
 */

package saelIntensiveSignUpsSolution;

import java.awt.EventQueue;

import saelIntensiveSignUpsSolution.UI.SAELIntensiveSignUpsSolutionWindow;

public class Main {
	public static void main(String[] args) {		
		Orchestrator orchestrator = new Orchestrator();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SAELIntensiveSignUpsSolutionWindow frame = new SAELIntensiveSignUpsSolutionWindow(orchestrator);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}