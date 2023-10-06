package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class RobotContainer {
    private final DriveSubsystem driveSubsystem = new DriveSubsystem();
    private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    private final Joystick driverController = new Joystick(0);
    private final Joystick operatorController = new Joystick(1);

    public RobotContainer() {
        configureButtonBindings();
        driveSubsystem.setDefaultCommand(new ArcadeDriveCommand(driveSubsystem, driverController));
        intakeSubsystem.setDefaultCommand(new IntakeCommand(intakeSubsystem, operatorController));
    }

    private void configureButtonBindings() {
        new JoystickButton(driverController, 1).onTrue(new ArcadeDriveCommand(driveSubsystem, driverController));
        new JoystickButton(operatorController, 2).onTrue(new IntakeCommand(intakeSubsystem, operatorController));
    }

    public Command getAutonomousCommand() {
       return new AutonomousCommand(driveSubsystem, intakeSubsystem);
    }
}
