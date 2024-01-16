package com.jaredbwasserman.openfda.ui.fieldlist;

import javax.swing.*;
import java.awt.*;

public class FieldListItemCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list,
                                                  Object value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof FieldListItem) {
            setText(((FieldListItem) value).getField());
        }
        return this;
    }
}
