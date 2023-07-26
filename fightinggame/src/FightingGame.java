import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.state.StateBasedGame;

    // includ
public class FightingGame extends StateBasedGame {
    // Constants for state IDs and player movement speed
    private static final int MENU_STATE = 0;
    private static final int GAMEPLAY_STATE = 1;
    private static final float PLAYER_SPEED = 0.2f;

    // Player coordinates
    private float playerX = 100;
    private float playerY = 100;

    public FightingGame(String title) {
        super(title);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer gameContainer = new AppGameContainer(new FightingGame("Fighting Game"));
            gameContainer.setDisplayMode(800, 600, false);
            gameContainer.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        addState(new MenuState(MENU_STATE));
        addState(new GameplayState(GAMEPLAY_STATE));
    }
}

class MenuState extends BasicGameState {
    public MenuState(int menuState) {
    }
    // ... previous code for MenuState

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }

    @Override
    public void keyPressed(int key, char c) {
        // ... handle key presses in the menu
    }
}

class GameplayState extends BasicGameState {
    // Constants for game objects
    private static final int PLAYER_WIDTH = 32;
    private static final int PLAYER_HEIGHT = 32;
    private static final int PLATFORM_WIDTH = 200;
    private static final int PLATFORM_HEIGHT = 20;
    private static final int PLAYER_SPEED = 0;

    public GameplayState(int gameplayState) {
    }

    // ... previous code for GameplayState

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        // ... initialize gameplay resources

        // Set the input to be controlled by the GameplayState
        container.getInput().addKeyListener(this);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        // ... render gameplay graphics

        // Draw the player character
        g.setColor(Color.blue);
        float playerX = 0;
        float playerY = 0;
        g.fillRect(playerX, playerY, PLAYER_WIDTH, PLAYER_HEIGHT);

        // Draw the platform
        g.setColor(Color.gray);
        g.fillRect(300, 400, PLATFORM_WIDTH, PLATFORM_HEIGHT);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        // ... update gameplay logic

        // Move the player character based on input
        Input input = container.getInput();
        int playerY = 0;
        if (input.isKeyDown(Input.KEY_UP)) {
            playerY -= PLAYER_SPEED * delta;
        }
        if (input.isKeyDown(Input.KEY_DOWN)) {
            playerY += PLAYER_SPEED * delta;
        }
        int playerX = 0;
        if (input.isKeyDown(Input.KEY_LEFT)) {
            playerX -= PLAYER_SPEED * delta;
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            playerX += PLAYER_SPEED * delta;
        }

        // Simple collision detection with the platform
        if (playerX < 500 && playerX + PLAYER_WIDTH > 300 && playerY + PLAYER_HEIGHT > 400 && playerY < 420) {
            // Colliding with the platform, reset position
            playerX = 100;
            playerY = 100;
        }
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void keyPressed(int key, char c) {
        // ... handle key presses in the gameplay
    }
}
