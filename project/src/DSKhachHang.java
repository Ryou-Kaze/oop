import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public  class DSKhachHang {

        private ArrayList<KhachHang> danhSachKH;

        public DSKhachHang() {
            danhSachKH = new ArrayList<>();
        }
        public ArrayList<KhachHang> getDanhSachKH() {
            return danhSachKH;
        }

        public void themKhachHang() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập họ và tên: ");
            String hoTen = sc.nextLine();
            System.out.print("Nhập năm sinh: ");
            int namSinh = sc.nextInt();
            System.out.print("Nhập mã khách hàng: ");
            String maKH = sc.nextLine();
            System.out.print("Nhập địa chỉ: ");
            String diaChi = sc.nextLine();
            System.out.print("Nhập số điện thoại: ");
            String soDienThoai = sc.nextLine();

            KhachHang kh = new KhachHang(hoTen, namSinh, maKH, diaChi, soDienThoai);
            danhSachKH.add(kh);
        }

        public void xuatDanhSach() {
            if (danhSachKH.isEmpty()) {
                System.out.println("Danh sách khách hàng trống.");
            } else {
                System.out.println("Danh sách khách hàng:");
                for (KhachHang kh : danhSachKH) {
                    kh.Xuat(); // Gọi phương thức Xuat() của từng khách hàng
                }
            }
        }

        public void ghiFile() {
            try (FileWriter writer = new FileWriter("DanhSachKhachHang.txt")) {
                for (KhachHang kh : danhSachKH) {
                    writer.write(kh.hoTen + "," + kh.namSinh + "," + kh.getMaKH() + "," + kh.getDiaChi() + "," + kh.getSoDienThoai() + "\n");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public void docFile() {
            try (BufferedReader input = new BufferedReader(new FileReader("DanhSachKhachHang.txt"))) {
                String line;
                while ((line = input.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length == 5) {
                        String hoTen = data[0];
                        int namSinh = Integer.parseInt(data[1]);
                        String maKH = data[2];
                        String diaChi = data[3];
                        String soDienThoai = data[4];

                        KhachHang kh = new KhachHang(hoTen, namSinh, maKH, diaChi, soDienThoai);
                        danhSachKH.add(kh);
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

