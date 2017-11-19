package org.usfirst.frc.team86.robot;

import org.usfirst.frc.team86.robot.IO;

import edu.wpi.first.wpilibj.Victor;

public class Shooter {

	private Victor shooter = IO.shooter;
	private Victor agitator = IO.agitator;
	private Victor vibrator = IO.vibrator;
	private Victor conveyor = IO.conveyor;
	
	public void init() {
		
		shooter.set(0);
		conveyor.set(0);
	}
	
	public void update() {
		
		if(IO.coDriver.getRawButton(1) && IO.coDriver.getRawButton(3)) {
			shooter.set(0.65);
			conveyor.set(1);
			agitator.set(0.3);
			vibrator.set(0.5);
		} else if(IO.coDriver.getRawButton(1)) {
			shooter.set(0.65);
			conveyor.set(1);
		} else {
			shooter.set(0);
			conveyor.set(0);
			agitator.set(0);
			vibrator.set(0);
		}
		
		if( IO.coDriver.getRawButton(5)) {
			shooter.set(0.25);
		} else {
			shooter.set(0);
		}
	}
}
