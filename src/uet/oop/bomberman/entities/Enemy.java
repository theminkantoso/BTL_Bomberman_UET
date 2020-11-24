package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public abstract class Enemy extends AnimatedEntity {
    public Enemy(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        setLayer(1);
    }
}
