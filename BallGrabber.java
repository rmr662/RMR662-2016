package org.usfirst.frc.team662.robot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.CANTalon;
public class BallGrabber extends Component{
 CANTalon grabbingTalon;
 final static int MOTORPORT = 1;
 final static int SWITCHPORT = 1;
 DigitalInput buttonOn;
 final static double SPEED_FORWARD = 1;
 final static double SPEED_BACKWARD = -1;
 boolean clockwise = false;
 boolean runBefore = false;
	public BallGrabber(){
		grabbingTalon = new CANTalon(MOTORPORT);
		buttonOn = new DigitalInput(SWITCHPORT);
	}
	public void update(){
		boolean buttonPressed;
		buttonPressed = Robot.manStick.getRawButton(XboxMap.LB);
		if(buttonOn.get()){
			grabbingTalon.set(0);
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
	
}
