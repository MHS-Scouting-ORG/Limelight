package frc.robot.commands;

//package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LimelightSub;

public class LimeLightCommand extends CommandBase {
    boolean state = true;
    LimelightSub lime = new LimelightSub();

    
    public LimeLightCommand(LimelightSub lime){
        this.lime = lime;
        addRequirements(lime);
    }

    @Override
    public void initialize(){
    }
       

    @Override
    public void execute(){
        lime.limelightState();
    }
    
   @Override 
    public void end(boolean interrupted){

    }
    @Override
    public boolean isFinished(){
        return true;
    }


    

    


}
