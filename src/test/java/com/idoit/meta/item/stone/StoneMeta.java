package com.idoit.meta.item.stone;

import com.idoit.meta.Meta;

public abstract class StoneMeta extends Meta {

    @Override
    protected Class<? extends Look> getLookClass() {
        return StoneLook.class;
    }

    @Override
    public Look getLook() {
        return new StoneLook();
    }

    private class StoneLook extends Look {

    }
}
