import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
import java.util.ArrayList;
import java.util.List;

// This class represents the main game scene with all its content (bird, pipes and game-logic)
class Contain {

    public Bird bird;
    public boolean isPlaying = true;
    public int p, d;
    public int score;

    private List<Pipe> pipes = new ArrayList<>();
    private PImage background;
    private int canvasWidth, canvasHeight;

    PGraphics pg;
    PApplet applet;

    Contain(PApplet applet, int width, int height) {
        this.applet = applet;
        this.bird = new Bird(applet);

        p = 0;
        d = 0;

        pg = applet.createGraphics(width,height);

        this.canvasWidth = width;
        this.canvasHeight = height;

        // Init score to 0
        score = 0;
    }

    void setup() {
        // Load background image
        background = applet.loadImage("bg.png");

        for (int x = 0; x < 2; x++) {
            Pipe p = new Pipe(applet, 400  + 350 * x, canvasWidth, canvasHeight, this);
            p.setup();
            this.pipes.add(p);
        }

        this.bird.setup();
    }

    void draw() {
        if (!isPlaying) {
            return;
        }

        for (int x = 0; x < pipes.size(); x++) {
            // Scale the image to fit the canvas
            int aspect = canvasHeight / background.height;
            applet.image(background,x * background.width,0, background.width * aspect, canvasHeight);
        }

        for(Pipe p : pipes) {
            p.draw();
        }
        this.bird.draw();

        if (this.bird.y < 0 || this.bird.y > canvasHeight) {
            this.gameOver();
        }

        for(int i = 0; i < pipes.size(); i++){
            if(bird.x >= (pipes.get(i).x - 65) && !birdIsBetweenPipe(bird.y, pipes.get(i))){
                this.gameOver();
            }
        }

        System.out.println("current score is: " + this.score);
    }

    void gameOver() {
        PImage gameOver = applet.loadImage("gameover.png");
        applet.image(gameOver, canvasWidth / 2 - gameOver.width / 2, canvasHeight / 2 - gameOver.height);
        stop();
    }

    private boolean birdIsBetweenPipe(double birdYValue, Pipe pipe){
        if(birdYValue> (pipe.y) && birdYValue < pipe.y + ((pipe.verticalSpacingBetweenPipes)-40)) {
            return true;
        } else {
            return false;
        }
    }

    void stop() {
        this.isPlaying = false;
    }
}