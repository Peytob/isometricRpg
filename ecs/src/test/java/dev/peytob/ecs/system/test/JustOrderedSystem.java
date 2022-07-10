package dev.peytob.ecs.system.test;

import dev.peytob.ecs.context.EcsContext;
import dev.peytob.ecs.system.System;

public class JustOrderedSystem implements System {

    private final Integer order;

    public JustOrderedSystem(Integer order) {
        this.order = order;
    }

    @Override
    public void execute(EcsContext context) { }

    @Override
    public Integer getOrder() {
        return order;
    }
}
