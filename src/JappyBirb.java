import org.newdawn.slick.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class JappyBirb extends BasicGame {
    static int WIDTH = 600;
    static int HEIGHT = 700;
    static final String TITLE = "Jappy Birb";
    private Random rand = new Random();
    private Timer timer;

    private Birb bird;
    private ArrayList<Pipe> pipes;
    private Ground ground;
    private Score score;

    private JappyBirb(String title) {
        super(title);
    }

    public void init(GameContainer gc) {
        timer = new Timer();
        bird = new Birb();
        pipes = new ArrayList<>();
        pipes.add(new Pipe(650, rand.nextInt(HEIGHT - 345) + 40));
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override public void run() {
                pipes.add(new Pipe(650, rand.nextInt(HEIGHT - 345) + 40));
            }
        }, 3000, 3000);
        ground = new Ground();
        score = new Score();
    }

    public void render(GameContainer gc, Graphics g) {
        g.setBackground(new Color(160, 160, 255));
        ArrayList<Pipe> pipes = Pipe.cloneList(this.pipes);
        for (Pipe pipe : pipes) {
            pipe.render(g);
        }
        ground.render(g);
        bird.render(g);
        score.render(g);
    }

    public void update(GameContainer gc, int dt) {
        Input input = gc.getInput();
        bird.update(dt);
        if (bird.collideGround(ground)) {
            restart(gc);
        }
        if (input.isKeyPressed(Input.KEY_SPACE) || input.isKeyPressed(Input.KEY_UP)) {
            bird.jump();
        } else if (input.isKeyPressed(Input.KEY_R)) {
            restart(gc);
        } else if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            gc.exit();
        }

        for (int i = pipes.size() - 1; i >= 0; i--) {
            pipes.get(i).update(dt);
            if (pipes.get(i).offScreen()) {
                pipes.remove(i);
            }
            if (bird.collidePipe(pipes.get(i))) {
//                System.out.println("hit");
                pipes.get(i).color = new Color(255, 0, 0);
                pipes.get(i).capColor = new Color(235, 0, 0);
            } else {
                pipes.get(i).color = new Color(0, 210, 0);
                pipes.get(i).capColor = new Color(0, 190, 0);
            }
            if (bird.scoreUp(pipes.get(i))) {
                score.score++;
//                System.out.println("SCORE");
            }
        }
//        System.out.println(pipes.size());
    }

    private void restart(GameContainer gc) {
        try {
            gc.reinit();
        } catch (SlickException e) {
            e.printStackTrace();
        }
        timer.cancel();
        pipes.clear();
    }

    public static void main(String[] args) {
        System.out.println("Jappy Birb");

        AppGameContainer appgc;
        try {
            appgc = new AppGameContainer(new JappyBirb(TITLE));
            appgc.setDisplayMode(WIDTH, HEIGHT, false);
            appgc.setTitle(TITLE);
            appgc.setTargetFrameRate(60);
//            appgc.setIcon();
            appgc.setVSync(false);
            appgc.setAlwaysRender(true);
            appgc.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
