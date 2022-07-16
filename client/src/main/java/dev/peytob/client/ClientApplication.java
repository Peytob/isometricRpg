package dev.peytob.client;

import dev.peytob.client.machine.Game;
import dev.peytob.client.machine.state.GameLibrariesInitializeState;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

public class ClientApplication implements CommandLineRunner {

    @Override
    public void run(String... args) {
        Game game = new Game();
        game.changeGameState(new GameLibrariesInitializeState());
        game.run();
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ClientApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
