package view;

import model.Role;

public class MainLauncher {
    private static final LoginView loginView = new LoginView();

    public static void mainLauncher(Role role) {
        loginView.login(role);
    }
}
