package com.idoit.profile;

import com.idoit.knowledge.Knowledge;
import com.idoit.quest.Quest;

public class Journal {
    public Quest quest;
    public Knowledge knowledge;

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public Knowledge getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
    }
}
