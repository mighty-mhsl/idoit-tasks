package com.idoit.knowledge;

import com.idoit.AbstractTest;
import com.idoit.meta.knowledge.KnowledgeMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Knowledge")
class KnowledgeTest extends AbstractTest {
    
    @BeforeEach
    void setUp() {
        setMeta(KnowledgeMeta.class);
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
        testSetter("test", "setDescription", "description");
    }

    @DisplayName("Тест, что метод setPerson в классе Knowledge сохраняет персонажа в поле класса")
    @Test
    void testSetPerson() {
        testSetter("test", "setPerson", "person");
    }

    @DisplayName("Тест, что метод getDescription в классе Knowledge возвращает описание знания")
    @Test
    void testGetDescription() {
        testGetter("getDescription", "setDescription", "test");
    }

    @DisplayName("Тест, что метод getPerson в классе Knowledge возвращает персонажа")
    @Test
    void testGetPerson() {
        testGetter("getPerson", "setPerson", "test");
    }
}
