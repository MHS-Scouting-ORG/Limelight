package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.LimelightSub;

public class AllignYCommand extends CommandBase {
    LimelightSub lime;
    DriveTrainSubsystem drive;

    double minDistance = 2;
    double maxDistance = 4;
    
    public AllignYCommand(LimelightSub lime, DriveTrainSubsystem drive){
        this.lime = lime;
        this.drive = drive;
        addRequirements(this.lime);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        double minCommand = 0.3;
        double kp = 0.045;
        double error = 0;

        if(lime.distance() > 0 &&  lime.distance() < minDistance){
            error = minDistance - lime.distance();
            drive.setRangeSpeed((kp *error) + minCommand );
        }
        else if(lime.distance() > maxDistance){
            error = maxDistance - lime.distance();
            drive.setRangeSpeed((kp * error) - minCommand);
        }
        else{
            drive.setRangeSpeed(0);
        }
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void end(boolean interrupted){

    }
}
