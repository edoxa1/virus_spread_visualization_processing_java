package Main;

import Menu.UI;
import Robot.RobotController;
import Robot.SafeRobot;

public class EnvironmentBox {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int color;
    public RobotController robots;

    public EnvironmentBox(int x, int y, int width, int height, int color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void initiate(int robotsCount, double infectionChance) {
        this.robots = new RobotController(robotsCount, infectionChance);
        updateCount();
    }

    public void updateCount() {
        UI.getSafeRobotsLabel().setText(String.format("Safe robots: %d", this.robots.getSafeRobotsCount()));
        UI.getInfectedRobotsLabel().setText(String.format("Infected robots: %d", this.robots.getInfectedRobotsCount()));
        UI.getRemovedRobotsLabel().setText(String.format("Removed robots: %d", this.robots.getRemovedRobotsCount()));
    }

    public void draw(){
        Main.processing.fill(this.color);
        Main.processing.rect(this.x, this.y, this.width, this.height);
        robots.startSimulation();
    }
}
