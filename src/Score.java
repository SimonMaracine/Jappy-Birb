import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

class Score {
    int score = 0;

    void render(Graphics g) {
//        g.setFont();
        g.setColor(Color.black);
        g.drawString("Score: " + score, JappyBirb.WIDTH / 2 - 30, 150);
    }
}
