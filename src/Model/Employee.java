package Model;

import java.util.Date;
import java.util.List;


public class Employee {

    private int id;

    private String name;


    private Integer accountID = null;

    private Account account;


    private String otherInformation;

    private Date createdAt = new Date();
    private Date deletedAt;
    private List<Invoice> createdInvoices;
}
