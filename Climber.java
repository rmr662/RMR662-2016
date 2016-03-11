package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Relay;


public class Climber extends Component{

	CANTalon climbMotor;
	final static int TOP_RELAY = 1;
	final static int BOTTOM_RELAY = 2;
	final static int CLIMBER_PORT = 8;
	final static double CLIMB_DEAD_ZONE = .3;
	final static double CLIMB_MULTIPLIER = .3;
	
	boolean firstTime = true;
	int state = 1;
	public Climber(){
		
		
		climbMotor = new CANTalon(CLIMBER_PORT);
	}
	
	public void update(){
	
		double speed = Robot.manipulator.getRawAxis(XboxMap.RIGHT_JOY_VERT);
		
		if(Math.abs(speed) > CLIMB_DEAD_ZONE){
			climbMotor.set(speed * CLIMB_MULTIPLIER);
		}
		
	}
	public void autoUpdate(){
		
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		climbMotor.set(0);
	}
}