package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.Relay;


public class Climber {

	Relay climbMotor;
	Relay topMotor;
	final static int TOP_RELAY = 1;
	final static int BOTTOM_RELAY = 2;
	boolean firstTime = true;
	int state = 1;
	public Climber(){
		
		
		climbMotor = new Relay(TOP_RELAY);
		topMotor = new Relay(BOTTOM_RELAY);
	}
	
	public void update(){
	
		boolean start = Robot.manipulator.getRawButton(XboxMap.START);
		
		if(start == true && firstTime == true){
			
			if(state == 1){
				setMotors(Relay.Value.kForward);
				firstTime = false;
				state ++; 
			
			}
			else if(state == 0 || state == 2){
				setMotors(Relay.Value.kOff);
				state ++;
			}
			else if(state == 3){
				setMotors(Relay.Value.kReverse);
				state = 1;
			}
		}
		if(start == false && firstTime == false){
			firstTime = true;
			
		}
	}
	public void setMotors (Relay.Value motor){
		climbMotor.set(motor);
		topMotor.set(motor);
	}
}