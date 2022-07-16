package dev.peytob.ecs.context;

import dev.peytob.ecs.component.ComponentManager;
import dev.peytob.ecs.component.ComponentsAccessor;
import dev.peytob.ecs.entity.EntitiesAccessor;
import dev.peytob.ecs.entity.Entity;
import dev.peytob.ecs.entity.EntityManager;
import dev.peytob.ecs.entity.GenericEntity;
import dev.peytob.ecs.system.System;
import dev.peytob.ecs.system.SystemManager;

import java.util.Collection;

class MutableEcsContext implements EcsContext {

    private final EntityManager entityManager;

    private final ComponentManager componentManager;

    private final ComponentsAccessor componentsAccessor;

    private final EntitiesAccessor entitiesAccessor;

    private final SystemManager systemManager;

    MutableEcsContext(EntityManager entityManager, ComponentManager componentManager, SystemManager systemManager) {
        this.entityManager = entityManager;
        this.componentManager = componentManager;
        this.systemManager = systemManager;

        this.componentsAccessor = new ComponentsAccessor(this.componentManager);
        this.entitiesAccessor = new EntitiesAccessor(this.entityManager);
    }

    @Override
    public ComponentsAccessor getComponentsAccessor() {
        return componentsAccessor;
    }

    @Override
    public EntitiesAccessor getEntitiesAccessor() {
        return entitiesAccessor;
    }

    @Override
    public Entity newEntity() {
        GenericEntity genericEntity = new GenericEntity();
        return new ContextEntity(genericEntity, this);
    }

    @Override
    public boolean removeEntity(Entity entity) {
        entity.getComponents().forEach(componentManager::removeComponent);
        return entityManager.removeEntity(entity);
    }

    @Override
    public Collection<System> getSystems() {
        return systemManager.getSystems();
    }

    @Override
    public boolean registerSystem(System system) {
        return systemManager.registerSystem(system);
    }

    @Override
    public boolean removeSystem(System system) {
        return systemManager.removeSystem(system);
    }

    @Override
    public void executeSystems() {
        systemManager.executeSystems(this);
    }

    @Override
    public void clearEntities() {
        entityManager.clear();
        componentManager.clear();
    }

    @Override
    public void clearSystems() {
        systemManager.clear();
    }

    EntityManager getEntityManager() {
        return entityManager;
    }

    ComponentManager getComponentManager() {
        return componentManager;
    }
}
