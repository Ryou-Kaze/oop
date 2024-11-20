import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DSKhachHang dSKhachHang = new DSKhachHang();
        DSNV dSNhanVien = new DSNV();
        taiTruocKho("C:\\Users\\Admin\\Desktop\\programming junk\\Java\\bigProjects\\OfficeSupplyManager\\project\\textStorage\\db.txt");
        boolean running = true;
        while (running) {
            System.out.println("\nChọn vai trò của bạn:");
            System.out.println("1. Quản lý");
            System.out.println("2. Nhân viên");
            System.out.println("3. Khách Hàng");
            System.out.println("0. Thoát");
            System.out.print("Nhâp lựa chọn: ");
            int luaChonVaiTro = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (luaChonVaiTro) {
                case 1:
                    System.out.println("Welcome, Quản Lý!");
                    menuQuanLy(scanner);
                    break;

                case 2: {
                    System.out.print("Nhập mã nhân viên: ");
                    String maNhanVien = scanner.nextLine();
                    boolean foundNhanVien = false;

                    for (NhanVien nv : dSNhanVien.getDanhSachNV()) { // Iterate through the list of employees
                        if (nv.getMaNV().equalsIgnoreCase(maNhanVien)) { // Compare entered maNhanVien with each employee's maNhanVien
                            System.out.println("Nhân viên được tìm thấy:");
                            System.out.println("Welcome, " + nv.getHoTen());
                            menuNhanVien(scanner, maNhanVien, nv);
                            foundNhanVien = true;
                            break; // Exit the loop as we found the employee
                        }
                    }

                    if (!foundNhanVien) {
                        System.out.println("Không tìm thấy nhân viên với mã: " + maNhanVien);
                        System.out.println("Bạn có muốn tạo hồ sơ mới? (y/n)");

                        String luaChon = scanner.nextLine().trim().toLowerCase();

                        if (luaChon.equalsIgnoreCase("y")) {
                            System.out.println("Bắt đầu tạo hồ sơ mới...");
                            dSNhanVien.themNhanVien();
                        } else if (luaChon.equalsIgnoreCase("n")) {
                            System.out.println("Quay lại menu chính.");
                            return; // Exit or return to the main menu
                        } else {
                            System.out.println("Lựa chọn không hợp lệ. Quay lại menu chính.");
                            return;
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.print("Nhập mã khách hàng: ");
                    String maKhachHang = scanner.nextLine();
                    boolean timThay = false;

                    for (KhachHang kh : dSKhachHang.getDanhSachKH()) { // Iterate through the list of customers
                        if (kh.getMaKH().equalsIgnoreCase(maKhachHang)) { // Compare entered maKhachHang with each customer's maKH
                            System.out.println("Khách hàng được tìm thấy:");
                            System.out.println("Welcome, " + kh.hoTen);
                            menuKhachHang(scanner, maKhachHang, kh);
                            timThay = true;
                            break; // Exit the loop as we found the customer
                        }
                    }

                    if (!timThay) {
                        System.out.println("Không tìm thấy khách hàng với mã: " + maKhachHang);
                        System.out.println("Bạn có muốn tạo tài khoản mới? (y/n)");

                        String luaChon = scanner.nextLine().trim().toLowerCase();

                        if (luaChon.equalsIgnoreCase("y")) {
                            System.out.println("Bắt đầu tạo tài khoản mới...");
                            dSKhachHang.themKhachHang(); // Call the method to create a new account
                        } else if (luaChon.equalsIgnoreCase("n")) {
                            System.out.println("Quay lại menu chính.");
                            return; // Exit or return to the main menu
                        } else {
                            System.out.println("Lựa chọn không hợp lệ. Quay lại menu chính.");
                            return;
                        }
                    }
                }
                case 0:
                    System.out.println("Thoát chương trình...");
                    running = false; // End the loop and exit the program
                    break;
                default:
                    System.out.println("Vai trò không phù hợp! chọn lại");
            }
        }

        System.out.println("Goodbye!");
    }
    private static void menuQuanLy(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Menu Quản Lý ---");
            System.out.println("1. Thêm Vật Phẩm");
            System.out.println("2. Xóa Vật Phẩm");
            System.out.println("3. Xem Danh Sách Vật Phẩm");
            System.out.println("4. Tìm Kiếm Vật Phẩm Theo UID");
            System.out.println("5. Cập Nhật Vật Phẩm");
            System.out.println("6. Xem Danh Sách Vật Phẩm Lưu Trữ");
            System.out.println("7. Khôi Phục Vật Phẩm Từ Lưu Trữ");
            System.out.println("8. Lưu Kho Hàng Vào Tệp");
            System.out.println("9. Tải Kho Hàng Từ Tệp");
            System.out.println("10. In Danh Sách Vật Phẩm Ra Tệp");
            System.out.println("11. Bổ Sung Hàng Tồn Kho");
            System.out.println("12. Tạo Báo Cáo Tóm Tắt");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    themVatPham(scanner);
                    break;
                case 2:
                    xoaVatPham(scanner);
                    break;
                case 3:
                    xemDanhSachVatPham(scanner);
                    break;
                case 4:
                    timVatPhamBangUID(scanner);
                    break;
                case 5:
                    capNhatVatPham(scanner);
                    break;
                case 6:
                    hienThiVatPhamDaXoa();
                    break;
                case 7:
                    khoiPhucVatPham(scanner);
                    break;
                case 8:
                    luuKho(scanner);
                    break;
                case 9:
                    taiKho(scanner);
                    break;
                case 10:
                    inRaFile(scanner);
                    break;
                case 11:
                    nhapKhoVatPham(scanner,true);
                    break;
                case 12:
                    Kho.INSTANCE.taoBangBaoCaoTongQuat();
                    break;
                case 0:
                    System.out.println("Exiting Manager Menu...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void menuNhanVien(Scanner scanner, String maNV, NhanVien nv) {
        if (nv.getVaiTro().equalsIgnoreCase(NhanVien.BAN_HANG)) {
            menuBanHang(scanner, maNV, nv);
        } else if (nv.getVaiTro().equalsIgnoreCase(NhanVien.KE_TOAN)) {
            menuKeToan(scanner, maNV, nv);
        } else {
            System.out.println("Unknown role. Cannot proceed.");
        }
    }
    private static void menuBanHang(Scanner scanner, String maNV, NhanVien nv, DSKhachHang customerList) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Menu Nhân Viên Bán Hàng ---");
            System.out.println("1. Xem danh sách vật phẩm");
            System.out.println("2. Tìm kiếm vật phẩm theo UID");
            System.out.println("3. Bán hàng");
            System.out.println("4. Quản lý khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    xemDanhSachVatPham(scanner); // Hiển thị danh sách vật phẩm theo danh mục
                    break;
                case 2:
                    timVatPhamBangUID(scanner); // Tìm kiếm vật phẩm theo UID
                    break;
                case 3:
                    BanHang(scanner); // Bán một vật phẩm
                    break;
                case 4:
                    manageCustomerList(scanner, customerList); // Quản lý danh sách khách hàng
                    break;
                case 0:
                    System.out.println("Đang thoát menu nhân viên bán hàng...");
                    running = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
    private static void menuKeToan(Scanner scanner, String maNV, NhanVien nv) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Accountant Menu ---");
            System.out.println("1. View Inventory");
            System.out.println("2. Restock Item");
            System.out.println("3. Check for Expired Items");
            System.out.println("4. Save Inventory to File");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    xemDanhSachVatPham(scanner); // Allow viewing items by category or subcategory
                    break;
                case 2:
                    nhapKhoVatPham(scanner, false); // Add more stock to an existing item
                    break;
                case 3:
                    checkExpiredItems(); // Check for expired items
                    break;
                case 4:
                    inRaFile(scanner); // Save the current inventory to a file
                    break;
                case 0:
                    System.out.println("Exiting Accountant Menu...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void menuKhachHang(Scanner scanner, String maKhachHang, KhachHang kh,DSNV danhSachNhanVien) {
        while (true) {
            System.out.println("\n--- Menu Khách Hàng ---");
            System.out.println("1. Xem thông tin");
            System.out.println("2. Thêm sản phẩm vào giỏ hàng");
            System.out.println("3. Xóa sản phẩm khỏi giỏ hàng");
            System.out.println("4. Xem giỏ hàng");
            System.out.println("5. Cập nhật thông tin");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Mời bạn chọn: ");
            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (luaChon) {
                case 1: {
                    System.out.println("\n--- Thông Tin Khách Hàng ---");
                    kh.Xuat();
                    break;
                }
                case 2: {
                    System.out.print("Nhập UID của vật phẩm muốn thêm: ");
                    String uid = scanner.nextLine();
                    VanPhongPham vatPham = Kho.INSTANCE.timBangUID(uid);

                    if (vatPham != null) {
                        System.out.print("Nhập số lượng muốn thêm vào giỏ hàng: ");
                        int soLuong = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        if (soLuong <= 0) {
                            System.out.println("Số lượng phải lớn hơn không.");
                        } else if (soLuong > vatPham.getSoLuong()) {
                            System.out.println("Số lượng không đủ để thêm. Số sản phẩm hiện có: " + vatPham.getSoLuong());
                        } else {
                            // Update inventory
                            vatPham.setSoLuong(vatPham.getSoLuong() - soLuong);

                            kh.themSanPham(vatPham, soLuong);

                            System.out.println("Đã thêm " + soLuong + " sản phẩm '" + vatPham.getTen() + "' vào giỏ hàng.");
                        }
                    } else {
                        System.out.println("Không tìm thấy vật phẩm.");
                    }
                    break;
                }
                case 3: {
                    System.out.println("--- Giỏ Hàng ---");
                    kh.xemGioHang();

                    System.out.println("Bạn muốn làm gì?");
                    System.out.println("1. Xóa một sản phẩm");
                    System.out.println("2. Xóa toàn bộ giỏ hàng");
                    System.out.print("Mời bạn chọn (1/2): ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (choice == 1) {
                        System.out.print("Nhập UID sản phẩm muốn xóa: ");
                        String uidXoa = scanner.nextLine();
                        kh.xoaSanPham(uidXoa); // Call method to remove single item
                    } else if (choice == 2) {
                        System.out.print("Bạn có chắc muốn xóa toàn bộ giỏ hàng không? (y/n): ");
                        String xacNhan = scanner.nextLine().trim().toLowerCase();
                        if (xacNhan.equalsIgnoreCase("y")) {
                            kh.xoaToanBoGioHang(); // Call method to clear the entire cart
                        } else {
                            System.out.println("Giỏ hàng không bị thay đổi.");
                        }
                    } else {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;
                }
                case 4: {
                    System.out.println("\n--- Giỏ Hàng ---");
                    kh.xemGioHang(); // Display the shopping cart

                    System.out.print("Bạn có muốn hoàn tất việc mua sắm  không? (y/n): ");
                    String input = scanner.nextLine().trim().toLowerCase();
                    if (input.equals("y")) {
                        String maOrder = "ORD-" + System.currentTimeMillis();
                        // Create and process the order
                        Order order = new Order(maOrder, maKhachHang);
                        kh.getGioHang().forEach(order::themVatPham); // Add all items from the cart to the order
                        order.hienThiChiTietOrder();
                        // Clear the shopping cart
                        kh.xoaToanBoGioHang();
                    } else {
                        System.out.println("Bạn đã hủy hoàn tất đơn hàng.");
                    }
                    break;
                }
                case 5: {
                    while (true) {
                        System.out.println(kh.chonMuc());
                        System.out.print("Nhập lựa chọn: ");
                        int input = scanner.nextInt();
                        scanner.nextLine();

                        if (input == 0) {
                            break;
                        }
                        kh.capNhatMuc(input);
                    }
                }

                case 0: {
                    System.out.println("Quay lại menu chính.");
                    return;
                }
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
    private static void themVatPham(Scanner scanner) {
        boolean vatPhamDaThem = false;

        while (!vatPhamDaThem) {
            try {
                System.out.println("Nhập '0' bất kỳ lúc nào để hủy và quay lại menu chính.");

                System.out.print("Nhập tên vật phẩm: ");
                String ten = scanner.nextLine();
                if (ten.equals("0")) return;

                System.out.print("Nhập giá vật phẩm: ");
                Double gia = scanner.nextDouble();
                if (gia == 0) return;
                scanner.nextLine();

                System.out.print("Nhập số lượng vật phẩm bạn muốn thêm: ");
                Integer soLuong = scanner.nextInt();
                if (soLuong == 0) return;
                scanner.nextLine();

                System.out.print("Nhập số lượng hàng tồn: ");
                Integer hangTon = scanner.nextInt();
                if (hangTon == 0) return;
                scanner.nextLine();

                System.out.print("Nhập nhà phân phối của vật phẩm: ");
                String nhaPhanPhoi = scanner.nextLine();
                if (nhaPhanPhoi.equals("0")) return;

                System.out.print("Vật phẩm này được lưu trữ ở đâu: ");
                String viTriKho = scanner.nextLine();
                if (viTriKho.equals("0")) return;

                System.out.print("Nhập cân nặng của vật phẩm(g): ");
                Double canNang = scanner.nextDouble();
                if (canNang == 0) return;
                scanner.nextLine();

                System.out.print("Nhập ngày sản xuất của vật phẩm (dd/MM/yyyy): ");
                String ngaySanXuat = scanner.nextLine();
                if (ngaySanXuat.equals("0")) return;

                System.out.print("Nhập ngày hết hạn của vật phẩm (dd/MM/yyyy): ");
                String ngayHetHan = scanner.nextLine();
                if (ngayHetHan.equals("0")) return;

                System.out.println("1. Công cụ viết");
                System.out.print("Nhập mục chính: ");
                String mucChinh = scanner.nextLine();
                if (mucChinh.equals("0")) return;

                switch (mucChinh) {
                    case "1":
                        mucChinh ="CongCuViet";
                        CongCuViet vatPham = null;
                        System.out.println("1.Bút Bi");
                        System.out.println("2.Bút Máy ");
                        System.out.println("3.Bút Chì ");
                        System.out.println("4.Bút Chì Bấm ");
                        System.out.println("5.Bút Lông ");
                        System.out.print("Nhập mục phụ: ");
                        String mucPhu = scanner.nextLine();
                        if (mucPhu.equals("0")) return;
                        switch (mucPhu) {
                            case "1": {
                                mucPhu="ButBi";

                                System.out.print("Nhập màu của bút: ");
                                String mau = menuMau(scanner);

                                System.out.print("Vỏ bút được làm từ chất liệu gì: ");
                                String vatLieuThanBut = menuVatLieuThanBut(scanner);

                                System.out.print("Bút này có thể bơm mực lại được không (y/n): ");
                                Boolean coTheNapLai = scanner.nextLine().equals("y");

                                System.out.print("Bút này có thể xóa được không (y/n): ");
                                Boolean coTheXoa = scanner.nextLine().equals("y");

                                System.out.print("Nhập kích thước ngòi bút bi: ");
                                Double kichThuocNgoiBut =menuKichThuocNgoiButBi(scanner);


                                System.out.print("Nhập màu mực của bút bi: ");
                                String mauMuc=menuMauMucButBi(scanner);

                                System.out.print("Nhập loại ngòi bút: ");
                                String loaiNgoi = menuLoaiNgoiButBi(scanner);

                                System.out.print("Bút này có nắp không (y/n): ");
                                Boolean coNap = scanner.nextLine().equals("y");

                                vatPham = new ButBi(ten, null, null, gia,  soLuong, hangTon,  nhaPhanPhoi, canNang,  viTriKho,  ngaySanXuat,  ngayHetHan, mau, vatLieuThanBut,  coTheNapLai,  coTheXoa, kichThuocNgoiBut, mauMuc, loaiNgoi,coNap);
                                vatPham.addTag("congcuviet");
                                vatPham.addTag("but");
                                break;
                            }
                            case "2": { // Fountain Pen
                                mucPhu="ButMay";
                                System.out.println("Nhập màu của bút máy: ");
                                String mauBut = menuMau(scanner);

                                System.out.println("Chất liệu vỏ của bút máy là gì: ");
                                String vatLieuThanBut = menuVatLieuThanBut(scanner);

                                System.out.print("Bút máy này có thể bơm mực lại được không (y/n): ");
                                boolean coTheNapLai = scanner.nextLine().equalsIgnoreCase("y");

                                System.out.print("Bút máy này có thể xóa được không (y/n): ");
                                boolean coTheXoa = scanner.nextLine().equalsIgnoreCase("y");

                                System.out.println("Nhập kích thước ngòi bút máy: ");
                                String kichThuocNgoi =menuKichThuocNgoiButMay(scanner);


                                System.out.println("Nhập màu mực bút máy: ");
                                String mauMuc =menuMauMucButMay(scanner);

                                System.out.println("Nhập loại ngòi bút máy: ");
                                String loaiNgoi = menuLoaiNgoiButMay(scanner);

                                System.out.println("Nhập loại vật liệu của ngòi bút máy: ");
                                String vatLieuNgoi = menuVatLieuNgoiButMay(scanner);

                                System.out.print("Nhập loại hệ thống bơm mực của bút máy: ");
                                String coCheBomMuc = menuHeThongCapMucButMay(scanner);

                                System.out.print("Bút máy này có nắp không (y/n): ");
                                boolean coNapDay = scanner.nextLine().equalsIgnoreCase("y");
                                vatPham = new ButMay(ten, null, null, gia,  soLuong, hangTon,  nhaPhanPhoi, canNang,  viTriKho,  ngaySanXuat,  ngayHetHan,  mauBut, vatLieuThanBut,coTheNapLai,  coTheXoa,kichThuocNgoi,mauMuc,loaiNgoi,vatLieuNgoi,coCheBomMuc,coNapDay);
                                vatPham.addTag("congcuviet");
                                vatPham.addTag("butmay");
                                break;
                            }

                            case "3": { // Pencil
                                mucPhu="ButChi";
                                System.out.print("Nhập màu bút chì: ");
                                String mau = menuMau(scanner);
                                System.out.print("Nhập vật liệu thân bút chì: ");
                                String vatLieuThanBut = menuVatLieuThanBut(scanner);
                                System.out.print("Is this pencil erasable (y/n): ");
                                boolean coTheXoa = scanner.nextLine().equalsIgnoreCase("y");
                                System.out.print("Nhập độ cứng bút chì: ");
                                String doCung = menuDoCungButChi(scanner);
                                System.out.print("Bút chì này có tẩy không(y/n): ");
                                boolean coTay = scanner.nextLine().equalsIgnoreCase("y");
                                vatPham = new ButChi(ten, null, null, gia,  soLuong ,hangTon,  nhaPhanPhoi, canNang,  viTriKho,  ngaySanXuat,  ngayHetHan, mau,vatLieuThanBut, false,coTheXoa , doCung, coTay);
                                vatPham.addTag("congcuviet");
                                vatPham.addTag("butchi");
                                break;
                            }

                            case "4": { // Mechanical Pencil
                                mucPhu="ButChiBam";
                                System.out.print("Nhập màu bút chì bấm: ");
                                String mau = menuMau(scanner);
                                System.out.print("Nhập vật liệu bút chì bấm: ");
                                String vatLieuThanBut = menuVatLieuThanBut(scanner);
                                System.out.print("Is this mechanical pencil refillable (y/n): ");
                                boolean coTheNapLai = scanner.nextLine().equalsIgnoreCase("y");
                                System.out.print("Is this mechanical pencil erasable (y/n): ");
                                boolean coTheXoa = scanner.nextLine().equalsIgnoreCase("y");
                                System.out.print("Enter mechanical pencil's point size: ");
                                double kichThuocNgoi = menuKichThuocNgoiButChiBam(scanner);
                                scanner.nextLine(); // Consume newline
                                System.out.print("Bút chì bấm này có tẩy không(y/n): ");
                                boolean coTay = scanner.nextLine().equalsIgnoreCase("y");
                                vatPham = new ButChiBam(ten, null, null,  gia,  soLuong, hangTon,  nhaPhanPhoi,canNang,  viTriKho,  ngaySanXuat, ngayHetHan, mau,vatLieuThanBut,coTheNapLai,  coTheXoa,kichThuocNgoi,  coTay);
                                vatPham.addTag("congcuviet");
                                vatPham.addTag("butchibam");
                                break;
                            }
                            case "5": { // Marker
                                mucPhu = "ButLong";
                                System.out.print("Nhập màu bút lông: ");
                                String mau = menuMau(scanner);
                                System.out.print("Nhập vật liệu thân bút lông: ");
                                String vatLieuThanBut = menuVatLieuThanBut(scanner);
                                System.out.print("Bút lông này có thể bơm mực lại được không (y/n): ");
                                boolean coTheNapLai = scanner.nextLine().equalsIgnoreCase("y");
                                System.out.print("Bút lông này có thể xóa được không (y/n): ");
                                boolean coTheXoa = scanner.nextLine().equalsIgnoreCase("y");
                                System.out.print("Nhập loại mực bút lông (ví dụ: mực dầu, mực nước): ");
                                String loaiMuc = menuLoaiMucButLong(scanner);
                                System.out.print("Nhập loại ngòi bút lông: ");
                                String loaiDauBut = menuLoaiDauButLong(scanner);
                                vatPham = new ButLong(ten,  null, null, gia, soLuong,hangTon, nhaPhanPhoi,canNang, viTriKho,  ngaySanXuat, ngayHetHan,  mau,vatLieuThanBut, coTheNapLai,  coTheXoa,loaiMuc , loaiDauBut);
                                vatPham.addTag("congcuviet");
                                vatPham.addTag("butlong");
                                break;
                            }
                            default:
                                System.out.println("Invalid subcategory selection.");
                                continue;
                        }
                        if(vatPham != null) {
                            Kho.INSTANCE.themVatPham(vatPham.getClass().getSuperclass().getSimpleName(), vatPham.getClass().getSimpleName(), vatPham);
                            System.out.println(vatPham.getClass().getSimpleName() + " đã thêm thành công");
                            vatPhamDaThem=true;
                            break;
                        }
                        break;
                    default:
                        System.out.println("Lựa chọn mục không phù hợp.");
                        continue;

                }
            } catch (Exception e) {
                System.out.println("Input không phù hợp! thử lại.");
                scanner.nextLine();
            }
        }
    }

    private static void xoaVatPham(Scanner scanner) {
        boolean vatPhamDaXoa = false;
        while (!vatPhamDaXoa) {
            System.out.println("Nhập '0' bất cứ lúc nào để hủy và quay lại menu chính.");
            System.out.println("Chọn phương thức tìm kiếm để xóa vật phẩm:");
            System.out.println("1. Tìm kiếm trực tiếp bằng UID");
            System.out.println("2. Tìm kiếm theo danh mục");
            String phuongThuc = scanner.nextLine();

            if (phuongThuc.equals("0")) return;

            switch (phuongThuc) {
                case "1": // Tìm kiếm trực tiếp bằng UID
                    System.out.print("Nhập UID của vật phẩm muốn xóa: ");
                    String uid = scanner.nextLine();
                    if (uid.equals("0")) return;
                    Kho.INSTANCE.xoaVatPham(uid);
                    vatPhamDaXoa=true;
                    break;

                case "2": // Tìm kiếm theo danh mục
                    System.out.println("Chọn danh mục để xóa:");
                    System.out.println("1. Công cụ viết");
                    String mucChinh = scanner.nextLine();
                    if (mucChinh.equals("0")) return;

                    switch (mucChinh) {
                        case "1":
                            mucChinh = "congcuviet";
                            System.out.println("Chọn danh mục phụ:");
                            System.out.println("1. Bút Bi");
                            System.out.println("2. Bút Máy");
                            System.out.println("3. Bút Chì");
                            System.out.println("4. Bút Chì Bấm");
                            System.out.println("5. Bút Lông");
                            String mucPhu = scanner.nextLine();
                            if (mucPhu.equals("0")) return;

                            switch (mucPhu) {
                                case "1":
                                    mucPhu = "butbi";
                                    break;
                                case "2":
                                    mucPhu = "butmay";
                                    break;
                                case "3":
                                    mucPhu = "butchi";
                                    break;
                                case "4":
                                    mucPhu = "butchibam";
                                    break;
                                case "5":
                                    mucPhu = "butlong";
                                    break;
                                default:
                                    System.out.println("Lựa chọn danh mục phụ không hợp lệ. Vui lòng thử lại.");
                                    continue; // Thử lại việc chọn danh mục phụ
                            }

                            // Hiển thị tất cả các vật phẩm trong danh mục phụ đã chọn
                            Map<String, VanPhongPham> vatPhamTheoDanhMuc = Kho.INSTANCE.getKho().get(mucChinh).get(mucPhu);
                            if (vatPhamTheoDanhMuc == null || vatPhamTheoDanhMuc.isEmpty()) {
                                System.out.println("Không có vật phẩm nào trong danh mục phụ: " + mucPhu);
                                return;
                            }

                            System.out.println("Các vật phẩm trong danh mục phụ '" + mucPhu + "':");
                            for (Map.Entry<String, VanPhongPham> entry : vatPhamTheoDanhMuc.entrySet()) {
                                System.out.println("UID: " + entry.getKey() + " - " + entry.getValue());
                            }

                            // Thêm menu lựa chọn xóa
                            System.out.println("Bạn muốn làm gì?");
                            System.out.println("1. Xóa toàn bộ vật phẩm trong danh mục này");
                            System.out.println("2. Xóa một vật phẩm cụ thể");
                            String luaChonXoa = scanner.nextLine();
                            if (luaChonXoa.equals("0")) return;

                            switch (luaChonXoa) {
                                case "1": // Xóa toàn bộ vật phẩm
                                    vatPhamTheoDanhMuc.clear(); // Xóa toàn bộ vật phẩm trong danh mục phụ
                                    System.out.println("Toàn bộ vật phẩm trong danh mục '" + mucPhu + "' đã được xóa.");
                                    vatPhamDaXoa = true; // Thoát vòng lặp
                                    break;

                                case "2": // Xóa một vật phẩm cụ thể
                                    System.out.print("Nhập UID của vật phẩm muốn xóa: ");
                                    String uidMucPhu = scanner.nextLine();
                                    if (uidMucPhu.equals("0")) return;
                                    Kho.INSTANCE.xoaVatPham(uidMucPhu);
                                    vatPhamDaXoa=true;
                                    break;

                                default:
                                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                                    break;
                            }
                            break;

                        default:
                            System.out.println("Lựa chọn danh mục không hợp lệ. Vui lòng thử lại.");
                            continue; // Thử lại việc chọn danh mục chính
                    }
                    break;

                default:
                    System.out.println("Phương thức không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    private static void timVatPhamBangUID(Scanner scanner) {
        System.out.println("Nhập '0' bất cứ lúc nào để hủy và quay lại menu chính.");
        System.out.print("Nhập UID để tìm kiếm: ");
        String uid = scanner.nextLine();
        if (uid.equals("0")) return;

        VanPhongPham vatPham = Kho.INSTANCE.timBangUID(uid);
        if (vatPham != null) {
            vatPham.xuatThongTin();  // Hiển thị thông tin vật phẩm nếu tìm thấy
        } else {
            System.out.println("Không tìm thấy vật phẩm với UID: " + uid);
        }
    }
    private static void capNhatVatPham(Scanner scanner) {
        System.out.println("Nhập '0' bất cứ lúc nào để hủy và quay lại menu chính.");
        System.out.print("Nhập UID để tìm kiếm: ");
        String uid = scanner.nextLine();
        if (uid.equals("0")) return;

        VanPhongPham vatPhamCanThayDoi = Kho.INSTANCE.timBangUID(uid);
        if (vatPhamCanThayDoi != null) {
            System.out.println(vatPhamCanThayDoi.chonMuc());  // Hiển thị tất cả các tùy chọn
            int luaChon =0;
            try {
                System.out.print("Nhập lưa chọn của bạn: ");
                luaChon = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input không phù hợp ! Chọn lại");
                scanner.nextLine();
            }
            vatPhamCanThayDoi.capNhatMuc(luaChon);
        } else {
            System.out.println("Không tìm thấy vật phẩm với UID đã nhập. Quay lại menu chính.");
            return;
        }

    }


    private static void hienThiVatPhamDaXoa(){
        Kho.INSTANCE.hienThiVatPhamDaXoa();
    }
    private static void khoiPhucVatPham(Scanner scanner) {
        System.out.print("Nhập UID của vật phẩm cần khôi phục: ");
        String uid = scanner.nextLine();
        Kho.INSTANCE.khoiPhucVatPham(uid);
    }
    private static void luuKho(Scanner scanner) {
        //System.out.print("Nhập đường dẫn file để lưu kho: ");
        //String filePath = scanner.nextLine();
        String filePath = "C:\\Users\\Admin\\Desktop\\programming junk\\Java\\bigProjects\\OfficeSupplyManager\\project\\textStorage\\xuat.txt";
        XuLyFile.luuKhoVaoFile(Kho.INSTANCE, filePath);
    }

    private static void taiKho(Scanner scanner) {
        System.out.print("Nhập đường dẫn file để tải kho: ");
        String filePath = scanner.nextLine();
        XuLyFile.taiKhoTuFile(filePath);
    }
    private static void inRaFile(Scanner scanner) {
        System.out.println("Nhấn '0' để hủy lệnh và trở về menu chính");
        boolean luaChonHopLe = false;

        while (!luaChonHopLe) {
            try {
                System.out.println("Kiểu In:");
                System.out.println("1. In vật phẩm theo UID");
                System.out.println("2. In theo danh mục");
                System.out.println("3. In theo danh mục phụ");
                System.out.print("Nhập lựa chọn của bạn: ");
                int luaChon = scanner.nextInt();
                scanner.nextLine(); // Xóa dòng trống

                switch (luaChon) {
                    case 0: // Thoát về menu
                        System.out.println("Hủy lệnh. Trở về menu chính...");
                        luaChonHopLe = true; // Thoát vòng lặp
                        break;

                    case 1: // In theo UID
                        System.out.print("Nhập UID của vật phẩm cần in: ");
                        String uid = scanner.nextLine();
                        if (uid.equals("0")) {
                            System.out.println("Hủy lệnh. Trở về menu chính...");
                            luaChonHopLe = true;
                            break;
                        }
                        XuLyFile.luuVatPhamTheoUID("C:\\Users\\Admin\\Desktop\\programming junk\\Java\\bigProjects\\OfficeSupplyManager\\project\\textStorage\\xuat.txt", uid);
                        luaChonHopLe = true;
                        break;

                    case 2: // In theo danh mục
                        System.out.println("Chọn danh mục:");
                        Map<String, Map<String, Map<String, VanPhongPham>>> kho = Kho.INSTANCE.getKho();
                        int chiSoDanhMuc = 1;
                        Map<Integer, String> danhSachDanhMuc = new HashMap<>();

                        for (String danhMuc : kho.keySet()) {
                            System.out.println(chiSoDanhMuc + ". " + danhMuc);
                            danhSachDanhMuc.put(chiSoDanhMuc, danhMuc);
                            chiSoDanhMuc++;
                        }

                        System.out.print("Nhập số thứ tự của danh mục: ");
                        int luaChonDanhMuc = scanner.nextInt();
                        scanner.nextLine(); // Xóa dòng trống

                        String danhMucDaChon = danhSachDanhMuc.get(luaChonDanhMuc);
                        if (danhMucDaChon != null) {
                            XuLyFile.luuVatPhamTheoDanhMuc("C:\\Users\\Admin\\Desktop\\programming junk\\Java\\bigProjects\\OfficeSupplyManager\\project\\textStorage\\xuat.txt", danhMucDaChon);
                            luaChonHopLe = true;
                        } else {
                            System.out.println("Lựa chọn danh mục không hợp lệ. Vui lòng thử lại.");
                        }
                        break;

                    case 3: // In theo danh mục phụ
                        System.out.println("Chọn danh mục:");
                        kho = Kho.INSTANCE.getKho();
                        chiSoDanhMuc = 1;
                        danhSachDanhMuc = new HashMap<>();

                        for (String danhMuc : kho.keySet()) {
                            System.out.println(chiSoDanhMuc + ". " + danhMuc);
                            danhSachDanhMuc.put(chiSoDanhMuc, danhMuc);
                            chiSoDanhMuc++;
                        }

                        System.out.print("Nhập số thứ tự của danh mục: ");
                        luaChonDanhMuc = scanner.nextInt();
                        scanner.nextLine(); // Xóa dòng trống

                        danhMucDaChon = danhSachDanhMuc.get(luaChonDanhMuc);
                        if (danhMucDaChon != null) {
                            System.out.println("Chọn danh mục phụ:");
                            Map<String, Map<String, VanPhongPham>> danhMucPhuMap = kho.get(danhMucDaChon);
                            int chiSoDanhMucPhu = 1;
                            Map<Integer, String> danhSachDanhMucPhu = new HashMap<>();

                            for (String danhMucPhu : danhMucPhuMap.keySet()) {
                                System.out.println(chiSoDanhMucPhu + ". " + danhMucPhu);
                                danhSachDanhMucPhu.put(chiSoDanhMucPhu, danhMucPhu);
                                chiSoDanhMucPhu++;
                            }

                            System.out.print("Nhập số thứ tự của danh mục phụ: ");
                            int luaChonDanhMucPhu = scanner.nextInt();
                            scanner.nextLine(); // Xóa dòng trống

                            String danhMucPhuDaChon = danhSachDanhMucPhu.get(luaChonDanhMucPhu);
                            if (danhMucPhuDaChon != null) {
                                XuLyFile.luuVatPhamTheoDanhMucPhu("C:\\Users\\Admin\\Desktop\\programming junk\\Java\\bigProjects\\OfficeSupplyManager\\project\\textStorage\\xuat.txt", danhMucDaChon, danhMucPhuDaChon);
                                luaChonHopLe = true;
                            } else {
                                System.out.println("Lựa chọn danh mục phụ không hợp lệ. Vui lòng thử lại.");
                            }
                        } else {
                            System.out.println("Lựa chọn danh mục không hợp lệ. Vui lòng thử lại.");
                        }
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số hợp lệ.");
                }
            } catch (Exception e) {
                System.out.println("Lỗi nhập liệu. Vui lòng nhập số hợp lệ.");
                scanner.nextLine(); // Xóa dữ liệu nhập không hợp lệ
            }
        }
    }

    private static void taiTruocKho(String FilePath) {
        System.out.println("Đang tải dữ liệu kho từ file: " + FilePath);
        File file = new File(FilePath);
        if (file.exists()) {
            XuLyFile.taiKhoTuFile(FilePath);
        } else {
            System.out.println("Không tìm thấy file dữ liệu mặc định. Bắt đầu với kho trống.");
        }
    }

    private static void xemDanhSachVatPham(Scanner scanner) {
        boolean luaChonHopLe = false;
        while (!luaChonHopLe) {
            try {
                System.out.println("Tùy chọn hiển thị:");
                System.out.println("1. Xem tất cả các vật phẩm");
                System.out.println("2. Xem theo danh mục");
                System.out.print("Nhập lựa chọn của bạn: ");
                int luaChon = scanner.nextInt();
                scanner.nextLine(); // Xóa dòng trống

                switch (luaChon) {
                    case 1:
                        // Hiển thị tất cả các vật phẩm trong kho
                        Kho.INSTANCE.hienThiTatCaVatPham();
                        luaChonHopLe = true; // Thoát vòng lặp
                        break;

                    case 2:
                        // Hiển thị vật phẩm theo danh mục và danh mục phụ
                        boolean luaChonDanhMucHopLe = false;
                        while (!luaChonDanhMucHopLe) {
                            try {
                                System.out.println("Danh mục:");
                                Map<String, Map<String, Map<String, VanPhongPham>>> kho = Kho.INSTANCE.getKho();
                                int chiSoDanhMuc = 1;
                                Map<Integer, String> danhSachDanhMuc = new HashMap<>();

                                // Liệt kê danh mục
                                for (String danhMuc : kho.keySet()) {
                                    System.out.println(chiSoDanhMuc + ". " + danhMuc);
                                    danhSachDanhMuc.put(chiSoDanhMuc, danhMuc);
                                    chiSoDanhMuc++;
                                }

                                System.out.print("Nhập số thứ tự của danh mục để xem danh mục phụ: ");
                                int luaChonDanhMuc = scanner.nextInt();
                                scanner.nextLine(); // Xóa dòng trống

                                String danhMucDaChon = danhSachDanhMuc.get(luaChonDanhMuc);
                                if (danhMucDaChon != null) {
                                    boolean luaChonDanhMucPhuHopLe = false;
                                    while (!luaChonDanhMucPhuHopLe) {
                                        try {
                                            System.out.println("Danh mục phụ trong " + danhMucDaChon + ":");
                                            Map<String, Map<String, VanPhongPham>> danhMucPhu = kho.get(danhMucDaChon);

                                            int chiSoDanhMucPhu = 1;
                                            Map<Integer, String> danhSachDanhMucPhu = new HashMap<>();

                                            // Liệt kê danh mục phụ
                                            for (String danhMucPhuKey : danhMucPhu.keySet()) {
                                                System.out.println(chiSoDanhMucPhu + ". " + danhMucPhuKey);
                                                danhSachDanhMucPhu.put(chiSoDanhMucPhu, danhMucPhuKey);
                                                chiSoDanhMucPhu++;
                                            }

                                            System.out.print("Nhập số thứ tự của danh mục phụ để xem vật phẩm: ");
                                            int luaChonDanhMucPhu = scanner.nextInt();
                                            scanner.nextLine(); // Xóa dòng trống

                                            String danhMucPhuDaChon = danhSachDanhMucPhu.get(luaChonDanhMucPhu);
                                            if (danhMucPhuDaChon != null) {
                                                // Hiển thị vật phẩm trong danh mục phụ đã chọn
                                                Map<String, VanPhongPham> vatPham = danhMucPhu.get(danhMucPhuDaChon);
                                                if (vatPham.isEmpty()) {
                                                    System.out.println("Không có vật phẩm nào trong danh mục phụ này.");
                                                } else {
                                                    for (VanPhongPham item : vatPham.values()) {
                                                        System.out.println("--------------");
                                                        item.xuatThongTin();
                                                        System.out.println("--------------");
                                                    }
                                                }
                                                luaChonDanhMucPhuHopLe = true; // Thoát vòng lặp danh mục phụ
                                                luaChonDanhMucHopLe = true;   // Thoát vòng lặp danh mục
                                                luaChonHopLe = true;          // Thoát vòng lặp chính
                                            } else {
                                                System.out.println("Lựa chọn danh mục phụ không hợp lệ. Vui lòng thử lại.");
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Lỗi nhập liệu. Vui lòng nhập số hợp lệ cho danh mục phụ.");
                                            scanner.nextLine(); // Xóa dữ liệu không hợp lệ
                                        }
                                    }
                                } else {
                                    System.out.println("Lựa chọn danh mục không hợp lệ. Vui lòng thử lại.");
                                }
                            } catch (Exception e) {
                                System.out.println("Lỗi nhập liệu. Vui lòng nhập số hợp lệ cho danh mục.");
                                scanner.nextLine(); // Xóa dữ liệu không hợp lệ
                            }
                        }
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                }
            } catch (Exception e) {
                System.out.println("Lỗi nhập liệu. Vui lòng nhập số hợp lệ.");
                scanner.nextLine(); // Xóa dữ liệu không hợp lệ
            }
        }
    }

    private static void nhapKhoVatPham(Scanner scanner, boolean laQuanLy) {
        System.out.print("Nhập UID của vật phẩm cần nhập kho: ");
        String uid = scanner.nextLine();
        VanPhongPham vatPham = Kho.INSTANCE.timBangUID(uid);

        if (vatPham != null) {
            if (laQuanLy) {
                System.out.print("Nhập số lượng cần thêm vào kho: ");
                int soLuong = scanner.nextInt();
                scanner.nextLine();

                if (soLuong > 0) {
                    double chiPhi = soLuong * vatPham.getGia();
                    vatPham.boSungHangTon(soLuong);
                    System.out.println("Quản lý đã nhập kho thành công.");
                    System.out.println("Tổng chi phí: $" + chiPhi);

                    // Ghi lại giao dịch nhập hàng
                    NhatKyGiaoDich.INSTANCE.ghiGiaoDich(
                            new GiaoDich("NHẬP KHO", vatPham.getTen(), uid, soLuong, chiPhi)
                    );
                } else {
                    System.out.println("Số lượng phải lớn hơn 0.");
                }
            } else {
                System.out.print("Nhập số lượng cần chuyển từ hàng tồn: ");
                int soLuong = scanner.nextInt();
                scanner.nextLine();

                if (soLuong <= 0) {
                    System.out.println("Số lượng phải lớn hơn 0.");
                } else if (soLuong > vatPham.getHangTon()) {
                    System.out.println("Hàng tồn không đủ. Số lượng khả dụng: " + vatPham.getHangTon());
                } else {
                    vatPham.boSungTuKhoHangTon(soLuong);
                    System.out.println("Nhân viên đã nhập kho thành công.");

                    // Ghi lại giao dịch nhập hàng từ hàng tồn
                    NhatKyGiaoDich.INSTANCE.ghiGiaoDich(
                            new GiaoDich("NHẬP KHO TỪ HÀNG TỒN", vatPham.getTen(), uid, soLuong, 0)
                    );
                }
            }
        } else {
            System.out.println("Không tìm thấy vật phẩm với UID đã nhập.");
        }
    }

    private static void banVatPham(Scanner scanner) {
        System.out.print("Nhập UID của vật phẩm cần bán: ");
        String uid = scanner.nextLine();
        VanPhongPham vatPham = Kho.INSTANCE.timBangUID(uid);

        if (vatPham != null) {
            System.out.print("Nhập số lượng cần bán: ");
            int soLuong = scanner.nextInt();
            scanner.nextLine();

            if (soLuong <= 0) {
                System.out.println("Số lượng phải lớn hơn không.");
            } else if (soLuong > vatPham.getSoLuong()) {
                System.out.println("Số lượng không đủ để bán. Số sản phẩm hiện có: " + vatPham.getSoLuong());
            } else {
                vatPham.setSoLuong(vatPham.getSoLuong() - soLuong);
                double tongGia = soLuong * vatPham.getGia();
                System.out.println("Bán thành công. Tổng số tiền: $" + tongGia);

                // Ghi lại giao dịch
                NhatKyGiaoDich.INSTANCE.ghiGiaoDich(
                        new GiaoDich("BÁN", vatPham.getTen(), uid, soLuong, tongGia)
                );
            }
        } else {
            System.out.println("Không tìm thấy vật phẩm.");
        }
    }
    private static void checkExpiredItems() {
        System.out.println("Checking for expired vatPhams...");
        for (String danhMucChinh : Kho.INSTANCE.getKho().keySet()) {
            for (String danhMucPhu : Kho.INSTANCE.getKho().get(danhMucChinh).keySet()) {
                for (VanPhongPham vatPham : Kho.INSTANCE.getKho().get(danhMucChinh).get(danhMucPhu).values()) {
                    vatPham.kiemTraNgay();
                }
            }
        }
    }
    private static String menuMau(Scanner scanner){
        do {
            System.out.println("1. Đen");
            System.out.println("2. Trắng");
            System.out.println("3. Bạc");
            System.out.println("4. Vàng");
            System.out.println("5. Xám");
            System.out.println("6. Đỏ");
            System.out.println("7. Xanh Dương");
            System.out.println("8. Vàng Nhạt");
            System.out.println("9. Xanh Lá");
            System.out.println("10. Cam");
            System.out.println("11. Tím");
            System.out.println("12. Hồng Nhạt");
            System.out.println("13. Xanh Dương Nhạt");
            System.out.println("14. Xanh Lá Nhạt");
            System.out.println("15. Trong Suốt");
            System.out.println("16. Màu Chuyển Đổi");
            System.out.println("17. Nâu");
            System.out.println("18. Xanh Navy");
            System.out.println("19. Khác");
            System.out.print("Chọn (1-19): ");


            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    return "Đen";
                case 2:
                    return "Trắng";
                case 3:
                    return "Bạc";
                case 4:
                    return "Vàng";
                case 5:
                    return "Xám";
                case 6:
                    return "Đỏ";
                case 7:
                    return "Xanh Dương";
                case 8:
                    return "Vàng Nhạt";
                case 9:
                    return "Xanh Lá";
                case 10:
                    return "Cam";
                case 11:
                    return "Tím";
                case 12:
                    return "Hồng Nhạt";
                case 13:
                    return "Xanh Dương Nhạt";
                case 14:
                    return "Xanh Lá Nhạt";
                case 15:
                    return "Trong Suốt";
                case 16:
                    return "Màu Chuyển Đổi";
                case 17:
                    return "Nâu";
                case 18:
                    return "Xanh Navy";
                case 19:
                    return scanner.nextLine();
                default:
                    System.out.println("Nhap sai! nhập lại");
                    continue;
            }
        }while(true);
    }
    private static String menuVatLieuThanBut(Scanner scanner){
        do {
            System.out.println("Chọn vật liệu thân bút mới:");
            System.out.println("1. Nhựa");
            System.out.println("2. Kim Loại");
            System.out.println("3. Gỗ");
            System.out.println("4. Nhôm");
            System.out.println("5. Thép Không Gỉ");
            System.out.println("6. Đồng");
            System.out.println("7. Thủy Tinh");
            System.out.println("8. Carbon");
            System.out.println("9. Cao Su");
            System.out.println("10. Acrylic");
            System.out.println("11. Khác");
            System.out.print("Chọn (1-11): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    return "Nhựa";
                case 2:
                    return "Kim Loại";
                case 3:
                    return "Gỗ";
                case 4:
                    return "Nhôm";
                case 5:
                    return "Thép Không Gỉ";
                case 6:
                    return "Đồng";
                case 7:
                    return "Thủy Tinh";
                case 8:
                    return "Carbon";
                case 9:
                    return "Cao Su";
                case 10:
                    return "Acrylic";
                case 11:
                    System.out.print("Nhập vật liệu: ");
                    return (scanner.nextLine());
                default:
                    System.out.println("Nhập sai! Nhập lại");
                    continue;
            }
        }while(true);
    }
    private static double menuKichThuocNgoiButBi(Scanner scanner) {
        do {
            System.out.println("Chọn kích thước ngòi bút bi:");
            System.out.println("1. 0.38mm (Rất Nhỏ)");
            System.out.println("2. 0.5mm (Nhỏ)");
            System.out.println("3. 0.7mm (Trung Bình)");
            System.out.println("4. 1.0mm (To)");
            System.out.println("5. 1.2mm (Rất To)");
            System.out.println("6. Kích thước khác (Nhập tay)");
            System.out.print("Chọn (1-6): ");


            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    return 0.38;
                case 2:
                    return 0.5;
                case 3:
                    return 0.7;
                case 4:
                    return 1.0;
                case 5:
                    return 1.2;
                case 6:
                    System.out.print("Nhập kích thước khác (mm): ");
                    double customSize = scanner.nextDouble();
                    scanner.nextLine(); // Clear buffer
                    if (customSize > 0.1) {
                        return customSize;
                    } else {
                        System.out.println("Kích thước không hợp lý! Vui lòng nhập lại.");
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không có! Vui lòng nhập lại.");
            }
        } while (true);
    }
    private static String menuMauMucButBi(Scanner scanner) {
        do {
            System.out.println("Chọn màu bút:");
            System.out.println("1. Đen");
            System.out.println("2. Xanh Dương");
            System.out.println("3. Đỏ");
            System.out.println("4. Xanh Lá");
            System.out.println("5. Tím");
            System.out.println("6. Trắng");
            System.out.println("7. Vàng");
            System.out.println("8. Cam");
            System.out.println("9. Hồng");
            System.out.println("10. Màu khác (Nhập tay)");
            System.out.print("Chọn (1-10): ");



            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    return "Đen";
                case 2:
                    return "Xanh Dương";
                case 3:
                    return "Đỏ";
                case 4:
                    return "Xanh Lá";
                case 5:
                    return "Tím";
                case 6:
                    return "Trắng";
                case 7:
                    return "Vàng";
                case 8:
                    return "Cam";
                case 9:
                    return "Hồng";
                case 10:
                    System.out.print("Nhập màu khác: ");
                    return scanner.nextLine();
                default:
                    System.out.println("Lựa chọn không có! Vui lòng nhập lại.");
            }
        } while (true);
    }
    private static String menuLoaiNgoiButBi(Scanner scanner) {
        do {
            System.out.println("1. Ngòi Bút Bi");
            System.out.println("2. Ngòi Gel");
            System.out.println("3. Ngòi Lăn Mực");
            System.out.println("4. Ngòi Mực Lông");
            System.out.println("5. Ngòi Mực Dầu");
            System.out.println("6. Loại ngòi khác (Nhập tay)");
            System.out.print("Chọn (1-6): ");


            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    return "Ngòi Bút Bi";
                case 2:
                    return "Ngòi Gel";
                case 3:
                    return "Ngòi Lăn Mực";
                case 4:
                    return "Ngòi Mực Lông";
                case 5:
                    return "Ngòi Mực Dầu";
                case 6:
                    System.out.print("Nhập loại ngòi khác: ");
                    return scanner.nextLine();
                default:
                    System.out.println("Lựa chọn không có! Vui lòng nhập lại.");
            }
        } while (true);
    }

    private static String menuKichThuocNgoiButMay(Scanner scanner){
        do{
            System.out.println("1. EF (Extra Fine)");
            System.out.println("2. F (Fine)");
            System.out.println("3. M (Medium)");
            System.out.println("4. B (Broad)");
            System.out.println("5. BB (Double Broad)");
            System.out.println("6. A (Apprentice)");
            System.out.println("7. OM (Oblique Medium)");
            System.out.println("8. OB (Oblique Broad)");
            System.out.println("9. OBB (Oblique Double Broad)");
            System.out.println("10. ST (Stub)");
            System.out.println("11. IT (Italic)");
            System.out.println("12. C (Calligraphy)");
            System.out.println("13. G (Gradient)");
            System.out.println("14. Z (Zoom)");
            System.out.println("15. Music (Ngòi Nhạc)");
            System.out.println("16. Architect (Ngòi Kiến trúc)");
            System.out.print("Chọn (1-16): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    return "EF (Extra Fine)";
                case 2:
                    return "F (Fine)";
                case 3:
                    return "M (Medium)";
                case 4:
                    return "B (Broad)";
                case 5:
                    return "BB (Double Broad)";
                case 6:
                    return "A (Apprentice)";
                case 7:
                    return "OM (Oblique Medium)";
                case 8:
                    return "OB (Oblique Broad)";
                case 9:
                    return "OBB (Oblique Double Broad)";
                case 10:
                    return "ST (Stub)";
                case 11:
                    return "IT (Italic)";
                case 12:
                    return "C (Calligraphy)";
                case 13:
                    return "G (Gradient)";
                case 14:
                    return "Z (Zoom)";
                case 15:
                    return "Music (Ngòi Nhạc)";
                case 16:
                    return "Architect (Ngòi Kiến trúc)";
                default:
                    System.out.println("Lựa chọn không có! Chọn lại.");
                    continue;
            }
        }while(true);
    }
    private static String menuMauMucButMay(Scanner scanner){
        do {
            System.out.println("1. Đen");
            System.out.println("2. Xanh Dương");
            System.out.println("3. Xanh Lá");
            System.out.println("4. Đỏ");
            System.out.println("5. Vàng");
            System.out.println("6. Cam");
            System.out.println("7. Tím");
            System.out.println("8. Nâu");
            System.out.println("9. Trắng");
            System.out.println("10. Bạc");
            System.out.println("11. Vàng Đồng");
            System.out.println("12. Xám");
            System.out.println("13. Hồng");
            System.out.println("14. Ngọc Lam");
            System.out.println("15. Lam Đậm");
            System.out.println("16. Xanh Biển");
            System.out.println("17. Lục Bảo");
            System.out.println("18. Đỏ Đậm");
            System.out.println("19. Hổ Phách");
            System.out.println("20. Khác");
            System.out.print("Chọn (1-20): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    return "Đen";
                case 2:
                    return "Xanh Dương";
                case 3:
                    return "Xanh Lá";
                case 4:
                    return "Đỏ";
                case 5:
                    return "Vàng";
                case 6:
                    return "Cam";
                case 7:
                    return "Tím";
                case 8:
                    return "Nâu";
                case 9:
                    return "Trắng";
                case 10:
                    return "Bạc";
                case 11:
                    return "Vàng Đồng";
                case 12:
                    return "Xám";
                case 13:
                    return "Hồng";
                case 14:
                    return "Ngọc Lam";
                case 15:
                    return "Lam Đậm";
                case 16:
                    return "Xanh Biển";
                case 17:
                    return "Lục Bảo";
                case 18:
                    return "Đỏ Đậm";
                case 19:
                    return "Hổ Phách";
                case 20:
                    System.out.print("Nhập màu mực: ");
                    return (scanner.nextLine());
                default:
                    System.out.println("Lựa chọn không có! Vui lòng nhập lại.");
                    continue;
            }
        } while (true);
    }

    private static String menuLoaiNgoiButMay(Scanner scanner) {
        do {

            System.out.println("1. Ngòi Thường (Round)");
            System.out.println("2. Ngòi Nhọn (Needlepoint)");
            System.out.println("3. Ngòi Uốn Lượn (Flex)");
            System.out.println("4. Ngòi Italic");
            System.out.println("5. Ngòi Stub");
            System.out.println("6. Ngòi Oblique");
            System.out.println("7. Ngòi Zoom");
            System.out.println("8. Ngòi Music (Ngòi Nhạc)");
            System.out.println("9. Ngòi Calligraphy (Thư pháp)");
            System.out.println("10. Ngòi Architect (Kiến trúc)");
            System.out.println("11. Ngòi Left-Handed (Cho người thuận tay trái)");
            System.out.println("12. Khác");
            System.out.print("Chọn (1-11): ");


            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    return "Ngòi Thường";
                case 2:
                    return "Ngòi Nhọn";
                case 3:
                    return "Ngòi Uốn Lượn";
                case 4:
                    return "Ngòi Italic";
                case 5:
                    return "Ngòi Stub";
                case 6:
                    return "Ngòi Oblique";
                case 7:
                    return "Ngòi Zoom";
                case 8:
                    return "Ngòi Music";
                case 9:
                    return "Ngòi Calligraphy";
                case 10:
                    return "Ngòi Architect";
                case 11:
                    return "Ngòi Left-Handed";
                case 12:
                    System.out.print("Nhập loại ngòi : ");
                    return (scanner.nextLine());
                default:
                    System.out.println("Lựa chọn không có! Vui lòng nhập lại.");
            }
        } while (true);
    }
    private static String menuVatLieuNgoiButMay(Scanner scanner) {
        do {

            System.out.println("1. Thép Không Gỉ (Stainless Steel)");
            System.out.println("2. Vàng");
            System.out.println("3. Bạch Kim (Platinum)");
            System.out.println("4. Titan (Titanium)");
            System.out.println("5. Đồng (Copper)");
            System.out.println("6. Khác");
            System.out.print("Chọn (1-6): ");


            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    return "Thép Không Gỉ";
                case 2:
                    return "Vàng";
                case 3:
                    return "Bạch Kim";
                case 4:
                    return "Titan";
                case 5:
                    return "Đồng";
                case 6:
                    System.out.print("Nhập loại vật liệu ngòi : ");
                    return (scanner.nextLine());
                default:
                    System.out.println("Lựa chọn không có! Vui lòng nhập lại.");
            }
        } while (true);
    }
    private static String menuHeThongCapMucButMay(Scanner scanner) {
        do {
            System.out.println("Chọn hệ thống cấp mực cho bút máy:");
            System.out.println("1. Converter (Ống bơm)");
            System.out.println("2. Cartridge (Ống mực)");
            System.out.println("3. Eyedropper (Bơm mực trực tiếp)");
            System.out.println("4. Piston (Pít-tông)");
            System.out.println("5. Vacuum (Hút chân không)");
            System.out.println("6. Khác");
            System.out.print("Chọn (1-6): ");


            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    return "Converter";
                case 2:
                    return "Cartridge";
                case 3:
                    return "Eyedropper";
                case 4:
                    return "Piston";
                case 5:
                    return "Vacuum";
                case 6:
                    System.out.print("Nhập hệ thống cấp mực : ");
                    return (scanner.nextLine());
                default:
                    System.out.println("Lựa chọn không có! Vui lòng nhập lại.");
            }
        } while (true);
    }
    private static String menuDoCungButChi(Scanner scanner) {
        do {

            System.out.println("1. 9H");
            System.out.println("2. 8H");
            System.out.println("3. 7H");
            System.out.println("4. 6H");
            System.out.println("5. 5H");
            System.out.println("6. 4H");
            System.out.println("7. 3H");
            System.out.println("8. 2H");
            System.out.println("9. H");
            System.out.println("10. HB");
            System.out.println("11. B");
            System.out.println("12. 2B");
            System.out.println("13. 3B");
            System.out.println("14. 4B");
            System.out.println("15. 5B");
            System.out.println("16. 6B");
            System.out.println("17. 7B");
            System.out.println("18. 8B");
            System.out.println("19. 9B");
            System.out.print("Chọn (1-19): ");


            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    return "9H";
                case 2:
                    return "8H";
                case 3:
                    return "7H";
                case 4:
                    return "6H";
                case 5:
                    return "5H";
                case 6:
                    return "4H";
                case 7:
                    return "3H";
                case 8:
                    return "2H";
                case 9:
                    return "H";
                case 10:
                    return "HB";
                case 11:
                    return "B";
                case 12:
                    return "2B";
                case 13:
                    return "3B";
                case 14:
                    return "4B";
                case 15:
                    return "5B";
                case 16:
                    return "6B";
                case 17:
                    return "7B";
                case 18:
                    return "8B";
                case 19:
                    return "9B";
                default:
                    System.out.println("Lựa chọn không có! Vui lòng nhập lại.");
            }
        } while (true);
    }
    private static double menuKichThuocNgoiButChiBam(Scanner scanner) {
        do {

            System.out.println("1. 0.3mm (Rất Nhỏ - Vẽ kỹ thuật)");
            System.out.println("2. 0.5mm (Nhỏ - Viết thông dụng)");
            System.out.println("3. 0.7mm (Trung Bình - Viết hoặc vẽ)");
            System.out.println("4. 0.9mm (To - Ít gãy hơn)");
            System.out.println("5. 2.0mm (Rất To - Vẽ hoặc phác thảo)");
            System.out.println("6. Kích thước khác (Nhập tay)");
            System.out.print("Chọn (1-6): ");


            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    return 0.3;
                case 2:
                    return 0.5;
                case 3:
                    return 0.7;
                case 4:
                    return 0.9;
                case 5:
                    return 2.0;
                case 6:
                    System.out.print("Nhập kích thước khác (mm): ");
                    double customSize = scanner.nextDouble();
                    scanner.nextLine(); // Clear buffer
                    if (customSize > 0.1) {
                        return customSize;
                    } else {
                        System.out.println("Kích thước không phù hợp! Vui lòng nhập lại.");
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không có! Vui lòng nhập lại.");
            }
        } while (true);
    }
    private static String menuLoaiMucButLong(Scanner scanner) {
        do {
            System.out.println("1. Mực Nước");
            System.out.println("2. Mực Dầu");
            System.out.println("3. Mực Gốc Cồn");
            System.out.println("4. Mực Acrylic");
            System.out.println("5. Mực Gel");
            System.out.println("6. Loại mực khác (Nhập tay)");
            System.out.print("Chọn (1-6): ");


            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1: return "Mực Nước";
                case 2: return "Mực Dầu";
                case 3: return "Mực Gốc Cồn";
                case 4: return "Mực Acrylic";
                case 5: return "Mực Gel";
                case 6:
                    System.out.print("Nhập loại mực khác: ");
                    return scanner.nextLine();
                default:
                    System.out.println("Lựa chọn không có! Vui lòng nhập lại.");
            }
        } while (true);
    }
    private static String menuLoaiDauButLong(Scanner scanner) {
        do {
            System.out.println("Chọn loại ngòi bút lông:");
            System.out.println("1. Ngòi Nhọn (Fine Tip)");
            System.out.println("2. Ngòi Tròn (Bullet Tip)");
            System.out.println("3. Ngòi Vuông (Chisel Tip)");
            System.out.println("4. Ngòi Dẹt (Flat Tip)");
            System.out.println("5. Ngòi Cọ (Brush Tip)");
            System.out.println("6. Loại ngòi khác (Nhập tay)");
            System.out.print("Chọn (1-6): ");


            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1: return "Ngòi Nhọn";
                case 2: return "Ngòi Tròn";
                case 3: return "Ngòi Vuông";
                case 4: return "Ngòi Dẹt";
                case 5: return "Ngòi Cọ";
                case 6:
                    System.out.print("Nhập loại ngòi khác: ");
                    return scanner.nextLine();
                default:
                    System.out.println("Lựa chọn không có! Vui lòng nhập lại.");
            }
        } while (true);
    }


}

