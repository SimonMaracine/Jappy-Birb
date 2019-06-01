import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

class Pipe {
    float x;
    int width = 100;
    float vel = 2;
    int startGap;
    int gapWidth = 165;
    Color color = new Color(0, 210, 0);
    Color capColor = new Color(0, 190, 0);

    Pipe(float x, int startGap) {
        this.x = x;
        this.startGap = startGap;
    }

    void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x, 0, width, startGap);  // top pipe
        g.fillRect(x, startGap + gapWidth, width, JappyBirb.HEIGHT - startGap - gapWidth - 100);  // bottom pipe
        g.setColor(capColor);
        g.fillRect(x - 4, startGap - 35, width + 8, 35);
        g.fillRect(x - 4, startGap + gapWidth, width + 8, 35);
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

    static ArrayList<Pipe> cloneList(ArrayList<Pipe> array) {
        ArrayList<Pipe> clone = new ArrayList<>(array.size());
        clone.addAll(array);
        return clone;
    }
}
