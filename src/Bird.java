import processing.core.PApplet;
import processing.core.PImage;

class Bird {
    private PApplet p;

    public int x, y;

    private int birdHeight = 50;

    PImage image;

    Bird(PApplet p){
        this.p = p;
    }

    void setup() {
        image = p.loadImage("bird.png");
        y = p.displayHeight / 2 - birdHeight / 2;
        x = 50;
    }

    void draw() {
        // Scale the bird to have a height of 50
        int aspect = birdHeight / image.height;
        p.image(image, x, y, image.width * aspect, birdHeight);
        x += 20;
        y += 20;
    }

    void jump() {
        this.y -= 50;
    }
}
