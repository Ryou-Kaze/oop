public abstract class Nguoi {

        protected String hoTen;
        protected int namSinh;

        public Nguoi() {
            hoTen = "";
            namSinh = 0;
        }

        public Nguoi(String hoTen, int namSinh) {
            this.hoTen = hoTen;
            this.namSinh = namSinh;
        }

        public String getHoTen() {
            return hoTen;
        }

        public void setHoTen(String hoTen) {
            this.hoTen = hoTen;
        }

        public int getNamSinh() {
            return namSinh;
        }

        public void setNamSinh(int namSinh) {
            this.namSinh = namSinh;
        }

    public abstract void Xuat();

}
