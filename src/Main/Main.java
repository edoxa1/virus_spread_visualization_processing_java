package Main;

import processing.core.PApplet;
import controlP5.*;
import Menu.UI;
import processing.core.PFont;

public class Main extends PApplet {
    public static PApplet processing;
    public static EnvironmentBox environmentBox;
    public static ControlP5 gui;

    public static int robotsCount;
    public static int robotSpeed;

    public static void main(String[] args) {
        robotSpeed = 5;
        robotsCount = 75;
        PApplet.main(new String[] { Main.class.getName() });
    }

    @Override
    public void settings() {
        processing = this;
        environmentBox = new EnvironmentBox(300, 20, 480, 560, 10);
        size(800, 600);
    }

    @Override
    public void setup() {
        UI.launchUI();
        environmentBox.initiate(150, 0.1);
    }

    @Override
    public void draw() {
        background(40);
        environmentBox.draw();
        stroke(0);
    }
}
