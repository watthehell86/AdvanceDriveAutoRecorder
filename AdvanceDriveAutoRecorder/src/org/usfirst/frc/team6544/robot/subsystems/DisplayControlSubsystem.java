package org.usfirst.frc.team6544.robot.subsystems;

import org.usfirst.frc.team6544.robot.commands.DisplayController;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DisplayControlSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DisplayController());
    }
}

