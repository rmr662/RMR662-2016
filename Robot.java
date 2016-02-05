
package org.usfirst.frc.team662.robot;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends SampleRobot {
    RobotDrive myRobot;
    public static Joystick stick;
    public static Joystick manStick;

    Component[] parts;
    static final int NUM_PARTS = 4;

    public Robot() {
        parts = new Component[NUM_PARTS];
        parts[0] = new Drive();
        parts[1] = new Shifter();
        parts[2] = new Arm();
        parts[3] = new BackArm();
        stick = new Joystick(0);
        manStick = new Joystick(1);
    }
    
    public void robotInit() {
        
    }

    public void autonomous() {
    	for(int i = 0; i < parts.length; i++){
    		parts[i].autoUpdate();
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
