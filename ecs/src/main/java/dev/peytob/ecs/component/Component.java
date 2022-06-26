package dev.peytob.ecs.component;

import dev.peytob.ecs.entity.Entity;

import static java.util.Objects.isNull;

public interface Component {

    Entity getEntity();

    void bindEntity(Entity entity);

    default boolean isBoundedToEntity() {
        return isNull(getEntity());
    }
}
