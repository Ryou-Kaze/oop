import java.util.LinkedHashSet;

import java.util.Scanner;

public class ButBi extends CongCuViet {
    private double kichThuocNgoiBut;
    private String mauMuc;
    private String loaiNgoi;
    private boolean coNapDay;
    public ButBi(String ten, String uid, LinkedHashSet<String> tags, double gia, int soLuong,int hangTon, String nhaPhanPhoi,double canNang, String viTriKho, String ngaySanXuat, String ngayHetHan, String mau,String vatLieuThanBut, boolean coTheNapLai, boolean coTheXoa,double kichThuocNgoiBut,String mauMuc,String loaiNgoi,boolean coNapDay){
        super(ten,uid,tags,gia,soLuong,hangTon,nhaPhanPhoi,canNang,viTriKho,ngaySanXuat,ngayHetHan,mau,vatLieuThanBut,coTheNapLai,coTheXoa);
        this.kichThuocNgoiBut=kichThuocNgoiBut;
        this.mauMuc=mauMuc;
        this.loaiNgoi=loaiNgoi;
        this.coNapDay=coNapDay;
    }
    public double getKichThuocNgoiBut() {
        return kichThuocNgoiBut;
    }

    public void setKichThuocNgoiBut(double kichThuocNgoiBut) {
        this.kichThuocNgoiBut = kichThuocNgoiBut;
    }

    public String getMauMuc() {
        return mauMuc;
    }

    public void setMauMuc(String mauMuc) {
        this.mauMuc = mauMuc;
    }

    public String getLoaiNgoi() {
        return loaiNgoi;
    }

    public void setLoaiNgoi(String loaiNgoi) {
        this.loaiNgoi = loaiNgoi;
    }


    public boolean getCoNapDay() {
        return coNapDay;
    }

    public void setCoNapDay(boolean coNapDay) {
        this.coNapDay = coNapDay;
    }

