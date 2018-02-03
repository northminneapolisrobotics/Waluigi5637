 package org.usfirst.frc.team2264.robot;
 
 // maps out the ports and buttons and objects and things
 // allows the changing of a variable only once, instead of multiple times 
public class RobotMap {
	
	final static int LIFT_BUTTON_DOWN = 7;
	final static int LIFT_BUTTON_UP = 6;
	final static int BOX_LIFT_MOTOR_PORT = 5;
	final static int LEFT_SEC_MOTOR_PORT = 4;
	final static int RIGHT_SEC_MOTOR_PORT = 3;
	final static int LEFT_MOTOR_PORT = 2;
	final static int RIGHT_MOTOR_PORT = 1;
	final static int LEFT_JOYSTICK_PORT = 1;
	final static int RIGHT_JOYSTICK_PORT = 0;
	final static double MOTOR_SPEED = 0.5;
	final static double MOTOR_ADJUST = .91;
	final static double MOTOR_ADJUST_SEC = 1;
	final static int MOTOR_DIRECTION_LEFT = -1;
	final static int MOTOR_DIRECTION_RIGHT = 1;
	
	final static double MOTOR_FULL_ADJUST_LEFT_SEC = RobotMap.MOTOR_DIRECTION_LEFT*RobotMap.MOTOR_SPEED;
	final static double MOTOR_FULL_ADJUST_LEFT = RobotMap.MOTOR_DIRECTION_LEFT*RobotMap.MOTOR_SPEED;
	final static double MOTOR_FULL_ADJUST_RIGHT = RobotMap.MOTOR_DIRECTION_RIGHT*RobotMap.MOTOR_ADJUST*RobotMap.MOTOR_SPEED;
	final static double MOTOR_FULL_ADJUST_RIGHT_SEC = RobotMap.MOTOR_DIRECTION_RIGHT*RobotMap.MOTOR_ADJUST_SEC*RobotMap.MOTOR_SPEED;

	final static double AUTO_MOTOR_ADJUST = 0.5;
	final static double AUTO_TIMER = 5000;
	
	
 }
