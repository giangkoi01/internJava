package qlymuonsach;

import java.util.Scanner;

import java.util.Scanner;

public class banDoc {
    public int maBD;
    public String hoTen;
    public String diaChi;
    public String sDT;
    public String loaiBD;
    public static int iD=10000;

    public banDoc(int maBD, String hoTen, String diaChi, String sDT, String loaiBD) {
        this.maBD = maBD;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sDT = sDT;
        this.loaiBD = loaiBD;
    }
    public int getMaBD() {
        return maBD;
    }

    public void setMaBD(int maBD) {
        this.maBD = maBD;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getLoaiBD() {
        return loaiBD;
    }

    public void setLoaiBD(String loaiBD) {
        this.loaiBD = loaiBD;
    }

    public banDoc(){
        this.maBD=iD++;
    }


        public void addbandoc() {
            Scanner scanner = new Scanner(System.in);
            this.setMaBD(this.maBD);
            System.out.println("Họ tên:");
            this.setHoTen(scanner.nextLine());
            System.out.println("địa chỉ:");
            this.setDiaChi(scanner.nextLine());
            System.out.println("số điện thoại:");
            this.setsDT(scanner.nextLine());
            String[] arr = {"sinh viên", "học viên cao học", "giáo viên"};

            boolean kt = true;
            do {
                kt = true;
                int a = 0;
                Scanner sc = new Scanner(System.in);
                System.out.println("chọn loại bạn học:");
                System.out.println("1.sinh viên:");
                System.out.println("2.học viên cao học");
                System.out.println("3.giáo viên");
                a = scanner.nextInt();
                switch (a) {
                    case 1:
                        this.setLoaiBD(arr[0]);
                        break;
                    case 2:
                        this.setLoaiBD(arr[1]);
                        break;
                    case 3:
                        this.setLoaiBD(arr[2]);
                        break;
                    default:
                        System.out.println("không có danh mục vừa nhập,nhập lại");
                        kt = false;
                        break;
                }
            }
            while (!kt) ;
    }

    @Override
    public String toString() {
        return "Bandoc{" +
                "mã=" + maBD +
                ", tên='" + hoTen + '\'' +
                ", địa chỉ='" + diaChi + '\'' +
                ", số điện thoại='" + sDT + '\'' +
                ", loại='" + loaiBD + '\'' +
                '}';
    }

}