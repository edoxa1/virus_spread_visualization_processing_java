package Robot;

import Main.*;
import processing.core.PConstants;
import processing.core.PShape;

import java.util.Random;

public class AbstractRobot {
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    protected int x;
    protected int y;
    protected int speed;
    protected int color;
    protected int width;
    protected int contactZone;

    public AbstractRobot (int x, int y, int speed, int width, int color, int contactZone) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.speed = speed;
        this.contactZone = contactZone;
        this.width = width;
    }

    public AbstractRobot(int speed, int contactZone, int width, int color) {
        this.x = new Random().nextInt(Main.environmentBox.getWidth()) + Main.environmentBox.getX();
        this.y = new Random().nextInt(Main.environmentBox.getHeight()) + Main.environmentBox.getY();
        this.color = color;
        this.speed = speed;
        this.width = width;
        this.contactZone = contactZone;
    }

    public void drawRobot() {
        check();
        int x_speed = 0;
        int y_speed = 0;
        try {
            x_speed = new Random().nextInt(Math.abs(speed)) - new Random().nextInt(Math.abs(speed));
            y_speed = new Random().nextInt(Math.abs(speed)) - new Random().nextInt(Math.abs(speed));
        } catch (Exception e) {
            System.out.println(speed);
        }
        this.x += x_speed;
        this.y += y_speed;
        Main.processing.pushMatrix();
        Main.processing.stroke(0);
        Main.processing.fill(255);
        Main.processing.rect(this.x, this.y, this.width, this.width);
        Main.processing.popMatrix();
        Main.processing.pushMatrix();
        Main.processing.noFill();
        Main.processing.stroke(this.color);
        Main.processing.ellipse(this.x + (this.width >> 1),
                this.y + (this.width >> 1), this.contactZone, this.contactZone);
        Main.processing.popMatrix();
    }
    public void check() {
        if (this.x >= Main.environmentBox.getWidth() + Main.environmentBox.getX() - this.width - this.contactZone)
             this.x = Main.environmentBox.getWidth() + Main.environmentBox.getX()  - this.width - this.contactZone;
        if (this.y >= Main.environmentBox.getHeight() + Main.environmentBox.getY()  - this.width - this.contactZone)
             this.y = Main.environmentBox.getHeight() + Main.environmentBox.getY()  - this.width - this.contactZone;

        if (this.x <= Main.environmentBox.getX() + this.width)
             this.x = Main.environmentBox.getX() + this.width;
        if (this.y <= Main.environmentBox.getY() + this.width)
             this.y = Main.environmentBox.getY() + this.width;
    }
}
