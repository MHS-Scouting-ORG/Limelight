package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.LimelightSub;
import frc.robot.commands.AllignCommand;
import frc.robot.commands.AllignYCommand;

public class AllignXYCommand extends CommandBase {
    
    LimelightSub limeSub;
    DriveTrainSubsystem drive;
    AllignCommand x = new AllignCommand(limeSub, drive);
    AllignYCommand y = new AllignYCommand(limeSub, drive);
    
    public AllignXYCommand(LimelightSub lime, DriveTrainSubsystem drive){
        this.limeSub = lime;
        this.drive = drive;
        addRequirements(limeSub);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        x.execute();
        y.execute();
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void end(boolean interrupted){

    }
}
