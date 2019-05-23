import processing.core.*;
import processing.event.KeyEvent;

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
    }

    @Override
    public void setup() {
        playGround = new Contain(this, canvasWidth, canvasHeight);
        playGround.setup();
    }

    @Override
    public void draw() {
        playGround.draw();
        playGround.d += 100;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        // If the spacebar is pressed down
        if (event.getKeyCode() == 32) {
            if (playGround.isPlaying) {
                playGround.bird.jump();
            }
            else {
                playGround = new Contain(this, canvasWidth, canvasHeight);
                playGround.setup();
            }
        }
    }
}
