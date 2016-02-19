package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.Compressor;

public class Compress extends Component {

	Compressor compressor;

	boolean started;

	final static int COMP_PORT = 1;

	public Compress() {
		started = false;
		compressor = new Compressor(COMP_PORT);
	}

	public void update() {
		if (compressor.getPressureSwitchValue() && !started) {
			compressor.start();
			started = true;
		} else if (!compressor.getPressureSwitchValue() && started) {
			compressor.stop();
			started = false;
		}

	}

	public void autoUpdate() {

	}
}
