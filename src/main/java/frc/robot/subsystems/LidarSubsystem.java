package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.Constants.OperatorConstants;

public class LidarSubsystem extends SubsystemBase{
    Counter lidar = new Counter(OperatorConstants.LIDAR);
    double dist = 0;
    

    public void initialize(){
        lidar.setMaxPeriod(1.00);
        lidar.setSemiPeriodMode(true);
        lidar.reset();
    }
    public void getDistance(){
        if(lidar.get() < 1){
            dist = 0;
            System.out.println("Doesnt work");
        }
        else{
            
            dist = (lidar.getPeriod()*1000000.0/10.0);
        }

    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("distance", dist);
    }



}
