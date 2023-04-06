package Model;


import java.util.Date;
import java.util.List;

public class Invoice {
    public enum InvoiceType {
          IMPORT,
            EXPORT,
    ;

        @Override
        public String toString() {
            return switch (this) {
                case IMPORT -> "Hoá đơn nhập hàng";
                case EXPORT -> "Hoá đơn bán hàng";
            };
        }
    }
    public enum Status {
        WAITING_FOR_ACCEPT,
        ACCEPTED,
        REJECTED,
        DONE
        ;
        @Override
        public String toString() {
            return switch (this) {
                case WAITING_FOR_ACCEPT -> "Chờ duyệt";
                case ACCEPTED -> "Đã duyệt";
                case REJECTED -> "Đã từ chối";
                case DONE -> "Đã hoàn thành";
            };
        }
    }

    private int id;//la id cua moi hoa don
    private Integer createdToAccountId = null;//truong hop la khach hang van lai hoac la hoa don nhap thi de null

    private Account createdToAccount;//day la doi tuong cu the cua account lay ra tu thuoc tinh createToAcountId
    private Integer computerId = null;//truong hop la hoa don nhap thi chung ta de la null
    private Computer createdToComputer;// la doi tuong cu the cua hoa may tinh lay ra tu thuoc tinh computerId

    private Double total = 0.0;//la tong tien cua moi hoa don
    private Date createdAt = new Date();//la ngay lap hoa don
   
    private Status status = Status.WAITING_FOR_ACCEPT;//
    private boolean isPaid = false;
    private int createdBy;//tao boi nhan vien co ID la gi
    private Employee createdByEmployee;//la nhan viec duoc lay ra dua theo ID ow tren(createdBy)

   
    private InvoiceType type;//kieu hoa do
    private Date deletedAt;//luu lai ngay ma hoa don do bi xoa
    private String note;

    private List<InvoiceDetail> invoiceDetails;

}
