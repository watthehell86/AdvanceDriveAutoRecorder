package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class SpeedSelect extends InstantCommand {
	private double speed = 1; // Speed field variable
    public SpeedSelect(double speed) {
        super();
        // Use requires() here to declare subsystem dependencies
       requires(Robot.m_drive); //Tell subsystem manager which subsytem you are using
       this.speed = speed; //Set inputed speed to the field variable speed
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.m_drive.speed = this.speed; // Set inputed speed to drive system speed variable
    }

}
