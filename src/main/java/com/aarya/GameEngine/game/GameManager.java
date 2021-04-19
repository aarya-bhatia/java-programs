package com.aarya.GameEngine.game;

import com.aarya.GameEngine.engine.AbstractGame;
import com.aarya.GameEngine.engine.GameContainer;
import com.aarya.GameEngine.engine.Renderer;
import com.aarya.GameEngine.engine.gfx.GfxImage;

import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame {

    private GfxImage image;

    public GameManager() {
        image = new GfxImage("/New Piskel.png");
    }

    @Override
    public void update(GameContainer gc, float dt) {
        if(gc.getInput().isKeyDown(KeyEvent.VK_A)) {
            System.out.println("Key pressed A");
        }
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.drawImage(image, gc.getInput().getMouseX(), gc.getInput().getMouseY());
//        r.drawImage(image, 100, 100);
    }

    public static void main(String[] args) {
        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
