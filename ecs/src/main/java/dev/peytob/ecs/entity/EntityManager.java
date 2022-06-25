package dev.peytob.ecs.entity;

import java.util.Collection;

public interface EntityManager {

    <T extends Entity> T registerEntity(T entity);

    <T extends Entity> T removeEntity(T entity);

    Collection<Class<? extends Entity>> getEntitiesTypes();

    Collection<Entity> getEntities(Class<? extends Entity> entityClass);
}