    @Override
    public void xuatThongTin(){
        super.xuatThongTin();
        System.out.println("- Kích thước ngòi: "+ kichThuocNgoiBut+" mm");
        System.out.println("- Màu Mực: " + mauMuc);
        System.out.println("- Loại Ngòi: "+ loaiNgoi);
        System.out.println("- Có nắp đậy: " + (coNapDay ? "Có" : "Không"));

    }
    @Override
    public String chonMuc() {
        return super.chonMuc() +
                "16. Kích thước ngòi\n" +
                "17. Màu Mực\n"+
                "18. loại ngòi\n" +
                "19. Nắp Đậy\n"+
                "0. Exit";
    }
    @Override
    public void capNhatMuc(int input) {
        Scanner scanner = new Scanner(System.in);
        switch (input) {
            case 16 : {
                System.out.println("Chọn kích thước ngòi bút bi:");
                System.out.println("1. 0.38mm (Rất Nhỏ)");
                System.out.println("2. 0.5mm (Nhỏ)");
                System.out.println("3. 0.7mm (Trung Bình)");
                System.out.println("4. 1.0mm (To)");
                System.out.println("5. 1.2mm (Rất To)");
                System.out.println("6. Kích thước khác (Nhập tay)");
                System.out.print("Kích thước ngòi hiện tại: " + getKichThuocNgoiBut() + "mm\nChọn (1-6): ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        setKichThuocNgoiBut(0.38);
                        break;
                    case 2:
                        setKichThuocNgoiBut(0.5);
                        break;
                    case 3:
                        setKichThuocNgoiBut(0.7);
                        break;
                    case 4:
                        setKichThuocNgoiBut(1.0);
                        break;
                    case 5:
                        setKichThuocNgoiBut( 1.2);
                        break;
                    case 6:
                        System.out.print("Nhập kích thước khác (mm): ");
                        double kt=scanner.nextDouble();
                        if(kt>0.1){
                            setKichThuocNgoiBut(kt);
                        }
                        else{
                            System.out.println("kích thước không hợp lý! Kích thước ngòi giữ nguyên.");
                            return;
                        }
                        break;
                    default:
                        System.out.println("Lựa chọn không có! Kích thước ngòi giữ nguyên.");
                        return;
                }
                System.out.println("Kích thước ngòi mới: " + getKichThuocNgoiBut() + "mm");
                break;
            }
            case 17:{
                System.out.println("Chọn màu mực bút bi:");
                System.out.println("1. Đen");
                System.out.println("2. Xanh Dương");
                System.out.println("3. Đỏ");
                System.out.println("4. Xanh Lá");
                System.out.println("5. Tím");
                System.out.println("6. Trắng");
                System.out.println("7. Vàng");
                System.out.println("8. Cam");
                System.out.println("9. Hồng");
                System.out.print("Màu hiện tại: " + getMauMuc() + "\nChọn (1-10): ");

                int choice = scanner.nextInt();
                String mauBut;

                switch (choice) {
                    case 1:
                        setMauMuc("Đen");
                        break;
                    case 2:
                        setMauMuc("Xanh Dương");
                        break;
                    case 3:
                        setMauMuc("Đỏ");
                        break;
                    case 4:
                        setMauMuc("Xanh Lá");
                        break;
                    case 5:
                        setMauMuc("Tím");
                        break;
                    case 6:
                        setMauMuc("Trắng");
                        break;
                    case 7:
                        setMauMuc("Vàng");
                        break;
                    case 8:
                        setMauMuc("Cam");
                        break;
                    case 9:
                        setMauMuc("Hồng");
                        break;
                    case 10:
                        System.out.print("Nhập màu khác: ");
                        setMauMuc(scanner.nextLine()); // Consume newline
                        break;
                    default:
                        System.out.println("Lựa chọn không có! Màu bút giữ nguyên.");
                        return;
                }

                System.out.println("Màu bút mới: " + mauMuc);
                break;
            }
            case 18: {
                System.out.println("Chọn loại ngòi bút:");
                System.out.println("1. Ngòi Bút Bi");
                System.out.println("2. Ngòi Gel");
                System.out.println("3. Ngòi Lăn Mực");
                System.out.println("4. Ngòi Mực Lông");
                System.out.println("5. Ngòi Mực Dầu");
                System.out.println("6. Loại ngòi khác (Nhập tay)");
                System.out.print("Loại ngòi hiện tại: " + getLoaiNgoi() + "\nChọn (1-6): ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        setLoaiNgoi("Ngòi Bút Bi");
                        break;
                    case 2:
                        setLoaiNgoi("Ngòi Gel");
                        break;
                    case 3:
                        setLoaiNgoi("Ngòi Lăn Mực");
                        break;
                    case 4:
                        setLoaiNgoi("Ngòi Mực Lông");
                        break;
                    case 5:
                        setLoaiNgoi("Ngòi Mực Dầu");
                        break;
                    case 6:
                        System.out.print("Nhập loại ngòi khác: ");
                        scanner.nextLine(); // Consume newline
                        setLoaiNgoi(scanner.nextLine());
                        break;
                    default:
                        System.out.println("Lựa chọn không có! Loại ngòi giữ nguyên.");
                        return;
                }

                System.out.println("Loại ngòi mới: " + getLoaiNgoi());
                break;
            }
            case 19: {
                System.out.print("Bút có nắp đậy hay không(y/n): ");
                switch (scanner.nextLine().toLowerCase().trim()){
                    case "y":{
                        setCoTheNapLai(true);
                        System.out.println("Thay đổi mới: bút có nắp đậy.");
                    }
                    case "n":{
                        setCoTheNapLai(false);
                        System.out.println("Thay đổi mới: bút không có nắp đậy.");
                    }
                    default:
                        System.out.println("Nhap sai");
                }
                break;
            }
            default :
                super.capNhatMuc(input);
        }
    }

}
