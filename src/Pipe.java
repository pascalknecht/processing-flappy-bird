import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

class Pipe {
    private PApplet p;

    private int pipeHeight, verticalSpacingBetweenPipes, x;

    PImage image_top, image_bottom;

    Pipe(PApplet p, int x, String type){
        this.p = p;
        this.x = x;

        pipeHeight = randBetween(300, 500);
    }

    int randBetween(int low, int high) {
        Random r = new Random();
        return r.nextInt(high-low) + low;
    }

    void setup() {
        image_top = p.loadImage("pipe_top.png");
        image_bottom = p.loadImage("pipe_bottom.png");
        verticalSpacingBetweenPipes = randBetween(200, 400);
    }

    void draw() {
        if(x >= 0){
            x -= 10;
        }
        p.image(image_top, x, 0, 65, p.displayHeight - pipeHeight - verticalSpacingBetweenPipes);
        p.image(image_bottom, x, p.displayHeight - pipeHeight, 65, pipeHeight);
    }
}
