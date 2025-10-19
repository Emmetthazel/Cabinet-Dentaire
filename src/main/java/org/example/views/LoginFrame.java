package org.example.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Page de connexion pour l'application de gestion de cabinet dentaire
 */
public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private JButton loginButton;
    private JButton cancelButton;

    public LoginFrame() {
        initializeComponents();
        setupLayout();
        setupEventHandlers();
    }

    private void initializeComponents() {
        setTitle("Connexion - DENTAL CARE PRO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(true);

        // Composants
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        roleComboBox = new JComboBox<>(new String[]{"Secrétaire", "Médecin", "Administrateur"});
        loginButton = new JButton("Se connecter");
        cancelButton = new JButton("Annuler");
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        // Header avec logo
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel dellLabel = new JLabel("DENTAL");
        dellLabel.setFont(new Font("Arial", Font.BOLD, 18));
        dellLabel.setForeground(new Color(0, 123, 255));
        JLabel youSmileLabel = new JLabel("CARE PRO");
        youSmileLabel.setFont(new Font("Arial", Font.BOLD, 16));
        youSmileLabel.setForeground(new Color(40, 167, 69));
        
        JPanel leftHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftHeader.setBackground(Color.WHITE);
        leftHeader.add(dellLabel);
        leftHeader.add(youSmileLabel);
        
        JPanel logoPanel = new JPanel(new BorderLayout());
        logoPanel.setBackground(new Color(0, 123, 255));
        logoPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        logoPanel.setPreferredSize(new Dimension(100, 70));
        
        JLabel logoLabel = new JLabel("D");
        logoLabel.setFont(new Font("Arial", Font.BOLD, 48));
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabel.setForeground(Color.WHITE);
        logoPanel.add(logoLabel, BorderLayout.CENTER);
        
        headerPanel.add(leftHeader, BorderLayout.WEST);
        headerPanel.add(logoPanel, BorderLayout.EAST);

        // Panel principal avec split
        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        mainSplitPane.setDividerLocation(500);
        mainSplitPane.setDividerSize(2);
        mainSplitPane.setEnabled(false); // Désactiver le redimensionnement

        // Panel gauche - Formulaire de connexion
        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(80, 80, 80, 80));
        GridBagConstraints gbc = new GridBagConstraints();

        // Titre de connexion
        JLabel loginTitle = new JLabel("Connexion");
        loginTitle.setFont(new Font("Arial", Font.BOLD, 24));
        loginTitle.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 40, 0);
        leftPanel.add(loginTitle, gbc);

        // Nom d'utilisateur
        JLabel usernameLabel = new JLabel("Nom d'utilisateur");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(usernameLabel, gbc);

        usernameField.setPreferredSize(new Dimension(250, 35));
        usernameField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 20, 0);
        leftPanel.add(usernameField, gbc);

        // Mot de passe
        JLabel passwordLabel = new JLabel("Mot de passe");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0; gbc.gridy = 3; gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(passwordLabel, gbc);

        passwordField.setPreferredSize(new Dimension(250, 35));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0; gbc.gridy = 4; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 30, 0);
        leftPanel.add(passwordField, gbc);

        // Sélection du rôle
        JLabel roleLabel = new JLabel("Rôle");
        roleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0; gbc.gridy = 5; gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(roleLabel, gbc);

        roleComboBox.setPreferredSize(new Dimension(250, 35));
        roleComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0; gbc.gridy = 6; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 40, 0);
        leftPanel.add(roleComboBox, gbc);

        // Bouton de connexion
        loginButton.setPreferredSize(new Dimension(250, 40));
        loginButton.setBackground(new Color(0, 123, 255)); // Bleu professionnel
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        gbc.gridx = 0; gbc.gridy = 7; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 20, 0);
        leftPanel.add(loginButton, gbc);

        // Bouton d'annulation
        cancelButton.setPreferredSize(new Dimension(250, 40));
        cancelButton.setBackground(new Color(108, 117, 125)); // Gris
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Arial", Font.BOLD, 16));
        cancelButton.setFocusPainted(false);
        cancelButton.setBorderPainted(false);
        gbc.gridx = 0; gbc.gridy = 8; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 0);
        leftPanel.add(cancelButton, gbc);

        // Panel droit - Zone d'image
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(new Color(248, 249, 250));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // Image placeholder plus grande et plus visible
        JPanel imageContainer = new JPanel(new BorderLayout());
        imageContainer.setBackground(new Color(0, 123, 255));
        imageContainer.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        
        JLabel imagePlaceholder = new JLabel("D");
        imagePlaceholder.setFont(new Font("Arial", Font.BOLD, 150));
        imagePlaceholder.setHorizontalAlignment(SwingConstants.CENTER);
        imagePlaceholder.setVerticalAlignment(SwingConstants.CENTER);
        imagePlaceholder.setForeground(Color.WHITE);
        
        JLabel welcomeText = new JLabel("Bienvenue dans DENTAL CARE PRO");
        welcomeText.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeText.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeText.setForeground(Color.WHITE);
        
        imageContainer.add(imagePlaceholder, BorderLayout.CENTER);
        imageContainer.add(welcomeText, BorderLayout.SOUTH);
        
        rightPanel.add(imageContainer, BorderLayout.CENTER);

        mainSplitPane.setLeftComponent(leftPanel);
        mainSplitPane.setRightComponent(rightPanel);

        // Footer
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.WHITE);
        footerPanel.setPreferredSize(new Dimension(0, 20));

        add(headerPanel, BorderLayout.NORTH);
        add(mainSplitPane, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);
    }

    private void setupEventHandlers() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String role = (String) roleComboBox.getSelectedItem();

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(LoginFrame.this, 
                        "Veuillez remplir tous les champs", 
                        "Erreur", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Simulation de connexion
                if (authenticate(username, password, role)) {
                    // Enregistrer l'utilisateur actuel
                    org.example.models.CurrentUser.setUser(username, role);
                    
                    JOptionPane.showMessageDialog(LoginFrame.this, 
                        "Connexion " + role.toLowerCase() + " réussie !", 
                        "Succès", 
                        JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    openDashboard(role);
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, 
                        "Nom d'utilisateur ou mot de passe incorrect pour " + role.toLowerCase(), 
                        "Erreur", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelButton.addActionListener(_ -> System.exit(0));
    }

    private boolean authenticate(String username, String password, String role) {
        // Simulation d'authentification avec différents rôles
        switch (role) {
            case "Secrétaire":
                return username.equals("secretaire") && password.equals("secret123");
            case "Médecin":
                return username.equals("medecin") && password.equals("med123");
            case "Administrateur":
                return username.equals("admin") && password.equals("admin123");
            default:
                return false;
        }
    }

    private void openDashboard(String role) {
        switch (role) {
            case "Secrétaire":
                new SecretaryDashboard().setVisible(true);
                break;
            case "Médecin":
                new DoctorDashboard().setVisible(true);
                break;
            case "Administrateur":
                new AdminDashboard().setVisible(true);
                break;
        }
    }
}
