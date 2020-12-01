package uet.oop.bomberman.entities.liveEntities;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import uet.oop.bomberman.audio.MyAudioPlayer;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.graphics.Sprite;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class BomberMulti extends AnimatedEntity {


    private int radius;
    private KeyCode direction = null;
    private int timeAfterDie = 0;

    private int power;

    public BomberMulti(int x, int y, Image img) {
        super( x, y, img);
        setLayer(1);
        setSpeed(2);
        setPower(1);
        setRadius(1);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void update() {

        if (direction == KeyCode.A) {
            goLeft();
        }
        if (direction == KeyCode.D) {
            goRight();
        }
        if (direction == KeyCode.W) {
            goUp();
        }
        if (direction == KeyCode.S) {
            goDown();
        }

        //animate();
        if(!isAlive()) {
            timeAfterDie ++;
            die();
        }
    }

    public void handleKeyPressedEvent(KeyCode keyCode) {

        if (keyCode == KeyCode.W || keyCode == KeyCode.S
                || keyCode == KeyCode.A || keyCode == KeyCode.D) {
            this.direction = keyCode;
        }

    }

    public void handleKeyReleasedEvent(KeyCode keyCode) {
        if (direction == keyCode) {
            if (direction == KeyCode.S) {
                img = Sprite.player2_left.getFxImage();
            }
            if (direction == KeyCode.D) {
                img = Sprite.player2_right.getFxImage();
            }
            if (direction == KeyCode.W) {
                img = Sprite.player2_up.getFxImage();
            }
            if (direction == KeyCode.S) {
                img = Sprite.player2_down.getFxImage();
            }
            direction = null;
        }
    }

    public void goLeft() {
        super.goLeft();
        img = Sprite.movingSprite(Sprite.player2_left, Sprite.player2_left_1, Sprite.player2_left_2, left++, 20).getFxImage();
    }

    public void goRight() {
        super.goRight();
        img = Sprite.movingSprite(Sprite.player2_right, Sprite.player2_right_1, Sprite.player2_right_2, right++, 20).getFxImage();
    }

    public void goUp() {
        super.goUp();
        img = Sprite.movingSprite(Sprite.player2_up, Sprite.player2_up_1, Sprite.player2_up_2, up++, 20).getFxImage();
    }

    public void goDown() {
        super.goDown();
        img = Sprite.movingSprite(Sprite.player2_down, Sprite.player2_down_1, Sprite.player2_down_2, down++, 20).getFxImage();
    }

    public boolean isAlive() {
        return alive;
    }

    public void die() {
        if(timeAfterDie <= 45) {
            img = Sprite.movingSprite(Sprite.player2_dead1, Sprite.player2_dead2,
                    Sprite.player2_dead3, timeAfterDie, 20).getFxImage();
        }

    }


    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Rectangle getBounds() {
        return new Rectangle(desX + 4, desY + 4, Sprite.SCALED_SIZE - 12, Sprite.SCALED_SIZE * 3 / 4);
    }

    public void setCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
