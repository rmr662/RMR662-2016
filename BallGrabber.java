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
		buttonOn = new DigitalInput(SWITCHPORT);
	}
	public void update(){
		boolean buttonPressed;
		buttonPressed = Robot.manipulator.getRawButton(XboxMap.LB);
		if(buttonOn.get() && limitHit == false){
			grabbingTalon.set(0);
			limitHit = true;
		}
		if(!buttonOn.get()){
			limitHit = false;
		}
	
		if(buttonPressed && !runBefore){	
			if(clockwise == false){
				clockwise = true;
				grabbingTalon.set(SPEED_FORWARD);
			}
			if(clockwise == true){
				clockwise = false;
				grabbingTalon.set(SPEED_BACKWARD);
			}
			runBefore = true;
			
		}
		else{
			if(buttonPressed){
				runBefore = false;
			}
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
