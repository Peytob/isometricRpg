package dev.peytob.ecs.component;

import dev.peytob.ecs.exception.ComponentException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentComponentManager implements ComponentManager {

    private final Map<Class<? extends Component>, Collection<Component>> components;

    public ConcurrentComponentManager() {
        this.components = new ConcurrentHashMap<>();
    }

    @Override
    public void registerComponent(Component component) {
        Class<? extends Component> componentClass = component.getClass();
        components.putIfAbsent(componentClass, Collections.synchronizedCollection(new HashSet<>()));
        Collection<Component> componentsByClass = components.get(componentClass);

        if (componentsByClass.contains(component)) {
            throw new ComponentException("Component is already registered!", component);
        }

        componentsByClass.add(component);
    }

    @Override
    public boolean removeComponent(Component component) {
        Class<? extends Component> componentClass = component.getClass();
        Collection<Component> componentsByClass = components.get(componentClass);
        return componentsByClass != null && componentsByClass.remove(component);
    }

    @Override
    public Collection<Class<? extends Component>> getComponentsTypes() {
        return components.keySet();
    }

    @Override
    public Collection<Component> getComponents(Class<? extends Component> componentClass) {
        Collection<Component> componentsByClass = components.get(componentClass);
        return componentsByClass == null ? Collections.emptySet() : componentsByClass;
    }
}
