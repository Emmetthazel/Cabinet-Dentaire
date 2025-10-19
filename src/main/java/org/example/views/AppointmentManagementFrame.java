package org.example.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Page de gestion des rendez-vous pour les secrétaires
 */
public class AppointmentManagementFrame extends JFrame {
    private JTable appointmentsTable;
    private DefaultTableModel tableModel;
    private JTextField patientNameField;
    private JTextField patientPhoneField;
    private JComboBox<String> doctorComboBox;
    private JComboBox<String> serviceComboBox;
    private JTextField dateField;
    private JTextField timeField;
    private JTextArea notesArea;

    public AppointmentManagementFrame() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        setTitle("Gestion des Rendez-vous");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);

        // Table des rendez-vous
        String[] columnNames = {"ID", "Patient", "Médecin", "Service", "Date", "Heure", "Statut", "Notes"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Table en lecture seule
            }
        };
        appointmentsTable = new JTable(tableModel);
        appointmentsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Champs de formulaire
        patientNameField = new JTextField(20);
        patientPhoneField = new JTextField(20);
        doctorComboBox = new JComboBox<>(new String[]{"Dr. Martin", "Dr. Dubois", "Dr. Leroy"});
        serviceComboBox = new JComboBox<>(new String[]{"Consultation", "Détartrage", "Soin carie", "Prothèse", "Orthodontie"});
        dateField = new JTextField(10);
        timeField = new JTextField(10);
        notesArea = new JTextArea(3, 20);
        notesArea.setLineWrap(true);
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        // Sidebar de navigation
        SidebarPanel sidebar = new SidebarPanel("Rendez-vous");
        sidebar.setActionListener(e -> {
            String command = ((JButton) e.getSource()).getText();
            switch (command) {
                case "Dashboard":
                    dispose();
                    new SecretaryDashboard().setVisible(true);
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

        JLabel titleLabel = new JLabel("Rendez-vous");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        // Ajouter le nom de l'utilisateur selon le rôle
        JLabel userLabel = new JLabel("Utilisateur");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        userLabel.setForeground(Color.GRAY);

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

        // Bouton ajouter rendez-vous
        JButton addAppointmentBtn = new JButton("Ajouter rendez-vous");
        addAppointmentBtn.setPreferredSize(new Dimension(150, 35));
        addAppointmentBtn.setBackground(new Color(0, 123, 255)); // Bleu professionnel
        addAppointmentBtn.setForeground(Color.WHITE);
        addAppointmentBtn.setFont(new Font("Arial", Font.BOLD, 12));
        addAppointmentBtn.setBorderPainted(false);
        addAppointmentBtn.setFocusPainted(false);

        // Tableau des rendez-vous
        String[] columnNames = {"Date", "Heure", "Motif", "Actions"};
        Object[][] data = {
            {"2024-01-15", "09:00", "Consultation", ""},
            {"2024-01-15", "10:30", "Détartrage", ""},
            {"2024-01-15", "14:00", "Soin carie", ""},
            {"2024-01-16", "09:30", "Prothèse", ""},
            {"2024-01-16", "11:00", "Orthodontie", ""}
        };
        
        appointmentsTable = new JTable(data, columnNames);
        appointmentsTable.setPreferredScrollableViewportSize(new Dimension(800, 300));
        
        // Ajouter des icônes d'action dans la colonne Actions
        appointmentsTable.getColumn("Actions").setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
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

        JScrollPane scrollPane = new JScrollPane(appointmentsTable);

        contentPanel.add(addAppointmentBtn, BorderLayout.NORTH);
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
        addAppointmentBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Ouverture du formulaire d'ajout de rendez-vous");
        });
    }

}
