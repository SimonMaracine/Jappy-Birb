import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

class Ground {
    int height = 100;
    int y = JappyBirb.HEIGHT - height;
    int vel = 2;
    Color groundColor = new Color(200, 200, 16);
    Color grassColor = new Color(0, 240, 0);

    void render(Graphics g) {
        g.setColor(groundColor);
        g.fillRect(0, y, JappyBirb.WIDTH, height);
        g.setColor(grassColor);
        g.fillRect(0, y, JappyBirb.WIDTH, 18);
    }

    void update(int dt) {}
}
