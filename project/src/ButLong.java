import java.util.LinkedHashSet;
import java.util.Scanner;

public class ButLong extends CongCuViet{
    private String loaiMuc;
    private String loaiDauBut;
    public ButLong(String ten, String uid, LinkedHashSet<String> tags, double gia, int soLuong,int hangTon, String nhaPhanPhoi,double canNang, String viTriKho, String ngaySanXuat, String ngayHetHan, String mau,String vatLieuThanBut, boolean coTheNapLai, boolean coTheXoa,String loaiMuc ,String loaiDauBut){
        super(ten,uid,tags,gia,soLuong,hangTon,nhaPhanPhoi,canNang,viTriKho,ngaySanXuat,ngayHetHan,mau,vatLieuThanBut,coTheNapLai,coTheXoa);
        this.loaiMuc=loaiMuc;
        this.loaiDauBut=loaiDauBut;
    }

    public String getLoaiMuc() {
        return loaiMuc;
    }

    public void setLoaiMuc(String loaiMuc) {
        this.loaiMuc = loaiMuc;
    }

    public String getLoaiDauBut() {
        return getLoaiDauBut();
    }

    public void setLoaiDauBut(String loaiDauBut) {
        this.loaiDauBut = loaiDauBut;
    }

    @Override
    public void xuatThongTin(){
        super.xuatThongTin();
        System.out.println("- Bút này sử dụng loại mực: "+loaiMuc);
        System.out.println("- Bút lông này có đầu dạng : "+loaiDauBut);
    }

    @Override
    public void capNhatMuc(int input) {
        Scanner scanner = new Scanner(System.in);
        switch (input) {
            case 16 : {
                System.out.println("Chọn loại mực cho bút lông:");
                System.out.println("1. Mực Nước");
                System.out.println("2. Mực Dầu");
                System.out.println("3. Mực Gốc Cồn");
                System.out.println("4. Mực Acrylic");
                System.out.println("5. Mực Gel");
                System.out.println("6. Loại mực khác (Nhập tay)");
                System.out.print("Loại mực hiện tại: " + getLoaiMuc() + "\nChọn (1-6): ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        setLoaiMuc("Mực Nước");
                        break;
                    case 2:
                        setLoaiMuc("Mực Dầu");
                        break;
                    case 3:
                        setLoaiMuc("Mực Gốc Cồn");
                        break;
                    case 4:
                        setLoaiMuc("Mực Acrylic");
                        break;
                    case 5:
                        setLoaiMuc("Mực Gel");
                        break;
                    case 6:
                        System.out.print("Nhập loại mực khác: ");
                        scanner.nextLine(); // Consume newline
                        setLoaiMuc(scanner.nextLine());
                        break;
                    default:
                        System.out.println("Lựa chọn không có! Loại mực giữ nguyên.");
                        return;
                }

// Hiển thị loại mực mới
                System.out.println("Loại mực mới: " + getLoaiMuc());
                break;
            }
            case 17: {
                System.out.println("Chọn loại ngòi bút lông:");
                System.out.println("1. Ngòi Nhọn (Fine Tip)");
                System.out.println("2. Ngòi Tròn (Bullet Tip)");
                System.out.println("3. Ngòi Vuông (Chisel Tip)");
                System.out.println("4. Ngòi Dẹt (Flat Tip)");
                System.out.println("5. Ngòi Cọ (Brush Tip)");
                System.out.println("6. Loại ngòi khác (Nhập tay)");
                System.out.print("Loại ngòi hiện tại: " + getLoaiDauBut() + "\nChọn (1-6): ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        setLoaiDauBut("Ngòi Nhọn");
                        break;
                    case 2:
                        setLoaiDauBut("Ngòi Tròn");
                        break;
                    case 3:
                        setLoaiDauBut("Ngòi Vuông");
                        break;
                    case 4:
                        setLoaiDauBut("Ngòi Dẹt");
                        break;
                    case 5:
                        setLoaiDauBut("Ngòi Cọ");
                        break;
                    case 6:
                        System.out.print("Nhập loại ngòi khác: ");
                        scanner.nextLine(); // Consume newline
                        setLoaiDauBut(scanner.nextLine());
                        break;
                    default:
                        System.out.println("Lựa chọn không có! Loại ngòi giữ nguyên.");
                        return;
                }

// Hiển thị loại ngòi mới
                System.out.println("Loại ngòi mới: " + getLoaiDauBut());
                break;
            }
            default :
                super.capNhatMuc(input);
        }
    }

}
