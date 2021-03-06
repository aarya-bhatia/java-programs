package com.aarya.GameEngine.engine;

import com.aarya.GameEngine.engine.gfx.GfxImage;
import java.awt.image.DataBufferInt;

public class Renderer {

    private int pW, pH;
    private int[] pixels;

    public Renderer(GameContainer gc) {
        pW = gc.getHeight();
        pH = gc.getHeight();
        pixels = ((DataBufferInt) gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
    }

    public void clear() {
        for(int i = 0; i < pixels.length; i++) {
//            pixels[i] += i; // Light show
            pixels[i] = 0;
        }
    }

    public void setPixel(int x, int y, int value) {
        if((x < 0 || x >= pW || y < 0 || y > pH) || value == 0xffff00ff) {
            return;
        }
        pixels[x + y * pW] = value;
    }

    public void drawImage(GfxImage image, int offX, int offY) {
        for(int y=0;y<image.getH();y++){
            for(int x=0;x<image.getW();x++){
                setPixel(x + offX, y + offY, image.getP() [x + y * image.getW()]);
            }
        }
    }
}
