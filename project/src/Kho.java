import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.LinkedHashSet;

public enum Kho {
    INSTANCE;
    private Map<String,Map<String,Map<String,VanPhongPham>>> kho;
    private Map<String,Integer> boDemMaUid;
    private Map<String,VanPhongPham> dSTraThangUid;
    private Map<String, VanPhongPham> dSDaXoa;
    Kho(){
        kho=new HashMap<>();
        kho.put("CongCuViet", new HashMap<>());
        kho.get("CongCuViet").put("ButBi", new HashMap<>());
        kho.get("CongCuViet").put("ButMay", new HashMap<>());
        kho.get("CongCuViet").put("ButChi", new HashMap<>());
        kho.get("CongCuViet").put("ButChiBam", new HashMap<>());
        kho.get("CongCuViet").put("ButLong", new HashMap<>());
        // Initialize UID counters for each danhMucPhu
        boDemMaUid = new HashMap<>();
        boDemMaUid.put("ButBi", 0);
        boDemMaUid.put("ButMay", 0);
        boDemMaUid.put("ButChi", 0);
        boDemMaUid.put("ButChiBam", 0);
        boDemMaUid.put("ButLong", 0);
        dSTraThangUid = new HashMap<>();
        dSDaXoa = new HashMap<>();

    }
    public Map<String, Map<String, Map<String, VanPhongPham>>> getKho() {
        return kho;
    }
    public String taoUID(String danhMucChinh, String danhMucPhu){
        if (!kho.containsKey(danhMucChinh) || !kho.get(danhMucChinh).containsKey(danhMucPhu)) {
            throw new IllegalArgumentException(" Danh Mục Chính hay Danh mục phụ không phù hợp");
        }

        // Get the current counter for the danhMucPhu
        int currentCount = boDemMaUid.get(danhMucPhu);

        // Generate the UID in the format "SUBCATEGORY-###"
        String uid = danhMucPhu.toLowerCase().replaceAll("\\s+", "") + "-" + String.format("%04d", currentCount);

        // Increment the counter and update it in boDemMaUid
        boDemMaUid.put(danhMucPhu, currentCount + 1);

        return uid;
    }


    public void themVatPham(String danhMucChinh, String danhMucPhu, VanPhongPham vatPham){
        String uid = taoUID(danhMucChinh, danhMucPhu);
        vatPham.setUid(uid);
        kho.get(danhMucChinh).get(danhMucPhu).put(uid, vatPham);
        dSTraThangUid.put(uid, vatPham);
        System.out.println("Added vatPham: " + vatPham);
    }
    public void xoaVatPham (String uid){
        // Step 1: Quick check in `dSTraThangUid`
        VanPhongPham vatPham = dSTraThangUid.get(uid);
        if (vatPham == null) {
            System.out.println("Không tồn tại vật phẩm với UID:" + uid);
            return;
        }
        LinkedHashSet<String> tagslist = vatPham.getTagsList();
        Iterator<String> iterator = tagslist.iterator();
        String danhMucChinh = iterator.next();    // Get main danhMucChinh
        String subCategory = iterator.next();   // Get danhMucPhu
        if (danhMucChinh == null || subCategory == null) {
            System.out.println("Lỗi: tag của danh mục chính và danh mục phụ  bị thiếu hoặc không phù hợp cho vật phẩm với UID: " + uid);
            return;
        }
        Map<String, VanPhongPham> dSVatPhamDanhMucPhu = kho.get(danhMucChinh).get(subCategory);
        if (dSVatPhamDanhMucPhu != null && dSVatPhamDanhMucPhu.remove(uid) != null) {
            dSTraThangUid.remove(uid);
            dSDaXoa.put(uid,vatPham);
            System.out.println("Đã bỏ vật phẩm với UID: " + uid);
            System.out.println("Ngày xóa: "+DateConverter.getDateNow() );
        } else {
            System.out.println("Không tìm thấy vật phẩm với UID: " + uid);
        }
    }


