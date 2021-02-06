package com.idoit.character.npc.enemy.boss;

import com.idoit.meta.MetaContext;
import com.idoit.meta.battlefield.PointMeta;
import com.idoit.meta.character.npc.enemy.boss.RougeCommanderMeta;
import com.idoit.safe.Safer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе RougeCommander")
class RougeCommanderTest extends BossTest {

    @BeforeEach
    void setUp() {
        setMeta(RougeCommanderMeta.class);
    }

    @DisplayName("Тест, что класс RougeCommander находится в пакете com.idoit.character.npc.enemy.boss")
    @Test
    void testRougeCommanderIsInBossPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс RougeCommander имеет все необходимые поля")
    @Test
    void testRougeCommanderHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе RougeCommander есть конструктор принимающий уровень и урон босса")
    @Test
    void testRougeCommanderHasConstructorWithLevelAndDamageParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields(1, 2);
    }

    @DisplayName("Тест, что в классе RougeCommander есть все необходимые методы")
    @Test
    void testRougeCommanderHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод setName в классе RougeCommander сохраняет переданное имя в поле класса")
    @Test
    void testSetNameSavesNameToField() {
        testSetter("test", "setName", "name", CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод setLevel в классе RougeCommander сохраняет переданный уровень в поле класса")
    @Test
    void testSetLevelSavesLevelToField() {
        testSetter(3, "setLevel", "level", CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод setDamage в классе RougeCommander сохраняет переданный урон в поле класса")
    @Test
    void testSetDamageSavesDamageToField() {
        testSetter(5, "setDamage", "damage", CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод setExpReward в классе RougeCommander сохраняет переданную награду в опыте в поле класса")
    @Test
    void testSetExpRewardSavesExpRewardToField() {
        testSetter(1, "setExpReward", "expReward", CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод setGoldReward в классе RougeCommander сохраняет переданную награду в золоте в поле класса")
    @Test
    void testSetGoldRewardSavesGoldRewardToField() {
        testSetter(1, "setGoldReward", "goldReward", CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод setPoint в классе RougeCommander сохраняет переданную точку в поле класса")
    @Test
    void testSetPointSavesPointToField() {
        Safer.runSafe(() -> {
            Object point = MetaContext.getMeta(PointMeta.class).instantiateObjectWithConstructor(1, 2);
            testSetter(point, "setPoint", "point", CONSTRUCTOR_PARAMS);
        });
    }

    @DisplayName("Тест, что метод getName в классе RougeCommander возвращает имя босса")
    @Test
    void testGetName() {
        testGetter("getName", "setName", "test", CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод getLevel в классе RougeCommander возвращает уровень босса")
    @Test
    void testGetLevel() {
        testGetter("getLevel", "setLevel", 5, CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод getDamage в классе RougeCommander возвращает урон босса")
    @Test
    void testGetDamage() {
        testGetter("getDamage", "setDamage", 5, CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод getExpReward в классе RougeCommander возвращает имя босса")
    @Test
    void testGetExpReward() {
        testGetter("getExpReward", "setExpReward", 1, CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод getGoldReward в классе RougeCommander возвращает имя босса")
    @Test
    void testGetGoldReward() {
        testGetter("getGoldReward", "setGoldReward", 1, CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод getPoint в классе RougeCommander возвращает имя босса")
    @Test
    void testGetPoint() {
        Safer.runSafe(() -> {
            Object point = MetaContext.getMeta(PointMeta.class).instantiateObjectWithConstructor(1, 2);
            testGetter("getPoint", "setPoint", point, CONSTRUCTOR_PARAMS);
        });
    }

    @DisplayName("Тест, что метод hit в классе RougeCommander наносит урон переданному рыцарю")
    @Test
    void testHitDamagesKnight() {
        testHit();
    }

    @DisplayName("Тест, что метод go в классе RougeCommander перемещает босса в точку с переданными координатами")
    @Test
    void testGoMovesBoss() {
        testGo();
    }
}
