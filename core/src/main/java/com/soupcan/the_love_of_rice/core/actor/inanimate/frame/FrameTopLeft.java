package com.soupcan.the_love_of_rice.core.actor.inanimate.frame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.soupcan.the_love_of_rice.core.manager.SpriteManager;

/**
 * The top left corner of the frame. Kill me for being inefficient.
 *
 * @author Zachary Latta
 */
public class FrameTopLeft extends Actor
{
    private Sprite sprite;

    public FrameTopLeft()
    {
        sprite = SpriteManager.instance.getSprite("frame_top_l");
    }

    public void draw(SpriteBatch batch, float parentAlpha)
    {
        sprite.setPosition(getX(), getY());
        sprite.setOrigin(sprite.getX() + sprite.getWidth(), sprite.getY() + sprite.getHeight());
        sprite.setRotation(getRotation());

        setSize(sprite.getWidth(), sprite.getHeight());
        setOrigin(sprite.getOriginX(), sprite.getOriginY());

        sprite.draw(batch);
    }
}
