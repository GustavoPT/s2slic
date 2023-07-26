package com.company;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class SimpleGame extends StateBasedGame {

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new SimpleGame("Simple Game"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    private SimpleGame(String title) {
        super(title);
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        // Initialize game states
        addState(new GameState());
        enterState(1); // Start with the first game state
    }
}

class GameState extends BasicGameState {

    private char keyPressedChar = ' '; // Store the last pressed key character

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        // Initialization code
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        // Render code
        g.drawString("Hello, Slick2D!", 100, 100);
        g.setColor(Color.black);
        g.fillRect(0, 0, container.getWidth(), container.getHeight());

        // Render some text on the screen
        g.setColor(Color.white);
        g.drawString("Press any key on the keyboard", 200, 250);

        g.drawString("Key pressed: " + keyPressedChar, 200, 300);

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        // Update code
    }

    @Override
    public void keyPressed(int key, char c) {
        // This method is called whenever a key is pressed
        System.out.println("Key pressed: " + key + " - " + c);

        keyPressedChar = c;
    }

}
