package dev.peytob.ecs.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class EntityManagerTest {

    abstract EntityManager createEntityManager();

    EntityManager entityManager;

    @BeforeEach
    void setUp() {
        entityManager = createEntityManager();
    }

    @Test
    void newEntityManagerIsEmpty() {
        assertTrue(entityManager.getEntities().isEmpty());
    }

    @Test
    void entitySuccessfullyRegistered() {
        Entity entity = new GenericEntity();
        assertTrue(entityManager.registerEntity(entity));
        assertEquals(1, entityManager.getEntities().size());
    }

    @Test
    void entitySuccessfullyRemoved() {
        Entity first = new GenericEntity();
        Entity second = new GenericEntity();
        Entity third = new GenericEntity();

        entityManager.registerEntity(first);
        entityManager.registerEntity(second);
        entityManager.registerEntity(third);

        entityManager.removeEntity(second);

        assertEquals(2, entityManager.getEntities().size());
        assertTrue(entityManager.getEntities().contains(first));
        assertTrue(entityManager.getEntities().contains(third));
    }
}