package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.Jaguar;

public class Drive extends Component{
	
	final static int LEFT = 0;
	final static int RIGHT = 1;
	
	Jaguar motorR = new Jaguar(0);
	Jaguar motorL = new Jaguar(1);
	
	public Drive(){
		
	}
	
	public void autoUpdate(){
		
	}
	
	public void update(){
		/*if (1<=Robot.stick.getRawAxis(LEFT) + Robot.stick.getRawAxis(RIGHT) && -1>=Robot.stick.getRawAxis(LEFT) + Robot.stick.getRawAxis(RIGHT))
			{motorL.set(Robot.stick.getRawAxis(LEFT) + Robot.stick.getRawAxis(RIGHT)); 
			motorR.set(Robot.stick.getRawAxis(LEFT) - Robot.stick.getRawAxis(RIGHT));}
		else if ((Robot.stick.getRawAxis(LEFT) + Robot.stick.getRawAxis(RIGHT))>(Robot.stick.getRawAxis(LEFT) - Robot.stick.getRawAxis(RIGHT)))
			motorL.set(Robot.stick.getRawAxis(LEFT) + Robot.stick.getRawAxis(RIGHT)/(Math.abs(Robot.stick.getRawAxis(LEFT) + Robot.stick.getRawAxis(RIGHT))));
			motorR.set(Robot.stick.getRawAxis(LEFT) - Robot.stick.getRawAxis(RIGHT) / (Math.abs(Robot.stick.getRawAxis(LEFT) + Robot.stick.getRawAxis(RIGHT))));
			else motorL.set((Robot.stick.getRawAxis(LEFT) + Robot.stick.getRawAxis(RIGHT))/Math.abs(Robot.stick.getRawAxis(LEFT) - Robot.stick.getRawAxis(RIGHT)));
				motorR.set((Robot.stick.getRawAxis(LEFT) + Robot.stick.getRawAxis(RIGHT))/Math.abs(Robot.stick.getRawAxis(LEFT) - Robot.stick.getRawAxis(RIGHT)));
		*/
		/*if (condition) {
			
		}*/
		
		
	}
}
