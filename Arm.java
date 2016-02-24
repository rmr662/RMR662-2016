package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

class Arm extends Component {
	final static int EXTEND_PORT_TOP = 2;
	final static int RETRACT_PORT_TOP = 3;
	final static int EXTEND_PORT_BOTTOM = 6;
	final static int RETRACT_PORT_BOTTOM = 7;
	boolean isFirstTime = true;
	DoubleSolenoid bottomSol;
	DoubleSolenoid topSol;

	boolean up, half, down;
	
	public Arm() {

		bottomSol = new DoubleSolenoid(1, EXTEND_PORT_BOTTOM, RETRACT_PORT_BOTTOM);

		topSol = new DoubleSolenoid(1, EXTEND_PORT_TOP, RETRACT_PORT_TOP);
		up = true;
		half = down = false;
	}

	public void update() {

		if (up == true && isFirstTime == true) {
			setSolenoids(DoubleSolenoid.Value.kForward, DoubleSolenoid.Value.kForward);
		}
		else if (half == true && isFirstTime == true) {
			setSolenoids(DoubleSolenoid.Value.kForward, DoubleSolenoid.Value.kReverse);
		}
		else if (down == true && isFirstTime == true) {
			setSolenoids(DoubleSolenoid.Value.kReverse, DoubleSolenoid.Value.kReverse);
		}
		else if (!down && !up && !half && !isFirstTime) {
			isFirstTime = true;
		}
		
		up = Robot.manipulator.getRawButton(XboxMap.Y);
		half = Robot.manipulator.getRawButton(XboxMap.X);
		down = Robot.manipulator.getRawButton(XboxMap.A);

	}

	private void setSolenoids(DoubleSolenoid.Value bottom, DoubleSolenoid.Value top) {
		bottomSol.set(bottom);
		topSol.set(top);
		isFirstTime = false;
	}

	public void autoUpdate() {
		setSolenoids(DoubleSolenoid.Value.kForward, DoubleSolenoid.Value.kForward);
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		setSolenoids(DoubleSolenoid.Value.kReverse, DoubleSolenoid.Value.kReverse);
		up = true;
		down = half = false;
		isFirstTime = true;
	}

}
