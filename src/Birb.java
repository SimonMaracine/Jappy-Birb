import org.newdawn.slick.Graphics;

class Birb {
    float x = 100;
    float y = JappyBirb.HEIGHT / 2 - 40;
    int width = 45;
    float vel = 0;
    float acc = 0.35f;
    boolean canJump = true;

    void render(Graphics g) {
        g.fillOval(x, y, width, width);
    }

    void update(int dt) {
        applyGravity();
        if (vel < 6) {
            vel += acc;
        }
        vel *= 0.97;
        y += vel;

        if (y < 0) {
            canJump = false;
        } else {
            canJump = true;
        }

        if (y > JappyBirb.HEIGHT) {
            vel = 0;
            System.out.println("You fell!");
        }
    }

    private void applyGravity() {
        if (acc < 0.35f) {
            acc += 0.07f;
        }
    }

    void jump() {
        if (canJump) {
            vel = -9;
        }
    }
}
