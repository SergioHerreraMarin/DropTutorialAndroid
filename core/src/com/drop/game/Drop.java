package com.drop.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Drop extends Game {

    public SpriteBatch batch;
    public BitmapFont font;


    @Override
    public void create() {
        System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        batch = new SpriteBatch();
        font = new BitmapFont();
        this.setScreen(new MainMenuScreen(this));

    }


    public void render(){
        super.render();
    }


    public void dispose(){
        batch.dispose();
        font.dispose();

    }

}
