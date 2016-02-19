package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

class Arm extends Component {
	final static int TOP_PORT_ONE = 1;
	final static int BOTTOM_PORT_ONE = 2;
	final static int BOTTOM_PORT_TWO = 3;
	final static int TOP_PORT_TWO = 4;
	boolean isFirstTime = true;
	DoubleSolenoid top, bottom;

	public Arm() {

		bottom = new DoubleSolenoid(1, BOTTOM_PORT_ONE, BOTTOM_PORT_TWO);
		top = new DoubleSolenoid(1, TOP_PORT_ONE, TOP_PORT_TWO);

	}

	public void update() {
		boolean Up = Robot.manipulator.getRawButton(XboxMap.Y);
		boolean Half = Robot.manipulator.getRawButton(XboxMap.X);
		boolean Down = Robot.manipulator.getRawButton(XboxMap.A);

		if (Up == true && isFirstTime == true) {
			setSolenoids(DoubleSolenoid.Value.kForward, DoubleSolenoid.Value.kForward);

		}

		else if (Half == true && isFirstTime == true) {
			setSolenoids(DoubleSolenoid.Value.kForward, DoubleSolenoid.Value.kReverse);
		}

		else if (Down == true && isFirstTime == true) {
			setSolenoids(DoubleSolenoid.Value.kReverse, DoubleSolenoid.Value.kReverse);
		}

		else if (!Down && !Up && !Half && !isFirstTime) {
			isFirstTime = true;
		}

	}

	private void setSolenoids(DoubleSolenoid.Value bottomValue, DoubleSolenoid.Value topValue) {
		bottom.set(bottomValue);
		top.set(topValue);
		isFirstTime = false;
	}

	public void autoUpdate() {
		setSolenoids(DoubleSolenoid.Value.kForward, DoubleSolenoid.Value.kForward);
	}

}
