package view;

import service.UserService;

import java.util.Scanner;

public class UserViewLauncher {
    private static final int SHOW = 1;
    private static final int ADD = 2;
    private static final int UPDATE = 3;
    private static final int DELETE = 4;
    private static final int FIND = 5;
    private static final int SORT = 6;
    private static final int RETURN = 7;
    private static final int EXIT = 0;
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserView userView = new UserView();

    private static final UserService userService = UserService.getInstance();

    public static void launch() {
        boolean isTrue = true;
        do {
            menuUserManager();
            try {
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case SHOW -> userView.showUser(userService.findAll(), InputOption.SHOW);

                    case ADD -> userView.addUser();

                    case UPDATE -> userView.updateUser();

                    case DELETE -> userView.deleteUser();

                    case FIND -> userView.findUser();

                    case SORT -> userView.sortUser();

                    case RETURN -> isTrue = false;

                    case EXIT -> {
                        System.out.println("Exit the program...");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Lựa chọn sai. Vui lòng nhập lại!");
                        System.out.print(" => ");
                    }
                }
            } catch (Exception e) {
                System.out.println("Sai cú pháp. Vui lòng nhập lại!");
            }
        } while (isTrue);
    }

    public static void menuUserManager() {
        System.out.println("═══════════ QUẢN LÝ TÀI KHOẢN ═══════════");
        System.out.println("║                                       ║");
        System.out.println("║       1. Hiện danh sách tài khoản.    ║");
        System.out.println("║       2. Thêm tài khoản.              ║");
        System.out.println("║       3. Chỉnh sửa tài khoản          ║");
        System.out.println("║       4. Xóa tài khoản.               ║");
        System.out.println("║       5. Tìm kiếm tài khoản.          ║");
        System.out.println("║       6. Sắp xếp tài khoản.           ║");
        System.out.println("║       7. Trở lại.                     ║");
        System.out.println("║       0. Thoát.                       ║");
        System.out.println("║                                       ║");
        System.out.println("═════════════════════════════════════════");
        System.out.println("Nhập lựa chọn: ");
        System.out.print("=> ");
    }
}