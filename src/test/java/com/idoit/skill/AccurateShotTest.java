package com.idoit.skill;

import com.idoit.AbstractTest;
import com.idoit.MessageUtil;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.ArcherMeta;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.item.weapon.BowMeta;
import com.idoit.meta.profile.ProfileMeta;
import com.idoit.meta.skill.AccurateShotMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе AccurateShot")
class AccurateShotTest extends AbstractTest {

    private AccurateShotMeta.AccurateShotLook accurateShot;

    @BeforeEach
	void setUp() {
        setMeta(AccurateShotMeta.class);
        AccurateShotMeta meta = (AccurateShotMeta) getMeta();
        accurateShot = meta.getLook();
    }

    @DisplayName("Тест, что класс AccurateShot находится в пакете com.idoit.skill")
    @Test
    void testAccurateShotIsInSkillPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс AccurateShot имеет все необходимые поля")
    @Test
    void testAccurateShotHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе AccurateShot есть конструктор принимающий название, количетсво расходуемой маны и минимальный уровень навыка")
    @Test
    void testAccurateShotHasConstructorWithNameAndManaAndMinLevelParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 20, 5);
    }

    @DisplayName("Тест, что в классе AccurateShot есть все необходимые методы")
    @Test
    void testAccurateShotHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод apply в классе AccurateShot отнимает хп цели в двойном размере")
    @Test
    void testApplyDamagesTargetTwiceMore() {
        int expectedValue = 98;
        ArcherMeta archer = (ArcherMeta) MetaContext.getMeta(ArcherMeta.class);
        BowMeta bow = (BowMeta) MetaContext.getMeta(BowMeta.class);
        archer.getLook().setBow(bow);
        ProfileMeta profile = createProfile();
        KnightMeta knight = createKnightWith(profile);

        accurateShot.apply(archer, knight);

        int actualValue = profile.getLook().getHp();
        String message = MessageUtil.formatAssertMessage(
                String.format("После вызова метода apply, переданная цель должна иметь %d хп", expectedValue),
                String.format("После вызова метода apply, переданная цель имеет %d хп", actualValue)
        );
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод apply в классе AccurateShot отнимает ману лучника в необходимом количестве")
    @Test
    void testApplySpendsMana() {
        int expectedValue = 99;
        ProfileMeta profile = createProfile();
        ArcherMeta archer = createArcherWith(profile);
        BowMeta bow = (BowMeta) MetaContext.getMeta(BowMeta.class);
        archer.getLook().setBow(bow);
        KnightMeta knight = createKnightWith(profile);

        accurateShot.apply(archer, knight);

        int actualValue = profile.getLook().getMana();
        String message = MessageUtil.formatAssertMessage(
                String.format("После вызова метода apply, переданная цель должна иметь %d хп", expectedValue),
                String.format("После вызова метода apply, переданная цель имеет %d хп", actualValue)
        );
        assertEquals(expectedValue, actualValue, message);
    }

    private ProfileMeta createProfile() {
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        ProfileMeta.ProfileLook profileLook = profile.getLook();
        profileLook.setHp(100);
        profileLook.setMana(100);
        return profile;
    }

    private KnightMeta createKnightWith(ProfileMeta profile) {
        KnightMeta knight = (KnightMeta) MetaContext.getMeta(KnightMeta.class);
        knight.getLook().setProfile(profile);
        return knight;
    }

    private ArcherMeta createArcherWith(ProfileMeta profile) {
        ArcherMeta archer = (ArcherMeta) MetaContext.getMeta(ArcherMeta.class);
        archer.getLook().setProfile(profile);
        return archer;
    }
}
