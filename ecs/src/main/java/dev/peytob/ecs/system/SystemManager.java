package dev.peytob.ecs.system;

import dev.peytob.ecs.context.EcsContext;

import java.util.List;

public interface SystemManager {

    List<System> getSystems();

    <T extends System> T registerSystem(T system);

    <T extends System> T removeSystem(T system);

    void executeSystems(EcsContext context);
}
