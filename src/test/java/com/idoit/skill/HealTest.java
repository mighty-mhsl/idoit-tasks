package com.idoit.skill;

import com.idoit.AbstractTest;
import com.idoit.MessageUtil;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.character.WizardMeta;
import com.idoit.meta.profile.ProfileMeta;
import com.idoit.meta.skill.HealMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Heal")
class HealTest extends AbstractTest {

    private HealMeta.HealLook heal;

    @BeforeEach
	void setUp() {
        setMeta(HealMeta.class);
        HealMeta meta = (HealMeta) getMeta();
        heal = meta.getLook();
    }

    @DisplayName("Тест, что класс Heal находится в пакете com.idoit.skill")
    @Test
    void testHealIsInSkillPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Heal имеет все необходимые поля")
    @Test
    void testHealHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Heal есть конструктор принимающий название, количетсво расходуемой маны и минимальный уровень навыка")
    @Test
    void testHealHasConstructorWithNameAndManaAndMinLevelParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 20, 5);
    }

    @DisplayName("Тест, что в классе Heal есть все необходимые методы")
    @Test
    void testHealHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод apply в классе Heal увеличивает хп цели на 10")
    @Test
    void testApplyIncreasesPatientsHp() {
        int expectedHp = 100;
        ProfileMeta profile = createProfile();
        KnightMeta patient = createKnightWith(profile);
        WizardMeta healer = (WizardMeta) MetaContext.getMeta(WizardMeta.class);

        heal.apply(healer, patient);

        int actualHp = profile.getLook().getHp();
        String message = MessageUtil.formatAssertMessage(
                String.format("После вызова метода apply, переданная цель должна иметь %d хп", expectedHp),
                String.format("После вызова метода apply, переданная цель имеет %d хп", actualHp)
        );
        assertEquals(expectedHp, actualHp, message);
    }

    @DisplayName("Тест, что метод apply в классе Heal уменьшает ману мага")
    @Test
    void testApplyDecreasesMana() {
        int expectedMana = 99;
        ProfileMeta profile = createProfile();
        WizardMeta healer = createWizardWith(profile);
        KnightMeta patient = (KnightMeta) MetaContext.getMeta(KnightMeta.class);

        heal.apply(healer, patient);

        int actualMana = profile.getLook().getMana();
        String message = MessageUtil.formatAssertMessage(
                String.format("После вызова метода apply, маг должен иметь %d маны", expectedMana),
                String.format("После вызова метода apply, маг имеет %d маны", actualMana)
        );
        assertEquals(expectedMana, actualMana, message);
    }

    private ProfileMeta createProfile() {
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        ProfileMeta.ProfileLook profileLook = profile.getLook();
        profileLook.setHp(90);
        profileLook.setMana(100);
        return profile;
    }

    private KnightMeta createKnightWith(ProfileMeta profile) {
        KnightMeta knight = (KnightMeta) MetaContext.getMeta(KnightMeta.class);
        KnightMeta.KnightLook patientLook = knight.getLook();
        patientLook.setProfile(profile);
        return knight;
    }

    private WizardMeta createWizardWith(ProfileMeta profile) {
        WizardMeta wizard = (WizardMeta) MetaContext.getMeta(WizardMeta.class);
        WizardMeta.WizardLook wizardLook = wizard.getLook();
        wizardLook.setProfile(profile);
        return wizard;
    }
}
