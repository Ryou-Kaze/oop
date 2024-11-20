import java.util.LinkedHashSet;
import java.util.Scanner;

public class ButMay extends CongCuViet {
    private String kichThuocNgoi;
    private String mauMuc;
    private String loaiNgoi;
    private String vatLieuNgoi;
    private String coCheBomMuc;
    private boolean coNapDay;
    public ButMay(String ten, String uid, LinkedHashSet<String> tags, double gia, int soLuong,int hangTon, String nhaPhanPhoi,double canNang, String viTriKho, String ngaySanXuat, String ngayHetHan, String mau,String vatLieuThanBut, boolean coTheNapLai, boolean coTheXoa,String kichThuocNgoi,String mauMuc,String loaiNgoi,String vatLieuNgoi,String coCheBomMuc,boolean coNapDay){
        super(ten,uid,tags,gia,soLuong,hangTon,nhaPhanPhoi,canNang,viTriKho,ngaySanXuat,ngayHetHan,mau,vatLieuThanBut,coTheNapLai,coTheXoa);
        this.kichThuocNgoi=kichThuocNgoi;
        this.mauMuc=mauMuc;
        this.loaiNgoi=loaiNgoi;
        this.vatLieuNgoi=vatLieuNgoi;
        this.coCheBomMuc=coCheBomMuc;
        this.coNapDay=coNapDay;
    }

    public String getKichThuocNgoi() {
        return kichThuocNgoi;
    }

