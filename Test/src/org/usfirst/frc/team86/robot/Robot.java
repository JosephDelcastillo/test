package org.usfirst.frc.team86.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	
	public static Shooter shooter;
	
	@Override
	public void robotInit() {
		shooter.init();
		Drive.init();
	}
	
	@Override
	public void autonomousInit() {
		shooter.init();
		Drive.init();
	}
	
	@Override
	public void autonomousPeriodic() {
		Drive.autoUpdate();		
	}
	
	@Override
	public void teleopPeriodic() {
		shooter.update();
		Drive.teleopUpdate();
	}
}

