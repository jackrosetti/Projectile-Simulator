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
    int screenHeight = 768;
    boolean isActive = false;

    JButton startButton;
    JButton stopButton;
    JButton resetButton;

    JSlider initVelocity;
    JSlider initAngle;

    JLabel velocityLabel;
    JLabel angleLabel;
    JLabel xVelocityLabel;
    JLabel yVelocityLabel;

    double angle = 0;
    double velocity = 0;

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
        panel.setSize(screenWidth, screenHeight - 182);

        //Animation panel setup
        animationPanel = new AnimationPanel();
        animationPanel.setLayout(null);
        animationPanel.setSize(screenWidth, screenHeight);
        animationPanel.addMouseMotionListener(this);

        timer = new Timer(17, this);
        timer.start();

        frame.add(panel);
        this.frame.add(this.animationPanel);


        //START BUTTON
        this.startButton = new JButton("START");
        this.startButton.setBounds(1024 - 160, 670, 100, 50);
        this.panel.add(this.startButton);
        this.startButton.addActionListener(this);

        //STOP BUTTON
        this.stopButton = new JButton("STOP");
        this.stopButton.setBounds(1024 - 290, 670, 100, 50);
        this.panel.add(this.stopButton);
        this.stopButton.addActionListener(this);

        //RESET BUTTON
        this.resetButton = new JButton("RESET");
        this.resetButton.setBounds(1024 - 290, 610, 100, 50);
        this.panel.add(this.resetButton);
        this.resetButton.addActionListener(this);

        this.initVelocity = new JSlider(0, 0, 30, 15);
        this.initVelocity.setBounds(50, 670, 300, 50);
        this.initVelocity.addChangeListener(this);
        this.panel.add(this.initVelocity);

        this.initAngle = new JSlider(0, 0, 90, 45);
        this.initAngle.setBounds(50, 610, 300, 50);
        this.initAngle.addChangeListener(this);
        this.panel.add(this.initAngle);

        //STARTING ANGLE LABEL
        this.velocityLabel = new JLabel(Double.toString(angle), JLabel.LEFT);
        this.velocityLabel.setVisible(true);
        this.velocityLabel.setBounds(400, 670, 300, 50);
        this.panel.add(this.velocityLabel);

        //STARTING VELOCITY LABEL
        this.angleLabel = new JLabel(Double.toString(velocity), JLabel.LEFT);
        this.angleLabel.setVisible(true);
        this.angleLabel.setBounds(400, 610, 300, 50);
        this.panel.add(this.angleLabel);

        //STARTING VELOCITY X AXIS LABEL
        this.xVelocityLabel = new JLabel("HI", JLabel.LEFT);
        this.xVelocityLabel.setVisible(true);
        this.xVelocityLabel.setBounds(480, 610, 300, 50);
        this.panel.add(this.xVelocityLabel);

        //STARTING VELOCITY Y AXIS LABEL
        this.yVelocityLabel = new JLabel("HI", JLabel.LEFT);
        this.yVelocityLabel.setVisible(true);
        this.yVelocityLabel.setBounds(480, 670, 300, 50);
        this.panel.add(this.yVelocityLabel);

        animationPanel.ball.reset(50, 480, getXVelocity(velocity, angle), getYVelocity(velocity, angle));
        animationPanel.repaint();
        xVelocityLabel.setText(animationPanel.ball.xVelocity + " M/S in X Axis");
        yVelocityLabel.setText(animationPanel.ball.yVelocity * (-1) + " M/S in Y Axis");


    }

    public double getYVelocity(double v, double a) {
        System.out.println("A VALUE " + a);
        System.out.println("SIN " + Math.sin(Math.toRadians(a)));
        return -(v * (Math.sin(Math.toRadians(a))));

    }

    public double getXVelocity(double v, double a) {
        System.out.println("A VALUE " + a);

        if ((Math.cos(Math.toRadians(a))) > 0.0000000001) {
            System.out.println("COS " + Math.cos(Math.toRadians(a)));
            return (v * (Math.cos(Math.toRadians(a))));

        } else {
            System.out.println("0");
            return 0;
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer && isActive) {

            if (animationPanel.ball.getyPos() >= animationPanel.ball.yI + 1) {

                animationPanel.ball.yPos = animationPanel.ball.yI;

                isActive = false;
            }
            animationPanel.repaint();
        }
        if (e.getSource() == startButton) {
            isActive = true;
        }
        if (e.getSource() == stopButton) {
            isActive = false;
        }
        if (e.getSource() == resetButton) {
            animationPanel.ball.reset(50, 480, getXVelocity(velocity, angle), getYVelocity(velocity, angle));
            animationPanel.repaint();
        }
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        animationPanel.ball.timeCount = 0;

        if (source == initAngle) {
            angle = source.getValue();
            angleLabel.setText(Double.toString(angle) + " Degrees");
        }

        if (source == initVelocity) {
            velocity = source.getValue();
            velocityLabel.setText(Double.toString(velocity) + " M/S");
        }

        animationPanel.ball.xVelocity = getXVelocity(velocity, angle);
        animationPanel.ball.yVelocity = getYVelocity(velocity, angle);
        xVelocityLabel.setText(animationPanel.ball.xVelocity + "M/S in X Axis");
        yVelocityLabel.setText(animationPanel.ball.yVelocity * (-1) + "M/S in Y Axis");
        System.out.println(getXVelocity(velocity, angle) * 100);
        isActive = false;
    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
