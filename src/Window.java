import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Window implements ActionListener, MouseMotionListener,ChangeListener {


    JFrame frame;
    AnimationPanel animationPanel;
    JPanel panel;
    Timer timer;

    int screenWidth = 1024;
    int screenHeight = 775;
    boolean isActive = false;

    JButton startButton;
    JButton stopButton;
    JButton resetButton;

    JSlider initVelocity;
    JSlider initAngle;

    JLabel velocityLabel;
    JLabel angleLabel = new JLabel();
    JLabel xVelocityLabel = new JLabel();
    JLabel yVelocityLabel = new JLabel();

    double dblAngle = 0;
    double dblVelocity = 0;

    public Window(){

        //JFrame setup
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Projectile");
        frame.setSize(screenWidth, screenHeight);
        frame.setResizable(false);
        frame.setVisible(true);

        //Panel setup
        panel = new JPanel();
        panel.setLayout(null);
        panel.addMouseMotionListener(this);
        panel.setSize(screenWidth, screenHeight);


    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {


    }
}
