package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.LimelightSub;

public class AllignCommand extends CommandBase {
    private final LimelightSub limeSub;
    private final DriveTrainSubsystem drive;
    double error;

    public AllignCommand(LimelightSub limelight, DriveTrainSubsystem drive){
        limeSub = limelight;
        this.drive = drive;
        addRequirements(limeSub);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        double kP = 0.0125;
        double minCommand = 0.25; // minimum speed 
        error = limeSub.getXOffset();

        

        if(error > 0.75){
            drive.setAlignSpeed(-((kP * error) + minCommand));
        }
        else if(error < 0.75){
            drive.setAlignSpeed(-((kP * error) - minCommand));
        }
        else{
            drive.setAlignSpeed(0);
        }

    }
    @Override
    public boolean isFinished(){
        if(Math.abs(error) <= .25){
            return true;
        }
        return false;
    }
    @Override
    public void end(boolean interrupted){

    }


}
