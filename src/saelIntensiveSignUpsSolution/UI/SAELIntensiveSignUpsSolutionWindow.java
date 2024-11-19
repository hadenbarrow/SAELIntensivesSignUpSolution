/**
 * This class represents the GUI window for the SAEL Intensive application.
 * It allows users to select input files, view student lists, and generate output files.
 *
 * The GUI includes features like file selection and a scrollable list of students
 * with checkboxes for eligibility management.
 *
 * @author Haden Barrow
 * @version 1.0
 * @since 11/16/2024
 */
package saelIntensiveSignUpsSolution.UI;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import saelIntensiveSignUpsSolution.Orchestrator;
import saelIntensiveSignUpsSolution.Student;
import javax.swing.SwingConstants;

public class SAELIntensiveSignUpsSolutionWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JScrollPane studentScrollPane;
    private Orchestrator orchestrator;
    private String outputFileDestination;
    private String intensivesAndCapacitiesInputLocation;
    private String studentResponsesInputLocation;

    public SAELIntensiveSignUpsSolutionWindow(Orchestrator orchestrator) {
        this.orchestrator = orchestrator;
        setTitle("SAEL Intensive Sign Up Solution");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 723, 573);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel selectIntensivesAndCapacitiesLabel = new JLabel("");
        selectIntensivesAndCapacitiesLabel.setBounds(266, 90, 432, 20);
        contentPane.add(selectIntensivesAndCapacitiesLabel);

        JLabel selectStudentInputDataLabel = new JLabel("");
        selectStudentInputDataLabel.setBounds(266, 118, 432, 20);
        contentPane.add(selectStudentInputDataLabel);

        Button selectIntensivesAndCapacitiesButton = new Button("Select intensives and capacities .csv file");
        selectIntensivesAndCapacitiesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setCurrentDirectory(new java.io.File("."));
                fc.setDialogTitle("Select the intensives and capacities .csv file");
                int retValue = fc.showOpenDialog(null);
                if (retValue == JFileChooser.APPROVE_OPTION) {
                    orchestrator.filePathHolder.setIntensivesAndCapacityInputFilePath(fc.getSelectedFile().toString());
                    intensivesAndCapacitiesInputLocation = fc.getSelectedFile().toString();
                    selectIntensivesAndCapacitiesLabel.setText(intensivesAndCapacitiesInputLocation);
                }
            }
        });
        selectIntensivesAndCapacitiesButton.setBounds(10, 90, 250, 22);
        contentPane.add(selectIntensivesAndCapacitiesButton);

        Button selectStudentInputDataButton = new Button("Select student input data .csv file");
        selectStudentInputDataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setDialogTitle("Select the student inputs .csv file");
                int retValue = fc.showOpenDialog(null);
                if (retValue == JFileChooser.APPROVE_OPTION) {
                    orchestrator.filePathHolder.setStudentResponsesInputFilePath(fc.getSelectedFile().toString());
                    orchestrator.populateStudentsList();
                    populateStudentList(orchestrator.getStudents());
                    selectStudentInputDataLabel.setText(fc.getSelectedFile().toString());
                }
            }
        });
        selectStudentInputDataButton.setBounds(10, 118, 250, 22);
        contentPane.add(selectStudentInputDataButton);

        JLabel intensivesAndCapacitiesLabel = new JLabel("");
        intensivesAndCapacitiesLabel.setBounds(266, 146, 432, 20);
        contentPane.add(intensivesAndCapacitiesLabel);

        Button selectOutputFileButton = new Button("Select file output location");
        selectOutputFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Select output file directory");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);
                chooser.setApproveButtonText("Select");
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    orchestrator.filePathHolder.setOutputFilePath(chooser.getSelectedFile().toString());
                    outputFileDestination = chooser.getSelectedFile().toString();
                    intensivesAndCapacitiesLabel.setText(outputFileDestination);
                }
            }
        });
        selectOutputFileButton.setBounds(10, 146, 250, 22);
        contentPane.add(selectOutputFileButton);

        Button generateButton = new Button("Generate list");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	orchestrator.filePathHolder.setOutputFilePath(outputFileDestination);
                orchestrator.OrchestrateAndGenerate();
            }
        });
        generateButton.setBounds(10, 202, 250, 22);
        contentPane.add(generateButton);

        // New scroll pane for students
        studentScrollPane = new JScrollPane();
        studentScrollPane.setBounds(10, 230, 688, 296);
        contentPane.add(studentScrollPane);
        
        JLabel lblNewLabel = new JLabel("Version " + orchestrator.Version);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(590, 11, 107, 14);
        contentPane.add(lblNewLabel);
    }

    private void populateStudentList(List<Student> students) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (Student student : students) {
            JCheckBox checkBox = new JCheckBox(student.getLastName() + ", " + student.getFirstName());
            checkBox.setSelected(student.getIsEligible());
            checkBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    student.setIsEligible(checkBox.isSelected());
                }
            });
            panel.add(checkBox);
        }

        // Use a JScrollPane-compatible panel
        panel.setPreferredSize(new Dimension(studentScrollPane.getWidth() - 20, students.size() * 25));
        studentScrollPane.setViewportView(panel);
        studentScrollPane.revalidate();
        studentScrollPane.repaint();
    }
}
