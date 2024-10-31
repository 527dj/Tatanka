package frc.robot.SubProject;
//import com.ctre.phoenix.motorcontrol.ControlMode;
//import edu.wpi.first.wpilibj.motorcontrol.Talon;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter {
    private final TalonSRX right_motor = new TalonSRX(2);
    private final TalonSRX left_motor = new TalonSRX(1);
    private final TalonSRX Fright_motor = new TalonSRX(4);
    private final TalonSRX Fleft_motor = new TalonSRX(3);
    private final TalonSRX Iright_motor = new TalonSRX(5);
    private final TalonSRX Ileft_motor = new TalonSRX(6);
    private final Encoder FrontLencoder = new Encoder(2,3);
    private final Encoder FrontRencoder = new Encoder(4,5);

    public Shooter(){
        right_motor.setInverted(true);
        left_motor.setInverted(true);
        Iright_motor.setInverted(true);
        Ileft_motor.setInverted(true);
        Fright_motor.follow(right_motor);
        Fleft_motor.follow(left_motor);
    }

    public void b(double speed){
        right_motor.set(TalonSRXControlMode.PercentOutput,speed);
        left_motor.set(TalonSRXControlMode.PercentOutput,speed);
        Iright_motor.set(TalonSRXControlMode.PercentOutput,speed);
        Ileft_motor.set(TalonSRXControlMode.PercentOutput,speed);
    }
    public void getSpeeds(){
        SmartDashboard.putNumber("Left Speed", FrontLencoder.getDistance()/1440*75*Math.PI/1000);
        SmartDashboard.putNumber("Right Speed", FrontRencoder.getDistance()/1440*75*Math.PI/1000);
    }
}

