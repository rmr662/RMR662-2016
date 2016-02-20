package org.usfirst.frc.team662.robot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;

public class BallGrabber extends Component{
	Talon grabbingTalon;
	final static int MOTORPORT = 0;
	final static int SWITCHPORT = 2;
	DigitalInput buttonOn;
	final static double SPEED_FORWARD = 1;
	final static double SPEED_BACKWARD = -1;
	final static double DEAD_ZONE = .3;
	boolean clockwise = false;
	boolean runBefore = false;
	boolean limitHit = false;
	
	public BallGrabber(){
		grabbingTalon = new Talon(MOTORPORT);
	}
	public void update(){
		boolean leftButton;
		boolean rightButton;
		leftButton = Robot.manipulator.getRawAxis(XboxMap.LEFT_TRIGGER) > .5;
		rightButton = Robot.manipulator.getRawAxis(XboxMap.RIGHT_TRIGGER) > .5;
		
		double ballPick = Robot.manipulator.getRawAxis(XboxMap.LEFT_JOY_VERT);
	
		/*if(leftButton){
			runBefore = true;
			grabbingTalon.set(SPEED_FORWARD);
		}
		else if(rightButton){
			runBefore = true;
			grabbingTalon.set(SPEED_BACKWARD);
		} else if(runBefore){
			runBefore = false;
			grabbingTalon.set(0);
		}
		*/
		grabbingTalon.set(Math.abs(ballPick) > DEAD_ZONE ? ballPick : 0);
			
	}
	public void autoUpdate(){
		
	}
	public void disable(){
		grabbingTalon.set(0);
		clockwise = false;
		runBefore = false;
	}
	
}
