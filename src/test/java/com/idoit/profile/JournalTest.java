package com.idoit.profile;

import com.idoit.AbstractTest;
import com.idoit.meta.knowledge.KnowledgeMeta;
import com.idoit.meta.profile.JournalMeta;
import com.idoit.meta.quest.QuestMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Journal")
class JournalTest extends AbstractTest {

    private JournalMeta.JournalLook journal;

    @BeforeEach
    void setUp() {
        setMeta(JournalMeta.class);
        JournalMeta meta = (JournalMeta) getMeta();
        journal = meta.getLook();
    }

    @DisplayName("Тест, что класс Journal находится в пакете com.idoit.profile")
    @Test
    void testJournalIsInProfilePackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Journal имеет все необходимые поля")
    @Test
    void testJournalHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Journal есть все необходимые методы")
    @Test
    void testJournalHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод setKnowledge в классе Journal сохраняет знание в поле класса")
    @Test
    void testSetKnowledge() {
        KnowledgeMeta expectedValue = new KnowledgeMeta();
        journal.setKnowledge(expectedValue);
        String message = getSetterAssertMessage("setKnowledge", "knowledge", getMeta().getClassName());
        assertEquals(expectedValue, journal.getKnowledge(), message);
    }

    @DisplayName("Тест, что метод setQuest в классе Journal сохраняет задание в поле класса")
    @Test
    void testSetQuest() {
        QuestMeta expectedValue = new QuestMeta();
        journal.setQuest(expectedValue);
        String message = getSetterAssertMessage("setQuest", "quest", getMeta().getClassName());
        assertEquals(expectedValue, journal.getQuest(), message);
    }

    @DisplayName("Тест, что метод getKnowledge в классе Journal возвращает знание")
    @Test
    void testGetKnowledge() {
        KnowledgeMeta expectedValue = new KnowledgeMeta();
        journal.setKnowledge(expectedValue);
        KnowledgeMeta actualValue = journal.getKnowledge();
        String message = getMethodReturnResultAssertMessage("getKnowledge", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getQuest в классе Journal возвращает задание")
    @Test
    void testGetQuest() {
        QuestMeta expectedValue = new QuestMeta();
        journal.setQuest(expectedValue);
        QuestMeta actualValue = journal.getQuest();
        String message = getMethodReturnResultAssertMessage("getQuest", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }
}
