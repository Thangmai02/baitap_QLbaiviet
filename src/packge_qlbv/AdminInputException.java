package packge_qlbv;

public class AdminInputException extends  Exception{
    public AdminInputException() {
        super("Lựa chọn trong menu admin không hợp lệ. Vui lòng chọn lại.");
    }
}
