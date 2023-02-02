// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.AllignCommand;
import frc.robot.commands.AllignYCommand;
import frc.robot.commands.Autos;
import frc.robot.commands.DriveTrainCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.LidarSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.LimelightSub;
import frc.robot.commands.LimeLightCommand;
import frc.robot.commands.lidarCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveTrainSubsystem drive = new DriveTrainSubsystem();
  private final LimelightSub limelight = new LimelightSub();
  private final LidarSubsystem lidar = new LidarSubsystem();
  private final LimeLightCommand limeLightCommand = new LimeLightCommand(limelight);
  private final AllignCommand allign = new AllignCommand(limelight, drive);
  private final AllignYCommand allignY = new AllignYCommand(limelight, drive);
  private final lidarCommand lidarDistance = new lidarCommand(lidar);
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private Joystick controller = new Joystick(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    drive.setDefaultCommand(new DriveTrainCommand(() -> controller.getX(), () -> controller.getY(), drive));
    configureBindings();
  }

 
  private void configureBindings() {
    new JoystickButton(controller, 1).onTrue(limeLightCommand);
    new JoystickButton(controller, 2).onTrue(allign);
    new JoystickButton(controller, 3).onTrue(allignY);
    new JoystickButton(controller, 4).onTrue(lidarDistance);
  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    //return Autos.exampleAuto(m_exampleSubsystem);
    return null;
  }
}
