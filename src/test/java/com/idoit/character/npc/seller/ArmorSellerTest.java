package com.idoit.character.npc.seller;

import com.idoit.meta.Meta;
import com.idoit.meta.character.npc.seller.ArmorSellerMeta;
import com.idoit.meta.item.armor.BootsMeta;
import com.idoit.meta.item.armor.CuirassMeta;
import com.idoit.meta.item.armor.GlovesMeta;
import com.idoit.meta.item.armor.HelmetMeta;
import com.idoit.meta.item.armor.ShieldMeta;
import com.idoit.safe.SafeFunction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе ArmorSeller")
class ArmorSellerTest extends SellerTest {

    @BeforeEach
	void setUp() {
        setMeta(ArmorSellerMeta.class);
    }

    @DisplayName("Тест, что класс ArmorSeller находится в пакете com.idoit.character.npc.seller")
    @Test
    void testArmorSellerIsInNpcPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс ArmorSeller имеет все необходимые поля")
    @Test
    void testArmorSellerHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе ArmorSeller есть конструктор принимающий название и уровень нпс")
    @Test
    void testArmorSellerHasConstructorWithNameAndBothDefenceParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 3);
    }

    @DisplayName("Тест, что в классе ArmorSeller есть все необходимые методы")
    @Test
    void testArmorSellerHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод fix в классе ArmorSeller восстанавливает прочность шлема до 100")
    @Test
    void testFixIncreasesHelmetDurability() {
        testFix(HelmetMeta.class, getArmorCreator());
    }

    @DisplayName("Тест, что метод fix в классе ArmorSeller восстанавливает прочность кирасы до 100")
    @Test
    void testFixIncreasesCuirassDurability() {
        testFix(CuirassMeta.class, getArmorCreator());
    }

    @DisplayName("Тест, что метод fix в классе ArmorSeller восстанавливает прочность сапог до 100")
    @Test
    void testFixIncreasesBootsDurability() {
        testFix(BootsMeta.class, getArmorCreator());
    }

    @DisplayName("Тест, что метод fix в классе ArmorSeller восстанавливает прочность перчаток до 100")
    @Test
    void testFixIncreasesGlovesDurability() {
        testFix(GlovesMeta.class, getArmorCreator());
    }

    @DisplayName("Тест, что метод fix в классе ArmorSeller восстанавливает прочность щита до 100")
    @Test
    void testFixIncreasesShieldDurability() {
        testFix(ShieldMeta.class, getArmorCreator());
    }

    private SafeFunction<Meta, Object> getArmorCreator() {
        return (armorMeta) -> armorMeta.instantiateObjectWithConstructor("armor", 10, 5);
    }
}
