package dev.peytob.ecs.context;

import dev.peytob.ecs.component.ConcurrentComponentManager;
import dev.peytob.ecs.entity.ConcurrentEntityManager;
import dev.peytob.ecs.system.ConcurrentSystemManager;

public final class Contexts {

    private Contexts() {
        throw new UnsupportedOperationException();
    }

    public static EcsContext createContext() {
        ConcurrentEntityManager concurrentEntityManager = new ConcurrentEntityManager();
        ConcurrentComponentManager concurrentComponentManager = new ConcurrentComponentManager();
        ConcurrentSystemManager concurrentSystemManager = new ConcurrentSystemManager();

        return new MutableEcsContext(concurrentEntityManager, concurrentComponentManager, concurrentSystemManager);
    }

    public static EcsContext unmodifiableContext(EcsContext context) {
        if (context instanceof UnmodifiableEcsContext) {
            return context;
        }

        return new UnmodifiableEcsContext(context);
    }
}
