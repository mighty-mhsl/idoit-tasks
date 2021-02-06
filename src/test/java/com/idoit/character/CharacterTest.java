package com.idoit.character;

import com.idoit.MessageUtil;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.profile.ProfileMeta;
import com.idoit.safe.Safer;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class CharacterTest extends AbstractCharacterTest {

    private static final String CONSTRUCTOR_PARAM = "test";

    ProfileMeta createProfile() {
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        ProfileMeta.ProfileLook profileLook = profile.getLook();
        profileLook.setHp(100);
        profileLook.setStamina(100);
        profileLook.setMana(100);
        profileLook.setAgility(7);
        profileLook.setStrength(7);
        profileLook.setIntelligence(7);
        profileLook.setGold(100);
        profileLook.setExperience(100);
        return profile;
    }

    KnightMeta createKnightWith(ProfileMeta profile) {
        KnightMeta knight = (KnightMeta) MetaContext.getMeta(KnightMeta.class);
        KnightMeta.KnightLook knightLook = knight.getLook();
        knightLook.setProfile(profile);
        return knight;
    }

    String getCoordinatesAssertMessage(String coordinate, int expectedValue, int actualValue) {
        return MessageUtil.formatAssertMessage(
                String.format("Значение координаты %s в точке персонажа должно быть %d", coordinate, expectedValue),
                String.format("Значение координаты %s в точке персонажа %d", coordinate, actualValue));
    }

    void testConstructorSetsValuesToProfile() {
        Safer.runSafe(() -> {
            Object character = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            Object profile = getProfile(character);
            String nameFieldName = "name";
            Object actualName = getFieldValue(profile, nameFieldName);
            String message = getConstructorAssertMessage(profile, nameFieldName);
            assertEquals(CONSTRUCTOR_PARAM, actualName, message);
        });
    }

    private Object getProfile(Object obj) throws NoSuchFieldException, IllegalAccessException {
        String profileFieldName = "profile";
        return getFieldValue(obj, profileFieldName);
    }

    private String getConstructorAssertMessage(Object profile, String nameFieldName) {
        return MessageUtil.formatAssertMessage(
                String.format("В классе %s полю %s в конструкторе должно выставляться значение параметра",
                        profile.getClass().getName(), nameFieldName),
                String.format("В классе %s полю %s в конструкторе не выставляется значение параметра",
                        profile.getClass().getName(), nameFieldName)
        );
    }
}
