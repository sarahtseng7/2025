package org.firstinspires.ftc.teamcode;

//import com.qualcomm.ftccommon.DbgLog;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

//import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "left_drive"
 * Motor channel:  Right drive motor:        "right_drive"
 * Motor channel:  Manipulator drive motor:  "roller_drive"
 * Servo channel:  Servo to open left claw_left:  "left_hand"
 * Servo channel:  Servo to open right claw_left: "right_hand"
 */
public class HardwareMechanumAthenabot
{
    /* Public OpMode members. */


    public DcMotor  left_front_drv_Motor   = null;    // Robot left front drive
    public DcMotor  right_front_drv_Motor  = null;    // Robot right front drive
    public DcMotor  left_back_drv_Motor   = null;    // Robot left back drive
    public DcMotor  right_back_drv_Motor  = null;    // Robot right back drive
    //public DcMotor  hang_motor = null; // Robot hang and landing

    //public DcMotor  hinge = null; // hinge for arm
    //public DcMotor  intake_motor = null ; //intake motor for arm
    public DcMotor intake_motor = null; // intake motor for clamp
    public DcMotor intake2_motor = null;
    public DcMotor fly_wheel = null;
    public DcMotor ramp = null;
    public DcMotor vacuum1 = null;
    public DcMotor guide = null;
    public DcMotor elevator = null;

    public DcMotor slide1 = null;

    public DcMotor slide2 = null;


    //public DcMotor intake2_motor = null;
    //public DcMotor flip_motor = null; // slide motor for stacking
    // public DcMotor stack2_motor = null;


    public Servo claw1 = null;
    public Servo claw2 = null;
    public Servo drone1 = null;
    public Servo drone2 = null;

    public ColorSensor colorSensor = null; // Sensor for Beacon
    public LightSensor LightSensorBottom = null; // Sensor for line following
    //public OpticalDistanceSensor odsSensor = null;  // Sensor for dist measurement


    public static final double SERVO_PUSH_MIN = 0.0;
    public static final double SERVO_PUSH_MAX = -2.0;

    public static final double SERVO_CLAW1_MIN = -1.0;
    public static final double SERVO_CLAW1_MAX = 1.0;
    public static final double SERVO_CLAW2_MIN = 0.0;
    public static final double SERVO_CLAW2_MAX = 2.0;
    public static final double SERVO_DRONE1_MIN = 0.0;
    public static final double SERVO_DRONE1_MAX = 1.0;
    public static final double SERVO_DRONE2_MIN = 0.0;
    public static final double SERVO_DRONE2_MAX = 1.0;
    public static final double fly_wheel_power = 0.75;
    public static final double ramp_power = 0.50;
    public static final double intake_motor_power = 0.25 ;
    public static final double intake2_motor_power = 1.00;
    public static final double vacuum1_power = 1.00;
    public static final double guide_power = 1.00;
    public static final double elevator_power = 0.50;

    public static final double slide1_power = 1.00;

    public static final double slide2_power = 1.00;

