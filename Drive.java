package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.RobotDrive;

public class Drive extends Component {
	RobotDrive driver;
	DualTalon left;
	DualTalon right;

	public Drive() {
		left = new DualTalon(3, 6);
		right = new DualTalon(4, 5);

		left.setMultiplier(.2);
		right.setMultiplier(.2);

		driver = new RobotDrive(left, right);

	}

	public void autoUpdate() {

	}

	public void update() {
		double lJoy = Robot.stick.getRawAxis(XboxMap.LEFT_JOY_HORIZ);
		double rJoy = Robot.stick.getRawAxis(XboxMap.RIGHT_JOY_HORIZ);
		if (Math.abs(lJoy) < .1) {
			lJoy = 0;

		}
		if (Math.abs(rJoy) < .1) {
			rJoy = 0;

		}
		double lM = 0;
		double rM = 0;

		if (lJoy >= 0) {
			lM = rJoy + lJoy;
			rM = lJoy - rJoy;

		}
		if (lJoy < 0) {
			lM = lJoy - rJoy;
			rM = lJoy + rJoy;
		}
		if (lM > 1) {
			lM = 1;
		}
		if (rM > 1) {
			rM = 1;
		}
		if (lM < -1) {
			lM = -1;
		}
		if (rM < -1) {
			rM = -1;

		}
		left.set(lM);
		right.set(rM);

	}
}
