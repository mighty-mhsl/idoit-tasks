package com.idoit.character.npc;

import com.idoit.character.Knight;
import com.idoit.quest.Quest;

public class NPC {
    public String name;
    public int level;
    public Quest quest;

    public NPC(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public void giveQuest(Knight knight) {
        knight.setActiveQuest(quest);
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Quest getQuest() {
        return quest;
    }
}
