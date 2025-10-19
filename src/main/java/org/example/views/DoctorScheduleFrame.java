package org.example.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Page de gestion d'agenda pour les médecins
 */
public class DoctorScheduleFrame extends JFrame {
    private JTable scheduleTable;
    private DefaultTableModel tableModel;
    private JComboBox<String> doctorComboBox;
    private JComboBox<String> dateComboBox;
    private JComboBox<String> timeSlotComboBox;
    private JTextField patientNameField;
    private JComboBox<String> serviceComboBox;
    private JTextArea notesArea;
    private JComboBox<String> statusComboBox;

    public DoctorScheduleFrame() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        setTitle("Gestion d'Agenda - Médecin");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);

        // Table de l'agenda
        String[] columnNames = {"Heure", "Patient", "Service", "Durée", "Statut", "Notes"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4; // Seul le statut est modifiable
            }
        };
        scheduleTable = new JTable(tableModel);
        scheduleTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Champs de formulaire
        doctorComboBox = new JComboBox<>(new String[]{"Dr. Martin", "Dr. Dubois", "Dr. Leroy"});
        dateComboBox = new JComboBox<>(new String[]{"2024-01-15", "2024-01-16", "2024-01-17", "2024-01-18", "2024-01-19"});
        timeSlotComboBox = new JComboBox<>(new String[]{"08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30"});
        patientNameField = new JTextField(20);
        serviceComboBox = new JComboBox<>(new String[]{"Consultation", "Détartrage", "Soin carie", "Prothèse", "Orthodontie", "Urgence", "Contrôle"});
        notesArea = new JTextArea(3, 20);
        notesArea.setLineWrap(true);
        statusComboBox = new JComboBox<>(new String[]{"Confirmé", "En attente", "Terminé", "Annulé", "En cours"});
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        // Sidebar de navigation
        SidebarPanel sidebar = new SidebarPanel("Agenda Médecin");
        sidebar.setActionListener(e -> {
            String command = ((JButton) e.getSource()).getText();
            switch (command) {
                case "Dashboard":
                    dispose();
                    new DoctorDashboard().setVisible(true);
                    break;
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
            }
        });

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // Header avec titre et bouton déconnexion
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel titleLabel = new JLabel("Agenda Médecin");
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

        // Section des rendez-vous
        JPanel appointmentsSection = new JPanel(new BorderLayout());
        appointmentsSection.setBackground(Color.WHITE);
        
        JLabel appointmentsTitle = new JLabel("les rendez-vous");
        appointmentsTitle.setFont(new Font("Arial", Font.BOLD, 16));
        
        // Boutons de filtre
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton tomorrowBtn = new JButton("Demain");
        JButton todayBtn = new JButton("Aujourd'hui");
        JButton yesterdayBtn = new JButton("Hier");

        tomorrowBtn.setPreferredSize(new Dimension(80, 30));
        todayBtn.setPreferredSize(new Dimension(80, 30));
        yesterdayBtn.setPreferredSize(new Dimension(80, 30));
        
        // Style des boutons de filtre
        tomorrowBtn.setBackground(new Color(108, 117, 125)); // Gris
        todayBtn.setBackground(new Color(40, 167, 69)); // Vert pour aujourd'hui
        yesterdayBtn.setBackground(new Color(108, 117, 125)); // Gris
        
        tomorrowBtn.setForeground(Color.WHITE);
        todayBtn.setForeground(Color.WHITE);
        yesterdayBtn.setForeground(Color.WHITE);
        
        tomorrowBtn.setBorderPainted(false);
        todayBtn.setBorderPainted(false);
        yesterdayBtn.setBorderPainted(false);
        
        tomorrowBtn.setFocusPainted(false);
        todayBtn.setFocusPainted(false);
        yesterdayBtn.setFocusPainted(false);
        
        filterPanel.add(tomorrowBtn);
        filterPanel.add(todayBtn);
        filterPanel.add(yesterdayBtn);
        
        JPanel titleBar = new JPanel(new BorderLayout());
        titleBar.setBackground(Color.WHITE);
        titleBar.add(appointmentsTitle, BorderLayout.WEST);
        titleBar.add(filterPanel, BorderLayout.EAST);

        // Tableau des rendez-vous
        String[] columnNames = {"Nom", "Prénom", "Date Rende-vous", "Heure Rendez-vous", "Acte"};
        Object[][] data = {
            {"Aitidir", "Abdelkhalek", "11-10-2024", "9:00 AM", "Dent de sagesse"},
            {"Boulahbach", "Zineb", "11-10-2024", "10:30 AM", "Détartrage"},
            {"Durand", "Pierre", "11-10-2024", "2:00 PM", "Soin carie"},
            {"Bernard", "Sophie", "12-10-2024", "9:30 AM", "Prothèse"},
            {"Moreau", "Luc", "12-10-2024", "11:00 AM", "Orthodontie"}
        };
        
        scheduleTable = new JTable(data, columnNames);
        scheduleTable.setPreferredScrollableViewportSize(new Dimension(800, 300));

        JScrollPane scrollPane = new JScrollPane(scheduleTable);

        appointmentsSection.add(titleBar, BorderLayout.NORTH);
        appointmentsSection.add(scrollPane, BorderLayout.CENTER);

        contentPanel.add(addPatientBtn, BorderLayout.NORTH);
        contentPanel.add(appointmentsSection, BorderLayout.CENTER);

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
