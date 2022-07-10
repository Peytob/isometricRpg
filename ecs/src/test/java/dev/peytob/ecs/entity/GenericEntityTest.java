package dev.peytob.ecs.entity;

public class GenericEntityTest extends EntityTest {

    @Override
    Entity createNewEntity() {
        return new GenericEntity();
    }
}
