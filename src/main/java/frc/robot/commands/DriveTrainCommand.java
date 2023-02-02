package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
//import java.util.function.DoubleSupplier;

public class DriveTrainCommand extends CommandBase{
    private final DriveTrainSubsystem driveTrain;

    private final DoubleSupplier x_value;
    private final DoubleSupplier y_value;

    public DriveTrainCommand(DoubleSupplier xVal, DoubleSupplier yVal, DriveTrainSubsystem drive){
        driveTrain = drive;
        x_value = xVal;
        y_value = yVal;   
        addRequirements(drive);
    } // CONSTRUCTOR FOR COMMAND CLASS

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        driveTrain.arcadeDrive(x_value, y_value);
    }

    @Override
    public void end(boolean interrupted){
        driveTrain.setSpeed(0, 0);
    }

    @Override 
    public boolean isFinished(){
        return false;
    }
    
}
