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
		
		int psi = (int)((compressorValue / 5.0) * 200);
		SmartDashboard.putNumber("Hopeful PSI", psi );

		//puts the value of the compressor to the dash board

		//puts the value of the Accumulator to the dash board
		// TODO find out the difference between accumulator values and voltage values and which one is better.
	}

	@Override
	public void autoUpdate() {

	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		
	}
}
