package org.firstinspires.ftc.teamcode.shplib.hardware.drive;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.shplib.hardware.sensors.SHPIMU;

public class SHPMecanumDrive extends SHPFourWheelDrive {
    private SHPIMU imu;

    public SHPMecanumDrive(HardwareMap hardwareMap, String[] deviceNames) {
        super(hardwareMap, deviceNames);
    }

    public void mecanum(double leftY, double leftX, double rightX) {
        double[] powers = {
                leftY - leftX + rightX,
                leftY + leftX + rightX,
                leftY + leftX - rightX,
                leftY - leftX - rightX,
        };

        setAll(powers);
    }

    public void tankanum(double leftY, double rightY, double rightX) {
        double[] powers = {
                leftY - rightX,
                leftY + rightX,
                rightY + rightX,
                rightY - rightX
        };

        setAll(powers);
    }


}
