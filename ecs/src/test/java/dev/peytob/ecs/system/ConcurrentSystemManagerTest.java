package dev.peytob.ecs.system;

public class ConcurrentSystemManagerTest extends SystemManagerTest {

    @Override
    SystemManager createNewSystemManager() {
        return new ConcurrentSystemManager();
    }
}
