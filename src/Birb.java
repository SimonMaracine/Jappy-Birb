import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import static org.joml.Math.sin;

class Birb {
    float x = 100;
    float y = JappyBirb.HEIGHT / 2.0f - 40;
    int width = 45;
    float vel = 0;
    float acc = 0.4f;
    boolean canJump = true;
    float maxVel = 6.8f;
    boolean isDead = false;
    boolean floating = true;
    float floatCount = 0;

    void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(x, y, width, width);

//        g.setColor(Color.white);
//        g.fillOval(0, 0, 60, 60);
    }

    void update(int dt) {
        applyGravity();
        if (vel < maxVel) {
            vel += acc;
        }
        vel *= 0.96f;
        y += vel;

        if (y < 0) {
            canJump = false;
        } else {
            canJump = true;
        }
    }

    private void applyGravity() {
        if (acc < 0.35f) {
            acc += 0.07f;
        }
    }

    void jump() {
        if (canJump) {
            vel = -11;
        }
    }

     boolean collidePipe(Pipe pipe) {
        if (x + width >= pipe.x && x <= pipe.x + pipe.width) {
            if (y + width >= pipe.startGap + pipe.gapWidth || y <= pipe.startGap) {
                return true;
            }
        }
        return false;
    }

    boolean collideGround(Ground ground) {
        if (y + width / 2 > JappyBirb.HEIGHT - ground.height) {
            vel = 0;
            acc = 0;
            System.out.println("You fell!");
            return true;
        } else {
            return false;
        }
    }

    boolean scoreUp(Pipe pipe) {
        if (x + width / 2f >= pipe.x + pipe.width / 2f && x + width / 2f <= pipe.x + pipe.width / 2f + 2) {
            return true;
        } else {
            return false;
        }
    }

    void fly() {
        y = JappyBirb.HEIGHT / 2.0f - 40 + (float) sin(floatCount) * 20;
        floatCount += 0.1f;
    }
}
