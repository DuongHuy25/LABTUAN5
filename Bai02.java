package packageBai02;
import java.util.Scanner;

interface Hinh {
    float pi = 3.14f;
    void nhap();
    void xuat();
    float dienTich();
}

class HinhVuong implements Hinh {
    private float canh;
    public HinhVuong() {
        this.canh = 0.0f;
    }
    public HinhVuong(float canh) {
        this.canh = canh;
    }
    @Override
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap canh hinh vuong: ");
        this.canh = scanner.nextFloat();
    }
    @Override
    public void xuat() {
        System.out.println("Hinh vuong - Canh: " + canh + ", Dien tich: " + dienTich());
    }
    @Override
    public float dienTich() {
        return canh * canh;
    }
}
class HinhChuNhat implements Hinh {
    private float dai;
    private float rong;
    public HinhChuNhat() {
        this.dai = 0.0f;
        this.rong = 0.0f;
    }
    public HinhChuNhat(float dai, float rong) {
        this.dai = dai;
        this.rong = rong;
    }
    @Override
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chieu dai: ");
        this.dai = scanner.nextFloat();
        System.out.print("Nhap chieu rong: ");
        this.rong = scanner.nextFloat();
    }
    @Override
    public void xuat() {
        System.out.println("Hinh chu nhat - Dai: " + dai + ", Rong: " + rong + ", Dien tich: " + dienTich());
    }
    @Override
    public float dienTich() {
        return dai * rong;
    }
}

class HinhTron implements Hinh {
    private float banKinh;
    public HinhTron() {
        this.banKinh = 0.0f;
    }
    public HinhTron(float banKinh) {
        this.banKinh = banKinh;
    }
    @Override
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ban kinh hinh tron: ");
        this.banKinh = scanner.nextFloat();
    }
    @Override
    public void xuat() {
        System.out.println("Hinh tron - Ban kinh: " + banKinh + ", Dien tich: " + dienTich());
    }
    @Override
    public float dienTich() {
        return pi * banKinh * banKinh;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong hinh: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 
        Hinh ds[] = new Hinh[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Chon loai hinh se nhap (vi tri " + (i + 1) + "): ");
            System.out.println("1: hinh vuong");
            System.out.println("2: hinh chu nhat");
            System.out.println("3: hinh tron");
            int chon;
            do {
                System.out.print("Nhap lua chon (1-3): ");
                chon = scanner.nextInt();
                scanner.nextLine(); 
                if (chon < 1 || chon > 3) {
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
                }
            } while (chon < 1 || chon > 3);

            switch (chon) {
                case 1:
                    ds[i] = new HinhVuong();
                    ds[i].nhap();
                    break;
                case 2:
                    ds[i] = new HinhChuNhat();
                    ds[i].nhap();
                    break;
                case 3:
                    ds[i] = new HinhTron();
                    ds[i].nhap();
                    break;
            }
        }

        System.out.println("\nDanh sach cac hinh da nhap:");
        for (Hinh hinh : ds) {
            hinh.xuat();
        }
        Hinh hinhDienTichLonNhat = ds[0];
        for (int i = 1; i < ds.length; i++) {
            if (ds[i].dienTich() > hinhDienTichLonNhat.dienTich()) {
                hinhDienTichLonNhat = ds[i];
            }
        }
        System.out.println("\nHinh co dien tich lon nhat:");
        hinhDienTichLonNhat.xuat();
    }
}