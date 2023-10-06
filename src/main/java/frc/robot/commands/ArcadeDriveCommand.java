package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ArcadeDriveCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem;
    private final Joystick driverController;

    public ArcadeDriveCommand(DriveSubsystem driveSubsystem, Joystick driverController) {
        this.driveSubsystem = driveSubsystem;
        this.driverController = driverController;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        double forward = -driverController.getRawAxis(1) * 0.7;
        double turn = driverController.getRawAxis(4) * 0.8;
        driveSubsystem.arcadeDrive(forward, turn);
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.arcadeDrive(0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
