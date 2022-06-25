package dev.peytob.ecs.entity;

import java.util.Collection;

import static java.util.Objects.requireNonNull;

public class EntitiesAccessor {

    private final EntityManager entityManager;

    public EntitiesAccessor(EntityManager entityManager) {
        this.entityManager = requireNonNull(entityManager);
    }

    public Collection<Class<? extends Entity>> getEntitiesTypes() {
        return entityManager.getEntitiesTypes();
    }

    public Collection<Entity> getEntities(Class<? extends Entity> entityClass) {
        return entityManager.getEntities(entityClass);
    }
}
