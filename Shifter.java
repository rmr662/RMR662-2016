package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shifter extends Component{

	final static boolean LOW = true;
	final static boolean HIGH = false;
	final static int portNumber = 5;
	Solenoid gearShifter;

	public Shifter (){
		gearShifter = new Solenoid(1, portNumber);
	}
	public void update(){
		
		 boolean rPress = Robot.manipulator.getRawButton(XboxMap.R_ANALOG);
		 boolean lPress = Robot.manipulator.getRawButton(XboxMap.L_ANALOG);
		 
		 if (rPress == true){
			 shift(HIGH); 
		 }
		 else if(lPress == true){
			shift(LOW);
		 }
	}
	public void shift(boolean gear){
		gearShifter.set(gear);
	}
	
	public void autoUpdate(){
		//gearShifter.set(LOW);
	}
	@Override
	public void disable() {
		//gearShifter.set(LOW);
	}
}
