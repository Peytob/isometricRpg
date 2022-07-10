package dev.peytob.ecs.entity;

import dev.peytob.ecs.component.Component;

import java.util.Collection;

public interface Entity {

    Collection<Component> getComponents();

    <T extends Component> T getComponent(Class<T> componentClass);

    <T extends Component> T removeComponent(Class<T> componentClass);

    void bindComponent(Component component);
}
