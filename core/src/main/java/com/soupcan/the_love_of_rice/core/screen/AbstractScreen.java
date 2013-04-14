package com.soupcan.the_love_of_rice.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.soupcan.the_love_of_rice.core.TheLoveOfRice;

/**
 * Other screens extend this.
 *
 * @author Zachary Latta
 */
public abstract class AbstractScreen implements Screen
{
    protected final SpriteBatch batch;
    protected final Stage stage;

    public AbstractScreen()
    {
        this.batch = new SpriteBatch();
        this.stage = new Stage(0, 0, true);
        Gdx.input.setInputProcessor(stage);

        stage.setCamera(new OrthographicCamera(1280, 768 - 96));
        stage.getCamera().position.set(1280/2, (768 - 96)/2, 0f);
    }

    protected String getName()
    {
        return getClass().getSimpleName();
    }

    @Override
    public void show()
    {
        Gdx.app.log(TheLoveOfRice.LOG, "Showing screen: " + getName() );
    }

    @Override
    public void resize(int width, int height )
    {
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(206f, 231f, 215f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT );

        // Log dat FPS
        TheLoveOfRice.fpsLogger.log();

        // Update and draw the stage actor
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void hide()
    {
        Gdx.app.log(TheLoveOfRice.LOG, "Hiding screen: " + getName());
    }

    @Override
    public void pause()
    {
        Gdx.app.log(TheLoveOfRice.LOG, "Pausing screen: " + getName());
    }

    @Override
    public void resume()
    {
        Gdx.app.log(TheLoveOfRice.LOG, "Resuming screen: " + getName());
    }

    @Override
    public void dispose()
    {
        Gdx.app.log(TheLoveOfRice.LOG, "Disposing screen: " + getName());

        stage.dispose();
        batch.dispose();
    }
}