    //Use MR Core Device Discovery to change address
    //I2cAddr i2CAddressColorFront = I2cAddr.create8bit(0x3c);
    //I2cAddr i2CAddressColorBottom = I2cAddr.create8bit(0x4c);


    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public HardwareMechanumAthenabot(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;
        // left frond drive motor
        try {

            left_front_drv_Motor = hwMap.dcMotor.get("frontLeft");
        } catch (Exception p_exeception) {


            left_front_drv_Motor = null;
        }
        //left back drive motor

        try {

            left_back_drv_Motor = hwMap.dcMotor.get("backLeft");
        } catch (Exception p_exeception) {


            left_back_drv_Motor = null;
        }
        // right front drive motor
        try {

            right_front_drv_Motor = hwMap.dcMotor.get("frontRight");
        } catch (Exception p_exeception) {

            right_front_drv_Motor = null;
        }
        //right back drive motor
        try {

            right_back_drv_Motor = hwMap.dcMotor.get("backRight");
        } catch (Exception p_exeception) {


            right_back_drv_Motor = null;
        }

        try {
            colorSensor = hwMap.colorSensor.get("color");

        } catch (Exception p_exception) {

            colorSensor = null;
        }
        //hinge motor for arm

        //try
        //{

      /*    hinge   = hwMap.dcMotor.get("hinge");
      }
      catch (Exception p_exeception)
      {


          hinge = null;
      }*/
        //stack motor for stacking skystones
        try {

            intake_motor = hwMap.dcMotor.get("intake");
        } catch (Exception p_exception) {


            intake_motor = null;
        }
        try {

            intake2_motor = hwMap.dcMotor.get("intake2");
        } catch (Exception p_exception){

            intake2_motor = null;
        }
        try {
            fly_wheel = hwMap.dcMotor.get("fly_wheel");
        } catch (Exception p_exception){
            fly_wheel = null;
        }

        try {
            ramp = hwMap.dcMotor.get("ramp");
        } catch (Exception p_exception){
            ramp = null;
        }

        try {
            vacuum1 = hwMap.dcMotor.get("vacuum1");
        } catch (Exception p_exception){
            vacuum1 = null;
        }

        try {
            guide = hwMap.dcMotor.get("guide");
        } catch (Exception p_exception){
            guide = null;
        }

        try{
            elevator = hwMap.dcMotor.get("lever");
        } catch (Exception p_exception){
            elevator = null;
        }

        try{
            slide1 = hwMap.dcMotor.get("slide1");
        } catch (Exception p_exception){
            slide1 = null;
        }

        try{
            slide2 = hwMap.dcMotor.get("slide2");
        } catch (Exception p_exception){
            slide2 = null;
        }
      /*try {

          intake2_motor = hwMap.dcMotor.get("intake2");
      } catch (Exception p_exeception) {


          intake2_motor = null;
      }*/

        // Servos :





        try {
            //v_motor_left_drive = hardwareMap.dcMotor.get ("l_drv");
            //v_motor_left_drive.setDirection (DcMotor.Direction.REVERSE);
            claw1 = hwMap.servo.get("claw1");
            if (claw1 != null) {
                claw1.setPosition(0.2);
            }


        }
        catch (Exception p_exeception) {
            //m_warning_message ("l_drv");
            //   DbgLog.msg (p_exeception.getLocalizedMessage ());

            claw1 = null;
        }

        try {
            //v_motor_left_drive = hardwareMap.dcMotor.get ("l_drv");
            //v_motor_left_drive.setDirection (DcMotor.Direction.REVERSE);
            claw2 = hwMap.servo.get("claw2");
            if (claw2 != null) {
                claw2.setPosition(SERVO_CLAW2_MIN);
            }


        }
        catch (Exception p_exeception) {
            //m_warning_message ("l_drv");
            //   DbgLog.msg (p_exeception.getLocalizedMessage ());

            claw2 = null;
        }

        try {
            //v_motor_left_drive = hardwareMap.dcMotor.get ("l_drv");
            //v_motor_left_drive.setDirection (DcMotor.Direction.REVERSE);
            drone1 = hwMap.servo.get("drone1");
            if (drone1 != null) {
                drone1.setPosition(0.3);
            }


        }
        catch (Exception p_exeception) {
            //m_warning_message ("l_drv");
            //   DbgLog.msg (p_exeception.getLocalizedMessage ());

            claw1 = null;
        }

        try {
            //v_motor_left_drive = hardwareMap.dcMotor.get ("l_drv");
            //v_motor_left_drive.setDirection (DcMotor.Direction.REVERSE);
            claw2 = hwMap.servo.get("drone2");
            if (claw2 != null) {
                claw2.setPosition(SERVO_DRONE2_MIN);
            }


        }
        catch (Exception p_exeception) {
            //m_warning_message ("l_drv");
            //   DbgLog.msg (p_exeception.getLocalizedMessage ());

            claw2 = null;
        }

        //set dc motors to run without an encoder  and set intial power to 0
        //l_f_drv
        if (left_front_drv_Motor != null) {
            //l_return = left_drv_Motor.getPower ();
            left_front_drv_Motor.setDirection(DcMotor.Direction.FORWARD); // FORWARD was moving it backwards
            left_front_drv_Motor.setPower(0);
            left_front_drv_Motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
        //l_b_drv
        if (left_back_drv_Motor != null) {
            //l_return = left_drv_Motor.getPower ();
            left_back_drv_Motor.setDirection(DcMotor.Direction.REVERSE); // FORWARD was moving it backwards
            left_back_drv_Motor.setPower(0);
            left_back_drv_Motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        //r_f_drv
        if (right_front_drv_Motor != null) {
            //l_return = left_drv_Motor.getPower ();
            right_front_drv_Motor.setDirection(DcMotor.Direction.FORWARD);// REVERSE was moving it backwards
            right_front_drv_Motor.setPower(0);
            right_front_drv_Motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        //r_b_drv
        if (right_back_drv_Motor != null) {
            //l_return = left_drv_Motor.getPower ();
            right_back_drv_Motor.setDirection(DcMotor.Direction.FORWARD);// REVERSE was moving it backwards
            right_back_drv_Motor.setPower(0);
            right_back_drv_Motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        //hinge
      /*if (hinge != null)
      {
          //l_return = left_drv_Motor.getPower ();
          hinge.setPower(0);
          hinge.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
      }*/
        //hang
          /*if (flip_motor != null) {
              flip_motor.setPower(0);
              flip_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
          }*/
          /*if (stack2_motor != null) {
              stack2_motor.setPower(0);
              stack2_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
          }*/
        //intake
        if (intake_motor != null) {
            intake_motor.setDirection(DcMotor.Direction.FORWARD);
            intake_motor.setPower(0);
            intake_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        if (intake2_motor != null){
            intake2_motor.setDirection(DcMotor.Direction.FORWARD);
            intake2_motor.setPower(0);
            intake2_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        if (fly_wheel != null) {
            fly_wheel.setDirection(DcMotor.Direction.FORWARD);
            fly_wheel.setPower(0);
            fly_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        if (ramp != null){
            ramp.setDirection(DcMotor.Direction.FORWARD);
            ramp.setPower(0);
            ramp.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        if (vacuum1 != null){
            vacuum1.setDirection(DcMotor.Direction.FORWARD);
            vacuum1.setPower(0);
            vacuum1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        if (guide != null){
            guide.setDirection(DcMotor.Direction.FORWARD);
            guide.setPower(0);
            guide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        if (elevator != null){
            elevator.setDirection(DcMotor.Direction.FORWARD);
            elevator.setPower(0);
            elevator.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            elevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }

        if (slide1 != null){
            slide1.setDirection(DcMotor.Direction.FORWARD);
            slide1.setPower(0);
            slide1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        if (slide2 != null){
            slide2.setDirection(DcMotor.Direction.FORWARD);
            slide2.setPower(0);
            slide2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

          /*if (intake2_motor != null) {
              intake2_motor.setDirection(DcMotor.Direction.REVERSE);
              intake2_motor.setPower(0);
              intake2_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
          }*/

      /*
      initalize the colorSensor and colorSensor
      */
        try {
            colorSensor = hwMap.colorSensor.get("color");
        } catch (Exception p_exeception) {
            //m_warning_message ("colr_f");
            //   DbgLog.msg (p_exeception.getLocalizedMessage ());
            colorSensor = null;
        }


        try {
            LightSensorBottom = hwMap.lightSensor.get("ods");
        } catch (Exception p_exeception) {
            //m_warning_message ("ods");
            //   DbgLog.msg (p_exeception.getLocalizedMessage ());
            LightSensorBottom = null;
        }


        if (colorSensor != null) {
            //ColorFront reads beacon light and is in passive mode
            //colorSensor.setI2cAddress(i2CAddressColorFront);
            colorSensor.enableLed(false);
        }

        if (LightSensorBottom != null) {
            //OpticalDistance sensor measures dist from the beacon
            LightSensorBottom.enableLed(false);
        }

    }

    /*
     * This method scales the joystick input so for low joystick values, the
     * scaled value is less than linear. This is to make it easier to drive
     * the robot more precisely at slower speeds.
     */
    public double scaleInput( double dVal ) {
        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

        // get the corresponding index for the scaleInput array.
        int index = (int) (dVal * 16.0);
        if (index < 0) {
            index = -index;
        } else if (index > 16) {
            index = 16;
        }

        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        return dScale;
    }


    /**
     * Access the left front drive motor's power level.
     */
    public double a_left_front_drive_power()
    {
        double l_return = 0.0;
        if (left_front_drv_Motor != null)
        {
            l_return = left_front_drv_Motor.getPower ();
        }

        return l_return;

    } // a_left_drive_power

    /**
     * Access the left back drive motor's power level.
     */
    double a_left_back_drive_power()
    {
        double l_return = 0.0;
        if (left_back_drv_Motor != null)
        {
            l_return = left_back_drv_Motor.getPower ();
        }

        return l_return;

    } // a_left_drive_power



    /**
     * Access the right front drive motor's power level.
     */
    double a_right_front_drive_power ()
    {
        double l_return = 0.0;

        if (right_front_drv_Motor != null)
        {
            l_return = right_front_drv_Motor.getPower ();
        }

        return l_return;

    } // a_right_front_drive_power

    /**
     * Access the right back drive motor's power level.
     */
    double a_right_back_drive_power ()
    {
        double l_return = 0.0;

        if (right_back_drv_Motor != null)
        {
            l_return = right_back_drv_Motor.getPower ();
        }

        return l_return;

    } // a_right_drive_power

    /**
     * Access the Hinge motor's power level.
     */
  /*double a_hinge_power ()
  {
      double l_return = 0.0;

      if (hinge != null) {
          l_return = hinge.getPower();
      }

      return l_return;
  }
  /**
   * Access the hang motor's power level.
   */
  /*double a_flip_power ()
  {
      double l_return = 0.0;

      if (flip_motor != null) {
          l_return = flip_motor.getPower();
      }

      return l_return;
  }*/

  /*double a_stack2_power ()
  {
      double l_return = 0.0;

      if (stack2_motor != null) {
          l_return = stack2_motor.getPower();
      }

      return l_return;
  }*/


    /**
     * Access the intake motor's power level.
     */
    //
    double a_intake_power ()
    {
        double l_return = 0.0;

        if (intake_motor != null) {
            l_return = intake_motor.getPower();
        }

        return l_return;
    }
    double a_intake2_power ()
    {
        double l_return = 0.0;
        if (intake2_motor != null){
            l_return = intake2_motor.getPower();
        }
        return l_return;
    }

    double a_fly_wheel_power ()
    {
        double l_return = 0.0;
        if (fly_wheel != null){
            l_return = fly_wheel.getPower();
        }
        return l_return;
    }

    double a_ramp_power ()
    {
        double l_return =0.0;
        if (ramp != null){
            l_return = ramp.getPower();
        }
        return l_return;
    }

    double a_vacuum1_power()
    {
        double l_return = 0.0;
        if(vacuum1 != null){
            l_return = vacuum1.getPower();
        }
        return l_return;
    }

    double a_guide_power()
    {
        double l_return = 0.0;
        if(guide != null){
            l_return = guide.getPower();
        }
        return l_return;
    }

    double a_elevator_power()
    {
        double l_return = 0.0;
        if(elevator != null){
            l_return = elevator.getPower();
        }
        return l_return;
    }

    double a_slide1_power()
    {
        double l_return = 0.0;
        if(slide1 != null){
            l_return = slide1.getPower();
        }
        return l_return;
    }

    double a_slide2_power()
    {
        double l_return = 0.0;
        if(slide2 != null){
            l_return = slide2.getPower();
        }
        return l_return;
    }
  /*double a_intake2_power ()
  {
      double l_return = 0.0;

      if (intake2_motor != null) {
          l_return = intake2_motor.getPower();
      }

      return l_return;
  }*/


    // marker - servo position
    //
    /**
     * Access the marker servo position.
     */

    //
    //
    // set_marker_position
    //
    /**
     * Change the marker servo position.
     */
    void set_push_position (double p_position) {
        //
        // Ensure the specific value is legal.
        //
        double l_position = Range.clip
                (p_position , SERVO_PUSH_MIN
                        , SERVO_PUSH_MAX); // Servo position is restricted to protect from mechanical damage



        //
        // Set the right  value.
        //


    }


    //
    //
    // set_marker_position
    //
    /**
     * Change the marker servo position.
     */


    double a_claw1_position ()
    {
        double l_return = 0.0;

        if (claw1 != null)
        {
            l_return = claw1.getPosition ();
        }

        return l_return;

    }
    //
    //
    // set_marker_position
    //
    /**
     * Change the marker servo position.
     */
    void set_claw1_position (double p_position) {
        //
        // Ensure the specific value is legal.
        //
        double l_position = Range.clip
                (p_position , SERVO_CLAW1_MIN
                        , SERVO_CLAW1_MAX); // Servo position is restricted to protect from mechanical damage



        //
        // Set the right  value.
        //
        if (claw1!= null)
        {
            claw1.setPosition (l_position);
        }

    }

    double a_claw2_position ()
    {
        double l_return = 0.0;

        if (claw2 != null)
        {
            l_return = claw2.getPosition ();
        }

        return l_return;

    }
    //
    //
    // set_marker_position
    //
    /**
     * Change the marker servo position.
     */
    void set_claw2_position (double p_position) {
        //
        // Ensure the specific value is legal.
        //
        double l_position = Range.clip
                (p_position , SERVO_CLAW2_MIN
                        , SERVO_CLAW2_MAX); // Servo position is restricted to protect from mechanical damage



        //
        // Set the right  value.
        //
        if (claw2!= null)
        {
            claw2.setPosition (l_position);
        }

    }

    double a_drone1_position ()
    {
        double l_return = 0.0;

        if (drone1 != null)
        {
            l_return = drone1.getPosition ();
        }

        return l_return;

    }
    //
    //
    // set_marker_position
    //
    /**
     * Change the marker servo position.
     */
    void set_drone1_position (double p_position) {
        //
        // Ensure the specific value is legal.
        //
        double l_position = Range.clip
                (p_position , SERVO_DRONE1_MIN
                        , SERVO_DRONE1_MAX); // Servo position is restricted to protect from mechanical damage



        //
        // Set the right  value.
        //
        if (drone1!= null)
        {
            drone1.setPosition (l_position);
        }

    }

    double a_drone2_position()
    {
        double l_return = 0.0;

        if(drone2 != null)
        {
            l_return = drone2.getPosition();
        }

        return l_return;
    }

    void set_drone2_position(double p_position)
    {
        double l_position = Range.clip
                (p_position, SERVO_DRONE2_MIN,
                        SERVO_DRONE2_MAX);

        if(drone2!= null)
        {
            drone2.setPosition(l_position);
        }
    }




    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     * @throws InterruptedException
     */
    public void waitForTick(long periodMs) throws InterruptedException {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0)
            Thread.sleep(remaining);

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}
