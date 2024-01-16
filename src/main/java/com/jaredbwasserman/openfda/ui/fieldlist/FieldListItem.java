package com.jaredbwasserman.openfda.ui.fieldlist;

import lombok.Getter;
import lombok.Setter;

@Getter
public class FieldListItem {
    @Setter
    private int index;
    private final String field;

    public FieldListItem(int index, String field) {
        this.index = index;
        this.field = field;
    }

    @Override
    public String toString() {
        return String.format("FieldListItem[index=%d, field=%s]", index, field);
    }
}
