import java.util.LinkedHashSet;
import java.util.Scanner;

public class SanPhamGiay extends VanPhongPham{
    private String mauGiay; //
    private int soTo;        // Số lượng tờ
    private boolean coTaiChe; // Có thể tái chế hay không


    public SanPhamGiay(String ten, String uid, LinkedHashSet<String> tags, double gia, int soLuong, int hangTon, String nhaPhanPhoi, double canNang, String viTriKho, String ngaySanXuat, String ngayHetHan, String loaiGiay, int soTo, boolean coTaiChe) {
        super(ten,uid,tags,gia,soLuong,hangTon,nhaPhanPhoi,canNang,viTriKho,ngaySanXuat,ngayHetHan);
        this.loaiGiay = loaiGiay;
        this.soTo = soTo;
        this.coTaiChe = coTaiChe;
    }


    public String getLoaiGiay() {
        return loaiGiay;
    }

    public void setLoaiGiay(String loaiGiay) {
        this.loaiGiay = loaiGiay;
    }

    public int getSoTo() {
        return soTo;
    }

    public void setSoTo(int soTo) {
        this.soTo = soTo;
    }

    public boolean isCoTaiChe() {
        return coTaiChe;
    }

    public void setCoTaiChe(boolean coTaiChe) {
        this.coTaiChe = coTaiChe;
    }
    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("- Loại giấy: " + loaiGiay);
        System.out.println("- Số tờ: " + soTo);
        System.out.println("- Có thể tái chế: " + (coTaiChe ? "Có" : "Không"));
    }
    @Override
    public String chonMuc() {
        return super.chonMuc() +
                "12. Loại giấy\n" +
                "13. Số tờ\n" +
                "14. Tái chế được\n";
    }
    @Override
    public void capNhatMuc(int input) {
        Scanner scanner = new Scanner(System.in);
        switch (input) {
            case 12: // Loại giấy
                System.out.println("Chọn loại giấy:");
                System.out.println("1. A4");
                System.out.println("2. Letter");
                System.out.println("3. Giấy ghi chú");
                System.out.println("4. Legal");
                System.out.println("5. Tabloid");
                System.out.println("6. Cardstock");
                System.out.println("7. Nhập loại giấy khác (tự nhập)");
                System.out.print("Nhập lựa chọn (1-7): ");
                int loaiGiayLuaChon = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer

                switch (loaiGiayLuaChon) {
                    case 1:
                        setLoaiGiay("A4");
                        break;
                    case 2:
                        setLoaiGiay("Letter");
                        break;
                    case 3:
                        setLoaiGiay("Giấy ghi chú");
                        break;
                    case 4:
                        setLoaiGiay("Legal");
                        break;
                    case 5:
                        setLoaiGiay("Tabloid";
                        break;
                    case 6:
                        setLoaiGiay("Cardstock";
                        break;
                    case 7:
                        System.out.print("Nhập loại giấy tùy chỉnh: ");
                        loaiGiay = scanner.nextLine();
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Giữ loại giấy cũ: " + loaiGiay);
                }
                System.out.println("Loại giấy hiện tại: " + loaiGiay);
                break;

            case 13: // Số tờ
                System.out.print("Nhập số tờ mới: ");
                int soToMoi = scanner.nextInt();
                if (soToMoi > 0) {
                    soTo = soToMoi;
                    System.out.println("Số tờ đã được cập nhật: " + soTo);
                } else {
                    System.out.println("Số tờ phải lớn hơn 0. Giữ giá trị cũ: " + soTo);
                }
                break;

            case 14: // Có thể tái chế
                System.out.println("Sản phẩm có thể tái chế?");
                System.out.println("1. Có");
                System.out.println("2. Không");
                System.out.print("Nhập lựa chọn (1 hoặc 2): ");
                int taiCheLuaChon = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer
                switch (taiCheLuaChon) {
                    case 1:
                        coTaiChe = true;
                        break;
                    case 2:
                        coTaiChe = false;
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Giữ giá trị cũ: " + (coTaiChe ? "Có" : "Không"));
                }
                System.out.println("Có thể tái chế: " + (coTaiChe ? "Có" : "Không"));
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }

}
