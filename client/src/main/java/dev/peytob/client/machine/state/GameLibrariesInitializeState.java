package dev.peytob.client.machine.state;

import dev.peytob.client.annotation.GameMachineState;
import dev.peytob.client.machine.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GameMachineState
public final class GameLibrariesInitializeState implements GameState {

    private final static Logger logger = LoggerFactory.getLogger(GameLibrariesInitializeState.class);

    private final GameLibrariesDestroyingState gameLibrariesDestroyingState;

    public GameLibrariesInitializeState(GameLibrariesDestroyingState gameLibrariesDestroyingState) {
        this.gameLibrariesDestroyingState = gameLibrariesDestroyingState;
    }

    @Override
    public void onStart(Game game) {
        logger.info("Game libraries initializing started");
    }

    @Override
    public void tick(Game game) {
        logger.info("Initializing some libraries...");
        game.changeGameState(gameLibrariesDestroyingState);
    }

    @Override
    public void onEnd(Game game) {
        logger.info("Game libraries initializing completed");
    }
}
