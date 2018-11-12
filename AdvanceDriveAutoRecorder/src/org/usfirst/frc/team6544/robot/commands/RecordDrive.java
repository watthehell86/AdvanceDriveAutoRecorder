package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.OI;
import org.usfirst.frc.team6544.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RecordDrive extends Command {

    public RecordDrive() {
        // Use requires() here to declare subsystem dependencies
         requires(Robot.m_recorder);
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	Robot.m_recorder.setWritten(true);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
    	Robot.m_recorder.JoystickInput(OI.XboxController);
    	Timer.delay(0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() {
        return OI.whenDone();
    }

    // Called once after isFinished returns true
    @Override
	protected void end() {
    	SmartDashboard.putNumberArray("Left Value Output", Robot.m_recorder.printLeftSpeed());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
	protected void interrupted() {
    }
}
