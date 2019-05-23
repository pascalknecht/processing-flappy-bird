import processing.core.PApplet;
import processing.core.PImage;

class Bird {
    private PApplet p;

    public float x, y;

    float gravity = 10f;

    float speed = 10;

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
        y = y + speed;
        speed = speed + gravity;
    }

    void jump() {
        speed = -20f;
    }
}
