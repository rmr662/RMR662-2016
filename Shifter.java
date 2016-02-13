package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.Solenoid;

public class Shifter extends Component{

	final static int portNumber = 5;
	
	
	Solenoid gearShifter;
	
	
	public Shifter (){
		

		gearShifter = new Solenoid(portNumber);
		
		
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
		gearShifter.set(gear);
	}
	
	public void autoUpdate(){
		
	}
}
