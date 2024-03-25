package packge_qlbv;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QLbaiviet qlbaiviet = new QLbaiviet();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Đăng nhập:");
                System.out.println("1. Admin");
                System.out.println("2. User");
                System.out.println("0. Thoát");
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1) {
                    System.out.println("Admin đăng nhập thành công.");
                    adminMenu(qlbaiviet, scanner);
                } else if (choice == 2) {
                    System.out.println("User đăng nhập thành công.");
                    userMenu(qlbaiviet, scanner);
                } else if (choice == 0) {
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                } else {
                    throw new SigninInputException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            } catch (SigninInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void adminMenu(QLbaiviet qlbaiviet, Scanner scanner) {
        while (true) {
            try {
                System.out.println("Admin Menu:");
                System.out.println("1. Thêm bài viết");
                System.out.println("2. Cập nhật bài viết");
                System.out.println("3. Xóa bài viết");
                System.out.println("4. Hiển thị danh sách bài viết");
                System.out.println("5. Đăng xuất");
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1) {
                    System.out.println("Nhập tiêu đề bài viết:");
                    String title = scanner.nextLine();
                    System.out.println("Nhập nội dung bài viết:");
                    String content = scanner.nextLine();
                    Date currentDate = new Date();
                    qlbaiviet.themBaiViet(qlbaiviet.layId(), title, content, currentDate);
                } else if (choice == 2) {
                    System.out.println("Nhập ID của bài viết cần cập nhật:");
                    int idUpdate = Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhập tiêu đề mới:");
                    String newTitle = scanner.nextLine();
                    System.out.println("Nhập nội dung mới:");
                    String newContent = scanner.nextLine();
                    Date updateDate = new Date();
                    qlbaiviet.capNhatBaiViet(idUpdate, newTitle, newContent, updateDate);
                } else if (choice == 3) {
                    System.out.println("Nhập ID của bài viết cần xóa:");
                    int idDelete = Integer.parseInt(scanner.nextLine());
                    qlbaiviet.xoaBaiViet(idDelete);
                } else if (choice == 4) {
                    qlbaiviet.hienDanhSachBaiViet();
                } else if (choice == 5) {
                    qlbaiviet.dangXuat();
                    return;
                } else {
                    throw new AdminInputException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            } catch (AdminInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void userMenu(QLbaiviet qlbaiviet, Scanner scanner) {
        while (true) {
            try {
                System.out.println("User Menu:");
                System.out.println("1. Hiển thị danh sách bài viết");
                System.out.println("2. Xem chi tiết bài viết");
                System.out.println("3. Tìm kiếm bài viết");
                System.out.println("4. Đăng xuất");
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1) {
                    qlbaiviet.hienDanhSachBaiVietForUser();
                } else if (choice == 2) {
                    System.out.println("Nhập ID của bài viết cần xem:");
                    int idView = Integer.parseInt(scanner.nextLine());
                    qlbaiviet.xemChiTietBaiViet(idView);
                } else if (choice == 3) {
                    System.out.println("Nhập từ khóa:");
                    String keyword = scanner.nextLine();
                    qlbaiviet.timKiemTheoTuKhoa(keyword);
                } else if (choice == 4) {
                    qlbaiviet.dangXuat();
                    return;
                } else {
                    throw new SigninInputException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            } catch (SigninInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
