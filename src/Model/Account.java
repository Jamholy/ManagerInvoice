package Model;

import java.util.List;

public class Account {
    public enum Role {
        ADMIN,
        MANAGER,
        EMPLOYEE,
        USER;

        @Override
        public String toString() {
            return switch (this) {
                case ADMIN -> "Admin";
                case MANAGER -> "Quản lý";
                case EMPLOYEE -> "Nhân viên";
                case USER -> "Khách hàng";
            };
        }
    }

    private int id;


    private String username;
    private String password;

    private Role role = Role.USER;
    private double balance = 0;
    private java.util.Date createdAt = new java.util.Date();
    private java.util.Date deletedAt;

    private List<ComputerUsage> usingHistory;
    private List<Invoice> invoices;
    private Session currentSession;
    private Employee employee;

    public void setRole(Integer role) {
        this.role = switch (role) {
            case 0 -> Role.ADMIN;
            case 1 -> Role.MANAGER;
            case 2 -> Role.EMPLOYEE;
            default -> Role.USER;
        };
    }
}
