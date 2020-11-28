package uet.oop.bomberman.entities.liveEntities.enemies;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.AnimatedEntity;

public abstract class Enemy extends AnimatedEntity {
    protected int startX;
    protected int startY;
    public Enemy(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        setLayer(1);
    }

    public abstract void generateDirection();

}
