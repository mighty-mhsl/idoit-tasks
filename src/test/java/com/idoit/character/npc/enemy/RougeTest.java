package com.idoit.character.npc.enemy;

import com.idoit.meta.character.npc.enemy.RougeMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Rouge")
class RougeTest extends EnemyTest {

    @BeforeEach
    void setUp() {
        setMeta(RougeMeta.class);
    }

    @DisplayName("Тест, что класс Rouge находится в пакете com.idoit.character.npc.enemy")
    @Test
    void testRougeIsInEnemyPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Rouge имеет все необходимые поля")
    @Test
    void testRougeHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Rouge есть конструктор принимающий уровень и урон npc")
    @Test
    void testRougeHasConstructorWithLevelAndDamageParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields(1, 2);
    }

    @DisplayName("Тест, что в классе Rouge есть все необходимые методы")
    @Test
    void testRougeHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод hit в классе Rouge наносит урон переданному Knight")
    @Test
    void testHit() {
        testHitMethod();
    }

    @DisplayName("Тест, что метод go в классе Rouge меняет координаты точки персонажа")
    @Test
    void testGoChangesPointCoordinates() {
        testGo(1, 2);
    }
}
