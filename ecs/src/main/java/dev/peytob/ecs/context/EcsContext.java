package dev.peytob.ecs.context;

import dev.peytob.ecs.component.ComponentsAccessor;
import dev.peytob.ecs.entity.EntitiesAccessor;
import dev.peytob.ecs.entity.Entity;
import dev.peytob.ecs.system.System;

import java.util.Collection;

public interface EcsContext {

    ComponentsAccessor getComponentsAccessor();

    EntitiesAccessor getEntitiesAccessor();

    Entity newEntity();

    boolean removeEntity(Entity entity);

    Collection<System> getSystems();

    boolean registerSystem(System system);

    boolean removeSystem(System system);

    void executeSystems();

    void clearEntities();

    void clearSystems();

}
