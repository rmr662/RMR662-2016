
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

    Component[] parts;
    static final int NUM_PARTS = 1;

    public Robot() {
        parts = new Component[NUM_PARTS];
    }
    
    public void robotInit() {
        
    }

    public void autonomous() {
    	for(int i = 0; i < parts.length; i++){
    		parts[i].autoUpdate();
    	}
    }

    public void operatorControl() {
        myRobot.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) {
            for(int i = 0; i < parts.length; i++){
            	parts[i].update();
            }
        }
    }

    public void test() {
    }
}
