package view.login;

import model.User;
import model.Role;
import service.interfaces.IUserService;
import service.file.UserService;
import utils.AppUtils;

import java.util.Scanner;

public class LoginView {
    private final static Scanner scanner = new Scanner(System.in);
    private static final int EXIT_PROGRAM = 0;
    private static final int LOGIN = 1;
    private final IUserService userService;

    public static User user = new User();

    public LoginView() {
        userService = UserService.getInstance();
    }

    public void login(Role role) {
        int option = -1;
        do {
            menuLogin();
            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case LOGIN -> loginProgram(role);

                    case EXIT_PROGRAM -> {
                        System.out.println("Exit the program...");
                        System.exit(0);
                    }
                    default -> System.out.println("Lựa chọn sai. Vui lòng nhập lại!");
                }
            } catch (Exception ex) {
                System.out.println("Sai cú pháp. Vui lòng nhập lại!");
            }
        } while (option != EXIT_PROGRAM);
    }

    private void loginProgram(Role role) {
        String userName, passWord;
        System.out.println("═════════ ĐĂNG NHẬP ═════════");
        System.out.print("Tài khoản: ");
        userName = AppUtils.retryString();
        System.out.print("Mật khẩu:  ");
        passWord = AppUtils.retryString();
        user = userService.login(userName, passWord, role);
        long userId = user.getId();
        if (user == null) {
            System.out.println("Tài khoản hoặc mật khẩu không đúng!");
            AppUtils.pressAnyKeyToContinue();
        } else {
            System.out.println("\n════ ĐĂNG NHẬP THÀNH CÔNG ════");
            AppUtils.pressAnyKeyToContinue();
            if (role == Role.ADMIN) {
                AdminView.launch(userId);
            } else {
                MemberView.launch(userId);
            }
        }
    }

    private static void menuLogin() {
        System.out.println("══════════════ MENU ══════════════");
        System.out.println("║       1. Đăng nhập.            ║");
        System.out.println("║       0. Thoát.                ║");
        System.out.println("══════════════════════════════════");
        System.out.println("Nhập lựa chọn: ");
        System.out.print("=> ");
    }
}