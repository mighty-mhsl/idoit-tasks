package com.idoit.character.npc.enemy;

import com.idoit.meta.character.npc.enemy.SkeletonMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Skeleton")
class SkeletonTest extends EnemyTest {

    @BeforeEach
    void setUp() {
        setMeta(SkeletonMeta.class);
    }

    @DisplayName("Тест, что класс Skeleton находится в пакете com.idoit.character.npc.enemy")
    @Test
    void testSkeletonIsInEnemyPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Skeleton имеет все необходимые поля")
    @Test
    void testSkeletonHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Skeleton есть конструктор принимающий уровень и урон npc")
    @Test
    void testSkeletonHasConstructorWithLevelAndDamageParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields(1, 2);
    }

    @DisplayName("Тест, что в классе Skeleton есть все необходимые методы")
    @Test
    void testSkeletonHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод hit в классе Skeleton наносит урон переданному Knight")
    @Test
    void testHit() {
        testHitMethod();
    }

    @DisplayName("Тест, что метод go в классе Skeleton меняет координаты точки персонажа")
    @Test
    void testGoChangesPointCoordinates() {
        testGo(1, 2);
    }
}
