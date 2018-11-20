/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6544.robot.subsystems;

import org.usfirst.frc.team6544.robot.RobotMap;
import org.usfirst.frc.team6544.robot.commands.XboxDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * DriveSystem
 */
public class DriveSystem extends Subsystem {
	private static final WPI_TalonSRX _backRightMotor = new WPI_TalonSRX(RobotMap.kBackRightCIM);
	private static final WPI_TalonSRX _frontRightMotor = new WPI_TalonSRX(RobotMap.kFrontRightCIM);
	private static final WPI_TalonSRX _frontLeftMotor = new WPI_TalonSRX(RobotMap.kFronLeftCIM);
	private static final WPI_TalonSRX _backLeftMotor = new WPI_TalonSRX(RobotMap.kbackLeftCIM);
	private static final SpeedControllerGroup right = new SpeedControllerGroup(_frontLeftMotor, _backLeftMotor);
	private static final SpeedControllerGroup left = new SpeedControllerGroup(_frontRightMotor, _backRightMotor);
	private static final DifferentialDrive ArcadeDrive = new DifferentialDrive(left, right);
	public double speed = 1;

//	List<Byte> leftDriveSpeeds = new ArrayList<Byte>();
//	leftDriveSpeeds.add((byte) 1);
//	leftDriveSpeeds.add((byte) 2);
//	System.out.println(leftDriveSpeeds.get(0));
//	System.out.println(leftDriveSpeeds.get(1));

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new XboxDrive());
	}

	public void arcadeDrive(Joystick joy) {
		ArcadeDrive.arcadeDrive((joy.getRawAxis(1))/speed, (joy.getRawAxis(4))/speed, true);
	}
}
