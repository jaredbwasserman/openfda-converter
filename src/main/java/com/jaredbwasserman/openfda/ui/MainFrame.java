package com.jaredbwasserman.openfda.ui;

import com.jaredbwasserman.openfda.api.EndpointCategory;
import com.jaredbwasserman.openfda.api.OpenFDAAPI;
import com.jaredbwasserman.openfda.ui.endpoint.EndpointCategoryComboItem;
import com.jaredbwasserman.openfda.ui.endpoint.EndpointComboItem;
import com.jaredbwasserman.openfda.ui.fieldlist.FieldListItem;
import com.jaredbwasserman.openfda.ui.fieldlist.FieldListItemCellRenderer;
import com.jaredbwasserman.openfda.ui.fieldlist.FieldListItemTransferHandler;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.jaredbwasserman.openfda.ui.fieldlist.FieldListItemTransferHandler.Mutability;

public class MainFrame extends JFrame {
    // First row
    private final JComboBox<EndpointCategoryComboItem> endpointCategoryComboBox = new JComboBox<>();
    private final JComboBox<EndpointComboItem> endpointComboBox = new JComboBox<>();

    private final JButton selectInputFilesButton = new JButton();
    private final JButton clearInputFilesButton = new JButton();
    private final JList<String> inputFilesList = new JList<>(new DefaultListModel<>());

    // Second row
    private final JList<FieldListItem> availableFieldsList = new JList<>(new DefaultListModel<>());

    private final JList<FieldListItem> selectedFieldsList = new JList<>(new DefaultListModel<>());

    private final JList<FieldListItem> splitFieldsList = new JList<>(new DefaultListModel<>());

    public MainFrame() {
        setTitle("openFDA Converter");
        setLayout(new GridLayout(2, 3));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        initComponents();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        // First row
        addEndpointCategoryAndEndpointPanel();

        addInputFilesPanel();

        add(new JPanel()); // TODO: Fix me

        // Second row
        resetAvailableFieldsForSelectedEndpoint();
        addFieldsListPanel(availableFieldsList, Mutability.IMMUTABLE, "Available Fields");

        addFieldsListPanel(selectedFieldsList, Mutability.MUTABLE, "Fields To Select");
        selectedFieldsList.setDropMode(DropMode.INSERT);

        addFieldsListPanel(splitFieldsList, Mutability.MUTABLE, "Fields To Split On");
        splitFieldsList.setDropMode(DropMode.INSERT);
    }

    private void addEndpointCategoryAndEndpointPanel() {
        addEndpointCategories();
        endpointCategoryComboBox.setSelectedIndex(0);
        endpointCategoryComboBox.addActionListener(e -> addEndpointsForSelectedEndpointCategory());
        final JPanel endpointCategoryPanel = new JPanel(new BorderLayout());
        endpointCategoryPanel.setBorder(BorderFactory.createTitledBorder("Endpoint Category"));
        endpointCategoryPanel.add(endpointCategoryComboBox);

        addEndpointsForSelectedEndpointCategory();
        endpointComboBox.addActionListener(e -> resetAvailableFieldsForSelectedEndpoint());
        final JPanel endpointPanel = new JPanel(new BorderLayout());
        endpointPanel.setBorder(BorderFactory.createTitledBorder("Endpoint"));
        endpointPanel.add(endpointComboBox);

        final JPanel endpointCategoryAndEndpointPanel = new JPanel(new GridLayout(2, 1));
        endpointCategoryAndEndpointPanel.add(endpointCategoryPanel);
        endpointCategoryAndEndpointPanel.add(endpointPanel);
        add(endpointCategoryAndEndpointPanel);
    }

