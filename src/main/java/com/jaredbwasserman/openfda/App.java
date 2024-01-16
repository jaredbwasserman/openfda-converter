package com.jaredbwasserman.openfda;

import com.jaredbwasserman.openfda.ui.MainFrame;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        new MainFrame();
    }
}
