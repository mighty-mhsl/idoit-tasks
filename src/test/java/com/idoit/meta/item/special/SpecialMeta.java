package com.idoit.meta.item.special;

import com.idoit.meta.Meta;

public abstract class SpecialMeta extends Meta {
    @Override
    protected Class<? extends Look> getLookClass() {
        return SpecialLook.class;
    }

    @Override
    public Look getLook() {
        return new SpecialLook();
    }

    private class SpecialLook extends Look {

    }
}
