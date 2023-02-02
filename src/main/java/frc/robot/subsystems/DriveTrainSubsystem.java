package frc.robot.subsystems;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.DriveTrainCommand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;

import static frc.robot.Constants.*;

import java.util.function.DoubleSupplier;

public class DriveTrainSubsystem extends SubsystemBase{
    CANSparkMax frontLeft = new CANSparkMax(OperatorConstants.FRONTLEFT_ID, MotorType.kBrushless);
    CANSparkMax backLeft = new CANSparkMax(OperatorConstants.BACKLEFT_ID, MotorType.kBrushless);
    CANSparkMax frontRight = new CANSparkMax(OperatorConstants.FRONTRIGHT_ID, MotorType.kBrushless);
    CANSparkMax backRight = new CANSparkMax(OperatorConstants.BACKRIGHT_ID, MotorType.kBrushless);

    MotorController leftGrp = new MotorControllerGroup(frontLeft, backLeft);
    MotorController rightGrp = new MotorControllerGroup(frontRight, backRight);

    DifferentialDrive drivez = new DifferentialDrive(leftGrp, rightGrp);

    public void tankDrive(DoubleSupplier d, DoubleSupplier i){
        drivez.tankDrive(d.getAsDouble(), i.getAsDouble());
    }

    public void arcadeDrive(DoubleSupplier x, DoubleSupplier y){
        drivez.arcadeDrive(-x.getAsDouble(), -y.getAsDouble());
    }
    
    public void setSpeed(double xSpeed, double ySpeed){
       // rightGrp.set(ySpeed);
        //leftGrp.set(xSpeed);
       drivez.tankDrive(xSpeed, ySpeed);
    }

    public void goForward(){
        setSpeed(0.5, 0.5);
    }

    public void goBack(){
        setSpeed(-0.5, -0.5);
    }

    public void stop(){
        setSpeed(0, 0);
    }

    public void setAlignSpeed(double newSpeed){
        setSpeed(newSpeed, newSpeed);
    }

    public void setRangeSpeed(double newSpeed){
        setSpeed(newSpeed, -newSpeed);
    }

    @Override
    public void periodic(){

    }

    
    
}