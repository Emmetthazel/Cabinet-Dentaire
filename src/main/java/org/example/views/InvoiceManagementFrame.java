package org.example.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Page de gestion des factures pour les secrétaires
 */
public class InvoiceManagementFrame extends JFrame {
    private JTable invoicesTable;
    private DefaultTableModel tableModel;
    private JTextField invoiceNumberField;
    private JTextField patientNameField;
    private JTextField serviceField;
    private JTextField amountField;
    private JTextField dateField;
    private JComboBox<String> statusComboBox;
    private JComboBox<String> paymentMethodComboBox;
    private JTextArea notesArea;

    public InvoiceManagementFrame() {
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        setTitle("Gestion des Factures");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);

        // Table des factures
        String[] columnNames = {"N° Facture", "Patient", "Service", "Montant", "Date", "Statut", "Méthode Paiement", "Notes"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Table en lecture seule
            }
        };
        invoicesTable = new JTable(tableModel);
        invoicesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Champs de formulaire
        invoiceNumberField = new JTextField(15);
        patientNameField = new JTextField(20);
        serviceField = new JTextField(20);
        amountField = new JTextField(10);
        dateField = new JTextField(10);
        statusComboBox = new JComboBox<>(new String[]{"En attente", "Payée", "En retard", "Annulée"});
        paymentMethodComboBox = new JComboBox<>(new String[]{"Espèces", "Chèque", "Carte bancaire", "Virement", "En attente"});
        notesArea = new JTextArea(3, 20);
        notesArea.setLineWrap(true);
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        // Sidebar de navigation
        SidebarPanel sidebar = new SidebarPanel("Factures");
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
                case "Patients":
                    dispose();
                    new PatientManagementFrame().setVisible(true);
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

        JLabel titleLabel = new JLabel("Factures");
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

        // Bouton ajouter facture
        JButton addInvoiceBtn = new JButton("Ajouter Facture");
        addInvoiceBtn.setPreferredSize(new Dimension(150, 35));
        addInvoiceBtn.setBackground(new Color(0, 123, 255)); // Bleu professionnel
        addInvoiceBtn.setForeground(Color.WHITE);
        addInvoiceBtn.setFont(new Font("Arial", Font.BOLD, 12));
        addInvoiceBtn.setBorderPainted(false);
        addInvoiceBtn.setFocusPainted(false);

        // Tableau des factures
        String[] columnNames = {"Nom", "Prénom", "Montant global", "Date d'émission", "Status", "Montant A payer", "Reste", "Actions"};
        Object[][] data = {
            {"Aitidir", "Abdelkhalek", "50.00", "2024-01-15", "Payée", "50.00", "0.00", ""},
            {"Boulahbach", "Zineb", "80.00", "2024-01-15", "Payée", "80.00", "0.00", ""},
            {"Durand", "Pierre", "120.00", "2024-01-15", "En attente", "120.00", "120.00", ""},
            {"Bernard", "Sophie", "500.00", "2024-01-16", "En attente", "500.00", "500.00", ""},
            {"Moreau", "Luc", "200.00", "2024-01-16", "En retard", "200.00", "200.00", ""}
        };
        
        invoicesTable = new JTable(data, columnNames);
        invoicesTable.setPreferredScrollableViewportSize(new Dimension(1000, 300));
        
        // Ajouter des icônes d'action dans la colonne Actions
        invoicesTable.getColumn("Actions").setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JPanel panel = new JPanel(new FlowLayout());
                JButton editBtn = new JButton("✏");
                JButton deleteBtn = new JButton("🗑");
                JButton downloadBtn = new JButton("⬇");
                editBtn.setPreferredSize(new Dimension(30, 25));
                deleteBtn.setPreferredSize(new Dimension(30, 25));
                downloadBtn.setPreferredSize(new Dimension(30, 25));
                editBtn.setBackground(new Color(255, 193, 7)); // Jaune pour édition
                deleteBtn.setBackground(new Color(220, 53, 69)); // Rouge pour suppression
                downloadBtn.setBackground(new Color(40, 167, 69)); // Vert pour téléchargement
                editBtn.setForeground(Color.WHITE);
                deleteBtn.setForeground(Color.WHITE);
                downloadBtn.setForeground(Color.WHITE);
                editBtn.setBorderPainted(false);
                deleteBtn.setBorderPainted(false);
                downloadBtn.setBorderPainted(false);
                editBtn.setFocusPainted(false);
                deleteBtn.setFocusPainted(false);
                downloadBtn.setFocusPainted(false);
                panel.add(editBtn);
                panel.add(deleteBtn);
                panel.add(downloadBtn);
                return panel;
            }
        });

        JScrollPane scrollPane = new JScrollPane(invoicesTable);

        contentPanel.add(addInvoiceBtn, BorderLayout.NORTH);
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
        addInvoiceBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Ouverture du formulaire d'ajout de facture");
        });
    }

}
