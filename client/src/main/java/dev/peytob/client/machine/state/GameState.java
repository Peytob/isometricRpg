package dev.peytob.client.machine.state;

import dev.peytob.client.machine.Game;

public interface GameState {

    void onStart(Game game);

    void tick(Game game);

    void onEnd(Game game);

    default String getName() {
        return getClass().getSimpleName();
    }
}
