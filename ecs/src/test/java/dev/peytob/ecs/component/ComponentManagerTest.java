package dev.peytob.ecs.component;

import dev.peytob.ecs.component.test.TestComponent1;
import dev.peytob.ecs.component.test.TestComponent2;
import dev.peytob.ecs.exception.ComponentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class ComponentManagerTest {

    abstract ComponentManager createNewComponentManager();

    ComponentManager componentManager;

    @BeforeEach
    void setUp() {
        componentManager = createNewComponentManager();
    }

    @Test
    void newComponentManagerIsEmpty() {
        assertTrue(componentManager.getComponentsTypes().isEmpty());
    }

    @Test
    void oneComponentSuccessfullyRegistered() {
        TestComponent1 testComponent1 = new TestComponent1();

        componentManager.registerComponent(testComponent1);
        Class<? extends TestComponent1> componentType = testComponent1.getClass();

        assertEquals(1, componentManager.getComponentsTypes().size());
        assertTrue(componentManager.getComponentsTypes().contains(componentType));
        assertEquals(1, componentManager.getComponents(componentType).size());

        Component resultComponent = componentManager.getComponents(componentType).stream()
                .findFirst()
                .orElseThrow();
        assertEquals(testComponent1, resultComponent);
    }

    @Test
    void multipleComponentsSuccessfullyRegistered() {
        TestComponent1 testComponent1 = new TestComponent1();
        TestComponent2 testComponent2 = new TestComponent2();

        componentManager.registerComponent(testComponent1);
        componentManager.registerComponent(testComponent2);

        assertEquals(2, componentManager.getComponentsTypes().size());
        assertTrue(componentManager.getComponentsTypes().contains(testComponent1.getClass()));
        assertTrue(componentManager.getComponentsTypes().contains(testComponent2.getClass()));

        assertEquals(1, componentManager.getComponents(testComponent1.getClass()).size());
        assertTrue(componentManager.getComponents(testComponent1.getClass()).contains(testComponent1));
        assertEquals(1, componentManager.getComponents(testComponent2.getClass()).size());
        assertTrue(componentManager.getComponents(testComponent2.getClass()).contains(testComponent2));
    }

    @Test
    void multipleSomeTypeComponentsRegisteringIsSuccessfully() {
        TestComponent1 testComponent11 = new TestComponent1();
        TestComponent1 testComponent12 = new TestComponent1();

        componentManager.registerComponent(testComponent11);
        componentManager.registerComponent(testComponent12);

        assertEquals(1, componentManager.getComponentsTypes().size());
        assertEquals(2, componentManager.getComponents(TestComponent1.class).size());
        assertTrue(componentManager.getComponents(TestComponent1.class).contains(testComponent11));
        assertTrue(componentManager.getComponents(TestComponent1.class).contains(testComponent12));
    }

    @Test
    void removingComponentIsSuccessfully() {
        TestComponent1 testComponent11 = new TestComponent1();
        TestComponent1 testComponent12 = new TestComponent1();

        componentManager.registerComponent(testComponent11);
        componentManager.registerComponent(testComponent12);

        assertEquals(2, componentManager.getComponents(TestComponent1.class).size());

        componentManager.removeComponent(testComponent11);

        assertEquals(1, componentManager.getComponents(TestComponent1.class).size());
        assertTrue(componentManager.getComponents(TestComponent1.class).contains(testComponent12));
        assertFalse(componentManager.getComponents(TestComponent1.class).contains(testComponent11));
    }

    @Test
    void removingComponentReturnsCurrentValue() {
        TestComponent1 testComponent1 = new TestComponent1();

        componentManager.registerComponent(testComponent1);
        assertTrue(componentManager.removeComponent(testComponent1));
        assertFalse(componentManager.removeComponent(testComponent1));
    }

    @Test
    void registeringAlreadyRegisteredComponentThrowsException() {
        TestComponent1 testComponent1 = new TestComponent1();

        assertDoesNotThrow(() -> componentManager.registerComponent(testComponent1));
        assertThrows(ComponentException.class, () -> componentManager.registerComponent(testComponent1));
    }

    @Test
    void componentManagerIsEmptyAfterClear() {
        componentManager.registerComponent(new TestComponent1());
        componentManager.registerComponent(new TestComponent1());
        componentManager.registerComponent(new TestComponent2());
        componentManager.registerComponent(new TestComponent2());

        assertEquals(2, componentManager.getComponentsTypes().size());
        assertEquals(2, componentManager.getComponents(TestComponent1.class).size());
        assertEquals(2, componentManager.getComponents(TestComponent2.class).size());

        componentManager.clear();

        assertTrue(componentManager.getComponentsTypes().isEmpty());
        assertTrue(componentManager.getComponents(TestComponent1.class).isEmpty());
        assertTrue(componentManager.getComponents(TestComponent2.class).isEmpty());
    }
}