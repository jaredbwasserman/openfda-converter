package com.jaredbwasserman.openfda.ui;

import com.jaredbwasserman.openfda.api.EndpointCategory;
import com.jaredbwasserman.openfda.api.OpenFDAAPI;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private JPanel mainPanel;
    private JLabel endpointCategoryLabel;
    private JComboBox<EndpointCategoryComboItem> endpointCategoryComboBox;
    private JLabel endpointLabel;
    private JComboBox<EndpointComboItem> endpointComboBox;
    private JLabel newLine1;
    private JButton placeholderButton;

    public MainForm() {
        setContentPane(mainPanel);
        setTitle("openFDA Converter");

        addEndpointCategories();
        endpointCategoryComboBox.addActionListener(e -> addEndpointsForSelectedEndpointCategory());

        newLine1.setPreferredSize(new Dimension(WIDTH, 0));

        setDefaultValues();
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
