# 🦷 DENTAL CARE PRO - Gestion de Cabinet Dentaire

Une application Java Swing moderne pour la gestion complète d'un cabinet dentaire avec système de rôles et interface utilisateur professionnelle.

## 📋 Table des Matières

- [Fonctionnalités](#-fonctionnalités)
- [Technologies Utilisées](#-technologies-utilisées)
- [Installation](#-installation)
- [Connexion](#-connexion)
- [Utilisation](#-utilisation)
- [Structure du Projet](#-structure-du-projet)
- [Captures d&#39;Écran](#-captures-décran)
- [Développement](#-développement)

## ✨ Fonctionnalités

### 🔐 Système de Rôles

- **Secrétaire** : Gestion des rendez-vous, patients, factures
- **Médecin** : Interface médicale spécialisée avec dossiers patients
- **Administrateur** : Accès complet à toutes les fonctionnalités

### 📱 Pages Principales

- **Page de Connexion** : Interface moderne avec sélection de rôle
- **Tableau de Bord** : Statistiques et vue d'ensemble
- **Gestion des Rendez-vous** : Planification et suivi
- **Gestion des Patients** : Dossiers médicaux complets
- **Gestion des Factures** : Suivi financier
- **Agenda Médecin** : Planning médical spécialisé

## 🛠 Technologies Utilisées

- **Java 23** : Langage de programmation principal
- **Java Swing** : Interface utilisateur graphique
- **Maven** : Gestion des dépendances et build
- **IntelliJ IDEA** : Environnement de développement

## 📦 Installation

### Prérequis

- Java 23 ou supérieur
- Maven 3.6 ou supérieur
- IntelliJ IDEA (recommandé)

### Étapes d'Installation

1. **Cloner le projet**

   ```bash
   git clone https://github.com/Emmetthazel/Cabinet-Dentaire.git
   cd Gestion-De-Cabinet-Dentaire
   ```
2. **Compiler le projet**

   ```bash
   mvn clean compile
   ```
3. **Exécuter l'application**

   ```bash
   mvn exec:java -Dexec.mainClass="org.example.Main"
   ```

   Ou directement :

   ```bash
   java -cp target/classes org.example.Main
   ```

## 🔑 Connexion

### Identifiants de Test

| Rôle                    | Nom d'utilisateur | Mot de passe  | Accès                                        |
| ------------------------ | ----------------- | ------------- | --------------------------------------------- |
| **Secrétaire**    | `secretaire`    | `secret123` | Rendez-vous, Patients, Factures, Agenda       |
| **Médecin**       | `medecin`       | `med123`    | Interface médicale spécialisée             |
| **Administrateur** | `admin`         | `admin123`  | Accès complet à toutes les fonctionnalités |

### Processus de Connexion

1. **Lancer l'application**
2. **Sélectionner le rôle** dans le menu déroulant
3. **Entrer les identifiants** correspondants
4. **Cliquer sur "Connexion"**

## 📖 Utilisation

### 👩‍💼 Interface Secrétaire

#### Tableau de Bord

- **Statistiques** : Total patients, visites, rendez-vous
- **Rendez-vous du jour** : Vue d'ensemble des consultations
- **Navigation** : Accès rapide aux différentes sections

#### Gestion des Rendez-vous

- **Ajouter** : Nouveau rendez-vous
- **Modifier** : Édition des rendez-vous existants
- **Supprimer** : Annulation de rendez-vous
- **Filtres** : Vue par date (aujourd'hui, demain, hier)

#### Gestion des Patients

- **Dossiers complets** : Informations personnelles et médicales
- **Recherche** : Trouver rapidement un patient
- **Historique** : Suivi des consultations

#### Gestion des Factures

- **Création** : Nouvelles factures
- **Suivi** : Statut des paiements
- **Export** : Téléchargement des factures

### 👨‍⚕️ Interface Médecin

#### Tableau de Bord Médical

- **Statistiques patients** : Vue d'ensemble médical
- **Rendez-vous** : Planning des consultations
- **Dossiers médicaux** : Accès aux informations patients

#### Fonctionnalités Spécialisées

- **Ordonnances** : Prescription de médicaments
- **Certifications** : Documents médicaux
- **Catalogue des actes** : Référentiel médical
- **Antécédents** : Historique médical des patients

### 👨‍💼 Interface Administrateur

#### Accès Complet

- **Toutes les fonctionnalités** : Secrétaire + Médecin
- **Gestion des utilisateurs** : Administration des comptes
- **Rapports** : Statistiques et analyses
- **Paramètres** : Configuration du système

## 📁 Structure du Projet

```
Gestion-De-Cabinet-Dentaire/
├── src/
│   └── main/
│       └── java/
│           └── org/
│               └── example/
│                   ├── Main.java                 # Point d'entrée
│                   ├── models/
│                   │   └── CurrentUser.java      # Gestion utilisateur
│                   └── views/
│                       ├── LoginFrame.java       # Page de connexion
│                       ├── SidebarPanel.java     # Navigation commune
│                       ├── SecretaryDashboard.java    # Tableau secrétaire
│                       ├── DoctorDashboard.java      # Tableau médecin
│                       ├── AdminDashboard.java       # Tableau administrateur
│                       ├── AppointmentManagementFrame.java  # Gestion rendez-vous
│                       ├── PatientManagementFrame.java      # Gestion patients
│                       ├── InvoiceManagementFrame.java      # Gestion factures
│                       └── DoctorScheduleFrame.java        # Agenda médecin
├── pom.xml                    # Configuration Maven
└── README.md                  # Documentation
```

## 🖼 Captures d'Écran

### Page de Connexion

![Page de Connexion](Captures%20d'ecran/1.png)
*Interface moderne avec logo "D" sur fond bleu, formulaire de connexion avec sélection de rôle*

### Tableau de Bord Secrétaire

![Tableau de Bord Secrétaire](Captures%20d'ecran/2.png)
*Interface de gestion administrative avec statistiques et navigation*

### Gestion des Rendez-vous

![Gestion des Rendez-vous](Captures%20d'ecran/3.png)
*Page de gestion des rendez-vous avec tableau et actions (modifier, supprimer)*

### Gestion des Patients

![Gestion des Patients](Captures%20d'ecran/4.png)
*Dossiers patients complets avec informations détaillées et actions*

### Gestion des Factures

![Gestion des Factures](Captures%20d'ecran/5.png)
*Suivi financier avec statuts de paiement et actions d'export*

### Tableau de Bord Médecin

![Tableau de Bord Médecin](Captures%20d'ecran/6.png)
*Interface médicale spécialisée avec fonctionnalités dédiées*

### Agenda Médecin

![Agenda Médecin](Captures%20d'ecran/7.png)
*Planning médical avec filtres de date et gestion des consultations*

### Tableau de Bord Administrateur

![Tableau de Bord Administrateur](Captures%20d'ecran/8.png)
*Accès complet avec toutes les fonctionnalités et gestion avancée*

## 📝 Notes de Développement

### Fonctionnalités en Développement

- Gestion des utilisateurs (Admin)
- Rapports et statistiques
- Paramètres système
- Ordonnances médicales
- Certifications
- Catalogue des actes
- Antécédents médicaux

### Améliorations Futures

- Base de données intégrée
- Sauvegarde automatique
- Notifications en temps réel
- Export PDF des rapports
- Interface mobile

---

**DENTAL CARE PRO** - Votre solution complète de gestion de cabinet dentaire 🦷
