package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
    private final WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(Constants.DriveConstants.FRONT_LEFT_MOTOR_ID);
    private final WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(Constants.DriveConstants.FRONT_RIGHT_MOTOR_ID);
    private final WPI_TalonSRX backLeftMotor = new WPI_TalonSRX(Constants.DriveConstants.BACK_LEFT_MOTOR_ID);
    private final WPI_TalonSRX backRightMotor = new WPI_TalonSRX(Constants.DriveConstants.BACK_RIGHT_MOTOR_ID);

    public DriveSubsystem() {
        // Set motor inversion if necessary
        frontLeftMotor.setInverted(false);
        frontRightMotor.setInverted(false);
        backLeftMotor.setInverted(false);
        backRightMotor.setInverted(false);
    }

    public void arcadeDrive(double forward, double turn) {
        // Implement your arcade drive logic here using the motor controllers
        frontLeftMotor.set(ControlMode.PercentOutput, forward + turn);
        frontRightMotor.set(ControlMode.PercentOutput, forward - turn);
        backLeftMotor.set(ControlMode.PercentOutput, forward + turn);
        backRightMotor.set(ControlMode.PercentOutput, forward - turn);
    }
}
