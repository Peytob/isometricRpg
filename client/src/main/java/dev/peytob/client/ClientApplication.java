package dev.peytob.client;

import dev.peytob.client.machine.Game;
import dev.peytob.client.machine.state.GameLibrariesInitializeState;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@ComponentScan
public class ClientApplication implements CommandLineRunner {

    private final GameLibrariesInitializeState gameLibrariesInitializeState;
    private final Game game;

    public ClientApplication(GameLibrariesInitializeState gameLibrariesInitializeState, Game game) {
        this.gameLibrariesInitializeState = gameLibrariesInitializeState;
        this.game = game;
    }

    @Override
    public void run(String... args) {
        game.changeGameState(gameLibrariesInitializeState);
        game.run();
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ClientApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
