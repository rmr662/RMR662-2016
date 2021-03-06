

package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

class Arm extends Component{
	final static int RIGHT_PORT_ONE = 1;
	final static int RIGHT_PORT_TWO = 2;
	final static int RIGHT_PORT_THREE = 3;
	final static int RIGHT_PORT_FOUR = 4;
	final static int LEFT_PORT_ONE = 5;
	final static int LEFT_PORT_TWO = 6;
	final static int LEFT_PORT_THREE = 7;
	final static int LEFT_PORT_FOUR = 0;
	boolean isFirstTime = true;	
	DoubleSolenoid rightBottom;
	DoubleSolenoid rightTop;
	DoubleSolenoid leftBottom;
	DoubleSolenoid leftTop;
	
	public Arm(){
		rightBottom= new DoubleSolenoid(1, RIGHT_PORT_TWO, RIGHT_PORT_THREE );
		leftBottom= new DoubleSolenoid(1, LEFT_PORT_TWO, LEFT_PORT_THREE);
		rightTop= new DoubleSolenoid(1, RIGHT_PORT_ONE, RIGHT_PORT_FOUR );
		leftTop= new DoubleSolenoid(1, LEFT_PORT_ONE, LEFT_PORT_FOUR);

	}
	public void update(){
		boolean Up = Robot.stick.getRawButton(XboxMap.Y);
		boolean Half = Robot.stick.getRawButton(XboxMap.B) || Robot.stick.getRawButton(XboxMap.X);
		boolean Down = Robot.stick.getRawButton(XboxMap.A);
			
		if (Up == true && isFirstTime == true) {
			setSolenoids(DoubleSolenoid.Value.kForward, DoubleSolenoid.Value.kForward);
			
		}
		
		else if(Half == true && isFirstTime == true){
			setSolenoids(DoubleSolenoid.Value.kForward, DoubleSolenoid.Value.kReverse);
		}
		
		else if (Down == true && isFirstTime == true){
			setSolenoids(DoubleSolenoid.Value.kReverse, DoubleSolenoid.Value.kReverse);
		}
		
		else if(!Down && !Up && !Half && !isFirstTime){
			isFirstTime = true;
		}
			

		
		
		
	}
	private void setSolenoids(DoubleSolenoid.Value bottom, DoubleSolenoid.Value top){
		rightBottom.set(bottom);
		leftBottom.set(bottom);
		rightTop.set(top);
	    leftTop.set(top);
	    isFirstTime = false;
	}
	public void autoUpdate(){
		
	}

}
