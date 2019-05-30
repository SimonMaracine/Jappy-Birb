import org.newdawn.slick.Graphics;

class Pipe {
    float x;
    int width = 100;
    float vel = 2;
    int startGap;
    int gapWidth = 165;

    Pipe(float x, int startGap) {
        this.x = x;
        this.startGap = startGap;
    }

    void render(Graphics g) {
        g.fillRect(x, 0, width, startGap);
        g.fillRect(x, startGap + gapWidth, width, JappyBirb.HEIGHT - startGap - gapWidth);
    }

    void update(int dt) {
        x -= vel;
    }

    boolean offScreen() {
        if (x + width < 0) {
            return true;
        } else {
            return false;
        }
    }
}
