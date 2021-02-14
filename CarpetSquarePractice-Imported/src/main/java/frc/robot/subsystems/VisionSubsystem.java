/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPipelineResult;
import org.photonvision.PhotonTrackedTarget;
import org.photonvision.PhotonUtils;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.geometry.Transform2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase {
  PhotonCamera camera = new PhotonCamera("Microsoft LifeCam HD-3000");
  /*NetworkTableInstance netTable = NetworkTableInstance.getDefault();
  NetworkTable visionTable = netTable.getTable("chameleon-vision").getSubTable("Microsoft LifeCam HD-3000");*/
 // NetworkTableEntry targetPoseEntry = visionTable.getEntry("targetPose");
  PhotonPipelineResult powercellPipeline = new PhotonPipelineResult();
  PhotonTrackedTarget target = powercellPipeline.getBestTarget();
  
 
  /** 
   * Creates a new VisionSubsystem.
   */
  public VisionSubsystem() {

  }
  public boolean hasTarget() {
    return powercellPipeline.hasTargets();
  }
  public Transform2d getTargetDistance() {
   /* double[] defaultPose = {0, 0, 0};
    double[] targetPose = targetPoseEntry.getDoubleArray(defaultPose);
    return targetPose[0];*/
    return target.getCameraToTarget();
   }

  public double getTargetYaw(){
    /*double[] defaultPose = {0, 0, 0};
    double[] targetPose = targetPoseEntry.getDoubleArray(defaultPose);
    return targetPose[2]; */
    return target.getYaw();
   }

   

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
