package com.jaredbwasserman.openfda.ui.fieldlist;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

public class FieldListItemTransferable implements Transferable {
    public static final DataFlavor FIELD_LIST_ITEM_DATA_FLAVOR = new DataFlavor(
            FieldListItem.class,
            "FieldListItem"
    );

    private final FieldListItem fieldListItem;

    public FieldListItemTransferable(FieldListItem fieldListItem) {
        this.fieldListItem = fieldListItem;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{FIELD_LIST_ITEM_DATA_FLAVOR};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return FIELD_LIST_ITEM_DATA_FLAVOR.equals(flavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
        if (isDataFlavorSupported(flavor)) {
            return fieldListItem;
        }
        throw new UnsupportedFlavorException(flavor);
    }
}
