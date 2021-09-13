package Robot;

import Main.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;

public class InfectedRobot extends AbstractRobot {
    protected int x;
    protected int y;
    protected int speed;
    protected int color;
    protected int infectionTime;

    public InfectedRobot(SafeRobot robot) {
        super(robot.x, robot.y, robot.speed, 10, Main.processing.color(255, 0, 0), robot.contactZone);
        this.infectionTime = Main.processing.millis();
    }

    public InfectedRobot(int speed) {
        super(speed, 25, 10, Main.processing.color(255, 0, 0));
        this.infectionTime = Main.processing.millis();
    }

    public int getInfectionTime() {
        return this.infectionTime;
    }

    public void remove() {
        List<InfectedRobot> infectedRobots = Main.environmentBox.robots.getInfectedRobots();
        List<RemovedRobot> removedRobots = Main.environmentBox.robots.getRemovedRobots();
        List<InfectedRobot> toRemove = new ArrayList<>();
        List<RemovedRobot> toAdd = new ArrayList<>();
        int rand = new Random().nextInt(10000) + 10000;

        if (Main.processing.millis() - this.getInfectionTime() >= rand) {
            toRemove.add(this);
            toAdd.add(new RemovedRobot(this));
        }

        if (toRemove.size() != 0) {
            infectedRobots.removeAll(toRemove);
            removedRobots.addAll(toAdd);
            Main.environmentBox.robots.setInfectedRobots(infectedRobots);
            Main.environmentBox.robots.setRemovedRobots(removedRobots);
            Main.environmentBox.updateCount();
        }
    }
}
