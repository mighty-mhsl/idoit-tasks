package com.idoit.character.npc.seller;

import com.idoit.AbstractTest;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.npc.seller.ArmorSellerMeta;
import com.idoit.meta.item.armor.BootsMeta;
import com.idoit.meta.item.armor.CuirassMeta;
import com.idoit.meta.item.armor.GlovesMeta;
import com.idoit.meta.item.armor.HelmetMeta;
import com.idoit.meta.item.armor.ShieldMeta;
import com.idoit.meta.item.special.InitialStoneMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе ArmorSeller")
class ArmorSellerTest extends AbstractTest {

    private ArmorSellerMeta.ArmorSellerLook seller;

    @BeforeEach
	void setUp() {
        setMeta(ArmorSellerMeta.class);
        ArmorSellerMeta meta = (ArmorSellerMeta) getMeta();
        seller = meta.getLook();
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
        int expectedDurability = 100;
        HelmetMeta helmet = (HelmetMeta) MetaContext.getMeta(HelmetMeta.class);
        helmet.getLook().setDurability(99);

        seller.fix(helmet);

        int actualDurability = helmet.getLook().getDurability();
        String message = getFieldValueAssert(helmet.getClassName(), "fix", "durability", expectedDurability, actualDurability);
        assertEquals(expectedDurability, actualDurability, message);
    }

    @DisplayName("Тест, что метод fix в классе ArmorSeller восстанавливает прочность кирасы до 100")
    @Test
    void testFixIncreasesCuirassDurability() {
        int expectedDurability = 100;
        CuirassMeta cuirass = (CuirassMeta) MetaContext.getMeta(CuirassMeta.class);
        cuirass.getLook().setDurability(99);

        seller.fix(cuirass);

        int actualDurability = cuirass.getLook().getDurability();
        String message = getFieldValueAssert(cuirass.getClassName(), "fix", "durability", expectedDurability, actualDurability);
        assertEquals(expectedDurability, actualDurability, message);
    }

    @DisplayName("Тест, что метод fix в классе ArmorSeller восстанавливает прочность сапог до 100")
    @Test
    void testFixIncreasesBootsDurability() {
        int expectedDurability = 100;
        BootsMeta boots = (BootsMeta) MetaContext.getMeta(BootsMeta.class);
        boots.getLook().setDurability(99);

        seller.fix(boots);

        int actualDurability = boots.getLook().getDurability();
        String message = getFieldValueAssert(boots.getClassName(), "fix", "durability", expectedDurability, actualDurability);
        assertEquals(expectedDurability, actualDurability, message);
    }

    @DisplayName("Тест, что метод fix в классе ArmorSeller восстанавливает прочность перчаток до 100")
    @Test
    void testFixIncreasesGlovesDurability() {
        int expectedDurability = 100;
        GlovesMeta gloves = (GlovesMeta) MetaContext.getMeta(GlovesMeta.class);
        gloves.getLook().setDurability(99);

        seller.fix(gloves);

        int actualDurability = gloves.getLook().getDurability();
        String message = getFieldValueAssert(gloves.getClassName(), "fix", "durability", expectedDurability, actualDurability);
        assertEquals(expectedDurability, actualDurability, message);
    }

    @DisplayName("Тест, что метод fix в классе ArmorSeller восстанавливает прочность щита до 100")
    @Test
    void testFixIncreasesShieldDurability() {
        int expectedDurability = 100;
        ShieldMeta shield = (ShieldMeta) MetaContext.getMeta(ShieldMeta.class);
        shield.getLook().setDurability(99);

        seller.fix(shield);

        int actualDurability = shield.getLook().getDurability();
        String message = getFieldValueAssert(shield.getClassName(), "fix", "durability", expectedDurability, actualDurability);
        assertEquals(expectedDurability, actualDurability, message);
    }

    @DisplayName("Тест, что метод accept в классе ArmorSeller увеличивает уровень кузнеца на 1")
    @Test
    void testAccept() {
        int expectedLevel = 2;
        InitialStoneMeta stone = (InitialStoneMeta) MetaContext.getMeta(InitialStoneMeta.class);

        seller.accept(stone);

        int actualLevel = seller.getLevel();
        String message = getFieldValueAssert(getMeta().getClassName(), "accept", "level", expectedLevel, actualLevel);
        assertEquals(expectedLevel, actualLevel, message);
    }
}
