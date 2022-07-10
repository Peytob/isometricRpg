package dev.peytob.ecs.system;

import dev.peytob.ecs.context.EcsContext;

import java.util.Collection;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class ConcurrentSystemManager implements SystemManager {

    private final SortedSet<System> systems;

    public ConcurrentSystemManager() {
        this.systems = Collections.synchronizedSortedSet(new TreeSet<>());
    }

    @Override
    public Collection<System> getSystems() {
        return Collections.unmodifiableCollection(systems);
    }

    @Override
    public boolean registerSystem(System system) {
        return systems.add(system);
    }

    @Override
    public boolean removeSystem(System system) {
        return systems.remove(system);
    }

    @Override
    public void executeSystems(EcsContext context) {
        systems.forEach(system -> system.execute(context));
    }
}
