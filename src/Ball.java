import java.awt.*;

public class Ball {
    double xPos;
    double yPos;
    double aX;
    double aY;
    double height;
    double xVelocity;
    double yVelocity;
    double xI;
    double yI;
    double dblTimeCount = 0 ;
    double dblTimeCurrent=0;



    public void draw ( Graphics2D g) {
        g.setColor(Color.GRAY);
        g.fillOval((int)(xPos*10),(int)(yPos*10),30,30);
    }


    public double getxPos() {
        return xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public double getaX() {
        return aX;
    }

    public void setaX(double aX) {
        this.aX = aX;
    }

    public double getaY() {
        return aY;
    }

    public void setaY(double aY) {
        this.aY = aY;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public double getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    public double getxI() {
        return xI;
    }

    public void setxI(double xI) {
        this.xI = xI;
    }

    public double getyI() {
        return yI;
    }

    public void setyI(double yI) {
        this.yI = yI;
    }


}
