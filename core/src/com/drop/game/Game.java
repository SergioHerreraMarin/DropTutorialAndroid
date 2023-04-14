/*package com.drop.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;

import org.w3c.dom.css.Rect;

import java.util.Iterator;


public class Game extends ApplicationAdapter {


	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture dropImage;
	private Texture bucketImage;
	private Sound dropSound;
	private Music rainMusic;
	private Rectangle bucket;
	private Vector3 touchPos;
	private Array<Rectangle> raindrops;
	private long lastDropTime;


	@Override
	public void create () {

		//Create camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		//Create spriteBatch
		batch = new SpriteBatch();

		// load the images for the droplet and the bucket, 64x64 pixels each
		dropImage = new Texture(Gdx.files.internal("droplet.png"));
		bucketImage = new Texture(Gdx.files.internal("bucket.png"));

		// load the drop sound effect and the rain background "music"
		dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));

		// start the playback of the background music immediately
		rainMusic.setLooping(true);
		rainMusic.play();

		//Create and define Bucket
		bucket = new Rectangle();
		bucket.x = (800 / 2) - (64 / 2); //Center
		bucket.y = 20;
		bucket.width = 64;
		bucket.height = 64;

		//Create touchPos vector
		touchPos = new Vector3();

		raindrops = new Array<Rectangle>();
		spawnRaindrop();

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0.2f, 1);
		camera.update(); //Update camera

		//Batch pass:
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		//Render bucket
		batch.draw(bucketImage, bucket.x, bucket.y);
		//Render raindrops
		for(Rectangle raindrop : raindrops){
			batch.draw(dropImage, raindrop.x, raindrop.y);
		}
		batch.end();

		//Bucket input screen touch
		if(Gdx.input.isTouched()){
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			bucket.x = (int)touchPos.x - 62 / 2;
		}

		//Bucket input keyboard
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			bucket.x -= 200 * Gdx.graphics.getDeltaTime(); //si va a 60FPS, se le restará 200unidades por segundo.
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			bucket.x += 200 * Gdx.graphics.getDeltaTime();
		}

		//Limits
		if(bucket.x < 0){
			bucket.x = 0;
		}
		if(bucket.x > 800 - 64){
			bucket.x = 800 - 64;
		}

		//Spawn raindrop
		if((TimeUtils.nanoTime() - lastDropTime) > 1000000000){
			spawnRaindrop();
		}


		//raindrops vertical move.
		for (Iterator<Rectangle> iter = raindrops.iterator(); iter.hasNext(); ) {
			Rectangle raindrop = iter.next();
			raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
			if(raindrop.y + 64 < 0) iter.remove();

			if(raindrop.overlaps(bucket)){
				dropSound.play();
				iter.remove();
			}
		}


	}


	private void spawnRaindrop(){
		Rectangle raindrop= new Rectangle();
		raindrop.x = MathUtils.random(0, 800-64);
		raindrop.y = 400;
		raindrop.width = 64;
		raindrop.height = 64;
		raindrops.add(raindrop);
		lastDropTime = TimeUtils.nanoTime(); //Current time.
	}


	
	@Override
	public void dispose () {
		dropImage.dispose();
		bucketImage.dispose();
		dropSound.dispose();
		rainMusic.dispose();
		batch.dispose();
	}


}
*/