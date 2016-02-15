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
	boolean clockwise = false;
	boolean runBefore = false;
	boolean limitHit = false;
	
	public BallGrabber(){
		grabbingTalon = new Talon(MOTORPORT);
		//buttonOn = new DigitalInput(SWITCHPORT);
	}
	public void update(){
		boolean leftButton;
		boolean rightButton;
		leftButton = Robot.manipulator.getRawAxis(XboxMap.LEFT_TRIGGER) > .5;
		rightButton = Robot.manipulator.getRawAxis(XboxMap.RIGHT_TRIGGER) > .5;
		
		/*if(buttonOn.get() && limitHit == false){
			grabbingTalon.set(0);
			limitHit = true;
		}
		if(!buttonOn.get()){
			limitHit = false;
		}*/
	
		if(leftButton){
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
			
	}
	public void autoUpdate(){
		
	}
	public void disable(){
		grabbingTalon.set(0);
		clockwise = false;
		runBefore = false;
	}
	
}
