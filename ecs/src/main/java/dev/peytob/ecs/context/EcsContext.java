package dev.peytob.ecs.context;

import dev.peytob.ecs.component.Component;
import dev.peytob.ecs.component.ComponentsAccessor;
import dev.peytob.ecs.entity.EntitiesAccessor;
import dev.peytob.ecs.entity.Entity;
import dev.peytob.ecs.system.System;

import java.util.List;

public interface EcsContext {

    ComponentsAccessor getComponentsAccessor();

    EntitiesAccessor getEntitiesAccessor();

    <T extends Component> T registerComponent(T component);

    <T extends Entity> T registerEntity(T entity);

    <T extends Component> T removeComponent(T component);

    <T extends Entity> T removeEntity(T entity);

    List<System> getSystems();

    <T extends System> T registerSystem(T system);

    <T extends System> T removeSystem(T system);

    void executeSystems();

}
