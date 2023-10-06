package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class AutonomousCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem;
    private final IntakeSubsystem intakeSubsystem;

    public AutonomousCommand(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem) {
        this.driveSubsystem = driveSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(driveSubsystem, intakeSubsystem);
    }

    @Override
    public void initialize() {
        // Set the drive and intake speeds when the command starts
        driveSubsystem.arcadeDrive(0.5, 0); // Drive forward at 0.5 speed
        intakeSubsystem.setIntakeSpeed(0.5); // Start intake at 0.5 speed
    }

    @Override
    public void end(boolean interrupted) {
        // Stop the drive and intake when the command ends
        driveSubsystem.arcadeDrive(0, 0); // Stop drive
        intakeSubsystem.setIntakeSpeed(0); // Stop intake
    }

    @Override
    public boolean isFinished() {
        // This command will run for 2 seconds
        return timeSinceInitialized() >= 2;
    }

    private int timeSinceInitialized() {
      return 0;
    }
}
