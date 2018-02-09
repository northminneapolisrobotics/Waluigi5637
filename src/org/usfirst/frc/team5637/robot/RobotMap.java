 package org.usfirst.frc.team5637.robot;
 
 // maps out the ports and buttons and objects and things
 // allows the changing of a variable only once, instead of multiple times 
public class RobotMap {
	
	final static int INTAKE_MOTOR_PORT_LEFT = 6;
	final static int INTAKE_MOTOR_PORT_RIGHT = 7;
	final static int WINCH_MOTOR_PORT = 5;
	final static int BOX_LIFT_MOTOR_PORT = 8;
	final static int LEFT_SEC_MOTOR_PORT = 1;
	final static int RIGHT_SEC_MOTOR_PORT = 3;
	final static int LEFT_MOTOR_PORT = 2;
	final static int RIGHT_MOTOR_PORT = 4;
	
	final static int XBOX_PORT = 2;
	final static int LEFT_JOYSTICK_PORT = 1;
	final static int RIGHT_JOYSTICK_PORT = 0;
	
	final static double TRIGGER_ACTIVATION = 0.1;
	final static double MOTOR_SPEED = .8;
	final static double MOTOR_ADJUST = .91;
	final static double MOTOR_ADJUST_SEC = 1;
	final static int MOTOR_DIRECTION_LEFT = 1;
	final static int MOTOR_DIRECTION_RIGHT = -1;
	final static double AUTO_MOTOR_ADJUST_ONE = 1;
	final static double AUTO_MOTOR_ADJUST_TWO = 1;
	
	final static double WINCH_SPEED_ACT = 0.5;
	final static double WINCH_SPEED_REV = -0.5;
	final static double INTAKE_LEFT_ACT = -0.5;
	final static double INTAKE_RIGHT_ACT = 0.5;
	final static double INTAKE_LEFT_REV = 0.5;
	final static double INTAKE_RIGHT_REV = -0.5;
	
	final static double MOTOR_FULL_ADJUST_LEFT_SEC = RobotMap.MOTOR_DIRECTION_LEFT*RobotMap.MOTOR_SPEED;
	final static double MOTOR_FULL_ADJUST_LEFT = RobotMap.MOTOR_DIRECTION_LEFT*RobotMap.MOTOR_SPEED;
	final static double MOTOR_FULL_ADJUST_RIGHT = RobotMap.MOTOR_DIRECTION_RIGHT*RobotMap.MOTOR_ADJUST*RobotMap.MOTOR_SPEED;
	final static double MOTOR_FULL_ADJUST_RIGHT_SEC = RobotMap.MOTOR_DIRECTION_RIGHT*RobotMap.MOTOR_ADJUST_SEC*RobotMap.MOTOR_SPEED;

	final static double AUTO_MOTOR_ADJUST = 0.5;
	final static double AUTO_TIMER = 5000;
	
	
 }
