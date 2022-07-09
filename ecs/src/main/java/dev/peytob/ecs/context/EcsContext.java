package dev.peytob.ecs.context;

import dev.peytob.ecs.component.ComponentsAccessor;
import dev.peytob.ecs.entity.EntitiesAccessor;
import dev.peytob.ecs.entity.Entity;
import dev.peytob.ecs.system.System;

import java.util.List;

public interface EcsContext {

    ComponentsAccessor getComponentsAccessor();

    EntitiesAccessor getEntitiesAccessor();

    Entity newEntity();

    Entity removeEntity(Entity entity);

    List<System> getSystems();

    <T extends System> T registerSystem(T system);

    <T extends System> T removeSystem(T system);

    void executeSystems();

}
