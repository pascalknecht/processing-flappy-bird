
import processing.core.*;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class MainApplet extends PApplet {

    Contain playGround;

    int canvasWidth = 1920;
    int canvasHeight = 1080;

    public static void main(String args[]) {
        PApplet.main("MainApplet");
    }

    @Override
    public void settings() {
        size(canvasWidth, canvasHeight);

        //fullScreen();
    }

    @Override
    public void setup() {
        playGround = new Contain(this, canvasWidth, canvasHeight);
        playGround.setup();
    }

    @Override
    public void draw() {
        playGround.draw();
    }

    @Override
    public void keyPressed(KeyEvent event) {
        // If the spacebar is pressed down
        if (event.getKeyCode() == 32) {
            //this.bird.jump();
        }
    }
}