package Model;


import java.util.Date;
import java.util.List;

public class Computer {
    public enum ComputerType {
        Vip,
        Normal,
        ;

        @Override
        public String toString() {
            return switch (this) {
                case Vip -> "Máy VIP";
                case Normal -> "Máy thường";
            };
        }
    }

    public enum ComputerStatus {
        MAINTAINING,
        LOCKED,
        OFF,
        USING,
        ;

        @Override
        public String toString() {
            return switch (this) {
                case MAINTAINING -> "Đang bảo trì";
                case LOCKED -> "Đang khóa";
                case OFF -> "Đang tắt";
                case USING -> "Đang sử dụng";
            };
        }
    }


    private int id;


    private String name;
    private float price; // giá tiền trên 1 giờ
    private ComputerType type;
    private ComputerStatus status = ComputerStatus.OFF;
    private Date createdAt = new Date();
    private Date deletedAt;

    private List<ComputerUsage> computerUsages;
    private List<Invoice> invoices;
    private Session currentSession;
    public void setStatus(Integer status) {
        this.status = ComputerStatus.values()[status];
    }
    public void setType(Integer type) {
        this.type = ComputerType.values()[type];
    }
}
