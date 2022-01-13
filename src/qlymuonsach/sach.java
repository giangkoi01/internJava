package qlymuonsach;

import java.util.Scanner;

public class sach {
    public static int iD = 10000;
    public int maSach;
    public String tenSach;
    public String tacGia;
    public String chuyenNganh;
    public String namXuatBan;

    public sach(int maSach, String tenSach, String tacGia, String chuyenNganh, String namXuatBan) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.chuyenNganh = chuyenNganh;
        this.namXuatBan = namXuatBan;
    }

    public static int getiD() {
        return iD;
    }

    public static void setiD(int iD) {
        sach.iD = iD;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }


    public sach(){
            this.maSach=iD++;
    }


    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public String getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(String namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public void addsach() {
        Scanner scanner = new Scanner(System.in);
        this.setMaSach(iD);
        System.out.println("tên sách");
        this.setTenSach(scanner.nextLine());
        System.out.println("tác giả:");
        this.setTacGia(scanner.nextLine());
        System.out.println("năm xuất bản:");
        this.setNamXuatBan(scanner.nextLine());
        System.out.println("chuyên ngành:");
        String[] arr = {"Khoa học tự nhiên", "Văn học – Nghệ thuật", "Điện tử viễn thông", "Công nghệ thông tin"};
        boolean kt = true;
        do {
            kt = true;
            int a = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("chọn loại sách:");
            System.out.println("1.Khoa học tự nhiên:");
            System.out.println("2.Văn học-nghệ thuật");
            System.out.println("3.Điện tử viễn thông");
            System.out.println("4.Công nghệ thông tin");
            a = scanner.nextInt();
            switch (a) {
                case 1:
                    this.setChuyenNganh(arr[0]);
                    break;
                case 2:
                    this.setChuyenNganh(arr[1]);
                    break;
                case 3:
                    this.setChuyenNganh(arr[2]);
                    break;
                case 4:
                    this.setChuyenNganh(arr[2]);
                    break;
                default:
                    System.out.println("không có danh mục vừa nhập, nhập lại");
                    kt = false;
                    break;
            }
        }
        while (!kt) ;

    }
    @Override
    public String toString() {
        return "Sach{" +
                "mã=" + maSach +
                ", tên='" + tenSach + '\'' +
                ", tác giả='" + tacGia + '\'' +
                ", loại='" + chuyenNganh + '\'' +
                ", năm xuất bản=" + namXuatBan +
                '}';
    }
}