package dev.peytob.client;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

public class ClientApplication implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("Hello world!");
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ClientApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
