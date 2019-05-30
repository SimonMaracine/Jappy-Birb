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
    private Timer timer = new Timer();

    private Birb bird;
    private ArrayList<Pipe> pipes = new ArrayList<>();

    private JappyBirb(String title) {
        super(title);
    }

    public void init(GameContainer gc) {
        bird = new Birb();
        pipes.add(new Pipe(650, rand.nextInt(HEIGHT - 245) + 40));
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override public void run() {
                System.out.println(0);
                pipes.add(new Pipe(650, rand.nextInt(HEIGHT - 245) + 40));
            }
        }, 3000, 3000);
    }

    public void render(GameContainer gc, Graphics g) {
        bird.render(g);
        for (Pipe pipe : pipes) {
            pipe.render(g);
        }
    }

    public void update(GameContainer gc, int dt) {
        Input input = gc.getInput();
        bird.update(dt);
        if (input.isKeyPressed(Input.KEY_SPACE)) {
            bird.jump();
        } else if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            gc.exit();
        }

        for (int i = pipes.size() - 1; i >= 0; i--) {
            pipes.get(i).update(dt);
            if (pipes.get(i).offScreen()) {
                pipes.remove(i);
            }
        }
        System.out.println(pipes.size());
    }

    public static void main(String[] args) {
        System.out.println("Jappy Birb");

        AppGameContainer appgc;
        try {
            appgc = new AppGameContainer(new JappyBirb(TITLE));
            appgc.setDisplayMode(WIDTH, HEIGHT, false);
            appgc.setTitle(TITLE);
            appgc.setTargetFrameRate(60);
            appgc.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
