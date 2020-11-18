package edu.lewisu.josephknelson;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MidiBoard extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background, title, clicked, ready;
	OrthographicCamera cam;
	float WIDTH, HEIGHT, XCLICK, YCLICK, VOLUME;
	boolean started;
	private Music sample1, sample2, sample3, sample4, sample5, sample6, sample7, sample8;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("./sprites/midi.png");
		title = new Texture("./sprites/title.png");
		ready = new Texture("./sprites/ready.png");
		clicked = new Texture("./sprites/inuse.png");
		started = false;
		WIDTH = 500;
		HEIGHT = 500;
		VOLUME = 100;
		cam = new OrthographicCamera(WIDTH, HEIGHT);
		cam.translate(WIDTH/2, HEIGHT/2 + HEIGHT);
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		sample1 = Gdx.audio.newMusic(Gdx.files.internal("./music/sample1.wav"));
		sample2 = Gdx.audio.newMusic(Gdx.files.internal("./music/sample2.wav"));
		sample3 = Gdx.audio.newMusic(Gdx.files.internal("./music/sample3.wav"));
		sample4 = Gdx.audio.newMusic(Gdx.files.internal("./music/sample4.wav"));
		sample5 = Gdx.audio.newMusic(Gdx.files.internal("./music/sample5.wav"));
		sample6 = Gdx.audio.newMusic(Gdx.files.internal("./music/sample6.wav"));
		sample7 = Gdx.audio.newMusic(Gdx.files.internal("./music/sample7.wav"));
		sample8 = Gdx.audio.newMusic(Gdx.files.internal("./music/sample8.wav"));
	}

	public void startHandle() {
		if (started == false) {
			if (Gdx.input.isKeyJustPressed(Keys.ENTER)) {
				cam.translate(0, -HEIGHT);
				cam.update();
				batch.setProjectionMatrix(cam.combined);
				started = true;
			}
		}
	}

	public void handleClick(){
		if (Gdx.input.justTouched()) {
			XCLICK = Gdx.input.getX();
			YCLICK = Gdx.input.getY();
			System.out.printf("you clicked at %.0f, %.0f", XCLICK, YCLICK);
			if ((XCLICK <= 70 + 50 && XCLICK >= 70) && (YCLICK <= 70 + 50 && YCLICK >= 70)) {
				sample1.play();
				sample1.setVolume(VOLUME/100);
			} else if ((XCLICK <= 130 + 50 && XCLICK >= 130) && (YCLICK <= 70 + 50 && YCLICK >= 70)) {
				sample2.play();
				sample2.setVolume(VOLUME/100);
			} else if ((XCLICK <= 190 + 50 && XCLICK >= 190) && (YCLICK <= 70 + 50 && YCLICK >= 70)) {
				sample3.play();
				sample3.setVolume(VOLUME/100);
			} else if ((XCLICK <= 250 + 50 && XCLICK >= 250) && (YCLICK <= 70 + 50 && YCLICK >= 70)) {
				sample4.play();
				sample4.setVolume(VOLUME/100);
			} else if ((XCLICK <= 70 + 50 && XCLICK >= 70) && (YCLICK <= 130 + 50 && YCLICK >= 130)) {
				sample5.play();
				sample5.setVolume(VOLUME/100);
			}  else if ((XCLICK <= 130 + 50 && XCLICK >= 130) && (YCLICK <= 130 + 50 && YCLICK >= 130)) {
				sample6.play();
				sample6.setVolume(VOLUME/100);
			} else if ((XCLICK <= 190 + 50 && XCLICK >= 190) && (YCLICK <= 130 + 50 && YCLICK >= 130)) {
				sample7.play();
				sample7.setVolume(VOLUME/100);
			} else if ((XCLICK <= 250 + 50 && XCLICK >= 250) && (YCLICK <= 130 + 50 && YCLICK >= 130)) {
				sample8.play();
				sample8.setVolume(VOLUME/100);
			} else if ((XCLICK == 433 && YCLICK == 87)) {
				VOLUME =- 25;
			} else if (XCLICK == 487 && YCLICK == 89)  {
				VOLUME =+ 25;
			}
		}	
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		startHandle();
		batch.begin();
		batch.draw(title, 0, 500);
		batch.draw(background, 0, 0);
		batch.draw(ready, 70, 70);
		batch.draw(ready, 130, 70);
		batch.draw(ready, 190, 70);
		batch.draw(ready, 250, 70);
		batch.draw(ready, 70, 130);
		batch.draw(ready, 130, 130);
		batch.draw(ready, 190, 130);
		batch.draw(ready, 250, 130);
		batch.end();
		handleClick();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
		sample1.dispose();
		sample2.dispose();
		sample3.dispose();
		sample4.dispose();
		sample5.dispose();
		sample6.dispose();
		sample7.dispose();
		sample8.dispose();
	}
}
