package com.idoit.meta.knowledge;

import com.idoit.meta.Meta;

public class KnowledgeMeta extends Meta {

    @Override
    protected Class<? extends Look> getLookClass() {
        return KnowledgeLook.class;
    }

    @Override
    public KnowledgeLook getLook() {
        return new KnowledgeLook();
    }

    public class KnowledgeLook extends Look {
        private String description;
        private String person;

        public String getDescription() {
            return (String) invokeOriginal();
        }

        public void setDescription(String description) {
            invokeOriginal(description);
            this.description = description;
        }

        public String getPerson() {
            return (String) invokeOriginal();
        }

        public void setPerson(String person) {
            invokeOriginal(person);
            this.person = person;
        }
    }
}
