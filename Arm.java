package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

class Arm extends Component {
	final static int EXTEND_PORT_TOP = 3;
	final static int RETRACT_PORT_TOP = 2;
	final static int EXTEND_PORT_BOTTOM = 6;
	final static int RETRACT_PORT_BOTTOM = 7;
	boolean isFirstTime = true;
	DoubleSolenoid bottomSol;
	DoubleSolenoid topSol;

	public Arm() {

		bottomSol = new DoubleSolenoid(1, EXTEND_PORT_BOTTOM, RETRACT_PORT_BOTTOM);

		topSol = new DoubleSolenoid(1, EXTEND_PORT_TOP, RETRACT_PORT_TOP);

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

	private void setSolenoids(DoubleSolenoid.Value bottom, DoubleSolenoid.Value top) {
		bottomSol.set(bottom);
		topSol.set(top);
		isFirstTime = false;
	}

	public void autoUpdate() {
		setSolenoids(DoubleSolenoid.Value.kForward, DoubleSolenoid.Value.kForward);
	}

}
