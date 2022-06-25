package dev.peytob.ecs.component;

import java.util.Collection;

public interface ComponentManager {

    <T extends Component> T registerComponent(T component);

    <T extends Component> T removeComponent(T component);

    Collection<Class<? extends Component>> getComponentsTypes();

    Collection<Component> getComponents(Class<? extends Component> componentClass);
}
