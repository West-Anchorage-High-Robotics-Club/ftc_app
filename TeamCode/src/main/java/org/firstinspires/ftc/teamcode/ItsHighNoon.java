
/**
 * Created by whs on 1/31/17.
 */
/*
// First we identify the package the OpMode belongs to.

package org.firstinspires.ftc.teamcode;

// Now we import the classes we need from the FTC SDK and the Java SDK.

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.text.SimpleDateFormat;
import java.util.Date;

// Here we extend the base OpMode class to be the new NullOp class.
// The @Autonomous "annotation" registers our new OpMode with the
// FtcRobotController app so our OpMode appears on the driver station
// menu of OpModes you can run.

@TeleOp(name="NullOp")
public class ItsHighNoon extends OpMode
{
    private String startDate, initDate;
    private ElapsedTime runtime = new ElapsedTime();

    // There is only one method for us to override with our own code.

    @Override
    public void runOpMode()  throws InterruptedException
    {
        initDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());

        telemetry.addData("0 init", "NullLinearOp initialized at " + initDate);
        telemetry.update();

        // After we are done initializing our code, we wait for Start button.

        waitForStart();

        // Start button pressed, off we go.

        startDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
        runtime.reset();

        // Here we implement the loop our code needs to run in for the duration of
        // our OpModes execution. We can tell when to stop by monitoring the base
        // LinearOpMode class opModeIsActive method.

        while (opModeIsActive())
        {
            telemetry.addData("1 Start", "NullLinearOp started at " + startDate);
            telemetry.addData("2 Status", "running for " + runtime.toString());
            telemetry.update();

            idle();
        }
    }
}


*/
