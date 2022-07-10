package dev.peytob.ecs.entity;

import java.util.Collection;

import static java.util.Objects.requireNonNull;

public class EntitiesAccessor {

    private final EntityManager entityManager;

    public EntitiesAccessor(EntityManager entityManager) {
        this.entityManager = requireNonNull(entityManager);
    }

    public Collection<Entity> getEntities() {
        return entityManager.getEntities();
    }
}
