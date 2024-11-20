import java.util.HashMap;
import java.util.Map;

public class Order {
    private String maOrder; // Order ID
    private String maKH; // Customer ID
    private String maNV; // Employee ID
    private Map<VanPhongPham, Integer> cacVatPham; // Items and their quantities
    private double tongGia; // Total price of the order
    private String tinhTrangOrder; // Order status

    // Constructor
    public Order(String maOrder, String maKH, String maNV) {
        this.maOrder = maOrder;
        this.maKH = maKH;
        this.maNV = maNV;
        this.cacVatPham = new HashMap<>();
        this.tongGia = 0.0;
        this.tinhTrangOrder = "Đang xử lý"; // Default status
    }

    // Add an item to the order
    public void themVatPham(VanPhongPham vatPham, int soLuong) {
        if (soLuong > 0) {
            cacVatPham.put(vatPham, soLuong);
            tinhTongGia();
        } else {
            System.out.println("Số lượng phải lớn hơn 0.");
        }
    }

    // Calculate the total price of the order
    public void tinhTongGia() {
        tongGia = 0.0;
        for (Map.Entry<VanPhongPham, Integer> entry : cacVatPham.entrySet()) {
            VanPhongPham vatPham = entry.getKey();
            int soLuong = entry.getValue();
            tongGia += vatPham.getGia() * soLuong;
        }
    }

    // Display order details
    public void hienThiChiTietOrder() {
        System.out.println("Mã đơn hàng: " + maOrder);
        System.out.println("Mã khách hàng: " + maKH);
        System.out.println("Mã nhân viên: " + maNV);
        System.out.println("Trạng thái đơn hàng: " + tinhTrangOrder);
        System.out.println("Danh sách vật phẩm:");
        for (Map.Entry<VanPhongPham, Integer> entry : cacVatPham.entrySet()) {
            VanPhongPham vatPham = entry.getKey();
            int soLuong = entry.getValue();
            System.out.printf("- %s (UID: %s): %d x %.2f = %.2f\n",
                    vatPham.getTen(), vatPham.getUid(), soLuong, vatPham.getGia(), vatPham.getGia() * soLuong);
        }
        System.out.printf("Tổng giá trị: %.2f\n", tongGia);
    }

    // Update order status
    public void capNhatTinhTrangOrder(String tinhTrang) {
        this.tinhTrangOrder = tinhTrang;
    }

    // Getters
    public String getMaOrder() {
        return maOrder;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public double getTongGia() {
        return tongGia;
    }

    public String getTinhTrangOrder() {
        return tinhTrangOrder;
    }

    // Verify if the employee is allowed to process the order
    public boolean duocGiaoCho(String maNV) {
        return this.maNV.equals(maNV);
    }

    // Process the order
    public void xuLyOrder(String maNV) {
        if (duocGiaoCho(maNV)) {
            this.tinhTrangOrder = "Đã xử lý";
            System.out.println("Đơn hàng " + maOrder + " đã được xử lý bởi nhân viên " + maNV);
        } else {
            System.out.println("Nhân viên " + maNV + " không được phép xử lý đơn hàng này!");
        }
    }
}


