package org.usfirst.frc.team662.robot;

import edu.wpi.first.wpilibj.Joystick;

public abstract class Component {
	
		public abstract void update();
		public abstract void autoUpdate();
		public abstract int getControllerIndex();
		public abstract void setController(Joystick j);
}
