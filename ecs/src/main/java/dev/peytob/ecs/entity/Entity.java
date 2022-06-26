package dev.peytob.ecs.entity;

import dev.peytob.ecs.component.Component;

import java.util.Collection;

public interface Entity {

    Collection<Component> getComponents();

    <T extends Component> T getComponent(Class<T> componentClass);

    <T extends Component> T removeComponent(Class<T> componentClass);

    @SuppressWarnings("unchecked")
    // According to the contract, objects in values must be cast to the types in the key
    default <T extends Component> T removeComponent(T component) {
        return (T) removeComponent(component.getClass());
    }

    <T extends Component> T bindComponent(T component);
}
