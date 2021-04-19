package com.aarya.GameEngine.engine;

public class GameContainer implements Runnable {

    private Thread thread;
    private volatile boolean running = false;
    private boolean render = false;
    private final double UPDATE_CAP = 1.0f / 60.0f;
    private Window window;
    private Renderer renderer;
    private Input input;
    private AbstractGame game;

    private final int width = 320, height = 240;
    private final float scale = 3f;
    private final String title = "2D Game Engine 1.0";

    public String getTitle() {
        return title;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getScale() {
        return scale;
    }

    public Window getWindow() {
        return window;
    }

    public GameContainer(AbstractGame game) {
        this.game = game;
    }

    public void start() {

        window = new Window(this);
        renderer = new Renderer(this);
        input = new Input(this);

        thread = new Thread(this);
        thread.run();

    }

    public void stop() {
    }

    public Input getInput() {
        return input;
    }

    // Game Loop
    public void run() {
        running = true;

        double firstTime = 0;
        double lastTime = System.nanoTime() / 1.0E9;
        double passedTime = 0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0;
        int fps = 0;

        while (running) {
            render = false;
            firstTime = System.nanoTime() / 1.0E9;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;
            unprocessedTime += passedTime;
            frameTime += passedTime;

            while(unprocessedTime >= UPDATE_CAP) {
                unprocessedTime -= UPDATE_CAP;
                render = true;

//                if(input.isKeyUp(KeyEvent.VK_A)) {
//                    System.out.println("Key Up: A");
//                }
//
//                if(input.isKeyDown(KeyEvent.VK_A)) {
//                    System.out.println("Key Down: A");
//                }
//
//                if(input.isButtonDown(1)) {
//                    System.out.println("Button down: 1");
//                }
//

                game.update(this, (float) UPDATE_CAP);
                input.update();

//                System.out.printf("Mouse x: %d, Mouse y: %d \n", input.getMouseX(), input.getMouseY());


                if(frameTime >= 1.0) {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    System.out.println("FPS: " + fps);
                }
            }

            if(render) {
                renderer.clear();
                game.render(this, renderer);
                window.update();
                frames++;
            }

            else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        dispose();
    }

    private void dispose() {
    }

}