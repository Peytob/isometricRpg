package dev.peytob.ecs.component;

import java.util.Collection;

public interface ComponentManager {

   boolean registerComponent(Component component);

   boolean removeComponent(Component component);

    Collection<Class<? extends Component>> getComponentsTypes();

    Collection<Component> getComponents(Class<? extends Component> componentClass);
}
