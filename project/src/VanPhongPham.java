
import java.util.LinkedHashSet;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import  java.util.Iterator;

public abstract class VanPhongPham implements printInterface  {
    private String ten;
    private String uid;
    private LinkedHashSet<String> tags;
    private Double gia;
    private Integer soLuong;
    private int hangTon;
    private String nhaPhanPhoi;
    private Double canNang;
    private String viTriKho;
    private String ngaySanXuat;
    private String ngayHetHan;
    private boolean coHetHan;
    private static final Set<String> protectedTags = new HashSet<>();
    static {
        protectedTags.add("congcuviet");
        protectedTags.add("butchi");
        protectedTags.add("butbi");
        protectedTags.add("butmay");
        protectedTags.add("butlong");
        protectedTags.add("butchibam");
    }
    public VanPhongPham(String ten,String uid,LinkedHashSet<String> tags,double gia,int soLuong,int hangTon,String nhaPhanPhoi,double canNang,String viTriKho,String ngaySanXuat,String ngayHetHan){
        this.ten=ten;
        this.uid=uid;
        this.tags = tags !=null ? tags: new LinkedHashSet<>();
        this.gia=gia;
        this.soLuong=soLuong;
        this.hangTon=hangTon;
        this.nhaPhanPhoi=nhaPhanPhoi;
        this.canNang=canNang;
        this.viTriKho=viTriKho;
        this.ngaySanXuat=ngaySanXuat;
        this.ngayHetHan=ngayHetHan;
        coHetHan=DateConverter.checkExpiry(ngayHetHan);
    }
    public String getTen(){
        return ten;
    }
    public void setTen(String ten){
        this.ten =ten;
    }
    public String getUid(){
        return uid;
    }
    public void setUid(String uid){
        this.uid =uid;
    }
    public LinkedHashSet<String> getTagsList(){
        return tags;
    }
    public  void setTagsList(LinkedHashSet<String> tags){
        this.tags=tags;
    }

    public void addTag(String tag){
        tags.add(tag.trim().toLowerCase());
    }

    public Double getGia(){
        return gia;
    }
    public void setGia(double gia){
        this.gia=gia;
    }
    public Integer getSoLuong(){
        return soLuong;
    }
    public void setSoLuong(int soLuong){
        this.soLuong=soLuong;
    }

    public int getHangTon() {
        return hangTon;
    }

    public void setHangTon(int hangTon) {
        this.hangTon = hangTon;
    }

    public String getNhaPhanPhoi(){
        return nhaPhanPhoi;
    }
    public void setNhaPhanPhoi(String nhaPhanPhoi){
        this.nhaPhanPhoi =nhaPhanPhoi;
    }
    public Double getCanNang(){
        return canNang;
    }
    public  void setCanNang(double canNang){
        this.canNang=canNang;
    }
    public String getViTriKho(){
        return viTriKho;
    }
    public void setViTriKho(String viTriKho){
        this.viTriKho=viTriKho;
    }
    public String getNgaySanXuat(){
        return ngaySanXuat;
    }
    public void setNgaySanXuat( String ngaySanXuat){
        this.ngaySanXuat=ngaySanXuat;
    }
    public String getNgayHetHan(){
        return ngayHetHan;
    }
    public void setNgayHetHan( String ngayHetHan){
        this.ngayHetHan=ngayHetHan;
    }
    public boolean getHetHanStatus(){return coHetHan;}




    public void apMaGiamGia(double phanTramGiamGia){
        this.gia=this.gia*phanTramGiamGia;
    }


    public void kiemTraNgay(){
        if (DateConverter.checkExpiry(this.ngayHetHan)){
            System.out.println("Sản phẩm hết hạn.");
            coHetHan =true;
        }
        else{
            System.out.println("Sản phẩm còn hạn.");
        }
    }
    @Override
    public void xuatThongTin(){

        System.out.println("- Tên: "+ ten);
        System.out.println("- UID: "+ uid);
        System.out.print("- Tags: ");
        printInterface.printTags(tags);
        System.out.println("\n- Giá: "+gia+" đ");
        System.out.println("- Số lượng đang bán: "+soLuong);
        System.out.println("- Hàng tồn trong kho: " + hangTon);
        System.out.println("- Cân nặng: "+canNang);
        System.out.println("- Vị trí trong kho: " +viTriKho);
        System.out.println("- Nhà phân phối: "+nhaPhanPhoi);
        System.out.println("- Ngày sản xuất : "+ngaySanXuat);
        System.out.println("- Ngày hết hạn:"+ ngayHetHan);
        if(coHetHan){
            System.out.println("- Sản phẩm hết hạn. Bỏ hoặc thay thế !");
        }
        else{
            System.out.println("- Sản phẩm còn hạn.");
        }
    }

    public void boTag(String targetTag) {
        targetTag = targetTag.toLowerCase().replaceAll("\\s+", "");
        if (protectedTags.contains(targetTag)) {
            System.out.println("Tag quan trọng. Không được bỏ.");
        } else if (tags.contains(targetTag)) {
            tags.remove(targetTag);
            System.out.println("Tag được bỏ: " + targetTag);
        } else {
            System.out.println("Không tìm được tag. Thử lại");
        }
    }
    public void boSungTuKhoHangTon(int so) {
        if (hangTon >= so) {
            this.soLuong += so;
            this.hangTon -= so;
            System.out.println("Đã bổ sung");
        } else {
            System.out.println("Không đủ hàng tồn để bổ sung.");
        }
    }
    public void boSungHangTon(int so){
        this.hangTon+=so;
    }

