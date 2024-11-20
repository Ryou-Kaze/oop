import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DSNV {
    private ArrayList<NhanVien> danhSachNV;

    public DSNV() {
        this.danhSachNV = new ArrayList<>();
    }

    public ArrayList<NhanVien> getDanhSachNV() {
        return danhSachNV;
    }

    public void themNhanVien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập họ và tên: ");
        String hoTen = sc.nextLine();
        System.out.print("Nhập năm sinh: ");
        int namSinh = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Nhập mã nhân viên: ");
        String maNV = sc.nextLine();

        // Check if mã nhân viên already exists
        boolean maTrung = false;
        for (NhanVien nv : danhSachNV) {
            if (nv.getMaNV().equalsIgnoreCase(maNV)) {
                maTrung = true;
                break;
            }
        }

        if (maTrung) {
            System.out.println("Mã nhân viên đã tồn tại! Không thể thêm nhân viên mới.");
            return;
        }

        System.out.print("Nhập vai trò: ");
        String vaiTro = sc.nextLine();

        NhanVien nv = new NhanVien(hoTen, namSinh, maNV, vaiTro);
        danhSachNV.add(nv);
        System.out.println("Nhân viên đã được thêm thành công!");
    }

    public void timKiemNhanVien(String maNV) {
        boolean found = false;
        for (NhanVien nv : danhSachNV) {
            if (nv.getMaNV().equalsIgnoreCase(maNV)) {
                nv.Xuat();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy nhân viên với mã: " + maNV);
        }
    }


    public void xoaNhanVien(String maNV) {
        boolean found = false;
        for (int i = 0; i < danhSachNV.size(); i++) {
            if (danhSachNV.get(i).getMaNV().equalsIgnoreCase(maNV)) {
                danhSachNV.remove(i);
                System.out.println("Nhân viên với mã " + maNV + " đã được xóa.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy nhân viên với mã: " + maNV);
        }
    }
    public String layNhanVienBanHangNgauNhien() {
        // Filter employees with the "Ban hang" role
        List<NhanVien> banHangEmployees = new ArrayList<>();
        for (NhanVien nv : danhSachNV) {
            if (NhanVien.BAN_HANG.equalsIgnoreCase(nv.getVaiTro())) {
                banHangEmployees.add(nv);
            }
        }

        if (banHangEmployees.isEmpty()) {
            return null; // No eligible employee
        }

        // Randomly pick one
        Random random = new Random();
        return banHangEmployees.get(random.nextInt(banHangEmployees.size())).getMaNV();
    }
    public void xuatDanhSach() {
        if (danhSachNV.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
        } else {
            System.out.println("Danh sách nhân viên:");
            for (NhanVien nv : danhSachNV) {
                nv.Xuat();
            }
        }
    }

    public void ghiFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (NhanVien nv : danhSachNV) {
                writer.write(nv.getHoTen() + "," + nv.getNamSinh() + "," + nv.getMaNV() + "," + nv.getVaiTro() + "\n");
            }
            System.out.println("Dữ liệu nhân viên đã được ghi vào file.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public void docFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String hoTen = data[0];
                    int namSinh = Integer.parseInt(data[1]);
                    String maNV = data[2];
                    String vaiTro = data[3];
                    NhanVien nv = new NhanVien(hoTen, namSinh, maNV, vaiTro);
                    danhSachNV.add(nv);
                }
            }
            System.out.println("Dữ liệu nhân viên đã được đọc từ file.");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
