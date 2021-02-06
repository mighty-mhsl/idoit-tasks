package com.idoit.profile;

import com.idoit.AbstractTest;
import com.idoit.meta.MetaContext;
import com.idoit.meta.knowledge.KnowledgeMeta;
import com.idoit.meta.profile.JournalMeta;
import com.idoit.meta.quest.QuestMeta;
import com.idoit.safe.Safer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Journal")
class JournalTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(JournalMeta.class);
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
        testSetterWithMetaParam(KnowledgeMeta.class, new Object[]{}, "setKnowledge", "knowledge");
    }

    @DisplayName("Тест, что метод setQuest в классе Journal сохраняет задание в поле класса")
    @Test
    void testSetQuest() {
        Object[] questConstructor = new Object[]{"test", "test", 1, 2, 3};
        testSetterWithMetaParam(QuestMeta.class, questConstructor, "setQuest", "quest");
    }

    @DisplayName("Тест, что метод getKnowledge в классе Journal возвращает знание")
    @Test
    void testGetKnowledge() {
        Safer.runSafe(() -> {
            Object knowledge = MetaContext.getMeta(KnowledgeMeta.class).instantiateObjectWithConstructor();
            testGetter("getKnowledge", "setKnowledge", knowledge);
        });
    }

    @DisplayName("Тест, что метод getQuest в классе Journal возвращает задание")
    @Test
    void testGetQuest() {
        Safer.runSafe(() -> {
            Object quest = MetaContext.getMeta(QuestMeta.class).instantiateObjectWithConstructor("test", "test", 1, 2, 3);
            testGetter("getQuest", "setQuest", quest);
        });
    }
}
