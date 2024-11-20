import java.util.ArrayList;
import java.util.List;

public enum NhatKyGiaoDich {
    INSTANCE;

    private List<GiaoDich> dSGiaoDich;

    NhatKyGiaoDich() {
        dSGiaoDich = new ArrayList<>();
    }

    public void ghiGiaoDich(GiaoDich giaoDich) {
        dSGiaoDich.add(giaoDich);
    }

    public void inTatCaCacGiaoDich() {
        if (dSGiaoDich.isEmpty()) {
            System.out.println("No transactions recorded.");
        } else {
            System.out.println("Transaction History:");
            for (GiaoDich giaoDich : dSGiaoDich) {
                System.out.println(giaoDich);
            }
        }
    }


}
