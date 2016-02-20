package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.Relay;

public class LightController extends Component {

	final int LIGHT_CHANNEL = 0;
	Relay lights = new Relay(LIGHT_CHANNEL);

	@Override
	public void update() {
		if (Robot.stick.getRawButton(XboxMap.A)) {
			lights.set(Relay.Value.kForward);
		}
		if (Robot.stick.getRawButton(XboxMap.B)) {
			lights.set(Relay.Value.kReverse);
		}
		if (Robot.stick.getRawButton(XboxMap.X)) {
			lights.set(Relay.Value.kOff);
		}
	}

	@Override
	public void autoUpdate() {

	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		
	}

}
