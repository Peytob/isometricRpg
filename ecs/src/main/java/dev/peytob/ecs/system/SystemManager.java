package dev.peytob.ecs.system;

import dev.peytob.ecs.context.EcsContext;

import java.util.Collection;

public interface SystemManager {

    Collection<System> getSystems();

    boolean registerSystem(System system);

    boolean removeSystem(System system);

    void executeSystems(EcsContext context);
}
