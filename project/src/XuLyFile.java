import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Map;

public class XuLyFile{


    private static final Map<String, Class<? extends VanPhongPham>> phanLoaiLopPhu = new HashMap<>();

    static {

        phanLoaiLopPhu.put("butbi", ButBi.class);
        phanLoaiLopPhu.put("butchi", ButChi.class);
        phanLoaiLopPhu.put("butmay", ButMay.class);
        phanLoaiLopPhu.put("butchibam", ButChiBam.class);
        phanLoaiLopPhu.put("butlong", ButLong.class);

    }
    //Lưu dữ liệu kho vào tệp
    public static void luuKhoVaoFile(Kho kho, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Kho\n");

            for (String mucChinh : kho.getKho().keySet()) {
                writer.write("MỤC CHÍNH: " + mucChinh + "\n");
                Map<String, Map<String, VanPhongPham>> dSMucPhu = kho.getKho().get(mucChinh);

                for (String mucPhu : dSMucPhu.keySet()) {
                    writer.write("  MỤC PHỤ: " + mucPhu + "\n");
                    Map<String, VanPhongPham> dSVatPham = dSMucPhu.get(mucPhu);

                    for (VanPhongPham vatPham : dSVatPham.values()) {
                        writer.write("      ITEM: " + taoChuoi(vatPham) + "\n");
                    }
                }
            }

            System.out.println("Dữ liệu đã lưu vào file: " + filePath);
        } catch (IOException e) {
            System.out.println("Lỗi khi viết file: " + e.getMessage());
        }
    }
    //Tải dữ liệu kho từ tệp
    public static void taiKhoTuFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String mucChinhHienTai = null;
            String mucPhuHientTai = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("MỤC CHÍNH:")) {
                    mucChinhHienTai = line.replace("MỤC CHÍNH:", "").trim();
                    Kho.INSTANCE.getKho().putIfAbsent(mucChinhHienTai, new HashMap<>());
                } else if (line.startsWith("MỤC PHỤ:")) {
                    mucPhuHientTai = line.replace("MỤC PHỤ:", "").trim();
                    Kho.INSTANCE.getKho().get(mucChinhHienTai).putIfAbsent(mucPhuHientTai, new HashMap<>());
                } else if (line.startsWith("VP:")) {
                    String thongTinVatPham = line.replace("VP:", "").trim();
                    VanPhongPham vatPham = tachChuoi(thongTinVatPham, mucChinhHienTai, mucPhuHientTai);
                    if (vatPham != null) {
                        Kho.INSTANCE.themVatPham(mucChinhHienTai, mucPhuHientTai, vatPham);
                    }
                }
            }

            System.out.println("Dữ liệu đươc tải thành công từ file : " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    //Chuyển đổi đối tượng sản phẩm thành chuỗi để lưu vào tệp
    private static String taoChuoi(VanPhongPham vatPham) {
        StringBuilder sb = new StringBuilder();
        sb.append("Tên: ").append(vatPham.getTen());
        sb.append("|| UID: ").append(vatPham.getUid());
        sb.append("|| Giá(đ): ").append(vatPham.getGia());
        sb.append("|| Số lượng: ").append(vatPham.getSoLuong());
        sb.append("|| Hàng tồn :").append(vatPham.getHangTon());
        sb.append("|| Nhà phân phối: ").append(vatPham.getNhaPhanPhoi());
        sb.append("|| Cân nặng(g): ").append(vatPham.getCanNang());
        sb.append("|| Vị trí kho: ").append(vatPham.getViTriKho());
        sb.append("|| Ngày sản xuất: ").append(vatPham.getNgaySanXuat());
        sb.append("|| Ngày hết hạn: ").append(vatPham.getNgayHetHan());
        if (vatPham.getHetHanStatus()){
            sb.append("|| Tình trạng: Hết hạn");
        }
        else{
            sb.append("|| Tình trạng: Còn hạn");
        }
        if (vatPham instanceof CongCuViet){
            CongCuViet but = (CongCuViet) vatPham;
            sb.append(" || Màu: ").append(but.getMau());
            sb.append(" || Vật liệu thân bút: ").append(but.getVatLieuThanBut());
            sb.append(" || Có thể nạp lại: ").append(but.getCoTheNapLai() ? "Có" : "Không");
            sb.append(" || Có thể xóa: ").append(but.getCoTheXoa() ? "Có" : "Không");
            if (vatPham instanceof ButLong) {
                ButLong butLong = (ButLong) vatPham;
                sb.append("|| Loại mực: ").append(butLong.getLoaiMuc());
                sb.append("|| Loại đầu bút: ").append(butLong.getLoaiDauBut());
            } else if (vatPham instanceof ButBi) {
                ButBi butBi = (ButBi) vatPham;
                sb.append("|| Kích thước ngòi bút(mm): ").append(butBi.getKichThuocNgoiBut());
                sb.append("|| Màu mực: ").append(butBi.getMauMuc());
                sb.append("|| Loại ngòi: ").append(butBi.getLoaiNgoi());
                sb.append(" || Có nắp đậy: ").append(butBi.getCoNapDay() ? "Có" : "Không");
            } else if (vatPham instanceof ButMay) {
                ButMay butMay = (ButMay) vatPham;
                sb.append("|| Kích thước ngòi bút(mm): ").append(butMay.getKichThuocNgoi());
                sb.append("|| Màu mực: ").append(butMay.getMauMuc());
                sb.append("|| Loại ngòi: ").append(butMay.getLoaiNgoi());
                sb.append("|| Vật liệu ngòi bút: ").append(butMay.getVatLieuNgoi());
                sb.append("|| Cơ chế bơm mực: ").append(butMay.getCoCheBomMuc());
                sb.append(" || Có nắp đậy: ").append(butMay.isCoNapDay() ? "Có" : "Không");
            }else if (vatPham instanceof ButChiBam){
                ButChiBam butChiBam = (ButChiBam) vatPham;
                sb.append("|| Kích thước ngòi bút(mm): ").append(butChiBam.getKichThuocNgoi());
                sb.append(" || Có đầu tẩy: ").append(butChiBam.isCoTay() ? "Có" : "Không");
            } else if (vatPham instanceof ButChi) {
                ButChi butChi = (ButChi) vatPham;
                sb.append("|| Độ cứng: ").append(butChi.getDoCung());
                sb.append(" || Có đầu tẩy: ").append(butChi.isCoTay() ? "Có" : "Không");
            }

        }


        return sb.toString();
    }
    //Chuyển đổi  đối tượng sản phẩm từ chuỗi đọc từ tệp
    private static VanPhongPham tachChuoi(String itemDetails, String mucChinh, String mucPhu) {
        try {
            // Split the input string into fields
            String[] fields = itemDetails.split("\\|\\|");
            Map<String, String> fieldMap = new HashMap<>();

            // Parse each field and populate the map
            for (String field : fields) {
                String[] keyValue = field.split(":");
                if (keyValue.length == 2) {
                    fieldMap.put(keyValue[0].trim().toLowerCase(), keyValue[1].trim());
                }
            }

            // Identify the class based on the category (mucPhu)
            Class<? extends VanPhongPham> clazz = phanLoaiLopPhu.get(mucPhu.toLowerCase());
            if (clazz == null) {
                System.out.println("Unknown mucPhu: " + mucPhu);
                return null;
            }

            // Collect tags
            LinkedHashSet<String> tags = new LinkedHashSet<>();
            tags.add(mucChinh.toLowerCase());
            tags.add(mucPhu.toLowerCase());

            // Parse and create instances based on the class type
            if (clazz.equals(ButLong.class)) {
                return new ButLong(
                        fieldMap.get("tên"),
                        fieldMap.get("uid"),
                        tags,
                        Double.parseDouble(fieldMap.get("giá(đ)")),
                        Integer.parseInt(fieldMap.get("số lượng")),
                        Integer.parseInt(fieldMap.get("hàng tồn")),
                        fieldMap.get("nhà phân phối"),
                        Double.parseDouble(fieldMap.get("cân nặng(g)")),
                        fieldMap.get("vị trí kho"),
                        fieldMap.get("ngày sản xuất"),
                        fieldMap.get("ngày hết hạn"),
                        fieldMap.get("màu"),
                        fieldMap.get("vật liệu thân bút"),
                        fieldMap.get("có thể nạp lại").equalsIgnoreCase("Có"),
                        fieldMap.get("có thể xóa").equalsIgnoreCase("Có"),
                        fieldMap.get("loại mực"),
                        fieldMap.get("loại đầu bút")
                );
            } else if (clazz.equals(ButBi.class)) {
                return new ButBi(
                        fieldMap.get("tên"),
                        fieldMap.get("uid"),
                        tags,
                        Double.parseDouble(fieldMap.get("giá(đ)")),
                        Integer.parseInt(fieldMap.get("số lượng")),
                        Integer.parseInt(fieldMap.get("hàng tồn")),
                        fieldMap.get("nhà phân phối"),
                        Double.parseDouble(fieldMap.get("cân nặng(g)")),
                        fieldMap.get("vị trí kho"),
                        fieldMap.get("ngày sản xuất"),
                        fieldMap.get("ngày hết hạn"),
                        fieldMap.get("màu"),
                        fieldMap.get("vật liệu thân bút"),
                        fieldMap.get("có thể nạp lại").equalsIgnoreCase("Có"),
                        fieldMap.get("có thể xóa").equalsIgnoreCase("Có"),
                        Double.parseDouble(fieldMap.get("kích thước ngòi bút(mm)")),
                        fieldMap.get("màu mực"),
                        fieldMap.get("loại ngòi"),
                        fieldMap.get("có nắp đậy").equalsIgnoreCase("Có")
                );
            } else if (clazz.equals(ButMay.class)) {
                return new ButMay(
                        fieldMap.get("tên"),
                        fieldMap.get("uid"),
                        tags,
                        Double.parseDouble(fieldMap.get("giá(đ)")),
                        Integer.parseInt(fieldMap.get("số lượng")),
                        Integer.parseInt(fieldMap.get("hàng tồn")),
                        fieldMap.get("nhà phân phối"),
                        Double.parseDouble(fieldMap.get("cân nặng(g)")),
                        fieldMap.get("vị trí kho"),
                        fieldMap.get("ngày sản xuất"),
                        fieldMap.get("ngày hết hạn"),
                        fieldMap.get("màu"),
                        fieldMap.get("vật liệu thân bút"),
                        fieldMap.get("có thể nạp lại").equalsIgnoreCase("Có"),
                        fieldMap.get("có thể xóa").equalsIgnoreCase("Có"),
                        fieldMap.get("kích thước ngòi bút(mm)"),
                        fieldMap.get("màu mực"),
                        fieldMap.get("loại ngòi"),
                        fieldMap.get("vật liệu ngòi bút"),
                        fieldMap.get("cơ chế bơm mực"),
                        fieldMap.get("có nắp đậy").equalsIgnoreCase("Có")
                );
            } else if (clazz.equals(ButChiBam.class)) {
                return new ButChiBam(
                        fieldMap.get("tên"),
                        fieldMap.get("uid"),
                        tags,
                        Double.parseDouble(fieldMap.get("giá(đ)")),
                        Integer.parseInt(fieldMap.get("số lượng")),
                        Integer.parseInt(fieldMap.get("hàng tồn")),
                        fieldMap.get("nhà phân phối"),
                        Double.parseDouble(fieldMap.get("cân nặng(g)")),
                        fieldMap.get("vị trí kho"),
                        fieldMap.get("ngày sản xuất"),
                        fieldMap.get("ngày hết hạn"),
                        fieldMap.get("màu"),
                        fieldMap.get("vật liệu thân bút"),
                        fieldMap.get("có thể nạp lại").equalsIgnoreCase("Có"),
                        fieldMap.get("có thể xóa").equalsIgnoreCase("Có"),
                        Double.parseDouble(fieldMap.get("kích thước ngòi bút(mm)")),
                        fieldMap.get("có đầu tẩy").equalsIgnoreCase("Có")
                );
            } else if (clazz.equals(ButChi.class)) {
                return new ButChi(
                        fieldMap.get("tên"),
                        fieldMap.get("uid"),
                        tags,
                        Double.parseDouble(fieldMap.get("giá(đ)")),
                        Integer.parseInt(fieldMap.get("số lượng")),
                        Integer.parseInt(fieldMap.get("hàng tồn")),
                        fieldMap.get("nhà phân phối"),
                        Double.parseDouble(fieldMap.get("cân nặng(g)")),
                        fieldMap.get("vị trí kho"),
                        fieldMap.get("ngày sản xuất"),
                        fieldMap.get("ngày hết hạn"),
                        fieldMap.get("màu"),
                        fieldMap.get("vật liệu thân bút"),
                        fieldMap.get("có thể nạp lại").equalsIgnoreCase("Có"),
                        fieldMap.get("có thể xóa").equalsIgnoreCase("Có"),
                        fieldMap.get("độ cứng"),
                        fieldMap.get("có đầu tẩy").equalsIgnoreCase("Có")
                );
            }

            System.out.println("Unhandled mucPhu: " + mucPhu);
            return null;
        } catch (Exception e) {
            System.out.println("Lỗi khi chuyển đổi chuỗi thành đối tượng: " + e.getMessage());
            return null;
        }
    }


    public static void luuVatPhamTheoUID(String filePath, String uid) {
        Set<String> danhSachUIDTonTai = layUIDTuFile(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) { // Chế độ ghi thêm
            if (danhSachUIDTonTai.contains(uid)) {
                System.out.println("Vật phẩm với UID " + uid + " đã tồn tại trong file.");
                return;
            }
            VanPhongPham vatPham = Kho.INSTANCE.timBangUID(uid);
            if (vatPham != null) {
                writer.write("VẬT PHẨM: " + taoChuoi(vatPham) + "\n");
                System.out.println("Vật phẩm với UID " + uid + " đã được lưu vào file: " + filePath);
            } else {
                System.out.println("Không tìm thấy vật phẩm với UID: " + uid);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }




    public static void luuVatPhamTheoDanhMucPhu(String filePath, String danhMuc, String danhMucPhu) {
        Set<String> danhSachUIDTonTai = layUIDTuFile(filePath); // Kiểm tra danh sách UID đã tồn tại trong file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) { // Chế độ ghi thêm
            Map<String, Map<String, VanPhongPham>> danhMucPhuMap = Kho.INSTANCE.getKho().get(danhMuc);
            if (danhMucPhuMap != null && danhMucPhuMap.containsKey(danhMucPhu)) {
                Map<String, VanPhongPham> vatPhams = danhMucPhuMap.get(danhMucPhu);
                for (VanPhongPham vatPham : vatPhams.values()) {
                    if (!danhSachUIDTonTai.contains(vatPham.getUid())) { // Ghi nếu UID chưa có trong file
                        writer.write("VẬT PHẨM: " + taoChuoi(vatPham) + "\n");
                        System.out.println("Vật phẩm với UID " + vatPham.getUid() + " đã được lưu vào file: " + filePath);
                    } else {
                        System.out.println("Vật phẩm với UID " + vatPham.getUid() + " đã tồn tại trong file.");
                    }
                }
            } else {
                System.out.println("Danh mục hoặc danh mục phụ không hợp lệ.");
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }



    public static void luuVatPhamTheoDanhMuc(String filePath, String danhMuc) {
        Set<String> danhSachUIDTonTai = layUIDTuFile(filePath); // Kiểm tra danh sách UID đã tồn tại trong file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) { // Chế độ ghi thêm
            Map<String, Map<String, VanPhongPham>> danhMucPhuMap = Kho.INSTANCE.getKho().get(danhMuc);
            if (danhMucPhuMap != null) {
                for (String danhMucPhu : danhMucPhuMap.keySet()) {
                    Map<String, VanPhongPham> vatPhams = danhMucPhuMap.get(danhMucPhu);
                    for (VanPhongPham vatPham : vatPhams.values()) {
                        if (!danhSachUIDTonTai.contains(vatPham.getUid())) { // Ghi nếu UID chưa có trong file
                            writer.write("VẬT PHẨM: " + taoChuoi(vatPham) + "\n");
                            System.out.println("Vật phẩm với UID " + vatPham.getUid() + " đã được lưu vào file: " + filePath);
                        } else {
                            System.out.println("Vật phẩm với UID " + vatPham.getUid() + " đã tồn tại trong file.");
                        }
                    }
                }
            } else {
                System.out.println("Danh mục không hợp lệ.");
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }


    private static Set<String> layUIDTuFile(String filePath) {
        Set<String> danhSachUID = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("VẬT PHẨM:")) {
                    String[] fields = line.split("\\|\\|");
                    for (String field : fields) {
                        if (field.trim().startsWith("UID:")) {
                            String uid = field.trim().replace("UID:", "").trim();
                            danhSachUID.add(uid);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file để lấy danh sách UID: " + e.getMessage());
        }
        return danhSachUID;
    }

}