    public VanPhongPham timBangUID(String uid) {
        return dSTraThangUid.get(uid);
    }

    public void taoBangBaoCaoTongQuat() {
        int tongVatPham = 0;
        double tongGiaTri = 0.0;

        System.out.println("Báo cáo tóm tắt hàng tồn kho");
        for (String danhMucChinh : kho.keySet()) {
            int danhMucChinhCount = 0;
            double danhMucChinhValue = 0.0;

            for (String danhMucPhu : kho.get(danhMucChinh).keySet()) {
                for (VanPhongPham vatPham : kho.get(danhMucChinh).get(danhMucPhu).values()) {
                    tongVatPham += vatPham.getSoLuong();
                    tongVatPham += vatPham.getHangTon();
                    tongGiaTri += vatPham.getGia() * vatPham.getSoLuong();
                    tongGiaTri += vatPham.getGia()*vatPham.getHangTon();
                    danhMucChinhCount += vatPham.getSoLuong();
                    danhMucChinhCount += vatPham.getHangTon();
                    danhMucChinhValue += vatPham.getGia() * vatPham.getSoLuong();
                    danhMucChinhValue += vatPham.getGia()*vatPham.getHangTon();
                }
            }

            System.out.println("Danh mục chính: " + danhMucChinh);
            System.out.println("  Tổng vật phẩm thuộc danh mục: " + danhMucChinhCount);
            System.out.println("  Tổng giá trị của danh mục chính: $" + danhMucChinhValue);
        }
        System.out.println("Tổng vật phẩm trong kho: " + tongVatPham);
        System.out.println("Tổng giá trị của các vật phẩm trong kho: $" + tongGiaTri);
    }

    public void hienThiTatCaVatPham() {
        for (String danhMucChinh : kho.keySet()) {
            System.out.println("Danh mục: " + danhMucChinh);
            Map<String, Map<String, VanPhongPham>> dSDanhMucPhu = kho.get(danhMucChinh);

            for (String danhMucPhu : dSDanhMucPhu.keySet()) {
                System.out.println("================");
                System.out.println("Danh mục phụ: " + danhMucPhu);
                System.out.println("================");
                Map<String, VanPhongPham> dsVatPham = dSDanhMucPhu.get(danhMucPhu);

                for (VanPhongPham vatPham : dsVatPham.values()) {
                    System.out.println("--------------");
                    vatPham.xuatThongTin();
                    System.out.println("--------------");
                }

            }
        }
    }

    public void hienThiVatPhamDaXoa() {
        if (dSDaXoa.isEmpty()) {
            System.out.println("Không có vật phẩm nào trong danh sách đã xóa.");
        } else {
            System.out.println("Danh sách vật phẩm đã xóa:");
            for (VanPhongPham vatPham : dSDaXoa.values()) {
                vatPham.xuatThongTin();
            }
        }
    }
    public void khoiPhucVatPham(String uid) {
        VanPhongPham vatPham = dSDaXoa.remove(uid);
        if (vatPham != null) {
            LinkedHashSet<String> tagslist = vatPham.getTagsList();
            Iterator<String> iterator = tagslist.iterator();
            String danhMucChinh = iterator.next();    // Get main danhMucChinh
            String danhMucPhu = iterator.next();   // Get danhMucPhu
            if (danhMucChinh != null && danhMucPhu != null) {
                if(kho.containsKey(danhMucChinh) && kho.get(danhMucChinh).containsKey(danhMucPhu))
                kho.get(danhMucChinh).get(danhMucPhu).put(uid, vatPham);
                dSTraThangUid.put(uid, vatPham);
                System.out.println("Vật phẩm  " + uid +" được khôi phục");
            } else {
                System.out.println("Khôi phục vật phẩm thất bại. Không thể xác định được danh mục chính hoặc danh mục phụ của vật phẩm  với UID: " + uid);
            }
        } else {
            System.out.println("Không tìm được vật phẩm với UID: "+ uid +" trong danh sách đã xóa." );
        }
    }

}
