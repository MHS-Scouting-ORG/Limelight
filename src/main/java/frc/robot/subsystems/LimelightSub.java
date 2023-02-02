package frc.robot.subsystems;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;


public class LimelightSub extends SubsystemBase{
    private NetworkTable limelight;
    private NetworkTableEntry camModeEntry;
    private NetworkTableEntry ledModeEntry;
    private NetworkTableEntry checkTargetEntry;
    private NetworkTableEntry xOffsetEntry;
    private NetworkTableEntry yOffsetEntry;
    private boolean limelightState = false;
    private boolean outputChanged = false;

    private double targetHeight = 3;
    private double cameraHeight = 1.79;
    private double cameraAngle = 0;
    private double cameraToBumpDistance = 1.458;

    public static class Settings{ // LIMELIGHT SETTINGS OMG!!!
        public int givenPipes;
        public double xOffset;
        public double yOffset;
        public boolean targetFound;

        public int pipeline = 0;
    }

    private Settings setting = new Settings();

    public NetworkTable getLimelight(){
        limelight = NetworkTableInstance.getDefault().getTable("limelight");
        return limelight;
    }

    public NetworkTableEntry getCamModeEntry(){
        camModeEntry = getLimelight().getEntry("camMode");
        return camModeEntry;
    }

    public NetworkTableEntry getLedModeEntry(){
        ledModeEntry = getLimelight().getEntry("ledMode");
        return ledModeEntry;
    }

    public NetworkTableEntry getTargetEntry(){
        checkTargetEntry = getLimelight().getEntry("tv");
        return checkTargetEntry;
    }

    public NetworkTableEntry getXOffsetEntry(){
        xOffsetEntry = getLimelight().getEntry("tx");
        return xOffsetEntry;
    }

    public NetworkTableEntry getYOffsetEntry(){
        yOffsetEntry = getLimelight().getEntry("ty");
        return yOffsetEntry;
    }
    
    public double getXOffset(){
        return getXOffsetEntry().getDouble(0);
    }

    public double getYOffset(){
        return getYOffsetEntry().getDouble(0);
    }

    // sets cam mode to vision process and then forces led state off
    public void drivingMode(){
     //   getLimelight().getEntry("pipeline").setDouble(1);
        getCamModeEntry().setDouble(1);
        getLedModeEntry().setDouble(1);
    }

    // sets the cam mode to vision process and then forces led state on
    public void trackingMode(){
    //getLimelight().getEntry("pipeline").setDouble(0);

        getCamModeEntry().setDouble(0);
        getLedModeEntry().setDouble(0);
    }


    public void limelightState(){
        limelightState = !limelightState;
        if(limelightState){
            trackingMode();
        }
        else{
            drivingMode();
        }
    }

    public boolean targetSeen(){
        return getTargetEntry().getDouble(0) == 1;
    }

    public double distance(){
        /*double heightDifference = targetHeight - cameraHeight;
        double cameraAngle2Rad = Math.toRadians(cameraAngle);
        double angleDiffRad = Math.toRadians(getYOffset());

        if(targetSeen()){
            return(heightDifference/Math.tan(cameraAngle2Rad +angleDiffRad) - cameraToBumpDistance + 2);
        }
        else{
            return -1.0;
        }
*/
        double angleToGoalDegrees = cameraAngle + getYOffset();
        double angleToGoalRadians = Math.toRadians(angleToGoalDegrees);

       // double distanceFromLimelightToGoalInches = (targetHeight - cameraHeight)/Math.tan(angleToGoalRadians);
       //double distanceFromLimelightToGoalInches = (targetHeight- cameraHeight)/(Math.tan(Math.toRadians(angleToGoalDegrees+getYOffset()))* Math.cos(Math.toRadians(getXOffset())));
        double distanceFromLimelightToGoalInches = (targetHeight - cameraHeight)/Math.tan(angleToGoalRadians) - cameraToBumpDistance + 2;

        return distanceFromLimelightToGoalInches;



    }


    @Override
    public void periodic(){
        SmartDashboard.putNumber("limelight distance", distance());
        //SmartDashboard.putNumber("yoffset", getYOffset());
        //SmartDashboard.putNumber("", NetworkTableInstance);
    }

}
