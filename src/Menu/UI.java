package Menu;

import Main.*;
import controlP5.*;

public class UI {
    private static Textlabel safeRobotsLabel;
    private static Textlabel infectedRobotsLabel;
    private static Textlabel removedRobotsLabel;

    public static Textlabel getSafeRobotsLabel() {
        return safeRobotsLabel;
    }

    public static Textlabel getInfectedRobotsLabel() {
        return infectedRobotsLabel;
    }

    public static Textlabel getRemovedRobotsLabel() {
        return removedRobotsLabel;
    }

    public static void launchUI() {
        Main.gui = new ControlP5(Main.processing);

        Main.gui.setFont(Main.processing.createFont("Ubuntu", 12));

        safeRobotsLabel = Main.gui.addTextlabel("safe", "Safe robots: 0", 0, 10)
                .setFont(Main.processing.createFont("Ubuntu", 18));

        infectedRobotsLabel = Main.gui.addTextlabel("infected", "Infected robots: 0", 0, 40)
                .setFont(Main.processing.createFont("Ubuntu", 18));

        removedRobotsLabel = Main.gui.addTextlabel("removed", "Removed robots: 0", 0, 70)
                .setFont(Main.processing.createFont("Ubuntu", 18));

        Main.gui.addSlider("count")
                .setRange(10, 1000)
                .setValue(50)
                .setSize(150, 20)
                .setPosition(0, 100)
                .addCallback(callbackEvent -> {
                    if (callbackEvent.getAction() == ControlP5.ACTION_MOVE)
                    {
                        Main.robotsCount = (int)callbackEvent.getController().getValue();
                    }
                });


        Main.gui.addSlider("Speed")
                .setRange(1, 50)
                .setSize(150, 20)
                .setValue(5)
                .setPosition(0, 130)
                .addCallback(callbackEvent -> {
                    if (callbackEvent.getAction() == ControlP5.ACTION_MOVE)
                    {
                        Main.robotSpeed = (int)callbackEvent.getController().getValue();
                    }
                });

        Main.gui.addButton("Reset")
                .setSize(100, 30)
                .setPosition(0, 160)
                .addCallback(callbackEvent -> {
                    if (callbackEvent.getAction() == ControlP5.ACTION_RELEASE)
                    {
                        Main.environmentBox = new EnvironmentBox(300, 20, 480, 560, 10);
                        Main.environmentBox.initiate(Main.robotsCount, 0.1);
                    }
                });
    }
}
