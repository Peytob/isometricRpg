package dev.peytob.ecs.system;

import dev.peytob.ecs.system.test.CollectionAdderSystem;
import dev.peytob.ecs.system.test.JustOrderedSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

abstract class SystemManagerTest {

    abstract SystemManager createNewSystemManager();

    SystemManager systemManager;

    @BeforeEach
    void setUp() {
        systemManager = createNewSystemManager();
    }

    @Test
    void newSystemManagerIsEmpty() {
        assertTrue(systemManager.getSystems().isEmpty());
    }

    @Test
    void systemSuccessfullyRegistered() {
        System system = new JustOrderedSystem(1);

        assertTrue(systemManager.registerSystem(system));
        assertEquals(1, systemManager.getSystems().size());
    }

    @Test
    void systemsHasCorrectOrder() {
        System first = new JustOrderedSystem(5);
        System second = new JustOrderedSystem(10);
        System third = new JustOrderedSystem(66);

        systemManager.registerSystem(first);
        systemManager.registerSystem(second);
        systemManager.registerSystem(third);

        Collection<System> systems = systemManager.getSystems();
        List<System> expected = List.of(first, second, third);
        assertIterableEquals(expected, systems);
    }

    @Test
    void systemExecutesInRightOrder() {
        List<String> orderMemory = new ArrayList<>(3);

        String firstObject = "a";
        String secondObject = "c";
        String thirdObject = "d";

        System first = new CollectionAdderSystem<>(orderMemory, firstObject, 1);
        System second = new CollectionAdderSystem<>(orderMemory, secondObject, 2);
        System third = new CollectionAdderSystem<>(orderMemory, thirdObject, 3);

        systemManager.registerSystem(first);
        systemManager.registerSystem(second);
        systemManager.registerSystem(third);

        systemManager.executeSystems(null);

        List<String> expected = List.of(firstObject, secondObject, thirdObject);
        assertIterableEquals(expected, orderMemory);
    }

    @Test
    void systemCorrectlyRemoved() {
        System first = new JustOrderedSystem(1);
        System second = new JustOrderedSystem(2);
        System third = new JustOrderedSystem(3);

        systemManager.registerSystem(first);
        systemManager.registerSystem(second);
        systemManager.registerSystem(third);

        systemManager.removeSystem(second);

        assertEquals(2, systemManager.getSystems().size());
        assertIterableEquals(List.of(first, third), systemManager.getSystems());
    }
}