package dev.peytob.ecs.exception;

import dev.peytob.ecs.entity.Entity;

public class EntityException extends RuntimeException {

    private final Entity entity;

    public EntityException(Entity entity) {
        this.entity = entity;
    }

    public EntityException(String message, Entity entity) {
        super(message);
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }
}
