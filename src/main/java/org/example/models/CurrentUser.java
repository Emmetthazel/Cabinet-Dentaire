package org.example.models;

/**
 * Classe pour gérer l'utilisateur actuellement connecté
 */
public class CurrentUser {
    private static String username;
    private static String role;
    
    public static void setUser(String username, String role) {
        CurrentUser.username = username;
        CurrentUser.role = role;
    }
    
    public static String getUsername() {
        return username;
    }
    
    public static String getRole() {
        return role;
    }
    
    public static String getDisplayName() {
        switch (role) {
            case "Secrétaire":
                return "Maryame";
            case "Médecin":
                return "Dr. Dinani";
            case "Administrateur":
                return "Admin";
            default:
                return username;
        }
    }
    
    public static void clear() {
        username = null;
        role = null;
    }
}
