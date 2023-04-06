package Model;

import Model.Account;
import Model.Computer;

import java.util.Date;

public class ComputerUsage {

    private int id;
    private Integer usedByAccountId = null;
    private Account usedBy;
    private Integer computerID;
    private Computer computer;
    private boolean isEmployeeUsing;

    private Date createdAt;
    private Date endAt;
    private float totalMoney;
}
