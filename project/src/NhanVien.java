import java.util.Scanner;

public class NhanVien extends Nguoi {
    public static final String BAN_HANG = "Ban hang";
    public static final String KE_TOAN = "Ke toan";

    private String maNV;
    private String vaiTro;

    // Default constructor
    public NhanVien() {
        super();
        this.maNV = "";
        this.vaiTro = "";
    }

    // Parameterized constructor
    public NhanVien(String hoTen, int namSinh, String maNV, String vaiTro) {
        super(hoTen, namSinh);
        this.maNV = maNV;
        setVaiTro(vaiTro);
    }

    // Getters and setters
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        if (vaiTro.equalsIgnoreCase(BAN_HANG) || vaiTro.equalsIgnoreCase(KE_TOAN)) {
            this.vaiTro = vaiTro;
        } else {
            this.vaiTro = "Unknown";
        }
    }
    public String chonMuc() {
        return "Chọn mục để thay đổi:\n" +
                "1. Họ và tên\n" +
                "2. Năm sinh\n" +
                "3. Mã nhân viên\n" +
                "4. Vai trò\n" +
                "0. Thoát\n";
    }
    public void capNhatMuc(int input) {
        Scanner scanner = new Scanner(System.in);

        switch (input) {
            case 1: {
                System.out.println("Họ và tên hiện tại: " + getHoTen());
                System.out.print("Nhập họ và tên mới: ");
                setHoTen(scanner.nextLine());
                System.out.println("Họ và tên đã được cập nhật.");
                break;
            }
            case 2: {
                System.out.println("Năm sinh hiện tại: " + getNamSinh());
                System.out.print("Nhập năm sinh mới: ");
                int namSinh = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (namSinh > 1900 && namSinh <= 2024) {
                    setNamSinh(namSinh);
                    System.out.println("Năm sinh đã được cập nhật.");
                } else {
                    System.out.println("Năm sinh không hợp lệ. Vui lòng thử lại.");
                }
                break;
            }
            case 3: {
                System.out.println("Mã nhân viên hiện tại: " + getMaNV());
                System.out.print("Nhập mã nhân viên mới: ");
                setMaNV(scanner.nextLine());
                System.out.println("Mã nhân viên đã được cập nhật.");
                break;
            }
            case 4: {
                System.out.println("Vai trò hiện tại: " + getVaiTro());
                System.out.println("Chọn vai trò mới:");
                System.out.println("1. " + BAN_HANG);
                System.out.println("2. " + KE_TOAN);
                System.out.print("Lựa chọn: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 1) {
                    setVaiTro(BAN_HANG);
                    System.out.println("Vai trò đã được cập nhật thành: " + BAN_HANG);
                } else if (choice == 2) {
                    setVaiTro(KE_TOAN);
                    System.out.println("Vai trò đã được cập nhật thành: " + KE_TOAN);
                } else {
                    System.out.println("Lựa chọn không hợp lệ. Vai trò giữ nguyên.");
                }
                break;
            }
            case 0: {
                System.out.println("Thoát menu cập nhật.");
                break;
            }
            default:
                System.out.println("Input không phù hợp! Chọn lại.");
        }
    }
    @Override
    public void Xuat() {
        System.out.println("- Họ và tên: " + getHoTen());
        System.out.println("- Năm sinh : " + getNamSinh());
        System.out.println("- Mã nhân viên: " + maNV);
        System.out.println("- Vai trò: " + vaiTro);
        System.out.println("--------------------------------------------");
    }
}