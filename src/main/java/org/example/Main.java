package org.example;

import org.example.views.LoginFrame;

import javax.swing.*;

/**
 * Application principale de gestion de cabinet dentaire
 */
public class Main {
    public static void main(String[] args) {
        // Configuration du look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Lancement de l'application
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}