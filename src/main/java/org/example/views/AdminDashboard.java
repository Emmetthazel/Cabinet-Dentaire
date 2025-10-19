package org.example.views;

import javax.swing.*;
import java.awt.*;

/**
 * Tableau de bord administrateur avec accès complet
 */
public class AdminDashboard extends JFrame {
    private JLabel welcomeLabel;
    private JTable appointmentsTable;

    public AdminDashboard() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        setTitle("Tableau de bord - Administrateur");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setResizable(true);

        welcomeLabel = new JLabel("Bienvenue dans le tableau de bord administrateur");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        // Sidebar de navigation pour administrateur
        JPanel sidebar = createAdminSidebar();

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // Header avec titre et bouton déconnexion
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel titleLabel = new JLabel("Dashboard Administrateur");
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

        // Carte 4 - Revenus
        JPanel card4 = createStatCard("Revenus", "15,000€");
        statsCardsPanel.add(card4);

        // Tableau des rendez-vous
        JPanel appointmentsPanel = new JPanel(new BorderLayout());
        appointmentsPanel.setBackground(Color.WHITE);
        appointmentsPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel appointmentsTitle = new JLabel("Vue d'ensemble des rendez-vous");
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
        String[] columnNames = {"Heure", "Nom Patient", "Prénom Patient", "Acte", "Médecin", "Status"};
        Object[][] data = {
            {"10:00 AM", "Aitidir", "Abdelkhalek", "Dent de sagesse", "Dr. Berrada", "Confirmé"},
            {"11:30 AM", "Boulahbach", "Zineb", "Détartrage", "Dr. Berrada", "En attente"}
        };
        JTable appointmentsTable = new JTable(data, columnNames);
        appointmentsTable.setPreferredScrollableViewportSize(new Dimension(800, 200));
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

    private JPanel createAdminSidebar() {
        JPanel sidebar = new JPanel(new BorderLayout());
        sidebar.setBackground(Color.WHITE);
        sidebar.setPreferredSize(new Dimension(200, 0));
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Header avec logo
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(Color.WHITE);
        
        JLabel logoLabel = new JLabel("D");
        logoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        logoLabel.setForeground(new Color(0, 123, 255));
        
        JLabel dellLabel = new JLabel("DENTAL");
        dellLabel.setFont(new Font("Arial", Font.BOLD, 16));
        dellLabel.setForeground(new Color(0, 123, 255));
        JLabel youSmileLabel = new JLabel("CARE PRO");
        youSmileLabel.setFont(new Font("Arial", Font.BOLD, 14));
        youSmileLabel.setForeground(new Color(40, 167, 69));
        
        headerPanel.add(logoLabel);
        headerPanel.add(Box.createHorizontalStrut(5));
        headerPanel.add(dellLabel);
        headerPanel.add(youSmileLabel);

        // Menu de navigation pour administrateur
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(Color.WHITE);
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        JButton dashboardBtn = new JButton("Dashboard");
        JButton appointmentsBtn = new JButton("Rendez-vous");
        JButton patientsBtn = new JButton("Patients");
        JButton invoicesBtn = new JButton("Factures");
        JButton doctorScheduleBtn = new JButton("Agenda Médecin");
        JButton usersBtn = new JButton("Gestion Utilisateurs");
        JButton reportsBtn = new JButton("Rapports");
        JButton settingsBtn = new JButton("Paramètres");

        // Style des boutons
        JButton[] buttons = {dashboardBtn, appointmentsBtn, patientsBtn, invoicesBtn, 
                            doctorScheduleBtn, usersBtn, reportsBtn, settingsBtn};
        for (JButton btn : buttons) {
            btn.setPreferredSize(new Dimension(160, 40));
            btn.setHorizontalAlignment(SwingConstants.LEFT);
            btn.setBackground(new Color(248, 249, 250)); // Gris très clair
            btn.setForeground(new Color(33, 37, 41)); // Gris foncé pour le texte
            btn.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
            btn.setFont(new Font("Arial", Font.PLAIN, 12));
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);
        }

        // Mettre en évidence Dashboard
        dashboardBtn.setBackground(new Color(0, 123, 255));
        dashboardBtn.setForeground(Color.WHITE);

        menuPanel.add(dashboardBtn);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(appointmentsBtn);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(patientsBtn);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(invoicesBtn);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(doctorScheduleBtn);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(usersBtn);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(reportsBtn);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(settingsBtn);

        // Gestionnaires d'événements pour les boutons de navigation
        appointmentsBtn.addActionListener(e -> {
            dispose();
            new AppointmentManagementFrame().setVisible(true);
        });
        
        patientsBtn.addActionListener(e -> {
            dispose();
            new PatientManagementFrame().setVisible(true);
        });
        
        invoicesBtn.addActionListener(e -> {
            dispose();
            new InvoiceManagementFrame().setVisible(true);
        });
        
        doctorScheduleBtn.addActionListener(e -> {
            dispose();
            new DoctorScheduleFrame().setVisible(true);
        });
        
        // Boutons spécifiques admin
        usersBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Gestion des utilisateurs - Fonctionnalité en développement", "Info", JOptionPane.INFORMATION_MESSAGE);
        });
        
        reportsBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Rapports - Fonctionnalité en développement", "Info", JOptionPane.INFORMATION_MESSAGE);
        });
        
        settingsBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Paramètres - Fonctionnalité en développement", "Info", JOptionPane.INFORMATION_MESSAGE);
        });

        sidebar.add(headerPanel, BorderLayout.NORTH);
        sidebar.add(menuPanel, BorderLayout.CENTER);

        return sidebar;
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
        iconLabel.setForeground(new Color(0, 123, 255));

        // Valeur
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 20));
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Titre
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(Color.GRAY);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);
        topPanel.add(iconLabel, BorderLayout.WEST);
        topPanel.add(valueLabel, BorderLayout.CENTER);

        card.add(topPanel, BorderLayout.CENTER);
        card.add(titleLabel, BorderLayout.SOUTH);

        return card;
    }
}
