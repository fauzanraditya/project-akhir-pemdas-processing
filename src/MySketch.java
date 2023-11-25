import processing.core.PApplet;

public class MySketch extends PApplet {

    float duration;
    float[][] colors = { { 255, 0, 0 }, { 0, 255, 0 }, { 0, 0, 255 } };
    int colorIndex = 0;
    float lastTime;
    float deltaTime;

    float xPos;

    public static void main(String[] args) {
        MySketch mySketch = new MySketch();
        PApplet.runSketch(new String[] { "Hello Processing" }, mySketch);
    }

    @Override
    public void settings() {
        size(1366, 768);

    }

    @Override
    public void draw() {
        deltaTime = millis() - lastTime;
        lastTime = millis();
        duration += deltaTime;
        // change bg color every 1s
        if (duration >= 1000) {
            if (colorIndex < colors.length - 1) {
                colorIndex++;
            } else {
                colorIndex = 0;
            }
            // reset counter to 0
            duration = 0;
        }
        background(colors[colorIndex][0], colors[colorIndex][1], colors[colorIndex][2]);

        fill(255, 255, 255);
        xPos += deltaTime * 0.05f;
        ellipse(xPos + (width / 2), height / 2, 100, 100);

    }
}