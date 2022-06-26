package dev.peytob.ecs.entity;

import dev.peytob.ecs.exception.EntityException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentEntityManager implements EntityManager {

    private final Map<Class<? extends Entity>, Collection<Entity>> entities;

    public ConcurrentEntityManager() {
        this.entities = new ConcurrentHashMap<>();
    }

    @Override
    public boolean registerEntity(Entity entity) {
        Class<? extends Entity> entityClass = entity.getClass();
        entities.putIfAbsent(entityClass, new HashSet<>());
        Collection<Entity> entitiesByClass = entities.get(entityClass);

        if (entitiesByClass.contains(entity)) {
            throw new EntityException("Entity already registered!", entity);
        }

        return entitiesByClass.add(entity);
    }

    @Override
    public boolean removeEntity(Entity entity) {
        Class<? extends Entity> entityClass = entity.getClass();
        Collection<Entity> entitiesByClass = entities.get(entityClass);
        return entitiesByClass != null && entitiesByClass.remove(entity);
    }

    @Override
    public Collection<Class<? extends Entity>> getEntitiesTypes() {
        return entities.keySet();
    }

    @Override
    public Collection<Entity> getEntities(Class<? extends Entity> entityClass) {
        Collection<Entity> entitiesByClass = entities.get(entityClass);
        return entitiesByClass == null ? Collections.emptySet() : entitiesByClass;
    }
}
