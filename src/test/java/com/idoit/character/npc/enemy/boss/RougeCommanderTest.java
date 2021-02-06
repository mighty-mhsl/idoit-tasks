package com.idoit.character.npc.enemy.boss;

import com.idoit.character.AbstractCharacterTest;
import com.idoit.meta.MetaContext;
import com.idoit.meta.battlefield.PointMeta;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.character.npc.enemy.boss.RougeCommanderMeta;
import com.idoit.meta.profile.ProfileMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе RougeCommander")
class RougeCommanderTest extends AbstractCharacterTest {

    private RougeCommanderMeta.BossLook boss;

    @BeforeEach
    void setUp() {
        setMeta(RougeCommanderMeta.class);
        RougeCommanderMeta meta = (RougeCommanderMeta) getMeta();
        boss = meta.getLook();
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
        String expectedValue = "test";
        boss.setName(expectedValue);
        String message = getSetterAssertMessage("setName", "name", getMeta().getClassName());
        assertEquals(expectedValue, boss.getName(), message);
    }

    @DisplayName("Тест, что метод setLevel в классе RougeCommander сохраняет переданный уровень в поле класса")
    @Test
    void testSetLevelSavesLevelToField() {
        int expectedValue = 2;
        boss.setLevel(expectedValue);
        String message = getSetterAssertMessage("setLevel", "level", getMeta().getClassName());
        assertEquals(expectedValue, boss.getLevel(), message);
    }

    @DisplayName("Тест, что метод setDamage в классе RougeCommander сохраняет переданный урон в поле класса")
    @Test
    void testSetDamageSavesDamageToField() {
        int expectedValue = 3;
        boss.setDamage(expectedValue);
        String message = getSetterAssertMessage("setDamage", "name", getMeta().getClassName());
        assertEquals(expectedValue, boss.getDamage(), message);
    }

    @DisplayName("Тест, что метод setExpReward в классе RougeCommander сохраняет переданную награду в опыте в поле класса")
    @Test
    void testSetExpRewardSavesExpRewardToField() {
        int expectedValue = 3;
        boss.setExpReward(expectedValue);
        String message = getSetterAssertMessage("setExpReward", "name", getMeta().getClassName());
        assertEquals(expectedValue, boss.getExpReward(), message);
    }

    @DisplayName("Тест, что метод setGoldReward в классе RougeCommander сохраняет переданную награду в золоте в поле класса")
    @Test
    void testSetGoldRewardSavesGoldRewardToField() {
        int expectedValue = 3;
        boss.setGoldReward(expectedValue);
        String message = getSetterAssertMessage("setGoldReward", "name", getMeta().getClassName());
        assertEquals(expectedValue, boss.getGoldReward(), message);
    }

    @DisplayName("Тест, что метод setPoint в классе RougeCommander сохраняет переданную точку в поле класса")
    @Test
    void testSetPointSavesPointToField() {
        PointMeta expectedValue = (PointMeta) MetaContext.getMeta(PointMeta.class);
        boss.setPoint(expectedValue);
        String message = getSetterAssertMessage("setPoint", "name", getMeta().getClassName());
        assertEquals(expectedValue, boss.getPoint(), message);
    }

    @DisplayName("Тест, что метод getName в классе RougeCommander возвращает имя босса")
    @Test
    void testGetName() {
        String expectedValue = "test";
        boss.setName(expectedValue);
        String actualValue = boss.getName();
        String message = getMethodReturnResultAssertMessage("getName", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getLevel в классе RougeCommander возвращает уровень босса")
    @Test
    void testGetLevel() {
        int expectedValue = 2;
        boss.setLevel(expectedValue);
        int actualValue = boss.getLevel();
        String message = getMethodReturnResultAssertMessage("getLevel", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getDamage в классе RougeCommander возвращает урон босса")
    @Test
    void testGetDamage() {
        int expectedValue = 2;
        boss.setDamage(expectedValue);
        int actualValue = boss.getDamage();
        String message = getMethodReturnResultAssertMessage("getDamage", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getExpReward в классе RougeCommander возвращает имя босса")
    @Test
    void testGetExpReward() {
        int expectedValue = 2;
        boss.setExpReward(expectedValue);
        int actualValue = boss.getExpReward();
        String message = getMethodReturnResultAssertMessage("getExpReward", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getGoldReward в классе RougeCommander возвращает имя босса")
    @Test
    void testGetGoldReward() {
        int expectedValue = 2;
        boss.setGoldReward(expectedValue);
        int actualValue = boss.getGoldReward();
        String message = getMethodReturnResultAssertMessage("getGoldReward", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getPoint в классе RougeCommander возвращает имя босса")
    @Test
    void testGetPoint() {
        PointMeta expectedValue = (PointMeta) MetaContext.getMeta(PointMeta.class);
        boss.setPoint(expectedValue);
        PointMeta actualValue = boss.getPoint();
        String message = getMethodReturnResultAssertMessage("getPoint", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод hit в классе RougeCommander наносит урон переданному рыцарю")
    @Test
    void testHitDamagesKnight() {
        int expectedHp = 99;
        KnightMeta knight = (KnightMeta) MetaContext.getMeta(KnightMeta.class);
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        profile.getLook().setHp(100);
        knight.getLook().setProfile(profile);

        boss.hit(knight);

        int actualHp = profile.getLook().getHp();
        String message = getFieldValueAssert(knight.getClassName(), "hit", "hp", expectedHp, actualHp);
        assertEquals(expectedHp, actualHp, message);
    }

    @DisplayName("Тест, что метод go в классе RougeCommander перемещает босса в точку с переданными координатами")
    @Test
    void testGoMovesBoss() {
        int expectedX = 5;
        int expectedY = 6;

        boss.go(expectedX, expectedY);

        int actualX = boss.getPoint().getLook().getX();
        int actualY = boss.getPoint().getLook().getY();
        assertEquals(expectedX, actualX, getGoAssertMessage("x", expectedX, actualX));
        assertEquals(expectedY, actualY, getGoAssertMessage("y", expectedY, actualY));
    }
}
