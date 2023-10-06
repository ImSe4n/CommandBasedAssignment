package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {
    private final IntakeSubsystem intakeSubsystem;
    private final Joystick operatorController;

    public IntakeCommand(IntakeSubsystem intakeSubsystem, Joystick operatorController) {
        this.intakeSubsystem = intakeSubsystem;
        this.operatorController = operatorController;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        if (operatorController.getRawButton(1)) {
            intakeSubsystem.intakeIn();
        } else if (operatorController.getRawButton(2)) {
            intakeSubsystem.intakeOut();
        } else {
            intakeSubsystem.stopIntake();
        }
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.stopIntake();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
