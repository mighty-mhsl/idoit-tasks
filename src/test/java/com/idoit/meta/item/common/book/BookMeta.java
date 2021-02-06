package com.idoit.meta.item.common.book;

import com.idoit.meta.Meta;

import java.util.Arrays;

public abstract class BookMeta extends Meta {

    @Override
    protected Class<? extends Look> getLookClass() {
        return BookLook.class;
    }

    @Override
    protected void initConstructors() {
        addConstructorForFields(Arrays.asList("name", "minLevel"));
    }

    public class BookLook extends Look {
        private String name;
        private int minLevel;

        BookLook(String name, int minLevel) {
            this.name = name;
            this.minLevel = minLevel;
        }

        public String getName() {
            return name;
        }

        public int getMinLevel() {
            return minLevel;
        }
    }
}
