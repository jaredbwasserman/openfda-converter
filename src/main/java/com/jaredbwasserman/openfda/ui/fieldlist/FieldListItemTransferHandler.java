package com.jaredbwasserman.openfda.ui.fieldlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.datatransfer.Transferable;

import static com.jaredbwasserman.openfda.ui.fieldlist.FieldListItemTransferable.FIELD_LIST_ITEM_DATA_FLAVOR;

// See https://stackoverflow.com/questions/15531783/add-string-to-jlist-exactly-where-theyre-dropped-not-at-the-bottom
public class FieldListItemTransferHandler extends TransferHandler {
    private static final Logger logger = LoggerFactory.getLogger(FieldListItemTransferHandler.class);

    public enum Mutability {
        MUTABLE,
        IMMUTABLE
    }

    private final JList<FieldListItem> fieldList;
    private final Mutability mutability;

    public FieldListItemTransferHandler(JList<FieldListItem> fieldList, Mutability mutability) {
        this.fieldList = fieldList;
        this.mutability = mutability;
    }

    @Override
    public boolean canImport(TransferSupport support) {
        boolean canImport = false;
        if (support.isDataFlavorSupported(FIELD_LIST_ITEM_DATA_FLAVOR)) {
            final JList.DropLocation dropLocation = (JList.DropLocation) support.getDropLocation();
            if (0 <= dropLocation.getIndex()) {
                canImport = true;
            }
        }
        return canImport;
    }

    @Override
    protected void exportDone(JComponent source, Transferable data, int action) {
        if (Mutability.IMMUTABLE.equals(mutability)) {
            return;
        }

        try {
            final FieldListItem fieldListItem = (FieldListItem) data.getTransferData(FIELD_LIST_ITEM_DATA_FLAVOR);
            ((DefaultListModel<FieldListItem>) fieldList.getModel()).removeElementAt(fieldListItem.getIndex());
            fixIndices();
        } catch (Exception e) {
            logger.error("Error during exportDone", e);
        }
    }

    @Override
    public boolean importData(TransferSupport support) {
        if (Mutability.IMMUTABLE.equals(mutability)) {
            return false;
        }

        boolean accepted = false;
        if (support.isDrop()) {
            if (support.isDataFlavorSupported(FIELD_LIST_ITEM_DATA_FLAVOR)) {
                final JList.DropLocation dropLocation = (JList.DropLocation) support.getDropLocation();
                final DefaultListModel<FieldListItem> model = (DefaultListModel<FieldListItem>) fieldList.getModel();
                final int dropIndex = dropLocation.getIndex();
                final boolean isInsert = dropLocation.isInsert();
                final Transferable transferable = support.getTransferable();

                try {
                    final FieldListItem fieldListItem = (FieldListItem) transferable.getTransferData(FIELD_LIST_ITEM_DATA_FLAVOR);

                    if (isInsert) {
                        if (dropIndex >= model.getSize()) {
                            model.addElement(new FieldListItem(dropIndex, fieldListItem.getField()));
                        } else {
                            model.add(dropIndex, new FieldListItem(dropIndex, fieldListItem.getField()));
                        }
                    } else {
                        model.addElement(new FieldListItem(dropIndex, fieldListItem.getField()));
                    }

                    fixIndices();
                    accepted = true;
                } catch (Exception e) {
                    logger.error("Error during importData", e);
                }
            }
        }
        return accepted;
    }

    @Override
    public int getSourceActions(JComponent c) {
        return COPY_OR_MOVE;
    }

    @Override
    protected Transferable createTransferable(JComponent c) {
        return new FieldListItemTransferable(fieldList.getSelectedValue());
    }

    private void fixIndices() {
        final DefaultListModel<FieldListItem> model = (DefaultListModel<FieldListItem>) fieldList.getModel();
        for (int index = 0; index < model.size(); ++index) {
            model.getElementAt(index).setIndex(index);
        }
    }
}
