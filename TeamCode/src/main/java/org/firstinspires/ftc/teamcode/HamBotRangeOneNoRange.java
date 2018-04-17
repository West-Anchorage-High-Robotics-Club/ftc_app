package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


/**
 * Created by whs on 11/21/17.
 */
@TeleOp(name="Ham Bot Range One No Range", group="Ham Bot")
public class HamBotRangeOneNoRange extends OpMode {

    private float W, V, X, Y, count;
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor rightDrive = null;
    private DcMotor leftDrive = null;
    //static final double MAX_POS     =  1.0;     // Maximum rotational position
    //static final double MIN_POS     =  0.0;     // Minimum rotational position
    private Servo servo;
    // double  position = (MAX_POS - MIN_POS) / 2; // Start at halfway position
    //ModernRoboticsI2cRangeSensor rangeSensor;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        servo = hardwareMap.get(Servo.class, "right_hand");
        //rangeSensor = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "range");


        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        // Setup a variable for each drive wheel to save power level for telemetry
        double leftPower;
        double rightPower;

        // Choose to drive using either Tank Mode, or POV Mode
        // Comment out the method that's not used.  The default below is POV.
        float X = gamepad1.left_stick_x;
        float Y = gamepad1.left_stick_y;
        float V = (1 - Math.abs(X)) * Y + Y;
        float W = (1 - Math.abs(Y)) * X + X;
        //leftPower = (-(((V - W) / 2)));// * (0.75 * gamepad1.right_trigger() + 0.25)));
        //rightPower = (((V + W) / 2));// * (0.75 * gamepad1.right_trigger() + 0.25));

        leftPower = (-Y - X);
        rightPower = (-Y + X);
        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);


        // POV Mode uses left stick to go forward, and right stick to turn.
        // - This uses basic math to combine motions and is easier to drive straight.
        /*
        double drive = -gamepad1.left_stick_y;
        double turn = -gamepad1.right_stick_x;
        leftPower = Range.clip(drive + turn, -1.0, 1.0);
        rightPower = Range.clip(drive - turn, -1.0, 1.0);
        */

        // Tank Mode uses one stick to control each wheel.
        // - This requires no math, but it is hard to drive forward slowly and keep straight.
        // leftPower  = -gamepad1.left_stick_y ;
        // rightPower = -gamepad1.right_stick_y ;

        // Send calculated power to wheels
        /*
        if (gamepad1.left_trigger > 0) {
             leftDrive.setPower(leftPower);
             rightDrive.setPower(rightPower);
        } else if (rangeSensor.getDistance(DistanceUnit.CM) < 28){
             leftDrive.setPower(0);
             rightDrive.setPower(0);
        } else {
            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);
        }
        */
         // Log.wtf(TAG, "loop: ", );

        float VertStick = gamepad1.right_stick_y;

        /*if (VertStick < 0) {
            servo.setPosition(-VertStick);
        } else {
            servo.setPosition(0);
        }*/

        if (VertStick < 0) {
            servo.setPosition(-VertStick);
        } else if (gamepad1.x) {
            servo.setPosition(0);
        } else if (gamepad1.y) {
            servo.setPosition(.5);
        } else if (gamepad1.b) {
            servo.setPosition(1);
        } else if (gamepad1.a) {
            servo.setPosition(1);
            servo.setPosition(0);
        } else {
        }

        /*if (gamepad1.a){
            servo.setPosition(1);
        } else {
            servo.setPosition(0);
        }*/

        // Show the elapsed game time and wheel power.
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
        telemetry.addData("right_Hand : ", servo.getPosition());
        /*
        telemetry.addData("raw ultrasonic", rangeSensor.rawUltrasonic());
        telemetry.addData("raw optical", rangeSensor.rawOptical());
        telemetry.addData("cm optical", "%.2f cm", rangeSensor.cmOptical());
        telemetry.addData("cm", "%.2f cm", rangeSensor.getDistance(DistanceUnit.CM));
        telemetry.addData("in", "%.2f in", rangeSensor.getDistance(DistanceUnit.INCH));
        feet = rangeSensor.getDistance(DistanceUnit.INCH) /12;
        telemetry.addData("ft : ", feet);
        */
        telemetry.update();
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }
}



    /**
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