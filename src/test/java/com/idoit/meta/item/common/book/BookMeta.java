package com.idoit.meta.item.common.book;

import com.idoit.meta.Meta;

abstract class BookMeta extends Meta {
    BookMeta() {
        packageName = BASE_PACKAGE + ".item.common.book";
        fields.put("name", String.class);
        fields.put("minLevel", int.class);
    }
}
