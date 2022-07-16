package dev.peytob.ecs.context;

import dev.peytob.ecs.component.ComponentsAccessor;
import dev.peytob.ecs.entity.EntitiesAccessor;
import dev.peytob.ecs.entity.Entity;
import dev.peytob.ecs.system.System;

import java.util.Collection;

class UnmodifiableEcsContext implements EcsContext {

    private final EcsContext targetContext;

    public UnmodifiableEcsContext(EcsContext targetContext) {
        this.targetContext = targetContext;
    }

    @Override
    public ComponentsAccessor getComponentsAccessor() {
        return targetContext.getComponentsAccessor();
    }

    @Override
    public EntitiesAccessor getEntitiesAccessor() {
        return targetContext.getEntitiesAccessor();
    }

    @Override
    public Entity newEntity() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeEntity(Entity entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<System> getSystems() {
        return targetContext.getSystems();
    }

    @Override
    public boolean registerSystem(System system) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeSystem(System system) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void executeSystems() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clearEntities() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clearSystems() {
        throw new UnsupportedOperationException();
    }
}
