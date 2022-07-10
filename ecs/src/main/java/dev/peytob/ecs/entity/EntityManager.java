package dev.peytob.ecs.entity;

import java.util.Collection;

public interface EntityManager {

    boolean registerEntity(Entity entity);

    boolean removeEntity(Entity entity);

    Collection<Entity> getEntities();
}