    private void addInputFilesPanel() {
        selectInputFilesButton.setText("Select Input Files");
        selectInputFilesButton.addActionListener(e -> {
            final JFileChooser inputFilesChooser = new JFileChooser();
            inputFilesChooser.setAcceptAllFileFilterUsed(false);
            inputFilesChooser.setFileFilter(new FileNameExtensionFilter("JSON", "json"));
            inputFilesChooser.setMultiSelectionEnabled(true);

            if (JFileChooser.APPROVE_OPTION == inputFilesChooser.showOpenDialog(MainFrame.this)) {
                final List<String> selectedFiles = Arrays.stream(inputFilesChooser.getSelectedFiles())
                        .map(File::getAbsolutePath)
                        .toList();
                final DefaultListModel<String> inputFilesListModel = (DefaultListModel<String>) inputFilesList.getModel();
                inputFilesListModel.removeAllElements();
                inputFilesListModel.addAll(selectedFiles);
            }
        });

        clearInputFilesButton.setText("Clear Input Files");
        clearInputFilesButton.addActionListener(e ->
                ((DefaultListModel<String>) inputFilesList.getModel()).removeAllElements()
        );

        inputFilesList.setSelectionModel(new DisabledItemSelectionModel());
        final JScrollPane inputFilesScrollPane = new JScrollPane(inputFilesList);

        final JPanel inputFilesPanel = new JPanel(new BorderLayout());
        inputFilesPanel.setBorder(BorderFactory.createTitledBorder("Input Files (Optional)"));
        inputFilesPanel.add(selectInputFilesButton, BorderLayout.WEST);
        inputFilesPanel.add(clearInputFilesButton, BorderLayout.EAST);
        inputFilesPanel.add(inputFilesScrollPane, BorderLayout.SOUTH);
        add(inputFilesPanel);
    }

    private void addFieldsListPanel(JList<FieldListItem> fieldsList, Mutability mutability, String title) {
        fieldsList.setCellRenderer(new FieldListItemCellRenderer());
        fieldsList.setTransferHandler(new FieldListItemTransferHandler(fieldsList, mutability));
        fieldsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fieldsList.setDragEnabled(true);
        final JScrollPane scrollPane = new JScrollPane(fieldsList);
        scrollPane.setPreferredSize(new Dimension(500, 200));
        final JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBorder(BorderFactory.createTitledBorder(title));
        listPanel.add(scrollPane);
        add(listPanel);
    }

    private void addEndpointCategories() {
        OpenFDAAPI.getEndpointCategories().forEach(endpointCategory ->
                endpointCategoryComboBox.addItem(new EndpointCategoryComboItem(
                        endpointCategory.friendlyName().displayName(),
                        endpointCategory
                ))
        );
    }

    private void addEndpointsForSelectedEndpointCategory() {
        final EndpointCategoryComboItem endpointCategoryComboItem =
                (EndpointCategoryComboItem) endpointCategoryComboBox.getSelectedItem();
        if (null != endpointCategoryComboItem) {
            endpointComboBox.removeAllItems();
            addEndpoints(endpointCategoryComboItem.endpointCategory());
        }
    }

    private void addEndpoints(EndpointCategory endpointCategory) {
        endpointCategory.endpoints().forEach(endpoint ->
                endpointComboBox.addItem(new EndpointComboItem(
                        endpoint.friendlyName().displayName(),
                        endpoint
                ))
        );
    }

    private void resetAvailableFieldsForSelectedEndpoint() {
        final EndpointComboItem endpointComboItem = (EndpointComboItem) endpointComboBox.getSelectedItem();
        if (null != endpointComboItem) {
            final List<String> availableFields = endpointComboItem.endpoint().fields();
            final List<FieldListItem> newFieldList = new ArrayList<>();
            for (int index = 0; index < availableFields.size(); ++index) {
                newFieldList.add(new FieldListItem(index, availableFields.get(index)));
            }
            final DefaultListModel<FieldListItem> availableFieldsListModel = (DefaultListModel<FieldListItem>) availableFieldsList.getModel();
            availableFieldsListModel.removeAllElements();
            availableFieldsListModel.addAll(newFieldList);

            final DefaultListModel<FieldListItem> selectedFieldsListModel = (DefaultListModel<FieldListItem>) selectedFieldsList.getModel();
            selectedFieldsListModel.removeAllElements();

            final DefaultListModel<FieldListItem> splitFieldsListModel = (DefaultListModel<FieldListItem>) splitFieldsList.getModel();
            splitFieldsListModel.removeAllElements();
        }
    }
}
