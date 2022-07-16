package dev.peytob.client.machine.state;

import dev.peytob.client.machine.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class GameLibrariesInitializeState implements GameState {

    private final static Logger logger = LoggerFactory.getLogger(GameLibrariesInitializeState.class);

    @Override
    public void onStart(Game game) {
        logger.info("Game libraries initializing started");
    }

    @Override
    public void tick(Game game) {
        logger.info("Initializing some libraries...");
        game.changeGameState(new GameLibrariesDestroyingState());
    }

    @Override
    public void onEnd(Game game) {
        logger.info("Game libraries initializing completed");
    }
}
