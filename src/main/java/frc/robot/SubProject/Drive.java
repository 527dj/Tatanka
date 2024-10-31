package frc.robot.SubProject;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive {
    private final Talon right_motor= new Talon(2);
    private final Talon left_motor= new Talon(1);
    private final Talon Fright_motor= new Talon(4);
    private final Talon Fleft_motor= new Talon(3);
    private final Encoder FrontLencoder = new Encoder(2,3);
    private final Encoder FrontRencoder = new Encoder(4,5);

    public Drive(){
        right_motor.setInverted(true);
        left_motor.setInverted(true);
        Fright_motor.addFollower(right_motor);
        Fleft_motor.addFollower(left_motor);
    }

    public void a(double speed){
        left_motor.set(speed);
        right_motor.set(speed);
    }

    public void a(double speed, double turn){
        left_motor.set(speed+turn);
        right_motor.set(speed-turn);
    }

    public void getDisctances(){
        SmartDashboard.putNumber("Left Distance", FrontLencoder.getDistance()/1440*75*Math.PI/1000);
        SmartDashboard.putNumber("Right Distance", FrontRencoder.getDistance()/1440*75*Math.PI/1000);
    }
}
