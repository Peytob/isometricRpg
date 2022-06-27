package dev.peytob.ecs.entity;

import java.util.Collection;

public interface EntityManager {

    void registerEntity(Entity entity);

    boolean removeEntity(Entity entity);

    Collection<Class<? extends Entity>> getEntitiesTypes();

    Collection<Entity> getEntities(Class<? extends Entity> entityClass);
}
