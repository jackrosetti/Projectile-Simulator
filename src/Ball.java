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
    double timeCount = 0;
    double timeCurrent = 0;

    public Ball(double X, double y, double h, double vx, double vy, double ax, double ay) {
        xPos = X / 10;
        yPos = y / 10;
        height = h;
        aX = ax;
        aY = ay;
        xVelocity = vx;
        yVelocity = vy;
        xI = xPos;
        yI = yPos;
        timeCurrent = 0.01;
    }

    public void reset(double x, double y, double vx, double vy) {

        xPos = x;
        yPos = y;
        xVelocity = vx;
        yVelocity = vy;
        timeCount = 0;

    }

    public void move() {

        timeCount += timeCurrent;

        if (timeCount == timeCurrent) {
            yPos = yI + yVelocity * timeCurrent + .5 * aY * timeCurrent * timeCurrent;
            xPos = xI + xVelocity * timeCurrent + .5 * aX * timeCurrent * timeCurrent;
        } else {
            yVelocity = yVelocity + aY * timeCurrent;
            xVelocity = xVelocity + aX * timeCurrent;
            yPos += yVelocity * timeCurrent + .5 * aY * timeCurrent * timeCurrent;
            xPos += xVelocity * timeCurrent + .5 * aX * timeCurrent * timeCurrent;

        }
        System.out.println("TIME : " + timeCount);
    }


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
