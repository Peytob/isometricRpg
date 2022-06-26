package dev.peytob.ecs.component;

public class ConcurrentComponentManagerTest extends ComponentManagerTest {

    @Override
    ComponentManager createNewComponentManager() {
        return new ConcurrentComponentManager();
    }
}
