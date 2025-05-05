package packageBai01;
import java.util.ArrayList;
import java.util.Scanner;
abstract class NhanVien {
    protected String maNhanVien;
    protected String tenNhanVien;
    protected String trinhDo;
    protected double luongCoBan;

    public NhanVien() {
        this.maNhanVien = "";
        this.tenNhanVien = "";
        this.trinhDo = "";
        this.luongCoBan = 0.0;
    }

    public NhanVien(String maNhanVien, String tenNhanVien, String trinhDo) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.trinhDo = trinhDo;
        this.luongCoBan = 0.0;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien: ");
        this.maNhanVien = scanner.nextLine();
        System.out.print("Nhap ten nhan vien: ");
        this.tenNhanVien = scanner.nextLine();
        System.out.print("Nhap trinh do: ");
        this.trinhDo = scanner.nextLine();
        System.out.print("Nhap luong co ban: ");
        this.luongCoBan = scanner.nextDouble();
    }

    public void xuat() {
        System.out.println("Ma nhan vien: " + maNhanVien + ", Ten nhan vien: " +
                           tenNhanVien +
                           ", Trinh do: " + trinhDo + ", Luong co ban: " + luongCoBan);
    }

    public abstract double tinhLuong();
}

class QuanLy extends NhanVien {
    private String chuyenMon;
    private double phuCapChucVu;

    public QuanLy() {
        super();
        this.chuyenMon = "";
        this.phuCapChucVu = 0.0;
    }
    public QuanLy(String maNhanVien, String tenNhanVien, String trinhDo, String chuyenMon, double phuCapChucVu) {
        super(maNhanVien, tenNhanVien, trinhDo);
        this.chuyenMon = chuyenMon;
        this.phuCapChucVu = phuCapChucVu;
    }
    public String getChuyenMon() {
        return chuyenMon;
    }
    public double getPhuCapChucVu() {
        return phuCapChucVu;
    }
    
    @Override
    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chuyen mon: ");
        this.chuyenMon = scanner.nextLine();
        System.out.print("Nhap phu cap chuc vu: ");
        this.phuCapChucVu = scanner.nextDouble();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println(", Chuyen mon: " + chuyenMon + ", Phu cap chuc vu: " + phuCapChucVu);
    }

    @Override
    public double tinhLuong() {
        return luongCoBan + phuCapChucVu;
    }
}

class NghienCuu extends NhanVien {
    private String chuyenMon;
    private double phuCapDocHai;

    public NghienCuu() {
        super();
        this.chuyenMon = "";
        this.phuCapDocHai = 0.0;
    }

    public NghienCuu(String maNhanVien, String tenNhanVien, String trinhDo, String chuyenMon, double phuCapDocHai) {
        super(maNhanVien, tenNhanVien, trinhDo);
        this.chuyenMon = chuyenMon;
        this.phuCapDocHai = phuCapDocHai;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public double getPhuCapDocHai() {
        return phuCapDocHai;
    }
    @Override
    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chuyen mon nghien cuu: ");
        this.chuyenMon = scanner.nextLine();
        System.out.print("Nhap phu cap doc hai: ");
        this.phuCapDocHai = scanner.nextDouble();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println(", Chuyen mon nghien cuu: " + chuyenMon + ", Phu cap doc hai: " + phuCapDocHai);
    }

    @Override
    public double tinhLuong() {
        return luongCoBan + phuCapDocHai;
    }
}

class PhucVu extends NhanVien {
    public PhucVu() {
        super();
    }

    public PhucVu(String maNhanVien, String tenNhanVien, String trinhDo) {
        super(maNhanVien, tenNhanVien, trinhDo);
    }

    @Override
    public double tinhLuong() {
        return luongCoBan;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<NhanVien> danhSachNhanVien = new ArrayList<>();
        System.out.println("Nhap thong tin Quan Ly:");
        QuanLy quanLy = new QuanLy();
        quanLy.nhap();
        System.out.println("\nThong tin Quan Ly:");
        quanLy.xuat();
        System.out.println("Luong: " + quanLy.tinhLuong());
        danhSachNhanVien.add(quanLy);
        System.out.println("\nNhap thong tin Nghien Cuu:");
        NghienCuu nghienCuu = new NghienCuu();
        nghienCuu.nhap();
        System.out.println("\nThong tin Nghien Cuu:");
        nghienCuu.xuat();
        System.out.println("Luong: " + nghienCuu.tinhLuong());
        danhSachNhanVien.add(nghienCuu);
        System.out.println("\nNhap thong tin Phuc Vu:");
        PhucVu phucVu = new PhucVu();
        phucVu.nhap();
        System.out.println("\nThong tin Phuc Vu:");
        phucVu.xuat();
        System.out.println("Luong: " + phucVu.tinhLuong());
        danhSachNhanVien.add(phucVu);
        System.out.println("\nDanh sach nhan vien:");
        for (NhanVien nv : danhSachNhanVien) {
            nv.xuat();
            System.out.println("Luong: " + nv.tinhLuong());
        }
    }
}
