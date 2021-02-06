package com.idoit.character.npc.enemy;

import com.idoit.character.AbstractCharacterTest;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.character.npc.enemy.RougeMeta;
import com.idoit.meta.profile.ProfileMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Rouge")
class RougeTest extends AbstractCharacterTest {

    private RougeMeta.EnemyLook enemy;

    @BeforeEach
    void setUp() {
        setMeta(RougeMeta.class);
        RougeMeta meta = (RougeMeta) getMeta();
        enemy = meta.getLook();
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

    @DisplayName("Тест, что метод go в классе Rouge меняет координаты точки персонажа")
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
