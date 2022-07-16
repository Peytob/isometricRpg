package dev.peytob.client.machine;

import dev.peytob.client.machine.state.GameState;
import dev.peytob.ecs.context.Contexts;
import dev.peytob.ecs.context.EcsContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public final class Game {

    private static final Logger logger = LoggerFactory.getLogger(Game.class);

    private GameState gameState;
    private final EcsContext context;
    private boolean isGameRunning;

    public Game() {
        this.gameState = null;
        this.isGameRunning = true;
        this.context = Contexts.createContext();
    }

    public void changeGameState(GameState gameState) {
        Objects.requireNonNull(gameState, "Game state must be not null");

        logger.info("Changing game state to {}", gameState.getName());

        if (this.gameState != null) {
            this.gameState.onEnd(this);
        }

        context.clearEntities();
        context.clearSystems();

        this.gameState = gameState;
        this.gameState.onStart(this);
    }

    public void run() {
        Objects.requireNonNull(gameState, "You should set game state before running the game");

        while (isGameRunning) {
            tick();
        }
    }

    public void exit() {
        this.isGameRunning = false;
    }

    private void tick() {
        gameState.tick(this);
    }
}
