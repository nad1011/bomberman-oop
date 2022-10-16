package com.myproject.bomberman;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;

public class PlantBombAnimationComponent extends Component {
    private AnimationChannel unActiveBomb;
    private AnimationChannel flameCore;
    private AnimatedTexture mainFrame;
    private boolean active;

    public PlantBombAnimationComponent(String assetName) {
        unActiveBomb = new AnimationChannel(FXGL.image(assetName),
                3, 32, 32, Duration.seconds(0.3), 0, 2);
        flameCore = new AnimationChannel(FXGL.image("flameCore.png"),
                7, 32, 32, Duration.seconds(1), 0, 6);
        mainFrame = new AnimatedTexture(unActiveBomb);
        mainFrame.loopAnimationChannel(unActiveBomb);
    }

    public AnimatedTexture getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(AnimatedTexture mainFrame) {
        this.mainFrame = mainFrame;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setBombExplosion() {
        mainFrame.playAnimationChannel(flameCore);
    }
}
