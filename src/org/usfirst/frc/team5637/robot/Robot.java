 /*----------------------------------------------------------------------------*/
 /* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
 /* Open Source Software - may be modified and shared by FRC teams. The code   */
 /* must be accompanied by the FIRST BSD license file in the root directory of */
 /* the project.                                                               */
 /*----------------------------------------------------------------------------*/
 
 package org.usfirst.frc.team5637.robot;

 import com.ctre.phoenix.motorcontrol.ControlMode;

 import com.ctre.phoenix.motorcontrol.can.TalonSRX;
 
 import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.IterativeRobot;
 import edu.wpi.first.wpilibj.Joystick;
 import edu.wpi.first.wpilibj.Timer;
 import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
 import edu.wpi.first.wpilibj.command.TimedCommand;
 /**
  * The VM is configured to automatically run this class, and to call the
  * functions corresponding to each mode, as described in the IterativeRobot
  * documentation. If you change the name of this class or the package after
  * creating this project, you must also update the build.properties file in the
  * project.
  */
 
 public class Robot extends IterativeRobot {
 	private double autoStartTime;
 	
 	TalonSRX winchMotor = new TalonSRX(RobotMap.WINCH_MOTOR_PORT);
 	TalonSRX intakeLeft = new TalonSRX(RobotMap.INTAKE_MOTOR_PORT_LEFT);
 	TalonSRX intakeRight = new TalonSRX(RobotMap.INTAKE_MOTOR_PORT_RIGHT);
 	//TalonSRX intakeTwo = new TalonSRX(RobotMap.INTAKE_MOTOR_PORT_TWO);
 	//TalonSRX intakeOne = new TalonSRX(RobotMap.INTAKE_MOTOR_PORT_ONE);
 	TalonSRX boxLift = new TalonSRX(RobotMap.BOX_LIFT_MOTOR_PORT);
 	TalonSRX leftBT = new TalonSRX(RobotMap.LEFT_SEC_MOTOR_PORT);
 	TalonSRX rightBT = new TalonSRX(RobotMap.RIGHT_SEC_MOTOR_PORT);
 	TalonSRX leftT = new TalonSRX(RobotMap.LEFT_MOTOR_PORT);
 	TalonSRX rightT = new TalonSRX(RobotMap.RIGHT_MOTOR_PORT);
 	
 	Joystick joystickL = new Joystick(RobotMap.LEFT_JOYSTICK_PORT);
 	Joystick joystickR = new Joystick(RobotMap.RIGHT_JOYSTICK_PORT);
 	XboxController xBox = new XboxController(RobotMap.XBOX_PORT);
 	
 	TimedCommand autoForward = new TimedCommand(RobotMap.AUTO_TIMER);
 	
 	CameraServer forwardCamera = CameraServer.getInstance();
 	CameraServer backCamera = CameraServer.getInstance();
 	
 	/**
 	 * This function is run when the robot is first started up and should be
 	 * used for any initialization code.
 	 */
	public Timer.Interface newTimer() {
		return null;
		
	}
	
 	@Override
 	public void robotInit() {
  		forwardCamera.startAutomaticCapture();
 		backCamera.startAutomaticCapture();
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
 		autoStartTime = System.currentTimeMillis();
 		
 	}
 
 	/**
 	 * This function is called periodically during autonomous.
 	 */
 	@Override
 	public void autonomousPeriodic() {
 		// Put custom auto code here
 		if(System.currentTimeMillis() - autoStartTime <= RobotMap.AUTO_TIMER){
 			autoForward();
 		}
 		else {
 			autoStop();
 		}				
 	}

 	
 	private void autoStop() {
 		leftT.set(ControlMode.PercentOutput, 0);
 		leftBT.set(ControlMode.PercentOutput, 0);
 		rightT.set(ControlMode.PercentOutput, 0);
 		rightBT.set(ControlMode.PercentOutput, 0);
 	}
 	private void autoForward() {
 		leftBT.set(ControlMode.PercentOutput, RobotMap.AUTO_MOTOR_ADJUST*RobotMap.MOTOR_FULL_ADJUST_LEFT_SEC*1);
 		leftT.set(ControlMode.PercentOutput, RobotMap.AUTO_MOTOR_ADJUST*RobotMap.MOTOR_FULL_ADJUST_LEFT*1);
		rightT.set(ControlMode.PercentOutput, RobotMap.AUTO_MOTOR_ADJUST*RobotMap.MOTOR_FULL_ADJUST_RIGHT*1);
		rightBT.set(ControlMode.PercentOutput, RobotMap.AUTO_MOTOR_ADJUST*RobotMap.MOTOR_FULL_ADJUST_RIGHT_SEC*1);
	}

	/**
 	 * This function is called periodically during operator control.
 	 */
 	
 	@Override
 	public void teleopPeriodic() {
 		//puts the y number of the joysticks on the dashboard.
 		SmartDashboard.putNumber("Left Joystick" , joystickL.getY());
 		SmartDashboard.putNumber("Right Joystick" , joystickR.getY());
 		leftT.set(ControlMode.PercentOutput, -RobotMap.MOTOR_FULL_ADJUST_LEFT*Math.pow(joystickL.getY(), 2)); //Remove negative sign to invert motor direction
 		leftBT.set(ControlMode.PercentOutput, -RobotMap.MOTOR_FULL_ADJUST_LEFT_SEC*Math.pow(joystickL.getY(), 2)); //Remove negative sign to invert motor direction
 		
 		rightT.set(ControlMode.PercentOutput, -RobotMap.AUTO_MOTOR_ADJUST_ONE*RobotMap.MOTOR_FULL_ADJUST_RIGHT*Math.pow(joystickR.getY(), 2)); //Remove negative sign to invert motor direction
 		rightBT.set(ControlMode.PercentOutput, -RobotMap.AUTO_MOTOR_ADJUST_ONE*RobotMap.MOTOR_FULL_ADJUST_RIGHT_SEC*Math.pow(joystickR.getY(), 2)); //Remove negative sign to invert motor direction
 		
 		if(getBoxLiftAct() > RobotMap.TRIGGER_ACTIVATION)
 		{
 			boxLift.set(ControlMode.PercentOutput, getBoxLiftAct());
 		}
 		//switch to triggers
 		else if(getBoxLiftRev() > RobotMap.TRIGGER_ACTIVATION)
 		{
 			boxLift.set(ControlMode.PercentOutput, -1 * getBoxLiftRev());
 		}
 		else{
 			boxLift.set(ControlMode.PercentOutput, 0);
 		}
 		
 		if(getWinchAct()){
 			winchMotor.set(ControlMode.PercentOutput, RobotMap.WINCH_SPEED_ACT);
 		}
 		//set to bumpers
 		else if(getWinchRev()){
 			winchMotor.set(ControlMode.PercentOutput, RobotMap.WINCH_SPEED_REV);
 		}
 		else{
 			winchMotor.set(ControlMode.PercentOutput, 0);
 		}
 		
 		if(getIntakeIn()){
 			
 			intakeLeft.set(ControlMode.PercentOutput, RobotMap.INTAKE_LEFT_ACT);
 			intakeRight.set(ControlMode.PercentOutput, RobotMap.INTAKE_RIGHT_ACT);
 		}
 		else if(getIntakeOut()){
 			intakeLeft.set(ControlMode.PercentOutput, RobotMap.INTAKE_LEFT_REV);
 			intakeRight.set(ControlMode.PercentOutput, RobotMap.INTAKE_RIGHT_REV);
 		}
 		else{
 			intakeLeft.set(ControlMode.PercentOutput, 0);
 			intakeRight.set(ControlMode.PercentOutput, 0);
 		}
 	}
 
	/**
 	 * This function is called periodically during test mode.
 	 */
 	@Override
 	public void testPeriodic() {
 	}
 	
 	public boolean getWinchAct(){
 		return xBox.getBumper(GenericHID.Hand.kRight);
 	}
 	public boolean getWinchRev(){
 		return xBox.getBumper(GenericHID.Hand.kLeft);
 	}
 	
 	public double getBoxLiftAct(){
 		return xBox.getTriggerAxis(GenericHID.Hand.kRight);
 	}
 	public double getBoxLiftRev(){
 		return xBox.getTriggerAxis(GenericHID.Hand.kLeft);
 	}
 	
 	public boolean getIntakeIn(){
 		return xBox.getAButton();
 	}
 	public boolean getIntakeOut(){
 		return xBox.getBButton();
 	}
 }
