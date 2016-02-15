package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BackArm extends Component{
	Solenoid backArm;
	
	boolean clicked;
	
	final static int SOL_PORT = 4;
	boolean direction = false;
	
	public BackArm(){
		clicked = false;
		backArm = new Solenoid(SOL_PORT);
		
	}
	
	public void update(){
		boolean rb = Robot.manipulator.getRawButton(XboxMap.RB);
		boolean lb = Robot.manipulator.getRawButton(XboxMap.LB);
		//backArm.set(lb);
		if(!clicked && rb){
			backArm.set(true);
			clicked = true;
		}
		else if(!clicked && lb){
			backArm.set(false);
			clicked = true;
		}
		else if(clicked && (!lb && !rb) ){
			clicked = false;
		}
		SmartDashboard.putBoolean("Back Arm", backArm.get());
	}
	public void autoUpdate(){
		
	}
}
