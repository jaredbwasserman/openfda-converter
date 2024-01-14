package com.jaredbwasserman.openfda.ui;

import com.jaredbwasserman.openfda.api.EndpointCategory;
import com.jaredbwasserman.openfda.api.OpenFDAAPI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static final String TITLE = "openFDA Converter";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private final JLabel endpointCategoryLabel = new JLabel();
    private final JLabel endpointLabel = new JLabel();
    private final JComboBox<EndpointCategoryComboItem> endpointCategoryComboBox = new JComboBox<>();
    private final JComboBox<EndpointComboItem> endpointComboBox = new JComboBox<>();
    private final JButton placeholderButton = new JButton();

    public MainFrame() {
        setTitle(TITLE);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        endpointCategoryLabel.setText("Endpoint Category:");
        add(endpointCategoryLabel);

        addEndpointCategories();
        endpointCategoryComboBox.setSelectedIndex(0);
        endpointCategoryComboBox.addActionListener(e -> addEndpointsForSelectedEndpointCategory());
        add(endpointCategoryComboBox);

        endpointLabel.setText("Endpoint:");
        add(endpointLabel);

        addEndpointsForSelectedEndpointCategory();
        add(endpointComboBox);

        addNewLine();

        add(placeholderButton);
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

    private void addNewLine() {
        final JLabel newLine = new JLabel();
        newLine.setPreferredSize(new Dimension(WIDTH, 0));
        add(newLine);
    }
}
