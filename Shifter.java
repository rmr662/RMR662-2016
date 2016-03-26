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
		
		 boolean rPress = Robot.stick.getRawButton(XboxMap.RB);
		 boolean lPress = Robot.stick.getRawButton(XboxMap.LB);
		 
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
