import java.util.LinkedHashSet;
import java.util.Scanner;

public class ButChiBam extends CongCuViet {
    private double kichThuocNgoi;
    private boolean coTay;
    public ButChiBam(String ten, String uid, LinkedHashSet<String> tags, double gia, int soLuong,int hangTon, String nhaPhanPhoi,double canNang, String viTriKho, String ngaySanXuat, String ngayHetHan, String mau,String vatLieuThanBut, boolean coTheNapLai, boolean coTheXoa,double kichThuocNgoi, boolean coTay){
        super(ten,uid,tags,gia,soLuong,hangTon,nhaPhanPhoi,canNang,viTriKho,ngaySanXuat,ngayHetHan,mau,vatLieuThanBut,coTheNapLai,coTheXoa);
        this.kichThuocNgoi=kichThuocNgoi;
        this.coTay=coTay;
    }

    public double getKichThuocNgoi() {
        return kichThuocNgoi;
    }

    public void setKichThuocNgoi(double kichThuocNgoi) {
        this.kichThuocNgoi = kichThuocNgoi;
    }

    public boolean isCoTay() {
        return coTay;
    }

    public void setCoTay(boolean coTay) {
        this.coTay = coTay;
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("- Kích thước ngòi bút: "+ kichThuocNgoi+" mm");
        System.out.println("- Chỉ ruột chì kích thước " + kichThuocNgoi + " mm mới tương thích với cây bút này");
        if(coTay==true){
            System.out.println("- Bút chì này có tẩy");
        }
        else{
            System.out.println("- Bút chì này không có tẩy");
        }

    }
    @Override
    public String chonMuc() {
        return super.chonMuc() +
                "16. Kích thước ngòi \n" +
                "17. Tẩy\n"+
                "0. Exit";
    }
    @Override
    public void capNhatMuc(int input) {
        Scanner scanner = new Scanner(System.in);
        switch (input) {
            case 16: {
                System.out.println("Chọn kích thước ruột chì cho bút chì kim:");
                System.out.println("1. 0.3mm (Rất Nhỏ - Vẽ kỹ thuật)");
                System.out.println("2. 0.5mm (Nhỏ - Viết thông dụng)");
                System.out.println("3. 0.7mm (Trung Bình - Viết hoặc vẽ)");
                System.out.println("4. 0.9mm (To - Ít gãy hơn)");
                System.out.println("5. 2.0mm (Rất To - Vẽ hoặc phác thảo)");
                System.out.println("6. Kích thước khác (Nhập tay)");
                System.out.print("Kích thước ruột chì hiện tại: " + getKichThuocNgoi() + "\nChọn (1-6): ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        setKichThuocNgoi(0.3);
                        break;
                    case 2:
                        setKichThuocNgoi(0.5);
                        break;
                    case 3:
                        setKichThuocNgoi(0.7);
                        break;
                    case 4:
                        setKichThuocNgoi(0.9);
                        break;
                    case 5:
                        setKichThuocNgoi(2.0);
                        break;
                    case 6:
                        System.out.print("Nhập kích thước khác (mm): ");
                        double kt = scanner.nextDouble();
                        if (kt > 0.1) {
                            setKichThuocNgoi(kt);
                        } else {
                            System.out.println("Kích thước không phù hợp! Kích thước ngòi giữ nguyên.");
                        }

                        break;
                    default:
                        System.out.println("Lựa chọn không có! Kích thước ngòi giữ nguyên.");
                        return;
                }
                System.out.println("Kích thước ruột chì mới: " + getKichThuocNgoi() + "mm");
                break;
            }
            case 17: {
                System.out.print("Bút có tẩy hay không(y/n): ");
                switch (scanner.nextLine().toLowerCase().trim()) {
                    case "y": {
                        setCoTheNapLai(true);
                        System.out.println("Thay đổi mới: bút có tẩy.");
                    }
                    case "n": {
                        setCoTheNapLai(false);
                        System.out.println("Thay đổi mới: bút không có tẩy.");
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
