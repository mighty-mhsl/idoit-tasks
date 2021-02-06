package com.idoit.knowledge;

import com.idoit.AbstractTest;
import com.idoit.meta.knowledge.KnowledgeMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Knowledge")
class KnowledgeTest extends AbstractTest {

    private KnowledgeMeta.KnowledgeLook knowledge;
    
    @BeforeEach
    void setUp() {
        setMeta(KnowledgeMeta.class);
        KnowledgeMeta meta = (KnowledgeMeta) getMeta();
        knowledge = meta.getLook();
    }

    @DisplayName("Тест, что класс Knowledge находится в пакете com.idoit.knowledge")
    @Test
    void testKnowledgeIsInKnowledgePackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Knowledge имеет все необходимые поля")
    @Test
    void testKnowledgeHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Knowledge есть все необходимые методы")
    @Test
    void testKnowledgeHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод setDescription в классе Knowledge сохраняет описание знания в поле класса")
    @Test
    void testSetDescription() {
        String expectedValue = "test";
        knowledge.setDescription(expectedValue);
        String message = getSetterAssertMessage("setDescription", expectedValue, getMeta().getClassName());
        assertEquals(expectedValue, knowledge.getDescription(), message);
    }

    @DisplayName("Тест, что метод setPerson в классе Knowledge сохраняет персонажа в поле класса")
    @Test
    void testSetPerson() {
        String expectedValue = "test";
        knowledge.setPerson(expectedValue);
        String message = getSetterAssertMessage("setPerson", expectedValue, getMeta().getClassName());
        assertEquals(expectedValue, knowledge.getPerson(), message);
    }

    @DisplayName("Тест, что метод getDescription в классе Knowledge возвращает описание знания")
    @Test
    void testGetDescription() {
        String expectedValue = "test";
        knowledge.setDescription(expectedValue);
        String actualValue = knowledge.getDescription();
        String message = getMethodReturnResultAssertMessage("getDescription", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getPerson в классе Knowledge возвращает персонажа")
    @Test
    void testGetPerson() {
        String expectedValue = "test";
        knowledge.setPerson(expectedValue);
        String actualValue = knowledge.getPerson();
        String message = getMethodReturnResultAssertMessage("getPerson", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }
}
