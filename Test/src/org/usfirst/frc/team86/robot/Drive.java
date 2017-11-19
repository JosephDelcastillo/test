package org.usfirst.frc.team86.robot;

public class Drive {
	
	static double initTime;
	static double elapsedTime;
	
	private static void tankDrive(double leftSide, double rightSide) {
		IO.lfMotor.setInverted(true);
		IO.lrMotor.setInverted(true);
		
		IO.lfMotor.set(leftSide);
		IO.lrMotor.set(leftSide);
		
		IO.rfMotor.set(rightSide);
		IO.rrMotor.set(rightSide);
	}
	
	public static void init() {
		tankDrive(0,0);
	}
	
	public static void autoUpdate() {
		int state = 0;
		
		switch(state) {
			case 0:
				initTime = System.currentTimeMillis();
				
				state++;
				break;
				
			case 1:
				elapsedTime = System.currentTimeMillis()- initTime;
				if(elapsedTime < 5) {
					tankDrive(0.5,0.5);
				}else {
					tankDrive(0,0);
				}
				
				state++;
				initTime = System.currentTimeMillis();
				break;
				
			case 2:
				elapsedTime = System.currentTimeMillis()- initTime;
				if(elapsedTime < 7.5 && elapsedTime > 5) {
					tankDrive(0.25,-0.25);
				}else {
					tankDrive(0,0);
				}
				
				state++;
				break;
				
			case 3:
				elapsedTime = System.currentTimeMillis()- initTime;
				if(elapsedTime < 10.5 && elapsedTime > 7.5) {
					tankDrive(-0.5,-0.5);
				}else {
					tankDrive(0,0);
				}
				
				state++;
				break;
			
			case 4:
				tankDrive(0,0);
				break;
		}
	}
	
	public static void teleopUpdate() {
		tankDrive(IO.leftJoystick.getY(), IO.rightJoystick.getY());
	}
}
