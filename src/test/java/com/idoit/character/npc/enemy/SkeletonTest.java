package com.idoit.character.npc.enemy;

import com.idoit.character.AbstractCharacterTest;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.character.npc.enemy.SkeletonMeta;
import com.idoit.meta.profile.ProfileMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Skeleton")
class SkeletonTest extends AbstractCharacterTest {

    private SkeletonMeta.EnemyLook enemy;

    @BeforeEach
    void setUp() {
        setMeta(SkeletonMeta.class);
        SkeletonMeta meta = (SkeletonMeta) getMeta();
        enemy = meta.getLook();
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
        int expectedHp = 98;
        KnightMeta knight = (KnightMeta) MetaContext.getMeta(KnightMeta.class);
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        profile.getLook().setHp(100);
        knight.getLook().setProfile(profile);

        enemy.hit(knight);

        int actualHp = profile.getLook().getHp();
        String message = getFieldValueAssert(knight.getClassName(), "hit", "hp", expectedHp, actualHp);
        assertEquals(expectedHp, actualHp, message);
    }

    @DisplayName("Тест, что метод go в классе Skeleton меняет координаты точки персонажа")
    @Test
    void testGoChangesPointCoordinates() {
        int expectedX = 5;
        int expectedY = 6;

        enemy.go(expectedX, expectedY);

        int actualX = enemy.getPoint().getLook().getX();
        int actualY = enemy.getPoint().getLook().getY();
        assertEquals(expectedX, actualX, getGoAssertMessage("x", expectedX, actualX));
        assertEquals(expectedY, actualY, getGoAssertMessage("y", expectedY, actualY));
    }
}
