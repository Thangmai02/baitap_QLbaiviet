package packge_qlbv;

import java.util.Date;
import java.util.List;

public interface interfaceChucnang {void themBaiViet(int id, String title, String content, Date createdAt); // Tạo bài viết mới
    void capNhatBaiViet(int id, String newTitle, String newContent, Date updatedAt); // Cập nhật bài viết
    void xoaBaiViet(int id); // Xóa bài viết
    void hienDanhSachBaiViet(); // Hiển thị danh sách bài viết
    void dangXuat(); // Đăng xuất

    // Menu user
    void hienDanhSachBaiVietForUser(); // Hiển thị danh sách bài viết cho người dùng
    void xemChiTietBaiViet(int id); // Xem chi tiết bài viết
    List<Integer> timKiemTheoTuKhoa(String keyword); // Tìm kiếm bài viết theo từ khóa
}