package org.usfirst.frc.team662.robot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BallGrabber extends Component{
	Talon grabbingTalon;
	final static int MOTORPORT = 0;
	final static int SWITCH_PORT = 2;
	DigitalInput buttonOn;
	final static double SPEED_FORWARD = 1;
	final static double SPEED_BACKWARD = -1;
	final static double DEAD_ZONE = .3;
	boolean stopped = false;
	boolean limitHit = false;
	
	public BallGrabber(){
		grabbingTalon = new Talon(MOTORPORT);
		buttonOn = new DigitalInput(SWITCH_PORT);
	}
	public void update(){
		
		double ballPick = Robot.manipulator.getRawAxis(XboxMap.LEFT_JOY_VERT);
	
		SmartDashboard.putBoolean("Limit Switch", buttonOn.get());
		if(!buttonOn.get() && ballPick < 0 && !Robot.manipulator.getRawButton(XboxMap.B)){
			ballPick = 0;
		}
		grabbingTalon.set(Math.abs(ballPick) > DEAD_ZONE ? ballPick : 0);
			
	}
	public void autoUpdate(){
		
	}
	public void disable(){
		grabbingTalon.set(0);
	}
	
}
