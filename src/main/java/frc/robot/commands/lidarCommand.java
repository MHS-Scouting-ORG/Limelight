package frc.robot.commands;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.LidarSubsystem;

public class lidarCommand extends CommandBase{
    LidarSubsystem lidar;
    public lidarCommand(LidarSubsystem lidar){
        this.lidar = lidar;
        addRequirements(lidar);
    }
    @Override
    public void initialize(){
       lidar.initialize();
       
    }
       

    @Override
    public void execute(){
        lidar.getDistance();
      
    }
    
   @Override 
    public void end(boolean interrupted){

    }
    @Override
    public boolean isFinished(){
        return false;
    }
    
}
