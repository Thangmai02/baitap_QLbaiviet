package packge_qlbv;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QLbaiviet implements interfaceChucnang {

    private int id;
    private String tieuDe;
    private String noiDung;
    private Date ngayTao;
    private Date ngayCapNhat;
    private List<QLbaiviet> danhSachBaiViet;

    public QLbaiviet() {
        danhSachBaiViet = new ArrayList<>();
    }

    public QLbaiviet(String tieuDe, String noiDung, Date ngayTao, Date ngayCapNhat) {
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    public int layId() {
        return id;
    }

    public void datId(int id) {
        this.id = id;
    }

    public String layTieuDe() {
        return tieuDe;
    }

    public void datTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String layNoiDung() {
        return noiDung;
    }

    public void datNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date layNgayTao() {
        return ngayTao;
    }

    public void datNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date layNgayCapNhat() {
        return ngayCapNhat;
    }

    public void datNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    @Override
    public void themBaiViet(int id, String tieuDe, String noiDung, Date ngayTao) {
        QLbaiviet baiViet = new QLbaiviet(tieuDe, noiDung, ngayTao, null);
        baiViet.datId(++this.id);
        danhSachBaiViet.add(baiViet);
    }

    @Override
    public void capNhatBaiViet(int id, String tieuDeMoi, String noiDungMoi, Date ngayCapNhatMoi) {
        for (QLbaiviet baiViet : danhSachBaiViet) {
            if (baiViet.layId() == id) {
                baiViet.datTieuDe(tieuDeMoi);
                baiViet.datNoiDung(noiDungMoi);
                baiViet.datNgayCapNhat(ngayCapNhatMoi);
                break;
            }
        }
    }

    @Override
    public void xoaBaiViet(int id) {
        danhSachBaiViet.removeIf(baiViet -> baiViet.layId() == id);
    }

    @Override
    public void hienDanhSachBaiViet() {
        for (QLbaiviet baiViet : danhSachBaiViet) {
            System.out.println("ID: " + baiViet.layId());
            System.out.println("Tiêu đề: " + baiViet.layTieuDe());
            System.out.println("Nội dung: " + baiViet.layNoiDung());
            System.out.println("Ngày tạo: " + baiViet.layNgayTao());
            System.out.println("Ngày cập nhật: " + baiViet.layNgayCapNhat());
            System.out.println("--------------------------------------");
        }
    }

    @Override
    public void dangXuat() {
        System.out.println("Đăng xuất thành công.");
    }

    @Override
    public void hienDanhSachBaiVietForUser() {
        hienDanhSachBaiViet();
    }

    @Override
    public void xemChiTietBaiViet(int id) {
        for (QLbaiviet baiViet : danhSachBaiViet) {
            if (baiViet.layId() == id) {
                System.out.println("ID: " + baiViet.layId());
                System.out.println("Tiêu đề: " + baiViet.layTieuDe());
                System.out.println("Nội dung: " + baiViet.layNoiDung());
                System.out.println("Ngày tạo: " + baiViet.layNgayTao());
                System.out.println("Ngày cập nhật: " + baiViet.layNgayCapNhat());
                return;
            }
        }
        System.out.println("Không tìm thấy bài viết.");
    }

    @Override
    public List<Integer> timKiemTheoTuKhoa(String tuKhoa) {
        List<Integer> ketQuaIds = new ArrayList<>();
        for (QLbaiviet baiViet : danhSachBaiViet) {
            if (baiViet.layTieuDe().contains(tuKhoa) || baiViet.layNoiDung().contains(tuKhoa)) {
                ketQuaIds.add(baiViet.layId());
            }
        }
        return ketQuaIds;
    }
}
