package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.Solenoid;

public class Shifter extends Component{

	final static int rPortNumber = 0;
	final static int lPortNumber = 1;
	
	
	Solenoid lGearShifter;
	Solenoid rGearShifter;
	
	
	public Shifter (){
		
		
		lGearShifter = new Solenoid(lPortNumber);
		rGearShifter = new Solenoid(rPortNumber);
		
		
	}
	public void update(){
		
		 boolean rPress = Robot.stick.getRawButton(XboxMap.RB);
		 boolean lPress = Robot.stick.getRawButton(XboxMap.LB);
		 
		 
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
