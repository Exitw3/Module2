package view.product;

import model.Product;
import service.interfaces.IProductService;
import service.file.ProductService;
import utils.AppUtils;
import utils.InstantUtils;
import utils.TypeSort;
import utils.ValidateUtils;
import view.login.InputOption;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    private final IProductService productService;

    private static final Scanner scanner = new Scanner(System.in);

    public ProductView() {
        productService = ProductService.getInstance();
    }

    public void showProduct(List<Product> products, InputOption option) {
        System.out.println("═════════════════════════════════════════════════════════════════════════════ DANH SÁCH SẢN PHẨM ═════════════════════════════════════════════════════════════════════════════");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-5s%-9s | %-16s%-16s | %-10s%-14s | %-4s%-14s | %-8s%-12s | %-4s%-18s | %-2s%-20s |\n",
                "", "ID",
                "", "TÊN",
                "", "GIÁ",
                "", "SỐ LƯỢNG",
                "", "NSX",
                "", "THỜI GIAN TẠO",
                "", "THỜI GIAN CHỈNH SỬA"
        );
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Product product : products) {
            System.out.printf("| %-2s%-12s | %-4s%-28s | %-4s%-20s | %-5s%-13s | %-6s%-14s | %-2s%-20s | %-2s%-20s |\n",
                    "", product.getId(),
                    "", product.getName(),
                    "", AppUtils.doubleToVND(product.getPrice()),
                    "", product.getQuantity(),
                    "", product.getManufacturer(),
                    "", InstantUtils.instantToString(product.getCreatedAt()),
                    "", product.getUpdatedAt() == null ? "" : InstantUtils.instantToString(product.getUpdatedAt())
            );
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        if (option != InputOption.UPDATE && option != InputOption.DELETE && option != InputOption.FIND) {
            AppUtils.pressAnyKeyToContinue();
        }
    }

    public void addProduct() {
        do {
            try {
                long id = System.currentTimeMillis() / 1000;
                String productName = inputProductName(InputOption.ADD);
                double price = inputPrice(InputOption.ADD);
                int quantity = inputQuantity(InputOption.ADD);
                String manufacturer = inputManufacturer(InputOption.ADD);
                Product product = new Product(id, productName, price, quantity, manufacturer);
                productService.add(product);
                System.out.println("Thêm sản phẩm thành công!");
                AppUtils.pressAnyKeyToContinue();
            } catch (Exception e) {
                System.out.println("Sai cú pháp. Vui lòng nhập lại!");
            }
        } while (AppUtils.isRetry(InputOption.ADD));
    }

    private String inputManufacturer(InputOption option) {
        switch (option) {
            case ADD -> System.out.println("Nhập nhà sản xuất (Tên nhà sản xuất phải ghi in hoa, VD: MIDEA.)");

            case UPDATE -> System.out.println("Nhập tên nhà sản xuất mới: ");
        }
        System.out.print(" => ");
        String manufacturer;
        while (!ValidateUtils.isManufacturerValid(manufacturer = scanner.nextLine())) {
            System.out.println("Tên nhà sản xuất phải ghi in hoa, VD: MIDEA.");
            System.out.print(" => ");
        }
        return manufacturer;
    }

    private int inputQuantity(InputOption option) {
        switch (option) {
            case ADD -> System.out.println("Nhập số lượng sản phẩm: ");

            case UPDATE -> System.out.println("Nhập số lượng sản phẩm mới: ");
        }
        int quantity;
        do {
            quantity = AppUtils.retryParseInt();
            if (quantity < 0) System.out.println("Số lượng sản phẩm không thể âm. Vui lòng nhập lại!");
        } while (quantity < 0);
        return quantity;
    }

    private double inputPrice(InputOption option) {
        switch (option) {
            case ADD -> System.out.println("Nhập giá sản phẩm: ");

            case UPDATE -> System.out.println("Nhập giá sản phẩm mới: ");
        }
        double price;
        do {
            price = AppUtils.retryParseDouble();
            if (price <= 100000 || price > 100000000D)
                if (price < 100000)
                    System.out.println("Giá sản phẩm ít nhất là '100.000 VNĐ'. Vui lòng nhập lại!");
        } while (price <= 100000 || price > 100000000D);
        return price;
    }


    private String inputProductName(InputOption option) {
        switch (option) {
            case ADD ->
                    System.out.println("Nhập tên sản phẩm (viết hoa chữ cái đầu tiên) (VD: Cây Nước Nóng Lạnh Midea)");

            case UPDATE -> System.out.println("Nhập tên sản phẩm mới: ");
        }
        System.out.print(" => ");
        String productName;
        do {
            if (!ValidateUtils.isProductNameValid(productName = scanner.nextLine())) {
                System.out.println("Nhập tên sản phẩm (viết hoa chữ cái đầu tiên) (VD: Cây Nước Nóng Lạnh Midea)");
                System.out.print(" => ");
                continue;
            }
            productName = productName.trim();
            if (productService.existsByName(productName)) {
                System.out.println("Tên sản phẩm này đã tồn tại. Vui lòng nhập lại");
                System.out.print(" => ");
                continue;
            }
            break;
        } while (true);
        return productName;
    }

    public void updateProduct() {
        int option;
        boolean isTrue = true;
        do {
            try {
                showProduct(productService.findAll(), InputOption.UPDATE);
                long id = inputId(InputOption.UPDATE);
                Product product = productService.findById(id);
                menuUpdateProduct();
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        updateName(product);
                        break;
                    case 2:
                        updatePrice(product);
                        break;
                    case 3:
                        updateQuantity(product);
                        break;
                    case 4:
                        updateManufacturer(product);
                        break;
                    case 5:
                        break;
                    case 0:
                        System.out.println("Exit the program...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lựa chọn sai. Vui lòng nhập lại!");
                        System.out.print(" => ");
                        break;
                }
                isTrue = option != 5 && AppUtils.isRetry(InputOption.UPDATE);
            } catch (Exception e) {
                System.out.println("Sai cú pháp. Vui lòng nhập lại!");
            }
        } while (isTrue);
    }

    private void updateManufacturer(Product newProduct) {
        String manufactuter = inputManufacturer(InputOption.UPDATE);
        newProduct.setManufacturer(manufactuter);
        productService.update(newProduct);
        System.out.println("Cập nhật nhà sản xuất thành công!");
        AppUtils.pressAnyKeyToContinue();
    }

    private void updateQuantity(Product newProduct) {
        int quantity = inputQuantity(InputOption.UPDATE);
        newProduct.setQuantity(quantity);
        productService.update(newProduct);
        System.out.println("Cập nhật số lượng thành công!");
        AppUtils.pressAnyKeyToContinue();
    }

    private void updatePrice(Product newProduct) {
        double price = inputPrice(InputOption.UPDATE);
        newProduct.setPrice(price);
        productService.update(newProduct);
        System.out.println("Cập nhật giá sản phẩm thành công!");
        AppUtils.pressAnyKeyToContinue();
    }

    private void updateName(Product newProduct) {
        String name = inputProductName(InputOption.UPDATE);
        newProduct.setName(name);
        productService.update(newProduct);
        System.out.println("Cập nhật tên sản phẩm thành công!");
        AppUtils.pressAnyKeyToContinue();
    }


    private long inputId(InputOption option) {
        long id;
        switch (option) {
            case UPDATE -> System.out.println("Nhập Id sản phẩm bạn muốn sửa: ");

            case DELETE -> System.out.println("Nhập Id sản phẩm bạn muốn xóa: ");
        }
        boolean isTrue = true;
        do {
            id = AppUtils.retryParseLong();
            boolean isFindId = productService.existById(id);
            if (isFindId) {
                isTrue = false;
            } else {
                System.out.println("Không tìm thấy. Vui lòng nhập lại");
            }
        } while (isTrue);
        return id;
    }


    public void deleteProduct() {
        boolean isRetry = true;
        do {
            showProduct(productService.findAll(), InputOption.DELETE);
            long id = inputId(InputOption.DELETE);
            int option;
            boolean isTrue = true;
            do {
                try {
                    AppUtils.menuDelete();
                    option = Integer.parseInt(scanner.nextLine());
                    switch (option) {
                        case 1 -> {
                            productService.deleteById(id);
                            System.out.println("xóa sản phẩm thành công!");
                            AppUtils.pressAnyKeyToContinue();
                            isTrue = false;
                        }

                        case 2 -> isTrue = false;

                        case 0 -> {
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
        } while (isRetry == AppUtils.isRetry(InputOption.DELETE));
    }

    public void FindProduct() {
        int option;
        boolean isTrue = true;
        do {
            try {
                menuFindProduct();
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1 -> findByProductId();

                    case 2 -> findByProductName();

                    case 3 -> findByManufacturer();

                    case 4 -> isTrue = false;

                    case 0 -> {
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
        } while (isTrue == AppUtils.isRetry(InputOption.FIND));
    }

    private void findByManufacturer() {
        showProduct(productService.findAll(), InputOption.FIND);
        System.out.println("═════ TÌM KIẾM THEO NHÀ SẢN XUẤT ═════");
        System.out.print("Nhập tên nhà sản xuất: ");
        String productName = scanner.nextLine();
        List<Product> productsFind = productService.findByManufacturer(productName);
        if (productsFind != null) {
            showProduct(productsFind, InputOption.FIND);
        } else {
            System.out.println("Không tìm thấy!");
        }
    }

    private void findByProductName() {
        showProduct(productService.findAll(), InputOption.FIND);
        System.out.println("═══════ TÌM KIẾM THEO TÊN SẢN PHẨM ═══════");
        System.out.print("Nhập tên sản phẩm: ");
        String productName = scanner.nextLine();
        List<Product> productsFind = productService.findByName(productName);
        if (productsFind != null) {
            showProduct(productsFind, InputOption.FIND);
        } else {
            System.out.println("Không tìm thấy!");
        }
    }

    private void findByProductId() {
        showProduct(productService.findAll(), InputOption.FIND);
        System.out.println("══════════ TÌM KIẾM THEO ID ══════════");
        System.out.print("Nhập Id sản phẩm: ");
        long value = Long.parseLong(scanner.nextLine());
        Product product = productService.findById(value);
        if (product != null) {
            List<Product> productsFind = new ArrayList<>();
            productsFind.add(product);
            showProduct(productsFind, InputOption.FIND);
        } else {
            System.out.println("Không tìm thấy!");
        }
    }

    public void sortProduct() {
        int option;
        boolean isTrue = true;
        do {
            try {
                menuSortProduct();
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1 -> sortById();

                    case 2 -> sortByProductName();

                    case 3 -> sortByPrice();

                    case 4 -> sortByQuantity();

                    case 5 -> sortByManufacturer();

                    case 6 -> sortByCreateTime();

                    case 7 -> isTrue = false;

                    case 0 -> {
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

    private void sortByCreateTime() {
        System.out.println("══════ SẮP XẾP THEO THỜI GIAN TẠO ══════");
        AppUtils.menuSort();
        int option;
        try {
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> showProduct(productService.sortByCreateAt(TypeSort.ASC), InputOption.SORT);

                case 2 -> showProduct(productService.sortByCreateAt(TypeSort.DESC), InputOption.SORT);

                default -> {
                    System.out.println("Lựa chọn sai. Vui lòng nhập lại!");
                    System.out.print(" => ");
                }
            }
        } catch (Exception e) {
            System.out.println("Sai cú pháp. Vui lòng nhập lại!");
        }
    }

    private void sortByManufacturer() {
        System.out.println("═══════ SẮP XẾP THEO NHÀ SẢN XUẤT ═══════");
        AppUtils.menuSort();
        int option;
        try {
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> showProduct(productService.sortByManufacturer(TypeSort.ASC), InputOption.SORT);

                case 2 -> showProduct(productService.sortByManufacturer(TypeSort.DESC), InputOption.SORT);

                default -> {
                    System.out.println("Lựa chọn sai. Vui lòng nhập lại!");
                    System.out.print(" => ");
                }
            }
        } catch (Exception e) {
            System.out.println("Sai cú pháp. Vui lòng nhập lại!");
        }
    }

    private void sortByQuantity() {
        System.out.println("════════ SẮP XẾP THEO SỐ LƯỢNG ════════");
        AppUtils.menuSort();
        int option;
        try {
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> showProduct(productService.sortByQuantity(TypeSort.ASC), InputOption.SORT);

                case 2 -> showProduct(productService.sortByQuantity(TypeSort.DESC), InputOption.SORT);

                default -> {
                    System.out.println("Lựa chọn sai. Vui lòng nhập lại!");
                    System.out.print(" => ");
                }
            }
        } catch (Exception e) {
            System.out.println("Sai cú pháp. Vui lòng nhập lại!");
        }
    }

    private void sortByPrice() {
        System.out.println("════════ SẮP XẾP THEO GIÁ ════════");
        AppUtils.menuSort();
        int option;
        try {
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> showProduct(productService.sortByPrice(TypeSort.ASC), InputOption.SORT);

                case 2 -> showProduct(productService.sortByPrice(TypeSort.DESC), InputOption.SORT);
                default -> {
                    System.out.println("Lựa chọn sai. Vui lòng nhập lại!");
                    System.out.print(" => ");
                }
            }
        } catch (Exception e) {
            System.out.println("Sai cú pháp. Vui lòng nhập lại!");
        }
    }

    private void sortByProductName() {
        System.out.println("══════ SẮP XẾP THEO TÊN SẢN PHẨM ══════");
        AppUtils.menuSort();
        int option;
        try {
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> showProduct(productService.sortByName(TypeSort.ASC), InputOption.SORT);

                case 2 -> showProduct(productService.sortByName(TypeSort.DESC), InputOption.SORT);
                default -> {
                    System.out.println("Lựa chọn sai. Vui lòng nhập lại!");
                    System.out.print(" => ");
                }
            }
        } catch (Exception e) {
            System.out.println("Sai cú pháp. Vui lòng nhập lại!");
        }
    }

    private void sortById() {
        System.out.println("══════════ SẮP XẾP THEO ID ══════════");
        AppUtils.menuSort();
        int option;
        try {
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> showProduct(productService.sortById(TypeSort.ASC), InputOption.SORT);

                case 2 -> showProduct(productService.sortById(TypeSort.DESC), InputOption.SORT);
                default -> {
                    System.out.println("Lựa chọn sai. Vui lòng nhập lại!");
                    System.out.print(" => ");
                }
            }
        } catch (Exception e) {
            System.out.println("Sai cú pháp. Vui lòng nhập lại!");
        }
    }

    private void menuSortProduct() {
        System.out.println("══════════ SẮP XẾP SẢN PHẨM ══════════");
        System.out.println("║                                    ║");
        System.out.println("║    1. Sắp xếp theo Id.             ║");
        System.out.println("║    2. Sắp xếp theo tên sản phẩm.   ║");
        System.out.println("║    3. Sắp xếp theo giá.            ║");
        System.out.println("║    4. Sắp xếp theo số lượng.       ║");
        System.out.println("║    5. Sắp xếp theo nhà sản xuất.   ║");
        System.out.println("║    6. Sắp xếp theo thời gian tạo.  ║");
        System.out.println("║    7. Trở lại.                     ║");
        System.out.println("║    0. Thoát.                       ║");
        System.out.println("║                                    ║");
        System.out.println("══════════════════════════════════════");
        System.out.println("Nhập lựa chọn: ");
        System.out.print(" => ");
    }

    private static void menuFindProduct() {
        System.out.println("═════════ TÌM KIẾM SẢN PHẨM ═════════");
        System.out.println("║                                   ║");
        System.out.println("║    1. Tìm kiếm theo Id.           ║");
        System.out.println("║    2. Tìm kiếm theo tên.          ║");
        System.out.println("║    3. Tìm kiếm theo nhà sản xuất. ║");
        System.out.println("║    4. Trở lại.                    ║");
        System.out.println("║    0. Thoát.                      ║");
        System.out.println("║                                   ║");
        System.out.println("═════════════════════════════════════");
        System.out.println("Nhập lựa chọn: ");
        System.out.print(" => ");
    }

    private static void menuUpdateProduct() {
        System.out.println("════════ CHỈNH SỬA SẢN PHẨM ════════");
        System.out.println("║                                  ║");
        System.out.println("║     1. Chỉnh sửa tên.            ║");
        System.out.println("║     2. Chỉnh sửa giá.            ║");
        System.out.println("║     3. Chỉnh sửa số lượng.       ║");
        System.out.println("║     4. Chỉnh sửa nhà sản xuất.   ║");
        System.out.println("║     5. Trở lại.                  ║");
        System.out.println("║     0. Thoát.                    ║");
        System.out.println("║                                  ║");
        System.out.println("════════════════════════════════════");
        System.out.println("Nhập lựa chọn: ");
        System.out.print(" => ");
    }

    public void restoreProduct() {
        List<Product> productsDeleted = productService.findAllDeleted();
        if (productsDeleted != null) {
            showProduct(productsDeleted, InputOption.DELETE);
            boolean isTrue = true;
            do {
                System.out.println("Chọn 'y' để chọn sản phẩm cần khôi phục \t|\t 'q' để trở lại.");
                System.out.print(" => ");
                String option = scanner.nextLine();
                switch (option) {
                    case "y" -> {
                        long id = inputIdDeleted();
                        Product productDeleted = productService.findByIdDeleted(id);
                        Instant createdAt = productDeleted.getCreatedAt();
                        productService.add(productDeleted);
                        productDeleted.setCreatedAt(createdAt);
                        productService.update(productDeleted);
                        productService.deleteInFileDeleted(id);
                        System.out.printf("===> Khôi phục sản phẩm '%s' có id '%s' thành công!\n", productDeleted.getName(), id);
                        AppUtils.pressAnyKeyToContinue();
                        showProduct(productService.findAllDeleted(), InputOption.DELETE);
                    }
                    case "q" -> isTrue = false;
                    default -> {
                        System.out.println("Lựa chọn sai. Vui lòng nhập lại!");
                        System.out.print(" => ");
                    }
                }
            } while (isTrue);
        } else {
            System.out.println("Không có đơn hàng cần khôi phục!");
            AppUtils.pressAnyKeyToContinue();
        }
    }

    private long inputIdDeleted() {
        long id;
        System.out.println("Nhập ID sản phẩm cần khôi phục: ");
        boolean isTrue = true;
        do {
            id = AppUtils.retryParseLong();
            boolean isFindId = productService.existByIdDeleted(id);
            if (isFindId) {
                isTrue = false;
            } else {
                System.out.println("Không tìm thấy, vui lòng nhập lại!");
            }
        } while (isTrue);
        return id;
    }
}