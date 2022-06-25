package dev.peytob.ecs.component;

import java.util.Collection;

import static java.util.Objects.requireNonNull;

public class ComponentsAccessor {

    private final ComponentManager componentManager;

    public ComponentsAccessor(ComponentManager componentManager) {
        this.componentManager = requireNonNull(componentManager);
    }

    public Collection<Class<? extends Component>> getComponentTypes() {
        return componentManager.getComponentsTypes();
    }

    public Collection<Component> getComponents(Class<? extends Component> componentClass) {
        return componentManager.getComponents(componentClass);
    }
}