    public String chonMuc() {
        return "Chọn mục để thay đổi:\n" +
                "1. Tên\n" +
                "2. Tags\n" +
                "3. Giá\n" +
                "4. Số Lượng\n" +
                "5. Hàng Tồn Trong Kho\n"+
                "6. Nhà Phân Phối\n" +
                "7. Cân Nặng\n" +
                "8. Vị Trí Trong Kho\n" +
                "9. Ngày Sản Xuất\n" +
                "10. Ngày Hết Hạn\n" +
                "0.Thoát\n";

    }

    public void capNhatMuc(int input) {
        Scanner scanner = new Scanner(System.in);
        switch (input) {
            case 1:  {
                System.out.print("Nhập tên mới: ");
                setTen(scanner.nextLine());
                break;
            }
            case 2: {
                System.out.println("1. Thêm Tag");
                System.out.println("2. Xóa Tag");
                System.out.print("Chọn một tùy chọn (1 hoặc 2): ");
                int luaChonTag = scanner.nextInt();
                scanner.nextLine(); // Loại bỏ dòng trống

                switch (luaChonTag) {
                    case 1: // Thêm Tag
                        System.out.print("Nhập Tag để thêm (phân cách bằng dấu phẩy): ");
                        String nhapTag = scanner.nextLine();
                        String phanTuDau = LayTagDauTien(this.tags);
                        String phanTuThuHai = LayTagThuHai(this.tags);
                        this.tags.clear();
                        tags.add(phanTuDau);
                        tags.add(phanTuThuHai);
                        for (String tag : nhapTag.split(",")) {
                            this.tags.add(tag.trim());
                        }
                        System.out.println("Đã thêm Tag thành công!");
                        break;

                    case 2: // Xóa Tag
                        boolean tiepTucXoa = true;
                        while (tiepTucXoa) {
                            System.out.println("Tag hiện tại: " + this.tags);
                            System.out.print("Nhập Tag cần xóa: ");
                            String tagCanXoa = scanner.nextLine().trim();
                            boTag(tagCanXoa); // Gọi phương thức `boTag` để xử lý việc xóa

                            System.out.print("Bạn có muốn xóa thêm Tag nào không? (y/n): ");
                            String traLoi = scanner.nextLine().trim().toLowerCase();
                            if (!traLoi.equals("y")) {
                                tiepTucXoa = false;
                            }
                        }
                        break;

                    default:
                        System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn 1 hoặc 2.");
                }
                break;
            }
            case 3: {
                System.out.println("Giá hiện tại: " + getGia()+" $");
                System.out.print("Nhập giá mới: ");
                setGia(scanner.nextDouble());
                break;
            }
            case 4: {
                System.out.println("Số lượng hiện tại: " + getSoLuong());
                System.out.print("Nhập số lượng mới: ");
                setSoLuong(scanner.nextInt());
                break;
            }
            case 5:{
                System.out.println("Số lượng hàng tồn hiện tại: " + getHangTon());
                System.out.print("Nhập số lượng hàng tồn mới: ");
                setHangTon(scanner.nextInt());
            }
            case 6:  {
                System.out.println("Nhà phân phối hiện tại: " + getNhaPhanPhoi());
                System.out.print("Nhập nhà phân phối mới: ");
                setNhaPhanPhoi(scanner.nextLine());
                break;
            }
            case 7 : {
                System.out.println("Cân nặng hiện tại: " + getCanNang() + " g");
                System.out.print("Nhập cân nặng mới: ");
                setCanNang(scanner.nextDouble());
                break;
            }
            case 8 : {
                System.out.println("Vị trí kho hiện tại: " + getViTriKho());
                System.out.print("Nhập vị tri kho mới: ");
                setViTriKho(scanner.nextLine());
                break;
            }
            case 9 : {
                System.out.println("Ngày sản xuất hiện tại: " + getNgaySanXuat());
                System.out.print("Nhập ngày sản xuất mới: ");
                setNgaySanXuat(scanner.nextLine());
                break;
            }
            case 10 : {
                System.out.println("Ngày hết hạn hiện tại: " + getNgayHetHan());
                System.out.print("Nhập ngày hết hạn mới: ");
                setNgayHetHan(scanner.nextLine());
                break;
            }
            case 0: {
                System.out.println("Exiting menu.");
                break;
            }
            default:
                System.out.println("Input không phù hợp ! Chọn lại");
        }
    }

    private String LayTagDauTien(LinkedHashSet tagslist){
        Iterator<String> iterator = tagslist.iterator();
        String tagDau = iterator.next();    // Get the first element
        return tagDau;
    }
    private String LayTagThuHai(LinkedHashSet tagslist){
       Iterator<String> iterator = tagslist.iterator();
       iterator.next();    // Get the first element
       String tagThuHai = iterator.next();
       return tagThuHai;
    }
}
