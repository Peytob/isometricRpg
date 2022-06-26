package dev.peytob.ecs.entity;

import dev.peytob.ecs.component.Component;
import dev.peytob.ecs.exception.EntityException;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractEntity implements Entity {

    private final Map<Class<? extends Component>, Component> components;

    public AbstractEntity() {
        this.components = new ConcurrentHashMap<>();
    }

    @Override
    public Collection<Component> getComponents() {
        return components.values();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Component> T getComponent(Class<T> componentClass) {
        Component component = components.get(componentClass);
        return component == null ? null : (T) component;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Component> T removeComponent(Class<T> componentClass) {
        Component component = components.remove(componentClass);
        return component == null ? null : (T) component;
    }

    @Override
    public <T extends Component> T bindComponent(T component) {
        Class<? extends Component> componentClass = component.getClass();

        if (components.containsKey(componentClass)) {
            throw new EntityException("Entity already contains component with type " + componentClass.getSimpleName(), this);
        }

        return component;
    }
}
