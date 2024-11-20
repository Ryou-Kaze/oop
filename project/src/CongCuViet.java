import java.util.Scanner;
import java.util.LinkedHashSet;

public abstract class CongCuViet extends VanPhongPham implements printInterface {
    private String mau;
    private String vatLieuThanBut;
    private boolean coTheNapLai;
    private boolean coTheXoa;
    public CongCuViet(String ten, String uid, LinkedHashSet<String> tags, double gia, int soLuong,int hangTon, String nhaPhanPhoi,double canNang, String viTriKho, String ngaySanXuat, String ngayHetHan, String mau,String vatLieuThanBut, boolean coTheNapLai, boolean coTheXoa){
        super(ten,uid,tags,gia,soLuong,hangTon,nhaPhanPhoi,canNang,viTriKho,ngaySanXuat,ngayHetHan);
        this.mau=mau;
        this.vatLieuThanBut=vatLieuThanBut;
        this.coTheNapLai=coTheNapLai;
        this.coTheXoa=coTheXoa;
    }
    public String getMau(){
        return mau;
    }
    public void setMau(String mau){
        this.mau=mau;
    }
    public String getVatLieuThanBut(){
        return vatLieuThanBut;
    }
    public void setVatLieuThanBut(String vatLieuThanBut){
        this.vatLieuThanBut=vatLieuThanBut;
    }
    public boolean getCoTheNapLai(){
        return coTheNapLai;
    }
    public void setCoTheNapLai(boolean coTheNapLai){
        this.coTheNapLai=coTheNapLai;
    }
    public boolean getCoTheXoa(){
        return coTheXoa;
    }
    public void setCoTheXoa(boolean coTheXoa){
        this.coTheXoa=coTheXoa;
    }
    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("- Màu bút: " + mau);
        System.out.println("- Vật liệu thân bút: "+vatLieuThanBut);
        System.out.println("- Có thể nạp lại : " + (coTheNapLai ? "Có" : "Không"));
        System.out.println("- Có thể xóa: " + (coTheXoa ? "Có" : "Không"));


    }
    @Override
    public String chonMuc() {
        return super.chonMuc() +
                "12. Màu bút\n" +
                "13. Vật liệu thân bút\n" +
                "14. Chức năng nạp\n" +
                "15. Chức năng xóa\n";
    }
    @Override
    public void capNhatMuc(int input) {
        Scanner scanner = new Scanner(System.in);
        switch (input) {
            case 12: {
                System.out.println("Chọn màu bút mới:");
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
                System.out.println("Màu hiện tại: " + getMau());
                System.out.print("Chọn (1-20): ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                switch (choice) {
                    case 1:
                        setMau("Đen");
                        break;
                    case 2:
                        setMau("Xanh Dương");
                        break;
                    case 3:
                        setMau("Xanh Lá");
                        break;
                    case 4:
                        setMau("Đỏ");
                        break;
                    case 5:
                        setMau("Vàng");
                        break;
                    case 6:
                        setMau("Cam");
                        break;
                    case 7:
                        setMau("Tím");
                        break;
                    case 8:
                        setMau("Nâu");
                        break;
                    case 9:
                        setMau("Trắng");
                        break;
                    case 10:
                        setMau("Bạc");
                        break;
                    case 11:
                        setMau("Vàng Đồng");
                        break;
                    case 12:
                        setMau("Xám");
                        break;
                    case 13:
                        setMau("Hồng");
                        break;
                    case 14:
                        setMau("Ngọc Lam");
                        break;
                    case 15:
                        setMau("Lam Đậm");
                        break;
                    case 16:
                        setMau("Xanh Biển");
                        break;
                    case 17:
                        setMau("Lục Bảo");
                        break;
                    case 18:
                        setMau("Đỏ Đậm");
                        break;
                    case 19:
                        setMau("Hổ Phách");
                        break;
                    case 20:
                        System.out.print("Nhập màu: ");
                        setMau(scanner.nextLine());
                    default:
                        System.out.println("Lựa chọn không có! Màu bút giữ nguyên.");
                        break;
                }
                System.out.println("Màu bút mới: " + getMau());
                break;
            }

            case 13: {
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
                System.out.println("Vật liệu hiện tại: " + getVatLieuThanBut());
                System.out.print("Chọn (1-11): ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                switch (choice) {
                    case 1:
                        setVatLieuThanBut("Nhựa");
                        break;
                    case 2:
                        setVatLieuThanBut("Kim Loại");
                        break;
                    case 3:
                        setVatLieuThanBut("Gỗ");
                        break;
                    case 4:
                        setVatLieuThanBut("Nhôm");
                        break;
                    case 5:
                        setVatLieuThanBut("Thép Không Gỉ");
                        break;
                    case 6:
                        setVatLieuThanBut("Đồng");
                        break;
                    case 7:
                        setVatLieuThanBut("Thủy Tinh");
                        break;
                    case 8:
                        setVatLieuThanBut("Carbon");
                        break;
                    case 9:
                        setVatLieuThanBut("Cao Su");
                        break;
                    case 10:
                        setVatLieuThanBut("Acrylic");
                        break;
                    case 11:
                        System.out.print("Nhập vật liệu: ");
                        setMau(scanner.nextLine());
                    default:
                        System.out.println("Lựa chọn không có! Vật liệu giữ nguyên.");
                        break;
                }
                System.out.println("Vật liệu thân bút mới: " + getVatLieuThanBut());
                break;
            }
            case 14: {
                System.out.print("Bút có khả năng nạp lại(y/n): ");
                switch (scanner.nextLine().toLowerCase().trim()){
                    case "y":{
                        setCoTheNapLai(true);
                        System.out.println("Thay đổi mới: bút có khả năng nạp.");
                    }
                    case "n":{
                        setCoTheNapLai(false);
                        System.out.println("Thay đổi mới: bút không có khả năng nạp.");
                    }
                    default:
                        System.out.println("Nhap sai");
                }
                break;
            }
            case 15: {
                System.out.print("Bút có khả năng xóa(y/n): ");
                switch (scanner.nextLine().toLowerCase().trim()){
                    case "y":{
                        setCoTheNapLai(true);
                        System.out.println("Thay đổi mới: bút có khả năng xóa.");
                    }
                    case "n":{
                        setCoTheNapLai(false);
                        System.out.println("Thay đổi mới: bút không có khả năng xóa.");
                    }
                    default:
                        System.out.println("Nhap sai");
                }
                break;
            }
            default:
                super.capNhatMuc(input);
        }
    }
}
