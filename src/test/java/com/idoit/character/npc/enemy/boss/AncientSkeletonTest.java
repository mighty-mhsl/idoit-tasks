package com.idoit.character.npc.enemy.boss;

import com.idoit.meta.MetaContext;
import com.idoit.meta.battlefield.PointMeta;
import com.idoit.meta.character.npc.enemy.boss.AncientSkeletonMeta;
import com.idoit.safe.Safer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе AncientSkeleton")
class AncientSkeletonTest extends BossTest {
    
    @BeforeEach
    void setUp() {
        setMeta(AncientSkeletonMeta.class);
    }

    @DisplayName("Тест, что класс AncientSkeleton находится в пакете com.idoit.character.npc.enemy.boss")
    @Test
    void testAncientSkeletonIsInBossPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс AncientSkeleton имеет все необходимые поля")
    @Test
    void testAncientSkeletonHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе AncientSkeleton есть конструктор принимающий уровень и урон босса")
    @Test
    void testAncientSkeletonHasConstructorWithLevelAndDamageParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields(1, 2);
    }

    @DisplayName("Тест, что в классе AncientSkeleton есть все необходимые методы")
    @Test
    void testAncientSkeletonHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод setName в классе AncientSkeleton сохраняет переданное имя в поле класса")
    @Test
    void testSetNameSavesNameToField() {
        testSetter("test", "setName", "name", CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод setLevel в классе AncientSkeleton сохраняет переданный уровень в поле класса")
    @Test
    void testSetLevelSavesLevelToField() {
        testSetter(3, "setLevel", "level", CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод setDamage в классе AncientSkeleton сохраняет переданный урон в поле класса")
    @Test
    void testSetDamageSavesDamageToField() {
        testSetter(5, "setDamage", "damage", CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод setExpReward в классе AncientSkeleton сохраняет переданную награду в опыте в поле класса")
    @Test
    void testSetExpRewardSavesExpRewardToField() {
        testSetter(1, "setExpReward", "expReward", CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод setGoldReward в классе AncientSkeleton сохраняет переданную награду в золоте в поле класса")
    @Test
    void testSetGoldRewardSavesGoldRewardToField() {
        testSetter(1, "setGoldReward", "goldReward", CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод setPoint в классе AncientSkeleton сохраняет переданную точку в поле класса")
    @Test
    void testSetPointSavesPointToField() {
        Safer.runSafe(() -> {
            Object point = MetaContext.getMeta(PointMeta.class).instantiateObjectWithConstructor(1, 2);
            testSetter(point, "setPoint", "point", CONSTRUCTOR_PARAMS);
        });
    }

    @DisplayName("Тест, что метод getName в классе AncientSkeleton возвращает имя босса")
    @Test
    void testGetName() {
        testGetter("getName", "setName", "test", CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод getLevel в классе AncientSkeleton возвращает уровень босса")
    @Test
    void testGetLevel() {
        testGetter("getLevel", "setLevel", 5, CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод getDamage в классе AncientSkeleton возвращает урон босса")
    @Test
    void testGetDamage() {
        testGetter("getDamage", "setDamage", 5, CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод getExpReward в классе AncientSkeleton возвращает имя босса")
    @Test
    void testGetExpReward() {
        testGetter("getExpReward", "setExpReward", 1, CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод getGoldReward в классе AncientSkeleton возвращает имя босса")
    @Test
    void testGetGoldReward() {
        testGetter("getGoldReward", "setGoldReward", 1, CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод getPoint в классе AncientSkeleton возвращает имя босса")
    @Test
    void testGetPoint() {
        Safer.runSafe(() -> {
            Object point = MetaContext.getMeta(PointMeta.class).instantiateObjectWithConstructor(1, 2);
            testGetter("getPoint", "setPoint", point, CONSTRUCTOR_PARAMS);
        });
    }

    @DisplayName("Тест, что метод hit в классе AncientSkeleton наносит урон переданному рыцарю")
    @Test
    void testHitDamagesKnight() {
        testHit();
    }

    @DisplayName("Тест, что метод go в классе AncientSkeleton перемещает босса в точку с переданными координатами")
    @Test
    void testGoMovesBoss() {
        testGo();
    }
}
