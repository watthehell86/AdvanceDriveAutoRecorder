package org.usfirst.frc.team6544.robot.subsystems;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 *
 */
public class RecorderSystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private boolean written = false;
	List<Byte> leftDriveSpeeds = new ArrayList<Byte>();
	List<Byte> rightDriveSpeeds = new ArrayList<Byte>();
	SendableChooser<String> m_chooser = new SendableChooser<>();
	private String[] fileNames = {"Left-Auto-Run.txt",
			"Right-Auto-Run.txt",
			"Center-Auto-Run.txt",
			"Left-Scale-Auto-Run.txt",
			"Right-Scale-Auto-Run.txt"
			};
	
    @Override
	public void initDefaultCommand() {
      setDefaultCommand(null);
    }
   
	public byte[] printLeftSpeed() {
    	byte[] output = new byte[leftDriveSpeeds.size()];
    	for(int i = 0;i<leftDriveSpeeds.size();i++) {
    		output[i] = leftDriveSpeeds.get(i);
    	}
    	return output;
    }
	public void writeReady() {
		
	}
	
    public void JoystickInput(Joystick joy) {
    	listSpeeds(joy.getRawAxis(1),joy.getRawAxis(4));
    	Timer.delay(0.5);
    }
    public void listSpeeds(double leftSpeed,double rightSpeed) {
		byte lSpeed = (byte) leftSpeed;
		byte rSpeed = (byte) rightSpeed;
		leftDriveSpeeds.add(lSpeed);
		rightDriveSpeeds.add(rSpeed);
	}
	public void displayFilenameOptions() {
		m_chooser.addDefault("Option 1", fileNames[0]);
		for(int i = 1;i<5;i++) {
			String g = String.valueOf(i);
			m_chooser.addObject(g, fileNames[i]);
		}
	}
	public void writeFile(String fileName, Object d) {
		try {
            FileOutputStream fileOutStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutStream);
           for(int i = 0;i<leftDriveSpeeds.size();i++) {
        	   objectOutStream.writeObject(d);
               objectOutStream.close();
           }
           setWritten(false);
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }finally{
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

