import java.util.ArrayList;
import java.util.List;

public class QuanLyOrder {
    private List<Order> orders;

    public QuanLyOrder() {
        this.orders = new ArrayList<>();
    }


    public void themOrder(Order order) {
        orders.add(order);
    }

    // Get orders assigned to a specific employee
    public List<Order> layOrdersTheoNhanVien(String maNV) {
        List<Order> ordersNhanVien = new ArrayList<>();
        for (Order order : orders) {
            if (order.duocGiaoCho(maNV)) {
                ordersNhanVien.add(order);
            }
        }
        return ordersNhanVien;
    }

    // Display all orders for a specific employee

    public void hienThiOrdersTheoNhanVien(String maNV) {
        List<Order> ordersNhanVien = layOrdersTheoNhanVien(maNV);
        if (ordersNhanVien.isEmpty()) {
            System.out.println("Nhân viên " + maNV + " không có đơn hàng nào.");
        } else {
            for (Order order : ordersNhanVien) {
                order.hienThiChiTietOrder();
            }
        }
    }
}
