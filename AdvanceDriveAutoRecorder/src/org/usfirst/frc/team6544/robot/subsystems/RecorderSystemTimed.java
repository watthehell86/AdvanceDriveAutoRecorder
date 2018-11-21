package org.usfirst.frc.team6544.robot.subsystems;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * Timed Drive Recorder Subsystem
 * Used to recored the robot drive movements and save them to a file
 */
public class RecorderSystemTimed extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private boolean written = false; // Has the arrays been written to a file
	List<Double> leftDriveSpeeds = new ArrayList<Double>(); // Store speed values in an array list for the left side motors
	List<Double> rightDriveSpeeds = new ArrayList<Double>(); // Store speed values in an array list for the right side motors
	SendableChooser<String> m_chooser = new SendableChooser<>(); //An object that will create a drop down when you send it to the dashboard
	private String[] fileNames = { "Left-Auto-Run.txt", 
			"Right-Auto-Run.txt", 
			"Center-Auto-Run.txt",
			"Left-Scale-Auto-Run.txt", 
			"Right-Scale-Auto-Run.txt" 
	};

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(null);
	}

	public double[] printLeftSpeed() {
		double[] output = new double[leftDriveSpeeds.size()];
		for (int i = 0; i < leftDriveSpeeds.size(); i++) {
			output[i] = leftDriveSpeeds.get(i);
		}
		return output;
	}

	public void writeReady() {

	}
	
	/**
	 * This function is takes the right and left joystick values and sends them to listSpeeds function
	 * @param joy {@link Joystick}  object
	 */
	public void JoystickInput(Joystick joy) {
		listSpeeds(joy.getRawAxis(1), joy.getRawAxis(4));

	}
	/**
	 * This function receives two double values and adds them to the {@link ArrayList}  
	 * {@literal leftDriveSpeeds} and {@literal rightDriveSpeeds}.
	 * @param leftSpeed left double speed value
	 * @param rightSpeed right double speed value
	 */
	public void listSpeeds(double leftSpeed, double rightSpeed) {
		leftDriveSpeeds.add(leftSpeed);
		rightDriveSpeeds.add(rightSpeed);
	}
	/**
	 * This function adds fileNames to a {@link SendableChooser} object 
	 * 
	 */
	public void displayFilenameOptions() {
		m_chooser.addDefault("Option 1", fileNames[0]);
		for (int i = 1; i < 5; i++) {
			String g = String.valueOf(i);
			m_chooser.addObject(g, fileNames[i]);
		}
	}
	//@TODO
	/**
	 * Writes left and right values  from an {@link ArrayList} stoed in an object
	 * to a .txt file. 
	 * @param fileName The {@link String} file name to be created.
	 * @param s {@link Object}
	 */
	public void writeFile(String fileName, Object s) {
		try {
			FileOutputStream fileOutStream = new FileOutputStream(fileName);
			ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutStream);
			for (int i = 0; i < leftDriveSpeeds.size(); i++) {
				objectOutStream.writeObject(s);
			}
			objectOutStream.close();
			setWritten(false);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			setWritten(true);
		}

	}

	public boolean isWritten() {
		return written;
	}

	public void setWritten(boolean written) {
		this.written = written;
	}

	public String getSelectedAuto() {
		return m_chooser.getSelected();
	}
}
