package org.example.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Page de gestion des patients pour les secrétaires
 */
public class PatientManagementFrame extends JFrame {
    private JTable patientsTable;
    private DefaultTableModel tableModel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextField addressField;
    private JTextField birthDateField;
    private JComboBox<String> genderComboBox;
    private JTextArea medicalHistoryArea;
    private JTextArea allergiesArea;

    public PatientManagementFrame() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        setTitle("Gestion des Patients");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);

        // Table des patients
        String[] columnNames = {"ID", "Nom", "Prénom", "Téléphone", "Email", "Date de naissance", "Sexe", "Adresse"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Table en lecture seule
            }
        };
        patientsTable = new JTable(tableModel);
        patientsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Champs de formulaire
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        phoneField = new JTextField(20);
        emailField = new JTextField(20);
        addressField = new JTextField(20);
        birthDateField = new JTextField(10);
        genderComboBox = new JComboBox<>(new String[]{"Homme", "Femme", "Autre"});
        medicalHistoryArea = new JTextArea(4, 20);
        medicalHistoryArea.setLineWrap(true);
        allergiesArea = new JTextArea(3, 20);
        allergiesArea.setLineWrap(true);
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        // Sidebar de navigation
        SidebarPanel sidebar = new SidebarPanel("Patients");
        sidebar.setActionListener(e -> {
            String command = ((JButton) e.getSource()).getText();
            switch (command) {
                case "Dashboard":
                    dispose();
                    new SecretaryDashboard().setVisible(true);
                    break;
                case "Rendez-vous":
                    dispose();
                    new AppointmentManagementFrame().setVisible(true);
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

        JLabel titleLabel = new JLabel("Patients");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JButton logoutBtn = new JButton("Se déconnecter");
        logoutBtn.setPreferredSize(new Dimension(120, 30));
        logoutBtn.setBackground(new Color(220, 53, 69)); // Rouge pour déconnexion
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setBorderPainted(false);
        logoutBtn.setFocusPainted(false);

        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.add(logoutBtn, BorderLayout.EAST);

        // Contenu principal
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        // Bouton ajouter patient
        JButton addPatientBtn = new JButton("Ajouter patient");
        addPatientBtn.setPreferredSize(new Dimension(150, 35));
        addPatientBtn.setBackground(new Color(0, 123, 255)); // Bleu professionnel
        addPatientBtn.setForeground(Color.WHITE);
        addPatientBtn.setFont(new Font("Arial", Font.BOLD, 12));
        addPatientBtn.setBorderPainted(false);
        addPatientBtn.setFocusPainted(false);

        // Tableau des patients
        String[] columnNames = {"Nom", "Prénom", "Date Naissance", "Numéro", "Sexe", "Adresse", "Actions"};
        Object[][] data = {
            {"Aitidir", "Abdelkhalek", "1985-03-15", "0123456789", "Homme", "123 Rue de la Paix", ""},
            {"Boulahbach", "Zineb", "1990-07-22", "0987654321", "Femme", "456 Avenue des Champs", ""},
            {"Durand", "Pierre", "1978-11-08", "0555666777", "Homme", "789 Boulevard Saint-Germain", ""},
            {"Bernard", "Sophie", "1992-05-30", "0333444555", "Femme", "321 Rue de Rivoli", ""},
            {"Moreau", "Luc", "1988-12-12", "0777888999", "Homme", "654 Place Bellecour", ""}
        };
        
        patientsTable = new JTable(data, columnNames);
        patientsTable.setPreferredScrollableViewportSize(new Dimension(900, 300));
        
        // Ajouter des icônes d'action dans la colonne Actions
        patientsTable.getColumn("Actions").setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JPanel panel = new JPanel(new FlowLayout());
                JButton editBtn = new JButton("✏");
                JButton deleteBtn = new JButton("🗑");
                editBtn.setPreferredSize(new Dimension(30, 25));
                deleteBtn.setPreferredSize(new Dimension(30, 25));
                editBtn.setBackground(new Color(255, 193, 7)); // Jaune pour édition
                deleteBtn.setBackground(new Color(220, 53, 69)); // Rouge pour suppression
                editBtn.setForeground(Color.WHITE);
                deleteBtn.setForeground(Color.WHITE);
                editBtn.setBorderPainted(false);
                deleteBtn.setBorderPainted(false);
                editBtn.setFocusPainted(false);
                deleteBtn.setFocusPainted(false);
                panel.add(editBtn);
                panel.add(deleteBtn);
                return panel;
            }
        });

        JScrollPane scrollPane = new JScrollPane(patientsTable);

        contentPanel.add(addPatientBtn, BorderLayout.NORTH);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        add(sidebar, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        // Gestionnaire d'événements pour le bouton déconnexion
        logoutBtn.addActionListener(e -> {
            dispose();
            new LoginFrame().setVisible(true);
        });

        // Gestionnaire d'événements pour le bouton ajouter
        addPatientBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Ouverture du formulaire d'ajout de patient");
        });
    }

}
