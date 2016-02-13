package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.Solenoid;

public class BackArm extends Component{
	Solenoid backArm;
	
	boolean clicked;
	
	final static int SOL_PORT = 1;
	
	public BackArm(){
		clicked = false;
		backArm = new Solenoid(SOL_PORT);
	}
	public void update(){
		boolean b = Robot.manipulator.getRawButton(XboxMap.B);
		if(!clicked && b){
			backArm.set(!backArm.get());
			clicked = true;
		}
		else if(clicked && !b){
			clicked = false;
		}
	}
	public void autoUpdate(){
		
	}
}
