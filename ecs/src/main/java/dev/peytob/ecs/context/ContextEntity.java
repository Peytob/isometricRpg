package dev.peytob.ecs.context;

import dev.peytob.ecs.component.Component;
import dev.peytob.ecs.entity.Entity;

import java.util.Collection;

public class ContextEntity implements Entity {

    private final Entity entity;

    public ContextEntity(Entity entity) {
        this.entity = entity;
    }

    @Override
    public Collection<Component> getComponents() {
        return entity.getComponents();
    }

    @Override
    public <T extends Component> T getComponent(Class<T> componentClass) {
        return entity.getComponent(componentClass);
    }

    @Override
    public <T extends Component> T removeComponent(Class<T> componentClass) {
        return entity.removeComponent(componentClass);
    }

    @Override
    public void bindComponent(Component component) {
        entity.bindComponent(component);
    }
}
