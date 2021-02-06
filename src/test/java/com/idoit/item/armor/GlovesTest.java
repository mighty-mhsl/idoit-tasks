package com.idoit.item.armor;

import com.idoit.AbstractTest;
import com.idoit.meta.item.armor.GlovesMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Gloves")
class GlovesTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new GlovesMeta());
    }

    @DisplayName("Тест, что класс Gloves находится в пакете com.idoit.item.armor")
    @Test
    void testGlovesIsInArmorPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Gloves имеет все необходимые поля")
    @Test
    void testGlovesHasAllFields() {
        testClassHasFields();
    }
}
