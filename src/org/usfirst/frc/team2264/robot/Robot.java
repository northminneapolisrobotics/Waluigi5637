/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2264.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */

public class Robot extends IterativeRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	TalonSRX leftT = new TalonSRX(RobotMap.LEFT_MOTOR_PORT);
	TalonSRX rightT = new TalonSRX(RobotMap.RIGHT_MOTOR_PORT);
	Joystick joystickL = new Joystick(RobotMap.LEFT_JOYSTICK_PORT);
	Joystick joystickR = new Joystick(RobotMap.RIGHT_JOYSTICK_PORT);
	
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public Timer.Interface newTimer() {
		return null;
		
	}
	
	@Override
	public void robotInit() {
		m_chooser.addDefault("Default Auto", kDefaultAuto);
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		switch (m_autoSelected) {
			case kCustomAuto:
				// Put custom auto code here
				break;
			case kDefaultAuto:
			default:
				// sets the motors to half normal speed for autonomous to avoid damage
					
					if(){
						
					}
					else{
						leftT.set(ControlMode.PercentOutput, RobotMap.AUTO_MOTOR_ADJUST*RobotMap.MOTOR_FULL_ADJUST_LEFT*1);
						rightT.set(ControlMode.PercentOutput, RobotMap.AUTO_MOTOR_ADJUST*RobotMap.MOTOR_FULL_ADJUST_RIGHT*1);
					
					}
				// Put default auto code here
				break;
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	
	@Override
	public void teleopPeriodic() {
		//puts the y number of the joysticks on the dashboard.
		SmartDashboard.putNumber("Left Joystick" , joystickL.getY());
		SmartDashboard.putNumber("Right Joystick" , joystickR.getY());
		leftT.set(ControlMode.PercentOutput, RobotMap.MOTOR_FULL_ADJUST_LEFT*joystickL.getY());
		rightT.set(ControlMode.PercentOutput, RobotMap.MOTOR_FULL_ADJUST_RIGHT*joystickR.getY());
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
