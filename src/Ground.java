import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

class Ground {
    int height = 100;
    int y = JappyBirb.HEIGHT - height;
    int vel = 2;

    void render(Graphics g) {
        g.setColor(new Color(200, 200, 16));
        g.fillRect(0, y, JappyBirb.WIDTH, height);
    }

    void update(int dt) {}
}
