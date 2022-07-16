package dev.peytob.ecs.entity;

import dev.peytob.ecs.exception.EntityException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class ConcurrentEntityManager implements EntityManager {

    private final Collection<Entity> entities;

    public ConcurrentEntityManager() {
        this.entities = Collections.synchronizedCollection(new HashSet<>());
    }

    @Override
    public boolean registerEntity(Entity entity) {
        if (entities.contains(entity)) {
            throw new EntityException("Entity is already registered!", entity);
        }

        return entities.add(entity);
    }

    @Override
    public boolean removeEntity(Entity entity) {
        return entities.remove(entity);
    }

    @Override
    public Collection<Entity> getEntities() {
        return Collections.unmodifiableCollection(entities);
    }

    @Override
    public void clear() {
        entities.clear();
    }
}