    public void setKichThuocNgoi(String kichThuocNgoi) {
        this.kichThuocNgoi = kichThuocNgoi;
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

    public String getVatLieuNgoi() {
        return vatLieuNgoi;
    }

    public void setVatLieuNgoi(String vatLieuNgoi) {
        this.vatLieuNgoi = vatLieuNgoi;
    }
    public String getCoCheBomMuc() {
        return coCheBomMuc;
    }

    public void setCoCheBomMuc(String coCheBomMuc) {
        this.coCheBomMuc = coCheBomMuc;
    }

    public boolean isCoNapDay() {
        return coNapDay;
    }

    public void setCoNapDay(boolean coNapDay) {
        this.coNapDay = coNapDay;
    }

    @Override
    public void xuatThongTin(){
        super.xuatThongTin();
        System.out.println("Thông tin bút máy:");
        System.out.println("- Kích thước ngòi: " + kichThuocNgoi);
        System.out.println("- Màu mực: " + mauMuc);
        System.out.println("- Loại ngòi: " + loaiNgoi);
        System.out.println("- Vật liệu ngòi: " + vatLieuNgoi);
        System.out.println("- Cơ chế bơm mực: " + coCheBomMuc);
        System.out.println("- Có nắp đậy: " + (coNapDay ? "Có" : "Không"));
    }
    @Override
    public String chonMuc() {
        return super.chonMuc() +
                "16. Kích thước ngòi\n" +
                "17. Màu Mực\n"+
                "18. loại ngòi\n" +
                "19. Vật liệu ngòi\n"+
                "20. Cơ chế bơm mực\n"+
                "21. Nắp đậy\n"+
                "0. Exit";
    }
    @Override
    public void capNhatMuc(int input) {
        Scanner scanner = new Scanner(System.in);
        switch (input) {
            case 16 : {
                System.out.println("Chọn kích thước ngòi mới cho bút máy:");
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
                System.out.println("Kích thước ngòi hiện tại: " + getKichThuocNgoi());
                System.out.print("Chọn (1-16): ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        setKichThuocNgoi("EF (Extra Fine)");
                        break;
                    case 2:
                        setKichThuocNgoi("F (Fine)");
                        break;
                    case 3:
                        setKichThuocNgoi("M (Medium)");
                        break;
                    case 4:
                        setKichThuocNgoi("B (Broad)");
                        break;
                    case 5:
                        setKichThuocNgoi("BB (Double Broad)");
                        break;
                    case 6:
                        setKichThuocNgoi("A (Apprentice)");
                        break;
                    case 7:
                        setKichThuocNgoi("OM (Oblique Medium)");
                        break;
                    case 8:
                        setKichThuocNgoi("OB (Oblique Broad)");
                        break;
                    case 9:
                        setKichThuocNgoi("OBB (Oblique Double Broad)");
                        break;
                    case 10:
                        setKichThuocNgoi("ST (Stub)");
                        break;
                    case 11:
                        setKichThuocNgoi("IT (Italic)");
                        break;
                    case 12:
                        setKichThuocNgoi("C (Calligraphy)");
                        break;
                    case 13:
                        setKichThuocNgoi("G (Gradient)");
                        break;
                    case 14:
                        setKichThuocNgoi("Z (Zoom)");
                        break;
                    case 15:
                        setKichThuocNgoi("Music (Ngòi Nhạc)");
                        break;
                    case 16:
                        setKichThuocNgoi("Architect (Ngòi Kiến trúc)");
                        break;
                    default:
                        System.out.println("Lựa chọn không có! Kích thước ngòi giữ nguyên.");
                        return;
                }

                System.out.println("Kích thước ngòi mới: " + getKichThuocNgoi());
                break;
            }
            case 17:{
                System.out.println("Chọn màu mới cho bút máy:");
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
                System.out.println("Màu hiện tại: " + getMauMuc());
                System.out.print("Chọn (1-19): ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        setMauMuc("Đen");
                        break;
                    case 2:
                        setMauMuc("Xanh Dương");
                        break;
                    case 3:
                        setMauMuc("Xanh Lá");
                        break;
                    case 4:
                        setMauMuc("Đỏ");
                        break;
                    case 5:
                        setMauMuc("Vàng");
                        break;
                    case 6:
                        setMauMuc("Cam");
                        break;
                    case 7:
                        setMauMuc("Tím");
                        break;
                    case 8:
                        setMauMuc("Nâu");
                        break;
                    case 9:
                        setMauMuc("Trắng");
                        break;
                    case 10:
                        setMauMuc("Bạc");
                        break;
                    case 11:
                        setMauMuc("Vàng Đồng");
                        break;
                    case 12:
                        setMauMuc("Xám");
                        break;
                    case 13:
                        setMauMuc("Hồng");
                        break;
                    case 14:
                        setMauMuc("Ngọc Lam");
                        break;
                    case 15:
                        setMauMuc("Lam Đậm");
                        break;
                    case 16:
                        setMauMuc("Xanh Biển");
                        break;
                    case 17:
                        setMauMuc("Lục Bảo");
                        break;
                    case 18:
                        setMauMuc("Đỏ Đậm");
                        break;
                    case 19:
                        setMauMuc("Hổ Phách");
                        break;
                    default:
                        System.out.println("Lựa chọn không có! Màu bút giữ nguyên.");
                        return;
                }

                System.out.println("Màu bút mới: " + getMauMuc());
                break;
            }
            case 18: {
                System.out.println("Chọn loại ngòi mới cho bút máy:");
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
                System.out.println("Loại ngòi hiện tại: " + getLoaiNgoi());
                System.out.print("Chọn (1-11): ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        setLoaiNgoi("Ngòi Thường (Round)");
                        break;
                    case 2:
                        setLoaiNgoi("Ngòi Nhọn (Needlepoint)");
                        break;
                    case 3:
                        setLoaiNgoi("Ngòi Uốn Lượn (Flex)");
                        break;
                    case 4:
                        setLoaiNgoi("Ngòi Italic");
                        break;
                    case 5:
                        setLoaiNgoi("Ngòi Stub");
                        break;
                    case 6:
                        setLoaiNgoi("Ngòi Oblique");
                        break;
                    case 7:
                        setLoaiNgoi("Ngòi Zoom");
                        break;
                    case 8:
                        setLoaiNgoi("Ngòi Music (Ngòi Nhạc)");
                        break;
                    case 9:
                        setLoaiNgoi("Ngòi Calligraphy (Thư pháp)");
                        break;
                    case 10:
                        setLoaiNgoi("Ngòi Architect (Kiến trúc)");
                        break;
                    case 11:
                        setLoaiNgoi("Ngòi Left-Handed (Cho người thuận tay trái)");
                        break;
                    default:
                        System.out.println("Lựa chọn không có! Loại ngòi giữ nguyên.");
                        return;
                }

                System.out.println("Loại ngòi mới: " + getLoaiNgoi());
                break;
            }
            case 19:{
                System.out.println("Chọn vật liệu ngòi mới cho bút máy:");
                System.out.println("1. Thép Không Gỉ (Stainless Steel)");
                System.out.println("2. Vàng");
                System.out.println("3. Bạch Kim (Platinum)");
                System.out.println("4. Titan (Titanium)");
                System.out.println("5. Đồng (Copper)");
                System.out.println("Vật liệu hiện tại: " + getVatLieuNgoi());
                System.out.print("Chọn (1-5): ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        setVatLieuNgoi("Thép Không Gỉ (Stainless Steel)");
                        break;
                    case 2:
                        setVatLieuNgoi("Vàng");
                        break;
                    case 3:
                        setVatLieuNgoi("Bạch Kim (Platinum)");
                        break;
                    case 4:
                        setVatLieuNgoi("Titan (Titanium)");
                        break;
                    case 5:
                        setVatLieuNgoi("Đồng (Copper)");
                        break;
                    default:
                        System.out.println("Lựa chọn không có! Vật liệu ngòi giữ nguyên.");
                        return;
                }

                System.out.println("Vật liệu ngòi mới: " + getVatLieuNgoi());
                break;

            }
            case 20:{
                System.out.println("Chọn hệ thống cấp mực cho bút máy:");
                System.out.println("1. Converter (Ống bơm)");
                System.out.println("2. Cartridge (Ống mực)");
                System.out.println("3. Eyedropper (Bơm mực trực tiếp)");
                System.out.println("4. Piston (Pít-tông)");
                System.out.println("5. Vacuum (Hút chân không)");
                System.out.println("Hệ thống cấp mực hiện tại: " + getCoCheBomMuc());
                System.out.print("Chọn (1-5): ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        setCoCheBomMuc("Converter (Ống bơm)");
                        break;
                    case 2:
                        setCoCheBomMuc("Cartridge (Ống mực)");
                        break;
                    case 3:
                        setCoCheBomMuc("Eyedropper (Bơm mực trực tiếp)");
                        break;
                    case 4:
                        setCoCheBomMuc("Piston (Pít-tông)");
                        break;
                    case 5:
                        setCoCheBomMuc("Vacuum (Hút chân không)");
                        break;
                    default:
                        System.out.println("Lựa chọn không có! Hệ thống cấp mực giữ nguyên.");
                        return;
                }

                System.out.println("Hệ thống cấp mực mới: " + getCoCheBomMuc());
                break;
            }
            case 21: {
                System.out.println("Bút hiện tại: "+(isCoNapDay()?"Có nắp đậy":"Không có nắp đậy"));
                System.out.print("Bút có nắp đậy hay không(y/n): ");
                switch (scanner.nextLine().toLowerCase().trim()){
                    case "y":{
                        setCoNapDay(true);
                        System.out.println("Thay đổi mới: bút có nắp đậy.");
                    }
                    case "n":{
                        setCoNapDay(false);
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



