import processing.core.PApplet;
import processing.core.PImage;

// This class represents the bird
class Bird {

    public float x, y;

    private PApplet p;
    private float gravity = 1.5f;
    private float speed = 2;
    private int birdHeight = 50;
    private PImage image;

    Bird(PApplet p){
        this.p = p;
    }

    void setup() {
        // Load the image for the bird
        image = p.loadImage("bird.png");

        y = 250;
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
        speed = -15f;
    }

    void fall(){
        y =-10;
    }
}
