import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

class Pipe {

    private PApplet p;
    int height, verticalSpacingBetweenPipes, x, y;
    private int canvasWidth, canvasHeight;
    private static final int SPACE_BETWEEN_PIPES = 200;
    private static final int MOVEMENT_SPEED = 3;
    private static final int RESET_X_POSITION = 700;
    private Contain contain;

    PImage image_top, image_bottom;

    Pipe(PApplet p, int x, int canvasWidth, int canvasHeight, Contain contain){
        this.p = p;
        this.x = x;
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.contain = contain;

        height = randBetween(200, 500);

        // Set the y value
        this.y = this.canvasHeight - height - verticalSpacingBetweenPipes;
    }

    void setup() {
        image_top = p.loadImage("pipe_top.png");
        image_bottom = p.loadImage("pipe_bottom.png");
        verticalSpacingBetweenPipes = SPACE_BETWEEN_PIPES;
    }

    void draw() {
        // If the position of the pipe is greater/equal zero, move it from the right to the left with the defined movement speed
        // For all other cases, reset the x position of the pipe to the 700
        if(x > 0){
            x -= MOVEMENT_SPEED;
        } else {

            this.contain.score++;

            this.x = RESET_X_POSITION;
            this.height = randBetween(200, 500);
            this.y = this.canvasHeight - height - verticalSpacingBetweenPipes;
        }

        // Load the top and bottom images for the pipe
        p.image(image_top, x, 0, 65, y);

        p.image(image_bottom, x, y + verticalSpacingBetweenPipes     , 65, height);
    }

    private int randBetween(int low, int high) {
        Random r = new Random();
        return r.nextInt(high-low) + low;
    }
}
