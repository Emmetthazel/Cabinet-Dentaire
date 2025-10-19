package org.example.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tableau de bord principal pour les secrétaires
 */
public class SecretaryDashboard extends JFrame {
    private JLabel welcomeLabel;
    private JPanel statsPanel;
    private JPanel quickActionsPanel;

    public SecretaryDashboard() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        setTitle("Tableau de bord - Secrétaire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        welcomeLabel = new JLabel("Bienvenue dans le tableau de bord secrétaire");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        // Sidebar de navigation
        SidebarPanel sidebar = new SidebarPanel("Dashboard");
        sidebar.setActionListener(e -> {
            String command = ((JButton) e.getSource()).getText();
            switch (command) {
                case "Rendez-vous":
                    dispose();
                    new AppointmentManagementFrame().setVisible(true);
                    break;
                case "Patients":
                    dispose();
                    new PatientManagementFrame().setVisible(true);
                    break;
                case "Factures":
                    dispose();
                    new InvoiceManagementFrame().setVisible(true);
                    break;
                case "Agenda Médecin":
                    dispose();
                    new DoctorScheduleFrame().setVisible(true);
                    break;
            }
        });

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // Header avec titre et bouton déconnexion
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel titleLabel = new JLabel("Dashboard");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        JLabel welcomeLabel = new JLabel("Welcome back, " + org.example.models.CurrentUser.getDisplayName());
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        welcomeLabel.setForeground(Color.GRAY);

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(Color.WHITE);
        titlePanel.add(titleLabel, BorderLayout.NORTH);
        titlePanel.add(welcomeLabel, BorderLayout.SOUTH);

        JButton logoutBtn = new JButton("Se déconnecter");
        logoutBtn.setPreferredSize(new Dimension(120, 30));
        logoutBtn.setBackground(new Color(220, 53, 69)); // Rouge pour déconnexion
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setBorderPainted(false);
        logoutBtn.setFocusPainted(false);

        headerPanel.add(titlePanel, BorderLayout.WEST);
        headerPanel.add(logoutBtn, BorderLayout.EAST);

        // Cartes de statistiques
        JPanel statsCardsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        statsCardsPanel.setBackground(Color.WHITE);
        statsCardsPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        // Carte 1 - Total Patient
        JPanel card1 = createStatCard("Total Patient", "150");
        statsCardsPanel.add(card1);

        // Carte 2 - Patient Visit
        JPanel card2 = createStatCard("Patient Visit", "150");
        statsCardsPanel.add(card2);

        // Carte 3 - Total Rendez-vous
        JPanel card3 = createStatCard("Total Rendez-vous", "170");
        statsCardsPanel.add(card3);

        // Tableau des rendez-vous
        JPanel appointmentsPanel = new JPanel(new BorderLayout());
        appointmentsPanel.setBackground(Color.WHITE);
        appointmentsPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel appointmentsTitle = new JLabel("les rendez-vous du Patient");
        appointmentsTitle.setFont(new Font("Arial", Font.BOLD, 16));
        
        JButton todayBtn = new JButton("Aujourd'hui");
        todayBtn.setPreferredSize(new Dimension(100, 30));
        todayBtn.setBackground(new Color(40, 167, 69)); // Vert pour action positive
        todayBtn.setForeground(Color.WHITE);
        todayBtn.setBorderPainted(false);
        todayBtn.setFocusPainted(false);

        JPanel titleBar = new JPanel(new BorderLayout());
        titleBar.setBackground(Color.WHITE);
        titleBar.add(appointmentsTitle, BorderLayout.WEST);
        titleBar.add(todayBtn, BorderLayout.EAST);

        // Tableau des rendez-vous
        String[] columnNames = {"Heure", "Nom Patient", "Prénom Patient", "Acte", "Prochaine visite"};
        Object[][] data = {
            {"10:00 AM", "Aitidir", "Abdelkhalek", "Dent de sagesse", "23-10-2024"}
        };
        JTable appointmentsTable = new JTable(data, columnNames);
        appointmentsTable.setPreferredScrollableViewportSize(new Dimension(600, 200));
        JScrollPane scrollPane = new JScrollPane(appointmentsTable);

        appointmentsPanel.add(titleBar, BorderLayout.NORTH);
        appointmentsPanel.add(scrollPane, BorderLayout.CENTER);

        // Assemblage du contenu principal
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.add(statsCardsPanel, BorderLayout.NORTH);
        contentPanel.add(appointmentsPanel, BorderLayout.CENTER);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        add(sidebar, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        // Gestionnaire d'événements pour le bouton déconnexion
        logoutBtn.addActionListener(e -> {
            dispose();
            new LoginFrame().setVisible(true);
        });
    }

    private JPanel createStatCard(String title, String value) {
        JPanel card = new JPanel(new BorderLayout());
        card.setPreferredSize(new Dimension(200, 120));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.LIGHT_GRAY),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        // Icône de pourcentage
        JLabel iconLabel = new JLabel("%");
        iconLabel.setFont(new Font("Arial", Font.BOLD, 24));
        iconLabel.setForeground(Color.GRAY);

        // Titre
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        titleLabel.setForeground(Color.GRAY);

        // Valeur
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 24));
        valueLabel.setForeground(Color.BLACK);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.WHITE);
        leftPanel.add(iconLabel, BorderLayout.NORTH);
        leftPanel.add(titleLabel, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.WHITE);
        rightPanel.add(valueLabel, BorderLayout.CENTER);

        card.add(leftPanel, BorderLayout.WEST);
        card.add(rightPanel, BorderLayout.EAST);

        return card;
    }

}
