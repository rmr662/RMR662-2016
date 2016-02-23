package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;

public class Robot extends SampleRobot {

	RobotDrive myRobot;
	public static Joystick stick;
	public static Joystick manipulator;
	DigitalInput auto;

	Component[] parts;
	static final int NUM_PARTS = 7;

	static final int AUTO_PORT = 1;

	public Robot() {
		stick = new Joystick(0);
		manipulator = new Joystick(1);
		parts = new Component[NUM_PARTS];
		parts[0] = new Compress();
		parts[1] = new Drive();
		parts[2] = new Shifter();
		parts[3] = new Arm();
		parts[4] = new BackArm();
		parts[5] = new BallGrabber();
		parts[6] = new PressureMeter();
		
		auto = new DigitalInput(AUTO_PORT);
	}

	public void robotInit() {

	}

	public void autonomous() {
		//Add loop
		if (!auto.get()) {
			for (int i = 0; i < parts.length; i++) {
				parts[i].autoUpdate();
			}
		}
	}

	public void operatorControl() {
		while (isOperatorControl() && isEnabled()) {
			for (int i = 0; i < parts.length; i++) {
				try{
					parts[i].update();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void test() {
	}
	public void disabled(){
		for(int i = 0 ; i < parts.length; i++){
			parts[i].disable();
		}
	}
}
