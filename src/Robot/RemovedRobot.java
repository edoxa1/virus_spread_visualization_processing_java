package Robot;

import Main.Main;

public class RemovedRobot extends AbstractRobot {
    public RemovedRobot(int speed, int contactZone, int width, int color) {
        super(speed, contactZone, width, color);
    }

    public RemovedRobot(InfectedRobot robot) {
        super(robot.getX(), robot.getY(), Main.robotSpeed, robot.width, Main.processing.color(211, 211, 211), robot.contactZone);
    }
}
