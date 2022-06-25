package dev.peytob.ecs.system;

import dev.peytob.ecs.context.EcsContext;

public interface System extends Comparable<System> {

    void execute(EcsContext context);

    Integer getOrder();

    @Override
    default int compareTo(System other) {
        return getOrder().compareTo(other.getOrder());
    }
}
