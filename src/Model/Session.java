package Model;

import Model.Account;
import Model.Computer;

import java.util.Date;

public class Session {

    private Integer id;

    private int totalTime;

    private int usedTime = 0;


    private int usedCost = 0;


    private int serviceCost = 0;

    private Date startTime = new Date();

    private int prepaidAmount = 0;
    private Integer usingBy = null;
    private Account usingByAccount;

    private Integer computerID = null;
    private Computer usingComputer;


}
