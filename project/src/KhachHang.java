
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KhachHang extends Nguoi {
    private String maKH;
    private String diaChi;
    private String soDienThoai;
    private Map<VanPhongPham,Integer> gioHang;

    public KhachHang() {
        super();
        maKH = "";
        diaChi = "";
        soDienThoai = "";
        gioHang = new HashMap<>();
    }

    public KhachHang(String hoTen, int namSinh, String maKH, String diaChi, String soDienThoai) {
        super(hoTen, namSinh);
        this.maKH = maKH;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.gioHang = new HashMap<>();
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Map<VanPhongPham, Integer> getGioHang() {
        return gioHang;
    }

    public void themSanPham(VanPhongPham vatPham, int soLuong) {
        gioHang.put(vatPham,soLuong);
    }

    public void xoaSanPham(String uid) {
        VanPhongPham vatPhamCanXoa = null;
        int soLuongXoa =0;

        for (VanPhongPham vatPham : gioHang.keySet()) {
            if (vatPham.getUid().equalsIgnoreCase(uid)) {
                vatPhamCanXoa = vatPham; // Identify the item to be removed
                soLuongXoa = gioHang.get(vatPham); // Get the quantity of this item
                break;
            }
        }

        if (vatPhamCanXoa != null) {
            vatPhamCanXoa.setSoLuong(vatPhamCanXoa.getSoLuong()+soLuongXoa);
            gioHang.remove(vatPhamCanXoa); // Remove the item from the cart
            System.out.println("Đã xóa sản phẩm với UID: " + uid + " khỏi giỏ hàng.");
        } else {
            System.out.println("Không tìm thấy sản phẩm với UID: " + uid + " trong giỏ hàng.");
        }
    }
    public void xoaToanBoGioHang() {
        if (gioHang.isEmpty()) {
            System.out.println("Giỏ hàng đã trống.");
        } else {
            gioHang.clear();
            System.out.println("Tất cả sản phẩm đã được xóa khỏi giỏ hàng.");
        }
    }

    public void xemGioHang() {
        if (gioHang.isEmpty()) {
            System.out.println("Giỏ hàng đang trống.");
        } else {
            System.out.println("Giỏ hàng:");
            for (Map.Entry<VanPhongPham, Integer> entry : gioHang.entrySet()) {
                VanPhongPham sanPham = entry.getKey();
                int quantity = entry.getValue();
                double giaTungCai = sanPham.getGia();
                double tongGia = quantity * giaTungCai;

                System.out.printf("- UID: %s || Tên: %s || Số lượng: %d || Giá từng cái: %.2f || Tổng giá: %.2f%n",
                        sanPham.getUid(), sanPham.getTen(), quantity, giaTungCai, tongGia);
            }
        }
    }
    public String chonMuc() {
        return "Chọn mục để thay đổi:\n" +
                "1. Họ và tên\n" +
                "2. Năm sinh\n" +
                "3. Mã khách hàng\n" +
                "4. Địa chỉ\n" +
                "5. Số điện thoại\n" +
                "0. Thoát\n";
    }
    public void capNhatMuc(int input) {
        Scanner scanner = new Scanner(System.in);

        switch (input) {
            case 1: {
                System.out.println("Họ và tên hiện tại: " + getHoTen());
                System.out.print("Nhập họ và tên mới: ");
                setHoTen(scanner.nextLine());
                break;
            }
            case 2: {
                System.out.println("Năm sinh hiện tại: " + getNamSinh());
                System.out.print("Nhập năm sinh mới: ");
                int namSinh = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (namSinh > 1900 && namSinh <= 2019) {
                    setNamSinh(namSinh);
                    System.out.println("Năm sinh đã được cập nhật.");
                } else {
                    System.out.println("Năm sinh không hợp lệ. Vui lòng thử lại.");
                }
                break;
            }
            case 3: {
                System.out.println("Mã khách hàng hiện tại: " + getMaKH());
                System.out.print("Nhập mã khách hàng mới: ");
                setMaKH(scanner.nextLine());
                break;
            }
            case 4: {
                System.out.println("Địa chỉ hiện tại: " + getDiaChi());
                System.out.print("Nhập địa chỉ mới: ");
                setDiaChi(scanner.nextLine());
                break;
            }
            case 5: {
                System.out.println("Số điện thoại hiện tại: " + getSoDienThoai());
                System.out.print("Nhập số điện thoại mới: ");
                setSoDienThoai(scanner.nextLine());
                break;
            }
            case 0: {
                System.out.println("Thoát menu.");
                break;
            }
            default:
                System.out.println("Input không phù hợp! Chọn lại.");
        }
    }

    @Override
    public void Xuat() {
        System.out.println("Họ và tên: " + hoTen);
        System.out.println("Năm sinh: " + namSinh);
        System.out.println("Mã khách hàng: " + maKH);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("Số điện thoại: " + soDienThoai);
        xemGioHang();
        System.out.println("--------------------------------------------");
    }
}
