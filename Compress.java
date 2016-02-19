package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;

public class Compress extends Component {

	Compressor compressor;
	DigitalInput comp;

	final static int DIGITAL_PORT = 0;

	boolean started;

	final static int COMP_PORT = 1;

	public Compress() {
		started = false;
		compressor = new Compressor(COMP_PORT);
		comp = new DigitalInput(DIGITAL_PORT);
	}

	public void update() {
		if (comp.get()) {
			compressor.start();
		} else {
			compressor.stop();
		}
	}

	public void autoUpdate() {

	}
}
