package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PressureMeter extends Component {

	final int ANALOG_CHANNEL = 0;
	double compressorValue;
	double compressorAccumulatorValue;

	SmartDashboard outputWindow = new SmartDashboard();
	AnalogInput compressorValueFinder = new AnalogInput(ANALOG_CHANNEL);

	@Override
	public void update() {
		//gets the compressor value from the analog channel
		compressorValue = compressorValueFinder.getVoltage();
		compressorAccumulatorValue = compressorValueFinder.getAccumulatorValue();

		//puts the value of the compressor to the dash board
		SmartDashboard.putNumber("Voltage", compressorValue);

		//puts the value of the Accumulator to the dash board
		// TODO find out the difference between accumulator values and voltage values and which one is better.
		SmartDashboard.putNumber("Accumulator Value", compressorAccumulatorValue);
	}

	@Override
	public void autoUpdate() {

	}
}
