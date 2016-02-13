
package org.usfirst.frc.team662.robot;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends SampleRobot {
    RobotDrive myRobot;
    public static Joystick stick;
    public static Joystick manipulator;
    DigitalInput auto;

    Component[] parts;
    static final int NUM_PARTS = 6;
    static final int AUTO_PORT = 1;

    public Robot() {
        parts = new Component[NUM_PARTS];
        parts[0] = new Compress();
        parts[1] = new Drive();
        parts[2] = new Shifter();
        parts[3] = new Arm();
        parts[4] = new BackArm();
        parts[5] = new BallGrabber();
        stick = new Joystick(0);
        manipulator = new Joystick(1);
        auto = new DigitalInput(AUTO_PORT);
    }
    
    public void robotInit() {
        
    }

    public void autonomous() {
    	if(auto.get()){
	    	for(int i = 0; i < parts.length; i++){
	    		parts[i].autoUpdate();
	    	}
    	}
    }

    public void operatorControl() {
        while (isOperatorControl() && isEnabled()) {
            for(int i = 0; i < parts.length; i++){
            	parts[i].update();
            }
        }
    }

    public void test() {
    }
}
