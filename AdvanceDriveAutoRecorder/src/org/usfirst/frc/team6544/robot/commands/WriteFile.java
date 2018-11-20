package org.usfirst.frc.team6544.robot.commands;

import org.usfirst.frc.team6544.robot.Robot;
import org.usfirst.frc.team6544.robot.subsystems.Movements;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WriteFile extends Command {
	Movements m = new Movements((byte) 0, (byte) 1, (int) 0.5);

	public WriteFile() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.m_recorder);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.m_recorder.writeFile(Robot.m_recorder.getSelectedAuto(), m);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
