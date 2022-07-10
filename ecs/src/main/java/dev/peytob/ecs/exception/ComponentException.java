package dev.peytob.ecs.exception;

import dev.peytob.ecs.component.Component;

public class ComponentException extends RuntimeException {

    private final Component component;

    public ComponentException(String message, Component component) {
        super(message);
        this.component = component;
    }

    public Component getComponent() {
        return component;
    }
}
