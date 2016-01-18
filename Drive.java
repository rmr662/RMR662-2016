package org.usfirst.frc.team662.robot;
import edu.wpi.first.wpilibj.RobotDrive;
public class Drive extends Component{
	RobotDrive driver; 
	DualTalon left;
	DualTalon right; 
	
	public Drive(){
		left = new DualTalon(3,6);
		right = new DualTalon(4,5);
		
		left.setMultiplier(.2);
		right.setMultiplier(.2);
				
		driver = new RobotDrive(left,right);
	}
	
	public void autoUpdate(){
		
	}
	
	public void update(){
		driver.arcadeDrive(Robot.stick.getRawAxis(XboxMap.LEFT_JOY_VERT), Robot.stick.getRawAxis(XboxMap.RIGHT_JOY_HORIZ));
	
	}
}

