package com.idoit.character.npc;

import com.idoit.AbstractTest;
import com.idoit.MessageUtil;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.character.npc.NPCMeta;
import com.idoit.meta.quest.QuestMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе NPC")
class NpcTest extends AbstractTest {

    private NPCMeta.NPCLook npc;

    @BeforeEach
    void setUp() {
        setMeta(NPCMeta.class);
        NPCMeta meta = (NPCMeta) getMeta();
        npc = meta.getLook();
    }

    @DisplayName("Тест, что класс NPC находится в пакете com.idoit.character.npc")
    @Test
    void testNPCIsInNpcPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс NPC имеет все необходимые поля")
    @Test
    void testNPCHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе NPC есть конструктор принимающий имя и уровень нпс")
    @Test
    void testNPCHasConstructorWithNameAndLevelParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("name", 1);
    }

    @DisplayName("Тест, что в классе NPC есть все необходимые методы")
    @Test
    void testNPCHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод setQuest в классе NPC сохраняет переданный Quest в поле класса")
    @Test
    void testSetQuestSavesQuestToField() {
        QuestMeta expectedValue = (QuestMeta) MetaContext.getMeta(QuestMeta.class);
        npc.setQuest(expectedValue);
        String message = getSetterAssertMessage("setQuest", "quest", getMeta().getClassName());
        assertEquals(expectedValue, npc.getQuest(), message);
    }

    @DisplayName("Тест, что метод giveQuest в классе NPC добавляет активное задание переданному Knight")
    @Test
    void testGiveQuest() {
        KnightMeta knight = (KnightMeta) MetaContext.getMeta(KnightMeta.class);
        QuestMeta expectedValue = (QuestMeta) MetaContext.getMeta(QuestMeta.class);
        npc.setQuest(expectedValue);

        npc.giveQuest(knight);

        QuestMeta actualValue = knight.getLook().getActiveQuest();
        String message = getGiveQuestAssertMessage(expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    private String getGiveQuestAssertMessage(Object expectedValue, Object actualValue) {
        return MessageUtil.formatAssertMessage(
                String.format("После вызовав метода giveQuest в классе NPC переданный Knight имеет activeQuest: %s", expectedValue),
                String.format("После вызовав метода giveQuest в классе NPC переданный Knight имеет activeQuest: %s", actualValue)
        );
    }
}
