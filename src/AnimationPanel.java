import javax.swing.*;
import java.awt.*;

public class AnimationPanel extends JPanel {
    Graphics2D graphics;
    Ball ball = new Ball(50, 480, 0, 1000, -1000, 0, 9.8);
    boolean blnfirst = true;
    int heightPanel;
    int widthPanel;

    public AnimationPanel() {
        super();
    }

    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        this.graphics = graphics;
        g.clearRect(0, 0, 1000, 1000);
        if (!blnfirst) {
            ball.move();
        }
        blnfirst = false;
        drawBall();
        graphics.setColor(Color.GREEN);
        g.fillRect(0, 500, 1000, 100);
    }

    public void drawBall() {
        ball.draw(graphics);
    }


    public void setSize(int intH, int intW) {
        heightPanel = intH;
        widthPanel = intW;
    }


}
