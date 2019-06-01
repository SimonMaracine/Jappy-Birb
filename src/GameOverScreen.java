import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

class GameOverScreen {
    int x = 100;
    int y = 150;
    int width = JappyBirb.WIDTH - 200;
    int height = JappyBirb.HEIGHT - 300;
    Color backgroundColor = new Color(200, 200, 0);

    void render(Graphics g) {
        g.setColor(backgroundColor);
        g.fillRect(x, y, width, height);
        g.setColor(Color.black);
        g.drawString("Game Over", x + 120, y + 150);

    }
}
