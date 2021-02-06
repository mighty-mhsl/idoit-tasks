package com.idoit.character.npc;

import com.idoit.AbstractTest;
import com.idoit.MessageUtil;
import com.idoit.meta.Meta;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.character.npc.NpcMeta;
import com.idoit.meta.quest.QuestMeta;
import com.idoit.safe.Safer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе NPC")
class NpcTest extends AbstractTest {

    private static final Object[] CONSTRUCTOR_PARAMS = new Object[] {"test", 1};

    @BeforeEach
    void setUp() {
        setMeta(NpcMeta.class);
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
        Object[] questConstructor = new Object[] {"test1", "test2", 1, 2, 3};
        testSetterWithMetaParam(QuestMeta.class, questConstructor, "setQuest", "quest", CONSTRUCTOR_PARAMS);
    }

    @DisplayName("Тест, что метод giveQuest в классе NPC добавляет активное задание переданному Knight")
    @Test
    void testGiveQuest() {
        Safer.runSafe(() -> {
            Object npc = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAMS);
            Object quest = setFieldForObjectAndGet(npc, "setQuest", QuestMeta.class, "name", "desc", 1, 2, 3);

            BiConsumer<Object, Object[]> giveQuestAssert = (obj, params) -> {
                Object knight = params[0];
                Safer.runSafe(() -> {
                    Object activeQuest = getFieldValue(knight, "activeQuest");
                    assertEquals(quest, activeQuest, getGiveQuestAssertMessage(quest, activeQuest));
                });
            };

            Meta knightMeta = MetaContext.getMeta(KnightMeta.class);
            Object knight = knightMeta.instantiateObjectWithConstructor("test");
            testClassMethod(giveQuestAssert, npc, "giveQuest", knight);
        });
    }

    private String getGiveQuestAssertMessage(Object expectedValue, Object actualValue) {
        return MessageUtil.formatAssertMessage(
                String.format("После вызовав метода giveQuest в классе NPC переданный Knight имеет activeQuest: %s", expectedValue),
                String.format("После вызовав метода giveQuest в классе NPC переданный Knight имеет activeQuest: %s", actualValue)
        );
    }
}
