package com.jaredbwasserman.openfda.ui;

import com.jaredbwasserman.openfda.api.EndpointCategory;
import com.jaredbwasserman.openfda.api.OpenFDAAPI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private final JLabel endpointCategoryLabel;
    private final JComboBox<EndpointCategoryComboItem> endpointCategoryComboBox;
    private final JLabel endpointLabel;
    private final JComboBox<EndpointComboItem> endpointComboBox;
    private final JLabel newLine1;
    private final JButton placeholderButton;

    public MainFrame() {
        endpointCategoryLabel = new JLabel();
        endpointCategoryComboBox = new JComboBox<>();
        endpointLabel = new JLabel();
        endpointComboBox = new JComboBox<>();
        newLine1 = new JLabel();
        placeholderButton = new JButton();

        add(endpointCategoryLabel);
        add(endpointCategoryComboBox);
        add(endpointLabel);
        add(endpointComboBox);
        add(newLine1);
        add(placeholderButton);

        setTitle("openFDA Converter");

        addEndpointCategories();
        endpointCategoryComboBox.addActionListener(e -> addEndpointsForSelectedEndpointCategory());

        newLine1.setPreferredSize(new Dimension(WIDTH, 0));

        setDefaultValues();
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
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
        final EndpointCategoryComboItem endpointCategoryComboItem = (EndpointCategoryComboItem) endpointCategoryComboBox.getSelectedItem();
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

    private void setDefaultValues() {
        endpointCategoryComboBox.setSelectedIndex(0);
        addEndpointsForSelectedEndpointCategory();
    }
}
