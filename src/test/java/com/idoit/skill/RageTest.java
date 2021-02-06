package com.idoit.skill;

import com.idoit.AbstractTest;
import com.idoit.MessageUtil;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.profile.ProfileMeta;
import com.idoit.meta.skill.RageMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Rage")
class RageTest extends AbstractTest {

    private RageMeta.RageLook rage;

    @BeforeEach
	void setUp() {
        setMeta(RageMeta.class);
        RageMeta meta = (RageMeta) getMeta();
        rage = meta.getLook();
    }

    @DisplayName("Тест, что класс Rage находится в пакете com.idoit.skill")
    @Test
    void testRageIsInSkillPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Rage имеет все необходимые поля")
    @Test
    void testRageHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Rage есть конструктор принимающий название, количетсво расходуемой маны и минимальный уровень навыка")
    @Test
    void testRageHasConstructorWithNameAndManaAndMinLevelParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 20, 5);
    }

    @DisplayName("Тест, что в классе Rage есть все необходимые методы")
    @Test
    void testRageHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод apply в классе Rage увеличивает силу цели в 2 раза")
    @Test
    void testRageDoublesStrength() {
        int expectedStrength = 14;
        ProfileMeta profile = createProfile();
        KnightMeta knight = createKnightWith(profile);

        rage.apply(knight);

        int actualStrength = profile.getLook().getStrength();
        String message = MessageUtil.formatAssertMessage(
                String.format("После вызова метода apply, переданная цель должна иметь %d силы", expectedStrength),
                String.format("После вызова метода apply, переданная цель имеет %d силы", actualStrength)
        );
        assertEquals(expectedStrength, actualStrength, message);
    }

    @DisplayName("Тест, что метод apply в классе Rage уменьшает хп цели на 15")
    @Test
    void testRageDecreasesHp() {
        int expectedHp = 85;
        ProfileMeta profile = createProfile();
        KnightMeta knight = createKnightWith(profile);

        rage.apply(knight);

        int actualHp = profile.getLook().getHp();
        String message = MessageUtil.formatAssertMessage(
                String.format("После вызова метода apply, переданная цель должна иметь %d хп", expectedHp),
                String.format("После вызова метода apply, переданная цель имеет %d хп", actualHp)
        );
        assertEquals(expectedHp, actualHp, message);
    }

    @DisplayName("Тест, что метод apply в классе Rage уменьшает ману цели на необходимое значение")
    @Test
    void testRageDecreasesMana() {
        int expectedMana = 99;
        ProfileMeta profile = createProfile();
        KnightMeta knight = createKnightWith(profile);

        rage.apply(knight);

        int actualMana = profile.getLook().getMana();
        String message = MessageUtil.formatAssertMessage(
                String.format("После вызова метода apply, переданная цель должна иметь %d маны", expectedMana),
                String.format("После вызова метода apply, переданная цель имеет %d маны", actualMana)
        );
        assertEquals(expectedMana, actualMana, message);
    }

    private ProfileMeta createProfile() {
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        ProfileMeta.ProfileLook profileLook = profile.getLook();
        profileLook.setStrength(7);
        profileLook.setHp(100);
        profileLook.setMana(100);
        return profile;
    }

    private KnightMeta createKnightWith(ProfileMeta profile) {
        KnightMeta knight = (KnightMeta) MetaContext.getMeta(KnightMeta.class);
        KnightMeta.KnightLook knightLook = knight.getLook();
        knightLook.setProfile(profile);
        return knight;
    }
}
