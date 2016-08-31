package org.usfirst.frc.team662.robot;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class Drive extends Component{
	RobotDrive driver; 
	DualTalon left;
	DualTalon right;
	ADXRS450_Gyro gyro;
	double firstRot;
	Timer clock1;
	boolean timerValue = false;
	
	final static double LEFT_MULTIPLIER = 1;
	final static double RIGHT_MULTIPLIER = -1;
	final static double LEFT_DEADZONE = 0.20;
	final static double RIGHT_DEADZONE = 0.20;
	final static double AUTO_LEFT_SPEED = .9;
	final static double AUTO_RIGHT_SPEED = .9;
	final static double LOW_ANGLE = -10;
	final static double HIGH_ANGLE = 10;
	final static double AUTO_TIMER = 3;
	final static double HIGH_MULTIPLIER = 1.05;
	final static double LOW_MULTIPLIER = .95;
	final static int FRONT_LEFT_MOTOR = 4;
	final static int REAR_LEFT_MOTOR = 6;
	final static int FRONT_RIGHT_MOTOR = 3;
	final static int REAR_RIGHT_MOTOR = 5;

	public Drive(){
		left = new DualTalon(FRONT_LEFT_MOTOR,REAR_LEFT_MOTOR);
		right = new DualTalon(FRONT_RIGHT_MOTOR,REAR_RIGHT_MOTOR);
		clock1 = new Timer();
		
		
		left.setMultiplier(LEFT_MULTIPLIER);
		right.setMultiplier(RIGHT_MULTIPLIER);
		
		gyro = new ADXRS450_Gyro();
		
		
	}
	
	public void autoUpdate(){
		if(timerValue == false){
			clock1.start();
			timerValue = true;
			firstRot = gyro.getAngle();
		}
		
		
		
		double time = clock1.get();
		if (time < AUTO_TIMER){
			double leftSpeed = AUTO_LEFT_SPEED;
			double rightSpeed = AUTO_RIGHT_SPEED;	
			
			//Check gyro for speed
			/*double[] tSpeed = gyroAngle(firstRot);
			leftSpeed = tSpeed[0];
			rightSpeed = tSpeed[1];*/
			left.set(leftSpeed);
			right.set(rightSpeed);
		}
		else {
			clock1.stop();
			left.set(0);
			right.set(0);
		}
		
	}
	private double[] gyroAngle(double initialAngle){
		double gyroSpeed[] = new double[2];
		double changeInAngle = gyro.getAngle() - initialAngle;
		SmartDashboard.putNumber("Gyro Value", changeInAngle);
		if(changeInAngle < LOW_ANGLE){
			double leftMod = AUTO_LEFT_SPEED * HIGH_MULTIPLIER < 1 ? AUTO_LEFT_SPEED * HIGH_MULTIPLIER : 1 ;
			double rightMod = AUTO_LEFT_SPEED * HIGH_MULTIPLIER > 1 ? AUTO_RIGHT_SPEED *LOW_MULTIPLIER - (AUTO_LEFT_SPEED * HIGH_MULTIPLIER - 1) : AUTO_RIGHT_SPEED *LOW_MULTIPLIER;
			gyroSpeed[0] = leftMod;
			gyroSpeed[1] = rightMod;
		}
		else if(changeInAngle > HIGH_ANGLE){
			double rightMod = AUTO_RIGHT_SPEED * HIGH_MULTIPLIER < 1 ? AUTO_RIGHT_SPEED * HIGH_MULTIPLIER : 1 ;
			double leftMod = AUTO_RIGHT_SPEED * HIGH_MULTIPLIER > 1 ? AUTO_LEFT_SPEED * LOW_MULTIPLIER - (AUTO_RIGHT_SPEED * HIGH_MULTIPLIER - 1) : AUTO_LEFT_SPEED *LOW_MULTIPLIER;
			gyroSpeed[0] = leftMod;
			gyroSpeed[1] = rightMod;
		}
		else{
			gyroSpeed[0] = AUTO_LEFT_SPEED;
			gyroSpeed[1] = AUTO_RIGHT_SPEED;
			return gyroSpeed;
		}
		return gyroSpeed;
	}
	public void update(){
		//experimental drive train code by James S.
    	SmartDashboard.putNumber("The teleGyro is ", gyro.getAngle());
           
       //set variables to defaults
       double rightMotorPower = 0;
       double leftMotorPower = 0;
       double highInput = 1;
       double leftInput = -Robot.manipulator.getRawAxis(XboxMap.LEFT_JOY_VERT);
       double rightInput = Robot.manipulator.getRawAxis(XboxMap.RIGHT_JOY_HORIZ);
       
       //left.set(0);
       //right.set(0);
       
       if (rightInput < 0) {
    	   rightInput *= -rightInput;
       }
       else {
    	   rightInput *= rightInput;
       }
       
       
       //set motor power variables to left stick value
       if(Math.abs(leftInput) > LEFT_DEADZONE){
    	   leftMotorPower = leftInput;
    	   rightMotorPower = leftInput;
       }
       
       //modify motor power variables by right stick values
       if(Math.abs(rightInput) > RIGHT_DEADZONE){
    	   leftMotorPower = leftMotorPower + rightInput;
    	   rightMotorPower = rightMotorPower - rightInput;
       }
       
       //determine the highest input received
       highInput = findHighInput(leftInput, rightInput);
       
       //limit left motor power to highest input received
       leftMotorPower = limitMotor(leftMotorPower, highInput);
       
       //limit right motor power to highest input received
       rightMotorPower = limitMotor(rightMotorPower, highInput);
       
       //set the motors to power variables
       left.set(leftMotorPower);
       right.set(rightMotorPower);
	
	}
	
	//determines which of two inputs is greater, and returns it
	public double findHighInput(double input1, double input2){
		double resultInput = 0;
        if(Math.abs(input1) >= Math.abs(input2)){
    	    resultInput = input1;
        }else{
    	    resultInput = input2;
        }
		return resultInput;
	}
	
	//limits a motor power value to a limiting value
	public double limitMotor(double inputPower, double limiter){
		double outputPower = inputPower;
		if(Math.abs(inputPower) > Math.abs(limiter)){
	    	   if(inputPower < 0){
	    		   outputPower = -Math.abs(limiter);
	    	   }else{
	    		   outputPower = Math.abs(limiter);
	    	   }
	       }
		return outputPower;
	}
	public void disable(){
		left.set(0);
		right.set(0);
		timerValue = false;
		clock1.reset();
	}
	
}