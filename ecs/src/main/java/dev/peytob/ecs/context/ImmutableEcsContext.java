package dev.peytob.ecs.context;

import dev.peytob.ecs.component.Component;
import dev.peytob.ecs.component.ComponentsAccessor;
import dev.peytob.ecs.entity.EntitiesAccessor;
import dev.peytob.ecs.entity.Entity;
import dev.peytob.ecs.system.System;

import java.util.List;

public class ImmutableEcsContext implements EcsContext {

    private final EcsContext targetContext;

    public ImmutableEcsContext(EcsContext targetContext) {
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
    public <T extends Component> T registerComponent(T component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T extends Entity> T registerEntity(T entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T extends Component> T removeComponent(T component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T extends Entity> T removeEntity(T entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<System> getSystems() {
        return targetContext.getSystems();
    }

    @Override
    public <T extends System> T registerSystem(T system) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T extends System> T removeSystem(T system) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void executeSystems() {
        targetContext.executeSystems();
    }
}
