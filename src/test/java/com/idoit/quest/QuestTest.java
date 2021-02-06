package com.idoit.quest;

import com.idoit.AbstractTest;
import com.idoit.MessageUtil;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.profile.ProfileMeta;
import com.idoit.meta.quest.QuestMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Quest")
class QuestTest extends AbstractTest {

    private QuestMeta.QuestLook quest;

    @BeforeEach
    void setUp() {
        setMeta(QuestMeta.class);
        QuestMeta meta = (QuestMeta) getMeta();
        quest = meta.getLook();
    }

    @DisplayName("Тест, что класс Quest находится в пакете com.character.quest")
    @Test
    void testQuestIsInQuestPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что в классе Quest есть все необходимые поля")
    @Test
    void testQuestHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Quest есть конструктор принимающий имя, описание, награду в золоте, награду в опыте и минимальный уровень для выполнения задания")
    @Test
    void testQuestHasConstructorWithNameDescGoldExpAndLevelParam() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", "description", 1, 2, 3);
    }

    @DisplayName("Тест, что в классе Quest есть все необходимые методы")
    @Test
    void testQuestHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод complete в классе Quest добавляет переданному Knight золото в награду")
    @Test
    void testCompleteAddsGold() {
        int expectedGold = 102;
        ProfileMeta profile = createProfile();
        KnightMeta knight = createKnightWith(profile);

        quest.complete(knight);

        int actualGold = profile.getLook().getGold();
        String message = getCompleteAssertMessage("gold", expectedGold, actualGold);
        assertEquals(expectedGold, actualGold, message);
    }

    @DisplayName("Тест, что метод complete в классе Quest добавляет переданному Knight опыт в награду")
    @Test
    void testCompleteAddsExperience() {
        int expectedExperience = 101;
        ProfileMeta profile = createProfile();
        KnightMeta knight = createKnightWith(profile);

        quest.complete(knight);

        int actualExperience = profile.getLook().getExperience();
        String message = getCompleteAssertMessage("experience", expectedExperience, actualExperience);
        assertEquals(expectedExperience, actualExperience, message);
    }

    private String getCompleteAssertMessage(String fieldName, int expectedValue, int actualValue) {
        return MessageUtil.formatAssertMessage(
                String.format("После вызова метода complete в классе Quest, переданный Knight должен иметь %d в поле %s", expectedValue, fieldName),
                String.format("После вызова метода complete в классе Quest, переданный Knight имеет %d в поле %s", actualValue, fieldName)
        );
    }

    private ProfileMeta createProfile() {
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        ProfileMeta.ProfileLook profileLook = profile.getLook();
        profileLook.setExperience(100);
        profileLook.setGold(100);
        return profile;
    }

    private KnightMeta createKnightWith(ProfileMeta profile) {
        KnightMeta knight = (KnightMeta) MetaContext.getMeta(KnightMeta.class);
        KnightMeta.KnightLook knightLook = knight.getLook();
        knightLook.setProfile(profile);
        return knight;
    }
}
