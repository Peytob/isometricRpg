package dev.peytob.ecs.system.test;

import dev.peytob.ecs.context.EcsContext;
import dev.peytob.ecs.system.System;

import java.util.Collection;

public class CollectionAdderSystem<T> implements System {

    private final Collection<T> collection;

    private final T targetObject;

    private final Integer order;

    public CollectionAdderSystem(Collection<T> collection, T targetObject, Integer order) {
        this.collection = collection;
        this.targetObject = targetObject;
        this.order = order;
    }

    @Override
    public void execute(EcsContext context) {
        collection.add(targetObject);
    }

    @Override
    public Integer getOrder() {
        return order;
    }
}
