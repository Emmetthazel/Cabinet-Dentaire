# Application de Gestion de Cabinet Dentaire

## Description
Cette application Java Swing est conçue pour la gestion complète d'un cabinet dentaire. Elle permet aux secrétaires et aux médecins de gérer efficacement les patients, les rendez-vous, les factures et les agendas.

## Fonctionnalités

### 🔐 Page de Connexion (`LoginFrame`)
- Authentification par nom d'utilisateur et mot de passe
- Sélection du rôle (Secrétaire, Médecin, Administrateur)
- Interface simple et sécurisée

### 👩‍💼 Tableau de Bord Secrétaire (`SecretaryDashboard`)
- Vue d'ensemble des statistiques du jour
- Actions rapides pour les tâches courantes
- Navigation vers tous les modules de gestion
- Informations en temps réel

### 📅 Gestion des Rendez-vous (`AppointmentManagementFrame`)
- Création, modification et suppression de rendez-vous
- Recherche et filtrage des rendez-vous
- Gestion des créneaux horaires
- Suivi du statut des rendez-vous

### 👥 Gestion des Patients (`PatientManagementFrame`)
- Dossier patient complet
- Informations personnelles et médicales
- Historique des consultations
- Gestion des allergies et antécédents

### 💰 Gestion des Factures (`InvoiceManagementFrame`)
- Création et suivi des factures
- Gestion des méthodes de paiement
- Statut des paiements
- Impression et export des factures

### 👨‍⚕️ Tableau de Bord Médecin (`DoctorDashboard`)
- Vue d'ensemble des rendez-vous du jour
- Alertes et rappels importants
- Actions rapides pour les médecins
- Statistiques personnalisées

### 📋 Agenda Médecin (`DoctorScheduleFrame`)
- Planification détaillée des créneaux
- Gestion des rendez-vous en temps réel
- Modification du statut des consultations
- Notes médicales

## Structure du Projet

```
src/main/java/org/example/
├── Main.java                           # Point d'entrée de l'application
└── views/
    ├── LoginFrame.java                 # Page de connexion
    ├── SecretaryDashboard.java         # Tableau de bord secrétaire
    ├── AppointmentManagementFrame.java # Gestion des rendez-vous
    ├── PatientManagementFrame.java     # Gestion des patients
    ├── InvoiceManagementFrame.java     # Gestion des factures
    ├── DoctorDashboard.java           # Tableau de bord médecin
    └── DoctorScheduleFrame.java       # Agenda médecin
```

## Technologies Utilisées

- **Java 23** : Langage de programmation principal
- **Java Swing** : Interface utilisateur graphique
- **Maven** : Gestion des dépendances et build
- **IntelliJ IDEA** : Environnement de développement

## Installation et Exécution

### Prérequis
- Java 23 ou version supérieure
- Maven 3.6 ou version supérieure
- IntelliJ IDEA (recommandé)

### Instructions d'installation

1. **Cloner le projet**
   ```bash
   git clone [URL_DU_REPO]
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

   Ou directement dans IntelliJ IDEA :
   - Ouvrir le projet
   - Exécuter la classe `Main.java`

### Connexion par défaut
- **Nom d'utilisateur** : `admin`
- **Mot de passe** : `admin`
- **Rôle** : Sélectionner selon vos besoins

## Fonctionnalités Détaillées

### Pour les Secrétaires
- ✅ Gestion complète des patients
- ✅ Planification des rendez-vous
- ✅ Suivi des factures et paiements
- ✅ Statistiques et rapports
- ✅ Interface intuitive et ergonomique

### Pour les Médecins
- ✅ Consultation de l'agenda personnel
- ✅ Gestion des rendez-vous en temps réel
- ✅ Suivi des patients
- ✅ Alertes et rappels
- ✅ Notes médicales

## Données d'Exemple

L'application inclut des données d'exemple pour faciliter les tests :
- Patients fictifs avec informations complètes
- Rendez-vous pré-planifiés
- Factures avec différents statuts
- Agenda médical avec créneaux variés

## Développement Futur

### Fonctionnalités Prévues
- 🔄 Base de données intégrée
- 📊 Rapports avancés
- 📱 Interface mobile
- 🔐 Authentification renforcée
- 📧 Notifications par email
- 💾 Sauvegarde automatique

### Améliorations Techniques
- Architecture MVC
- Tests unitaires
- Documentation API
- Déploiement automatisé

## Support et Contribution

Pour toute question ou suggestion d'amélioration, n'hésitez pas à :
- Créer une issue sur le repository
- Proposer des pull requests
- Contacter l'équipe de développement

## Licence

Ce projet est développé dans le cadre d'un projet académique. Tous droits réservés.

---

**Version** : 1.0  
**Dernière mise à jour** : Janvier 2024  
**Auteur** : Équipe de développement
