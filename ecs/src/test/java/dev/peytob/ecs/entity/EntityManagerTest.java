package dev.peytob.ecs.entity;

import dev.peytob.ecs.entity.test.TestEntity1;
import dev.peytob.ecs.entity.test.TestEntity2;
import dev.peytob.ecs.exception.EntityException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class EntityManagerTest {

    abstract EntityManager createEntityManager();

    @Test
    void newEntityManagerIsEmpty() {
        EntityManager entityManager = createEntityManager();

        assertTrue(entityManager.getEntitiesTypes().isEmpty());
    }

    @Test
    void oneEntityRegisteredSuccessfully() {
        EntityManager entityManager = createEntityManager();
        TestEntity1 testEntity1 = new TestEntity1();

        entityManager.registerEntity(testEntity1);

        assertEquals(1, entityManager.getEntitiesTypes().size());
        assertTrue(entityManager.getEntitiesTypes().contains(TestEntity1.class));
        assertTrue(entityManager.getEntities(TestEntity1.class).contains(testEntity1));
    }

    @Test
    void multipleEntitySuccessfullyRegistered() {
        EntityManager entityManager = createEntityManager();
        TestEntity1 testEntity1 = new TestEntity1();
        TestEntity2 testEntity2 = new TestEntity2();

        entityManager.registerEntity(testEntity1);
        entityManager.registerEntity(testEntity2);

        assertEquals(2, entityManager.getEntitiesTypes().size());
        assertTrue(entityManager.getEntitiesTypes().contains(testEntity1.getClass()));
        assertTrue(entityManager.getEntitiesTypes().contains(testEntity2.getClass()));

        assertEquals(1, entityManager.getEntities(testEntity1.getClass()).size());
        assertTrue(entityManager.getEntities(testEntity1.getClass()).contains(testEntity1));
        assertEquals(1, entityManager.getEntities(testEntity2.getClass()).size());
        assertTrue(entityManager.getEntities(testEntity2.getClass()).contains(testEntity2));
    }

    @Test
    void removingEntityIsSuccessfully() {
        EntityManager entityManager = createEntityManager();
        TestEntity1 testEntity11 = new TestEntity1();
        TestEntity1 testEntity12 = new TestEntity1();

        entityManager.registerEntity(testEntity11);
        entityManager.registerEntity(testEntity12);

        assertEquals(2, entityManager.getEntities(TestEntity1.class).size());

        entityManager.removeEntity(testEntity11);

        assertEquals(1, entityManager.getEntities(TestEntity1.class).size());
        assertTrue(entityManager.getEntities(TestEntity1.class).contains(testEntity12));
        assertFalse(entityManager.getEntities(TestEntity1.class).contains(testEntity11));
    }

    @Test
    void removingEntityReturnsCurrentValue() {
        EntityManager entityManager = createEntityManager();
        TestEntity1 testEntity1 = new TestEntity1();

        entityManager.registerEntity(testEntity1);
        assertTrue(entityManager.removeEntity(testEntity1));
        assertFalse(entityManager.removeEntity(testEntity1));
    }

    @Test
    void registeringAlreadyRegisteredEntityThrowsException() {
        EntityManager entityManager = createEntityManager();
        TestEntity1 testEntity1 = new TestEntity1();

        assertDoesNotThrow(() -> entityManager.registerEntity(testEntity1));
        assertThrows(EntityException.class, () -> entityManager.registerEntity(testEntity1));
    }
}
