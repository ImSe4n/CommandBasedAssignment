package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
    private final WPI_TalonSRX intakeMotor = new WPI_TalonSRX(Constants.IntakeConstants.MOTOR_ID);

    public IntakeSubsystem() {
        // Set motor inversion if necessary
        intakeMotor.setInverted(false);
    }

    public void intakeIn() {
        intakeMotor.set(ControlMode.PercentOutput, 0.4);
    }

    public void intakeOut() {
        intakeMotor.set(ControlMode.PercentOutput, -0.4);
    }

    public void stopIntake() {
        intakeMotor.set(ControlMode.PercentOutput, 0);
    }

    public void setIntakeSpeed(double d) {
    }
}
