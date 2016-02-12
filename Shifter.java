package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;

public class Shifter extends Component{

	final static int rPortNumber = 0;
	final static int lPortNumber = 1;
	
	
	Solenoid lGearShifter;
	Solenoid rGearShifter;
	
	Joystick stick;
	
	public Shifter (){
		
		
		lGearShifter = new Solenoid(lPortNumber);
		rGearShifter = new Solenoid(rPortNumber);
		
		
	}

	public int getControllerIndex() {
		return XboxMap.DRIVE_CONTROLLER;
	}

	public void setController(Joystick j) {
		stick = j;
	}

	public void update(){
		
		 boolean rPress = stick.getRawButton(XboxMap.RB);
		 boolean lPress = stick.getRawButton(XboxMap.LB);
		 
		 
		 if (rPress == true){
			 shift(true); 
		 }
		 else if(lPress == true){
			shift(false);
		 }
		
	}
	public void shift(boolean gear){
		lGearShifter.set(gear);
		rGearShifter.set(gear);
	}
	
	public void autoUpdate(){
		
	}
}
