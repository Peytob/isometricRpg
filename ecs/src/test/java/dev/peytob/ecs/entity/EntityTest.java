package dev.peytob.ecs.entity;

import dev.peytob.ecs.component.test.TestComponent1;
import dev.peytob.ecs.component.test.TestComponent2;
import dev.peytob.ecs.exception.EntityException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class EntityTest {

    abstract Entity createNewEntity();

    Entity entity;

    @BeforeEach
    void setUp() {
        entity = createNewEntity();
    }

    @Test
    void isNewEntityIsEmpty() {
        assertTrue(entity.getComponents().isEmpty());
    }

    @Test
    void oneComponentSuccessfullyRegistered() {
        TestComponent1 testComponent1 = new TestComponent1();

        entity.bindComponent(testComponent1);
        Class<? extends TestComponent1> componentType = testComponent1.getClass();

        assertEquals(1, entity.getComponents().size());
        assertNotNull(entity.getComponent(componentType));
    }

    @Test
    void multipleComponentsSuccessfullyRegistered() {
        TestComponent1 testComponent1 = new TestComponent1();
        TestComponent2 testComponent2 = new TestComponent2();

        entity.bindComponent(testComponent1);
        entity.bindComponent(testComponent2);

        assertEquals(2, entity.getComponents().size());
        assertNotNull(entity.getComponent(testComponent1.getClass()));
        assertNotNull(entity.getComponent(testComponent2.getClass()));
    }

    @Test
    void entityExceptionThrowsIfDuplicateComponentRegistered() {
        TestComponent1 testComponent11 = new TestComponent1();
        TestComponent1 testComponent12 = new TestComponent1();

        assertDoesNotThrow(() -> entity.bindComponent(testComponent11));
        assertThrows(EntityException.class, () -> entity.bindComponent(testComponent12));
    }

    @Test
    void componentSuccessfullyRemoved() {
        TestComponent1 testComponent1 = new TestComponent1();
        TestComponent2 testComponent2 = new TestComponent2();

        entity.bindComponent(testComponent1);
        entity.bindComponent(testComponent2);

        assertEquals(2, entity.getComponents().size());
        assertNotNull(entity.getComponent(testComponent1.getClass()));
        assertNotNull(entity.getComponent(testComponent2.getClass()));

        entity.removeComponent(testComponent1.getClass());

        assertEquals(1, entity.getComponents().size());
        assertNull(entity.getComponent(testComponent1.getClass()));
        assertNotNull(entity.getComponent(testComponent2.getClass()));
    }
}