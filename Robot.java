
package org.usfirst.frc.team662.robot;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends SampleRobot {

    Joystick [] sticks;

    ComponentLoader cl;
    public static Component[] parts;
    public static boolean[] compDisabled;
    static final int NUM_PARTS = 3;
    public Robot() {
	sticks = new Joystick[2];

	sticks[0] = new Joystick(XboxMap.DRIVE_CONTROLLER);
	sticks[1] = new Joystick(XboxMap.MANIP_CONTROLLER);

        cl = new ComponentLoader();
    }
    
    public void robotInit() {
        parts = cl.loadComponents();
		for (int i = 0; parts[i] != null && i < parts.length; i++) {
		   parts[i].setController(sticks[parts[i].getControllerIndex()]);
		}   
    }

    public void autonomous() {
    	for(int i = 0; parts[i] != null && i < parts.length; i++){
    		if(!compDisabled[i]){
    			parts[i].autoUpdate();
    		}
    		else{
    			parts[i].disabled();
    		}
    	}
    }

    public void operatorControl() {
        while (isOperatorControl() && isEnabled()) {
            for(int i = 0; parts[i] != null && i < parts.length; i++){
            	if(!compDisabled[i]){
        			parts[i].update();
        		}
        		else{
        			parts[i].disabled();
        		}
            }
        }
    }

    public void test() {
    }
}
