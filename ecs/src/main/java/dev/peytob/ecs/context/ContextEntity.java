package dev.peytob.ecs.context;

import dev.peytob.ecs.component.Component;
import dev.peytob.ecs.entity.Entity;

import java.util.Collection;

class ContextEntity implements Entity {

    private final Entity entity;

    private final MutableEcsContext context;

    public ContextEntity(Entity entity, MutableEcsContext context) {
        this.entity = entity;
        this.context = context;
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
        T component = entity.removeComponent(componentClass);
        context.getComponentManager().removeComponent(component);
        return component;
    }

    @Override
    public void bindComponent(Component component) {
        entity.bindComponent(component);

        context.getComponentManager().removeComponent(component);
        if (entity.getComponents().isEmpty()) {
            context.getEntityManager().removeEntity(entity);
        }
    }
}
