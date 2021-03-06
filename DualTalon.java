package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.*;

public class DualTalon implements SpeedController {
	
	CANTalon left, right;
	
	double currentSpeed;
	double leftSpeedMultiplier;
	double rightSpeedMultiplier;
	
	public DualTalon(int leftChannel, int rightChannel) {
		this(new CANTalon(leftChannel), new CANTalon(rightChannel));
	}
	
	public DualTalon(CANTalon left, CANTalon right) {
		this.left = left;
		this.right = right;
		
		currentSpeed = 0;
		leftSpeedMultiplier = rightSpeedMultiplier = 1.0;
	}
	
	public void setMultiplier(double multiplier) {
		setMultiplier(true, multiplier);
		setMultiplier(false, multiplier);
	}
	
	public void setMultiplier(boolean left, double multiplier) {
		if (multiplier > 1.0) {
			multiplier = 1.0;
		}
		else if (multiplier < -1.0) {
			multiplier = -1.0;
		}
		
		if (left) {
			leftSpeedMultiplier = multiplier;
		}
		else {
			rightSpeedMultiplier = multiplier;
		}
	}
	
	public void invert() {
		invert(true);
		invert(false);
	}
	
	public void invert(boolean left) {
		if (left) {
			leftSpeedMultiplier = -leftSpeedMultiplier;
		}
		else {
			rightSpeedMultiplier = -rightSpeedMultiplier;
		}
	}

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
	}

	@Override
	public double get() {
		return currentSpeed;
	}
	
	// Does nothing
	@Override
	public void set(double speed, byte syncGroup) {
		set(speed);
	}

	@Override
	public void set(double speed) {
		// TODO Auto-generated method stub
		if (speed < -1) {
			speed = -1;
		}
		else if (speed > 1) {
			speed = 1;
		}
		
		currentSpeed = speed;
		
		left.set(leftSpeedMultiplier * currentSpeed);
		right.set(rightSpeedMultiplier * currentSpeed);
	}

	// Does nothing
	@Override
	public void setInverted(boolean isInverted) {
		
	}

	// Does nothing
	@Override
	public boolean getInverted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void disable() {
		leftSpeedMultiplier = rightSpeedMultiplier = 0.0;
	}
}
