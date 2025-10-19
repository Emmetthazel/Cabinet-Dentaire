package org.example.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe de base pour créer une sidebar de navigation commune
 */
public class SidebarPanel extends JPanel {
    private JButton dashboardBtn;
    private JButton appointmentsBtn;
    private JButton patientsBtn;
    private JButton doctorScheduleBtn;
    private JButton invoicesBtn;
    private String currentPage;

    public SidebarPanel(String currentPage) {
        this.currentPage = currentPage;
        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(200, 0));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        dashboardBtn = new JButton("Dashboard");
        appointmentsBtn = new JButton("Rendez-vous");
        patientsBtn = new JButton("Patients");
        doctorScheduleBtn = new JButton("Agenda Médecin");
        invoicesBtn = new JButton("Factures");

        // Style des boutons
        JButton[] buttons = {dashboardBtn, appointmentsBtn, patientsBtn, doctorScheduleBtn, invoicesBtn};
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

        // Mettre en évidence la page actuelle
        switch (currentPage) {
            case "Dashboard":
                dashboardBtn.setBackground(new Color(0, 123, 255));
                dashboardBtn.setForeground(Color.WHITE);
                break;
            case "Rendez-vous":
                appointmentsBtn.setBackground(new Color(0, 123, 255));
                appointmentsBtn.setForeground(Color.WHITE);
                break;
            case "Patients":
                patientsBtn.setBackground(new Color(0, 123, 255));
                patientsBtn.setForeground(Color.WHITE);
                break;
            case "Agenda Médecin":
                doctorScheduleBtn.setBackground(new Color(0, 123, 255));
                doctorScheduleBtn.setForeground(Color.WHITE);
                break;
            case "Factures":
                invoicesBtn.setBackground(new Color(0, 123, 255));
                invoicesBtn.setForeground(Color.WHITE);
                break;
        }
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        // Header avec logo
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Logo et nom de l'entreprise
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        logoPanel.setBackground(Color.WHITE);
        
        JLabel logoLabel = new JLabel("D");
        logoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        logoLabel.setForeground(new Color(0, 123, 255));
        
        JLabel dellLabel = new JLabel("DENTAL");
        dellLabel.setFont(new Font("Arial", Font.BOLD, 16));
        dellLabel.setForeground(new Color(0, 123, 255));
        JLabel youSmileLabel = new JLabel("CARE PRO");
        youSmileLabel.setFont(new Font("Arial", Font.BOLD, 14));
        youSmileLabel.setForeground(new Color(40, 167, 69));
        
        logoPanel.add(logoLabel);
        logoPanel.add(Box.createHorizontalStrut(5));
        logoPanel.add(dellLabel);
        logoPanel.add(youSmileLabel);
        
        // Nom de l'utilisateur
        JLabel userLabel = new JLabel(org.example.models.CurrentUser.getDisplayName());
        userLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        userLabel.setForeground(Color.GRAY);
        userLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        headerPanel.add(logoPanel, BorderLayout.CENTER);
        headerPanel.add(userLabel, BorderLayout.SOUTH);

        // Menu de navigation
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(Color.WHITE);
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        menuPanel.add(dashboardBtn);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(appointmentsBtn);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(patientsBtn);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(doctorScheduleBtn);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(invoicesBtn);

        add(headerPanel, BorderLayout.NORTH);
        add(menuPanel, BorderLayout.CENTER);
    }

    public void setActionListener(ActionListener listener) {
        dashboardBtn.addActionListener(listener);
        appointmentsBtn.addActionListener(listener);
        patientsBtn.addActionListener(listener);
        doctorScheduleBtn.addActionListener(listener);
        invoicesBtn.addActionListener(listener);
    }
}
