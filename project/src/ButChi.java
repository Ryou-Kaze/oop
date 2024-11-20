import java.util.LinkedHashSet;
import java.util.Scanner;

public class ButChi extends CongCuViet {

    private String doCung;
    private boolean coTay;
    public ButChi(String ten, String uid, LinkedHashSet<String> tags, double gia, int soLuong,int hangTon, String nhaPhanPhoi,double canNang, String viTriKho, String ngaySanXuat, String ngayHetHan, String mau,String vatLieuThanBut, boolean coTheNapLai, boolean coTheXoa,String doCung, boolean coTay){
        super(ten,uid,tags,gia,soLuong,hangTon,nhaPhanPhoi,canNang,viTriKho,ngaySanXuat,ngayHetHan,mau,vatLieuThanBut,coTheNapLai,coTheXoa);
        this.doCung=doCung;
        this.coTay=coTay;
    }

    public String getDoCung() {
        return doCung;
    }

    public void setDoCung(String doCung) {
        this.doCung = doCung;
    }

    public boolean isCoTay() {
        return coTay;
    }

    public void setCoTay(boolean coTay) {
        this.coTay = coTay;
    }

    @Override
    public void xuatThongTin(){
        super.xuatThongTin();
        System.out.println("- Độ cứng của bút chì này: " + doCung);
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
                "16. Độ cứng \n" +
                "17. Tẩy\n"+
                "0. Exit";
    }
    @Override
    public void capNhatMuc(int input) {
        Scanner scanner = new Scanner(System.in);
        switch (input) {
            case 16 : {
                System.out.println("Chọn độ cứng mới cho bút chì:");
                System.out.println("1. 9H");
                System.out.println("2. 8H");
                System.out.println("3. 7H");
                System.out.println("4. 6H");
                System.out.println("5. 5H");
                System.out.println("6. 4H");
                System.out.println("7. 3H");
                System.out.println("8. 2H");
                System.out.println("9. H");
                System.out.println("10. HB");
                System.out.println("11. B");
                System.out.println("12. 2B");
                System.out.println("13. 3B");
                System.out.println("14. 4B");
                System.out.println("15. 5B");
                System.out.println("16. 6B");
                System.out.println("17. 7B");
                System.out.println("18. 8B");
                System.out.println("19. 9B");
                System.out.println("Độ cứng hiện tại: "+ getDoCung());
                System.out.print("chọn (1-19): ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        setDoCung("9H");
                        break;
                    case 2:
                        setDoCung("8H");
                        break;
                    case 3:
                        setDoCung("7H");
                        break;
                    case 4:
                        setDoCung("6H");
                        break;
                    case 5:
                        setDoCung("5H");
                        break;
                    case 6:
                        setDoCung("4H");
                        break;
                    case 7:
                        setDoCung("3H");
                        break;
                    case 8:
                        setDoCung("2H");
                        break;
                    case 9:
                        setDoCung("H");
                        break;
                    case 10:
                        setDoCung("HB");
                        break;
                    case 11:
                        setDoCung("B");
                        break;
                    case 12:
                       setDoCung("2B");
                        break;
                    case 13:
                        setDoCung("3B");
                        break;
                    case 14:
                        setDoCung("4B");
                        break;
                    case 15:
                        setDoCung("5B");
                        break;
                    case 16:
                        setDoCung("6B");
                        break;
                    case 17:
                        setDoCung("7B");
                        break;
                    case 18:
                        setDoCung("8B");
                        break;
                    case 19:
                       setDoCung("9B");
                        break;
                    default:
                        System.out.println("Lựa chọn không có! Độ cứng giữ nguyên");
                        return;
                }

                // Display the updated hardness
                System.out.println("Độ cứng mới: " + getDoCung());
                break;
            }
            case 17: {
                System.out.print("Bút có tẩy hay không(y/n): ");
                switch (scanner.nextLine().toLowerCase().trim()){
                    case "y":{
                        setCoTheNapLai(true);
                        System.out.println("Thay đổi mới: bút có tẩy.");
                    }
                    case "n":{
                        setCoTheNapLai(false);
                        System.out.println("Thay đổi mới: bút không có tẩy.");
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
