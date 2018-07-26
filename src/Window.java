import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Window implements ActionListener, MouseMotionListener,ChangeListener {

    JFrame frame;
    JPanel panel;
    int width = 1024;
    int height = 750;
    JButton start;
    JButton stop;
    JSlider startVelocity;
    JSlider angleSlider;
    JLabel velocityText;
    JLabel angleText;
    JLabel xVelocity;
    JLabel yVelocity;
    double angleToLaunch = 0.0;
    double velocity = 0.0;


    public Window(){
        //Frame
        frame = new JFrame("Projectile Motion ");
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        //Panel inside frame
        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(width, height);
        this.frame.add(panel);

        //start button
        this.start = new JButton ("START");
        this.start.setBounds (1024-160,670,100,50);
        this.panel.add(this.start);
        this.start.addActionListener(this);

        //Stop button
        this.stop = new JButton ("STOP");
        this.stop.setBounds (1024-290,670,100,50);
        this.panel.add(this.stop);
        this.stop.addActionListener(this);

        //Adjust angle in beginning
        this.angleSlider = new JSlider (0, 0,90,45);
        this.angleSlider.setBounds(50,610,300,50);
        this.angleSlider.addChangeListener(this);
        this.panel.add(this.angleSlider);

        //change velocity in beginning
        this.startVelocity = new JSlider (0, 0,30,10);
        this.startVelocity.setBounds(50,670,300,50);
        this.startVelocity.addChangeListener(this);
        this.panel.add(this.startVelocity);


        //STARTING VELOCITY X AXIS LABEL
        this.xVelocity = new JLabel ("HI",JLabel.LEFT);
        this.xVelocity.setVisible(true);
        this.xVelocity.setBounds(480,610,300,50);
        this.panel.add(this.xVelocity);

        //STARTING VELOCITY Y AXIS LABEL
        this.yVelocity = new JLabel ("HI",JLabel.LEFT);
        this.yVelocity.setVisible(true);
        this.yVelocity.setBounds(480,670,300,50);
        this.panel.add(this.yVelocity);



    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if(source == start) {
//            dblVelocity = source.getValue();
//            startvelocity.setText(Double.toString(dblVelocity)+"M/S");
            System.out.println("START");
        }
        if(source == stop){
            System.out.println("STOP");
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if(source == angleSlider) {
//            angleToLaunch = source.getValue();
//            angleText.setText(Double.toString(angleToLaunch)+" Degrees");
            System.out.println("SHOOT");
        }
        if(source == startVelocity){
            velocity = source.getValue();
            velocityText.setText(Double.toString(velocity) + " M/S");
        }

//        panel.ball.dblVx = vX(dblVelocity,dblAngle);
//        panel.ball.dblVy = vY(dblVelocity,dblAngle);
//        xVelocity.setText(panel.ball.dblVx+"M/S in X Axis");
//        yVelocity.setText(panel.ball.dblVy*(-1)+"M/S in Y Axis");
//        System.out.println(vX(dblVelocity,dblAngle)*100);
//        go=false;

    }
}
