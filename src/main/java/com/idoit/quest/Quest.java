package com.idoit.quest;

import com.idoit.character.Knight;

public class Quest {
    public String name;
    public String description;
    public int expReward;
    public int goldReward;
    public int minLevel;

    public Quest(String name, String description, int expReward, int goldReward, int minLevel) {
        this.name = name;
        this.description = description;
        this.expReward = expReward;
        this.goldReward = goldReward;
        this.minLevel = minLevel;
    }

    public void complete(Knight knight) {
        knight.addExperience(expReward);
        knight.addGold(goldReward);
    }
}
