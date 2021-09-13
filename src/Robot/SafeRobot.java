package Robot;

import Main.*;

import java.util.ArrayList;
import java.util.List;

public class SafeRobot extends AbstractRobot{
    public SafeRobot(int speed){
        super(speed, 25, 10, Main.processing.color(0, 255, 0));
    }

    public void infect(){
        List<InfectedRobot> infectedRobots = Main.environmentBox.robots.getInfectedRobots();
        List<SafeRobot> safeRobots = Main.environmentBox.robots.getSafeRobots();
        List<SafeRobot> toRemove = new ArrayList<>();
        List<InfectedRobot> toAdd = new ArrayList<>();
        double randomValue = Math.random();
        for (InfectedRobot infectedRobot : infectedRobots) {
            if (Math.abs(super.getX() - infectedRobot.getX()) < infectedRobot.contactZone
                    && Math.abs(super.getY() - infectedRobot.getY()) < infectedRobot.contactZone) {
                if (randomValue < Main.environmentBox.robots.infectionChance / 10) {
                    toAdd.add(new InfectedRobot(this));
                    toRemove.add(this);
                    break;
                }
            }
        }

        if (toRemove.size() != 0) {
            safeRobots.removeAll(toRemove);
            infectedRobots.addAll(toAdd);
            Main.environmentBox.robots.setInfectedRobots(infectedRobots);
            Main.environmentBox.robots.setSafeRobots(safeRobots);
            Main.environmentBox.updateCount();
        }
    }
}
