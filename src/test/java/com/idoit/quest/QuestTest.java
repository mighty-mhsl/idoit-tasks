package com.idoit.quest;

import com.idoit.AbstractTest;
import com.idoit.MessageUtil;
import com.idoit.meta.Meta;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.quest.QuestMeta;
import com.idoit.safe.Safer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Quest")
class QuestTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(QuestMeta.class);
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

    @DisplayName("Тест, что метод complete в классе Quest добавляет переданному Knight золото и опыт в награду")
    @Test
    void testComplete() {
        Safer.runSafe(() -> {
            int goldReward = 10;
            int expReward = 15;
            Object quest = getMeta().instantiateObjectWithConstructor("test", "test-desc", expReward, goldReward, 1);

            BiConsumer<Object, Object[]> completeAssert = (obj, params) -> {
                Object knight = params[0];
                Safer.runSafe(() -> {
                    String goldField = "gold";
                    String expField = "experience";
                    int goldValue = (int) getFieldValue(knight, goldField);
                    int expValue = (int) getFieldValue(knight, expField);
                    String goldMessage = getCompleteAssertMessage(goldField, goldReward, goldValue);
                    String expMessage = getCompleteAssertMessage(expField, expReward, expValue);
                    assertEquals(100 + goldReward, goldValue, goldMessage);
                    assertEquals(expReward, expValue, expMessage);
                });
            };

            Meta knightMeta = MetaContext.getMeta(KnightMeta.class);
            Object knight = knightMeta.instantiateObjectWithConstructor("test");
            testClassMethod(completeAssert, quest, "complete", knight);
        });
    }

    private String getCompleteAssertMessage(String fieldName, int expectedValue, int actualValue) {
        return MessageUtil.formatAssertMessage(
                String.format("После вызова метода complete в классе Quest, переданный Knight должен иметь %d в поле %s", expectedValue, fieldName),
                String.format("После вызова метода complete в классе Quest, переданный Knight имеет %d в поле %s", actualValue, fieldName)
        );
    }
}
