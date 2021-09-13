package Robot;

import Main.*;

import java.util.*;

public class RobotController {
    public List<SafeRobot> safeRobots;
    public List<InfectedRobot> infectedRobots;
    public List<RemovedRobot> removedRobots;
    public int totalCount;
    public double infectionChance;

    public RobotController(int robotsCount, double infectionChance){
        this.totalCount = robotsCount;
        this.infectionChance = infectionChance;
        safeRobots = new ArrayList<>();
        infectedRobots = new ArrayList<>();
        removedRobots = new ArrayList<>();
        for (int i = 0; i < this.totalCount - 1; i++) {
            safeRobots.add(new SafeRobot(Main.robotSpeed));
        }
        infectedRobots.add(new InfectedRobot(Main.robotSpeed));
    }

    public void setSafeRobots(List<SafeRobot> safeRobots) {
        this.safeRobots = safeRobots;
    }

    public void setInfectedRobots(List<InfectedRobot> infectedRobots) {
        this.infectedRobots = infectedRobots;
    }

    public void setRemovedRobots(List<RemovedRobot> removedRobots) {
        this.removedRobots = removedRobots;
    }

    public void startSimulation(){
        for (int i = 0; i < safeRobots.size(); i++) {
            safeRobots.get(i).drawRobot();
            safeRobots.get(i).infect();
        }
        for (int i = 0; i < infectedRobots.size(); i++) {
            infectedRobots.get(i).drawRobot();
            infectedRobots.get(i).remove();
        }
        for (int i = 0; i < removedRobots.size(); i++) {
            removedRobots.get(i).drawRobot();
        }
    }

    public List<SafeRobot> getSafeRobots() {
        return safeRobots;
    }

    public List<InfectedRobot> getInfectedRobots() {
        return infectedRobots;
    }

    public List<RemovedRobot> getRemovedRobots() {
        return removedRobots;
    }

    public int getTotalRobots(){
        return this.safeRobots.size() + this.infectedRobots.size() + this.removedRobots.size();
    }
    public int getSafeRobotsCount(){
        return this.safeRobots.size();
    }
    public int getInfectedRobotsCount(){
        return this.infectedRobots.size();
    }
    public int getRemovedRobotsCount(){
        return this.removedRobots.size();
    }
}
