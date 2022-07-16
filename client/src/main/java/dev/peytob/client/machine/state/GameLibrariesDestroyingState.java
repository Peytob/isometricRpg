package dev.peytob.client.machine.state;

import dev.peytob.client.machine.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class GameLibrariesDestroyingState implements GameState {

    private static final Logger logger = LoggerFactory.getLogger(GameLibrariesDestroyingState.class);

    @Override
    public void onStart(Game game) {
        logger.info("Game libraries destroying started");
    }

    @Override
    public void tick(Game game) {
        logger.info("Destroying some libraries...");
        game.exit();
    }

    @Override
    public void onEnd(Game game) {
        logger.info("Game libraries destroying completed");
    }
}
