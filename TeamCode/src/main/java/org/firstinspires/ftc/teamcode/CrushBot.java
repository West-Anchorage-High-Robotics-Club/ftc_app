package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by whs on 1/17/17. Update 8/29 - Working on program for omnibot
 */
@TeleOp(name="CrushBot", group="HardwareCrushBot")
public class CrushBot extends OpMode {

    private float W, V, X, Y, count;
    public DcMotor rightMotor,leftMotor, armRight, armLeft = null;

    float leftY = -gamepad1.left_stick_y;
    float rightY = -gamepad1.right_stick_y;

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        leftMotor.setPower(leftY);
        rightMotor.setPower(rightY);
    }
}



    /*
     * This function is executed when this Op Mode is selected from the Driver Station.
     */

    /*
    public void runOpMode() {
        door.setPosition(0.4);
        boot.setZeroPowerBehavior("BRAKE");
        boot.setMode("RUN_WITHOUT_ENCODER");
        boot.setPower(-0.2);
        count = 0;
        boot.setMode("RUN_USING_ENCODER");
        boot.setMode("STOP_AND_RESET_ENCODER");
        boot.setMode("RUN_USING_ENCODER");
        boot.setMode("RUN_TO_POSITION");
        boot.setTargetPosition(50);
        boot.setMaxSpeed(500);
        boot.setPower(1);
        boot.setZeroPowerBehavior("FLOAT");
        count = 0;
        while (count < 400) {
            if (boottop.getIsPressed()) {
                boot.setPower(0);
            }
            count = (typeof count == 'number' ? count : 0) + 1;
            telemetry.addNumericData('reset', count);
            telemetry.update();
        }
        boot.setPower(0);
        boot.setMode("STOP_AND_RESET_ENCODER");
        boot.setMode("RUN_USING_ENCODER");
        boot.setMode("RUN_TO_POSITION");
        boot.setZeroPowerBehavior("BRAKE");
        while (linearOpMode.opModeIsActive()) {
            telemetry.update();
            X = -gamepad1.getLeftStickX();
            Y = -gamepad1.getLeftStickY();
            V = (1 - Math.abs(X)) * Y + Y;
            W = (1 - Math.abs(Y)) * X + X;
            left.setDualPower(-(((V - W) / 2) * (0.75 * gamepad1.getRightTrigger() + 0.25)), right, ((V + W) / 2) * (0.75 * gamepad1.getRightTrigger() + 0.25));
            if (gamepad1.getX()) {
                telemetry.addNumericData('End Boot', boot.getCurrentPosition());
                boot.setMaxSpeed(500);
                boot.setPower(1);
                boot.setTargetPosition(600);
            } else if (gamepad1.getA()) {
                door.setPosition(0.4);
            } else if (gamepad1.getB()) {
                door.setPosition(1.5);
            } else if (gamepad1.getY()) {
                door.setPosition(0.5);
                telemetry.addNumericData('End Boot', boot.getCurrentPosition());
                boot.setMaxSpeed(5000);
                boot.setPower(-1);
                boot.setTargetPosition(-100);
            } else if (gamepad1.getBack()) {
                boot.setPower(0);
                boot.setZeroPowerBehavior("FLOAT");
            } else if (gamepad1.getRightBumper() || gamepad1.getLeftBumper()) {
                boot.setPower(0.1);
                boot.setTargetPosition(boot.getCurrentPosition());
                boot.setZeroPowerBehavior("BRAKE");
            }
            if (boottouch.getIsPressed()) {
                boot.setMaxSpeed(500);
                boot.setPower(1);
                boot.setTargetPosition(600);
                telemetry.addNumericData('End Boot', boot.getCurrentPosition());
            }
            if (boottop.getIsPressed()) {
                boot.setPower(-0.1);
                boot.setTargetPosition(boot.getTargetPosition() - 100);
                telemetry.addNumericData('End Boot', boot.getCurrentPosition());
            }
            telemetry.addTextData('moterstatus', boot.isBusy());
            telemetry.addTextData('servo loc', door.getPosition());
        }
        if (!boot.isBusy()) {
            boot.setPower(0);
        }
    }

*/