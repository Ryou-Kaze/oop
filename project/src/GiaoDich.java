import java.util.Date;
public class GiaoDich {

    private String loai; // "SALE" or "RESTOCK"
    private String tenVatPham;
    private String uid;
    private int soLuong;
    private double tongTien;
    private Date date;

    public GiaoDich(String loai, String tenVatPham, String uid, int soLuong, double tongTien) {
        this.loai=loai;
        this.tenVatPham=tenVatPham;
        this.uid=uid;
        this.soLuong=soLuong;
        this.tongTien=tongTien;
        this.date=date;

    }
}
