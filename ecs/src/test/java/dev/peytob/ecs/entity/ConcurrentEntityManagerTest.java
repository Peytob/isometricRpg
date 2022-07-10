package dev.peytob.ecs.entity;

public class ConcurrentEntityManagerTest extends EntityManagerTest {

    @Override
    EntityManager createEntityManager() {
        return new ConcurrentEntityManager();
    }
}
