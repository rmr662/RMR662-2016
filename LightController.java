package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.Relay;

public class LightController extends Component {

	final int LIGHT_CHANNEL = 0;
	boolean color = false;
	Relay lights = new Relay(LIGHT_CHANNEL);

	@Override
	public void update() {
		if (Robot.manipulator.getRawButton(XboxMap.START)) {
			lights.set(color ? Relay.Value.kForward : Relay.Value.kReverse);
		}
		if (Robot.manipulator.getRawButton(XboxMap.BACK)) {
			lights.set(Relay.Value.kOff);
		}
		/*if (Robot.stick.getRawButton(XboxMap.X)) {
			lights.set(Relay.Value.kOff);
		}*/
	}

	@Override
	public void autoUpdate() {

	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		
	}

}
