import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;

class Contain {

    private Bird bird;

    private List<Pipe> pipes = new ArrayList<>();

    PImage background;

    int p, d;

    int canvasWidth, canvasHeight;

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
    }

    void setup() {
        background = applet.loadImage("bg.png");
        for (int x = 0; x < 100; x++) {
            Pipe p = new Pipe(applet, 800 + 150 * x, "top");
            p.setup();
            this.pipes.add(p);
        }

        this.bird.setup();
    }

    void draw(){
        if( p < d ){ p++; }
        if( p > d ){ p--; }
        pg.beginDraw();
        pg.background(255);
        pg.noStroke();
        pg.translate(-p,0);
        pg.fill(255,0,0);
        pg.rect(50,50,50,50);
        pg.fill(255,255,0);
        pg.rect(150,50,50,50);
        pg.fill(0,255,0);
        pg.rect(250,50,50,50);
        pg.fill(0,0,255);
        pg.rect(350,50,50,50);
        pg.endDraw();
        applet.image(pg.get(),0,0);

        for (int x = 0; x < 100; x++) {
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
    }

    void gameOver() {
        PImage gameOver = applet.loadImage("gameover.png");
        applet.image(gameOver, canvasWidth / 2, canvasHeight / 2);
    }
}