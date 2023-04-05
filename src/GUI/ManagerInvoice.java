package GUI;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import GUI.library;

public class ManagerInvoice extends JFrame {
    private JPanel managerInvoiceContentPane;//tao mot contentpane cho JFrame
    private JPanel managerInvoiceHeader;
    private JPanel containTitleManagerInvoice;
    private JLabel titleManagerInvoice;
    private JPanel containActionInHeader;
    private JLabel actionShowInvoiceImport;
    private JLabel actionShowInvoiceExport;
    private JButton btnCreateInvoice;
    private JPanel  containShowInvoiceAction;
    private JPanel containCreateNewInvoiceAction;
    private DefaultTableModel listInvoiceModelExport;
    private JTable listInvoiceExport;
    private DefaultTableModel listInvoiceModelImport;
    private JTable listInvoiceImport;
    private JScrollPane listInvoiceScrollPane;
    private JLabel titleContainShowListInvoice;
    private JPanel managerInvoiceBody;
    private JLabel titleComputerFilter;
    private JComboBox computer;
    private JPanel containAccountFilter;
    private JPanel containComputerFilter;
    private JLabel titleContainAccountFilter;
    private JTextField inputAccountToFilter;
    private  JLabel limitDateFrom;
    private JPanel containDateFrom;
    private JDateChooser dateChooserFrom;
    private JButton btnCancel;
    private JButton btnSearch;
    public ManagerInvoice(){
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
    }

    public void sizeInComputer(JPanel jpanel){

        jpanel.setPreferredSize(new Dimension(1200,650));
    }

    public void setPaddingJLabel(int top,int left,int buttom,int right,JLabel jlabel){
        jlabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0,0,0,1)),
                BorderFactory.createEmptyBorder(top,left,buttom,right)
        ));
    }

    public void setPaddingJButton(int top,int left,int buttom,int right,JButton jbutton){
        jbutton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0,0,0,1)),
                BorderFactory.createEmptyBorder(top,left,buttom,right)
        ));
    }

    public void setPlaceHoder(String textPlaceHoder,JTextField jtextField){
        jtextField.setText(textPlaceHoder);
        jtextField.setFont(new Font("serif",Font.PLAIN,16));
    }
    public void initManagerInvoice(){


        //manager header START
//        1-----Title Quan Ly hoa don-START---
        titleManagerInvoice = new JLabel("Quản lý hóa đơn");
        titleManagerInvoice.setFont(new Font("serif",Font.BOLD,30));
        titleManagerInvoice.setForeground(Color.WHITE);
        setPaddingJLabel(0,20,0,0,titleManagerInvoice);
        containTitleManagerInvoice = new JPanel();
        containTitleManagerInvoice.setLayout(new FlowLayout(FlowLayout.LEFT));
        containTitleManagerInvoice.setPreferredSize(new Dimension(1198,50));
        containTitleManagerInvoice.setBackground(new Color(42,121,255));
        containTitleManagerInvoice.add(titleManagerInvoice);
//        1-----Title Quan Ly hoa don-END---


//        2-------ACTION IN HEADER-START-----
//        2.1------Hoa don nhap-Hoa don ban-START-----
        actionShowInvoiceExport = new JLabel("Hóa đơn bán");
        actionShowInvoiceExport.setFont(new Font("serif",Font.BOLD,20));
        actionShowInvoiceExport.setCursor(new Cursor(Cursor.HAND_CURSOR));
        actionShowInvoiceExport.setForeground(Color.WHITE);
//        setPaddingJLabel(50,10,0,0,showInvoiceBuy);
        actionShowInvoiceExport.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0,0,0,1)),
                BorderFactory.createEmptyBorder(50,0,5,0)
        ));
        actionShowInvoiceImport = new JLabel("Hóa đơn nhập");
        actionShowInvoiceImport.setFont(new Font("serif",Font.BOLD,20));
        actionShowInvoiceImport.setCursor(new Cursor(Cursor.HAND_CURSOR));
        actionShowInvoiceImport.setForeground(Color.WHITE);
        setPaddingJLabel(50,0,0,0, actionShowInvoiceImport);
        containShowInvoiceAction = new JPanel(new FlowLayout(FlowLayout.LEFT));
        containShowInvoiceAction.setBackground(new Color(42,121,255));
        containShowInvoiceAction.add(actionShowInvoiceExport);
        containShowInvoiceAction.add(new JLabel("       "));
        containShowInvoiceAction.add(actionShowInvoiceImport);
//        2.1------Hoa don nhap-hoa don ban-END-----



//        2.2-------Nut them hoa don moi-START
        btnCreateInvoice = new JButton("+ tạo mới");
        btnCreateInvoice.setBackground(new Color(238,238,238));
        btnCreateInvoice.setFont(new Font("srief",Font.PLAIN,17));
        btnCreateInvoice.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCreateInvoice.setFocusPainted(false);//dung de bo border cua text ben trong button
        setPaddingJButton(5,20,5,20,btnCreateInvoice);
        containCreateNewInvoiceAction = new JPanel(new FlowLayout(FlowLayout.RIGHT,50,50));//muc dich set hgap va vgap de cang chinh JButton
        containCreateNewInvoiceAction.setBackground(new Color(42,121,255));
        containCreateNewInvoiceAction.add(btnCreateInvoice,BorderLayout.LINE_END);
//        containCreateNewInvoiceAction.setBorder(BorderFactory.createLineBorder(Color.red));
//        2.2-----Nut them hoa don moi-END-----


        containActionInHeader = new JPanel();
        containActionInHeader.setLayout(new BoxLayout(containActionInHeader,BoxLayout.X_AXIS));
        containActionInHeader.setPreferredSize(new Dimension(1190,100));
        containActionInHeader.add(Box.createRigidArea(new Dimension(5,0)));
        containActionInHeader.setBackground(new Color(42,121,255));
        containActionInHeader.add( containShowInvoiceAction);
        containActionInHeader.add(containCreateNewInvoiceAction);
//        2-----ACTION IN HEADER-END------


        managerInvoiceHeader = new JPanel();
        managerInvoiceHeader.setLayout(new BoxLayout(managerInvoiceHeader,BoxLayout.Y_AXIS));
        managerInvoiceHeader.add(containTitleManagerInvoice);
        managerInvoiceHeader.add(containActionInHeader);
//        MANAGER HEADER END





//        MANAGER BODY START
//        1---------Body Filter for Search start-----
//            a-----Title of FILTER---
        ImageIcon iconFilter = new ImageIcon("D:\\projectJava\\src\\GUI\\img\\filter.png");
        Image imgFilter = iconFilter.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
        iconFilter = new ImageIcon(imgFilter);
        JLabel titleFilter = new JLabel("Lọc tìm kiếm",iconFilter,JLabel.CENTER);
        titleFilter.setFont(new Font("serif",Font.BOLD,17));
        JPanel containTitleFilter = new JPanel(new FlowLayout(FlowLayout.LEFT));
        containTitleFilter.setPreferredSize(new Dimension(245,50));
        containTitleFilter.add(titleFilter);



//            b------Date limit of filter------
        limitDateFrom = new JLabel("Từ ngày");
        dateChooserFrom = new JDateChooser();
        dateChooserFrom.setPreferredSize(new Dimension(121,30));
        dateChooserFrom.setFont(new Font("serif",Font.PLAIN,16));
        dateChooserFrom.setDateFormatString("yyyy-MM-dd");
        containDateFrom = new JPanel(new GridLayout(2,1,0,0));
        containDateFrom.setPreferredSize(new Dimension(107,50));
        containDateFrom.add(limitDateFrom);
        containDateFrom.add(dateChooserFrom);

        JLabel limitDateTo = new JLabel("Đến ngày");
        JDateChooser dateChooserTo = new JDateChooser();
        dateChooserTo.setPreferredSize(new Dimension(121,30));
        dateChooserTo.setFont(new Font("serif",Font.PLAIN,16));
        dateChooserTo.setDateFormatString("yyyy-MM-dd");
        JPanel containDateTo = new JPanel(new GridLayout(2,1,0,0));
        containDateTo.setPreferredSize(new Dimension(107,50));
        containDateTo.add(limitDateTo);
        containDateTo.add(dateChooserTo);

        JPanel containLimitDate = new JPanel(new FlowLayout(FlowLayout.LEFT));
        containLimitDate.setPreferredSize(new Dimension(245,60));
        containLimitDate.add(containDateFrom);
        containLimitDate.add(new JLabel("   "));
        containLimitDate.add(containDateTo);



//            c-------Total limit of FIlter---
        ImageIcon totalIcon = new ImageIcon("D:\\projectJava\\src\\GUI\\img\\dollar.png");
        Image imgMoney = totalIcon.getImage();
        imgMoney = imgMoney.getScaledInstance(20,20,Image.SCALE_SMOOTH);
        totalIcon = new ImageIcon(imgMoney);
        JLabel titleLimitTotal = new JLabel("Khoảng total",totalIcon,JLabel.LEFT);
        titleLimitTotal.setPreferredSize(new Dimension(150,30));
        JTextField limitTotalFrom = new JTextField(11);
        limitTotalFrom.setPreferredSize(new Dimension(0,25));
        JTextField limitTotalTo = new JTextField(11);
        limitTotalTo.setPreferredSize(new Dimension(0,25));
        JPanel containLimitTotal = new JPanel(new FlowLayout(FlowLayout.LEFT,4,0));
        containLimitTotal.setPreferredSize(new Dimension(245,60));
        containLimitTotal.add(titleLimitTotal);
        containLimitTotal.add(limitTotalFrom);
        containLimitTotal.add(new JLabel("đến"));
        containLimitTotal.add(limitTotalTo);



//        d------Choose Employee of Filter---
        ImageIcon employeesIcon = new ImageIcon("D:\\projectJava\\src\\GUI\\img\\nhanvien.png");
        Image imgEmployee = employeesIcon.getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH);
        employeesIcon = new ImageIcon(imgEmployee);
        JLabel titleContainEmployeeFilter = new JLabel("Nhân viên ",employeesIcon,JLabel.LEFT);
        JTextField inputEmployeeToFilter = new JTextField(13);
        inputEmployeeToFilter.setPreferredSize(new Dimension(0,25));
        JPanel containEmployeeFilter = new JPanel(new FlowLayout());
        containEmployeeFilter.add(titleContainEmployeeFilter);
        containEmployeeFilter.add(new JLabel("    "));
        containEmployeeFilter.add(inputEmployeeToFilter);


//        e------choose Account of Filter---
        ImageIcon userIcon = new ImageIcon("D:\\projectJava\\src\\GUI\\img\\user.png");
        Image imgUser = userIcon.getImage().getScaledInstance(19,19,Image.SCALE_SMOOTH);
        userIcon = new ImageIcon(imgUser);
        titleContainAccountFilter = new JLabel("Tên tài khoản ",userIcon,JLabel.LEFT);
        inputAccountToFilter = new JTextField(13);
        inputAccountToFilter.setPreferredSize(new Dimension(0,25));
        containAccountFilter = new JPanel(new FlowLayout());
        containAccountFilter.add(titleContainAccountFilter);
        containAccountFilter.add(new JLabel(""));
        containAccountFilter.add(inputAccountToFilter);


//        f----choose Computer of FIlter
        ImageIcon computerIcon = new ImageIcon("D:\\projectJava\\src\\GUI\\img\\monitor.png");
        Image imgComputerIcon = computerIcon.getImage();
        imgComputerIcon = imgComputerIcon.getScaledInstance(20,20,Image.SCALE_SMOOTH);
        computerIcon = new ImageIcon(imgComputerIcon);
        titleComputerFilter = new JLabel("Chọn máy",computerIcon,JLabel.CENTER);
        setPaddingJLabel(0,0,0,24,titleComputerFilter);
        computer = new JComboBox();
        computer.setPreferredSize(new Dimension(120,25));
        for(int i = 1; i <= 20;i++){
            computer.addItem("May "+ i);
        }
        containComputerFilter = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        containComputerFilter.setBorder(BorderFactory.createLineBorder(Color.red));
        containComputerFilter.setPreferredSize(new Dimension(245,40));
        containComputerFilter.add(titleComputerFilter);
        containComputerFilter.add(computer);


//        g------button cancel and shearch ----
        btnCancel = new JButton("Cancel");
        btnCancel.setPreferredSize(new Dimension(100,35));
        btnCancel.setFocusPainted(false);
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        setPaddingJButton(0,0,0,0,btnCancel);
        btnSearch = new JButton("Search");
        btnSearch.setPreferredSize(new Dimension(100,35));
        btnSearch.setFocusPainted(false);
        btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        setPaddingJButton(0,0,0,0,btnSearch);
        JPanel containActionInFilter = new JPanel(new FlowLayout());
        containActionInFilter.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0,0,0,1)),
                BorderFactory.createEmptyBorder(30,0,0,0)
        ));
        containActionInFilter.add(btnCancel);
        containActionInFilter.add(new JLabel("  "));
        containActionInFilter.add(btnSearch);


        JPanel managerInvoiceFilter = new JPanel(new FlowLayout());
        managerInvoiceFilter.setPreferredSize(new Dimension(250,498));
        managerInvoiceFilter.setBorder(BorderFactory.createMatteBorder(0,0,0,2,new Color(42,121,255)));
        managerInvoiceFilter.add(containTitleFilter);
        managerInvoiceFilter.add(containLimitDate);
        managerInvoiceFilter.add(containLimitTotal);
        managerInvoiceFilter.add(containComputerFilter);
        managerInvoiceFilter.add(containAccountFilter);
        managerInvoiceFilter.add(containEmployeeFilter);
        managerInvoiceFilter.add((containActionInFilter));

//        1--------Body Filter for search end------




//        2--------Body show list invoice-start-----

//            a----Hoa don ban----
        listInvoiceModelExport = new DefaultTableModel();
        listInvoiceModelExport.addColumn("ID");
        listInvoiceModelExport.addColumn("Tên tài khoản");
        listInvoiceModelExport.addColumn("Ngày tạo");
        listInvoiceModelExport.addColumn("Tổng tiền");
        listInvoiceModelExport.addColumn("Trạng thái");
        listInvoiceModelExport.addColumn("Người tạo");
        listInvoiceModelExport.addColumn("Máy");
        listInvoiceModelExport.addColumn("#");
        ImageIcon operationIcon = new ImageIcon("D:\\projectJava\\src\\GUI\\img\\menu.png");
        Image imgOperationIcon = operationIcon.getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH);
//        operationIcon = new ImageIcon(imgOperationIcon);

        //thu nghiem them vai hang du lieu vao ban
        listInvoiceModelExport.addRow(new Object[]{"HD001","Jam holy","13-12-2022","120.000 Đ","Da xu ly","NV001","May 01"});
        listInvoiceModelExport.addRow(new Object[]{"HD001","Jam holy","13-12-2022","120.000 Đ","Da xu ly","NV001","May 01"});
        listInvoiceModelExport.addRow(new Object[]{"HD001","Jam holy","13-12-2022","120.000 Đ","Da xu ly","NV001","May 01"});
        listInvoiceModelExport.addRow(new Object[]{"HD001","Jam holy","13-12-2022","120.000 Đ","Da xu ly","NV001","May 01"});


        listInvoiceExport = new JTable();
        listInvoiceExport.setModel(listInvoiceModelExport);
        listInvoiceExport.getTableHeader().setPreferredSize(new Dimension(0,40));
        listInvoiceExport.getTableHeader().setFont(new Font("serif",Font.BOLD,17));
        listInvoiceExport.getColumnModel().getColumn(0).setPreferredWidth(50);
        listInvoiceExport.getColumnModel().getColumn(1).setPreferredWidth(100);
        listInvoiceExport.getColumnModel().getColumn(2).setPreferredWidth(100);
        listInvoiceExport.getColumnModel().getColumn(3).setPreferredWidth(100);
        listInvoiceExport.getColumnModel().getColumn(4).setPreferredWidth(100);
        listInvoiceExport.getColumnModel().getColumn(5).setPreferredWidth(100);
        listInvoiceExport.getColumnModel().getColumn(6).setPreferredWidth(100);
        listInvoiceExport.getColumnModel().getColumn(7).setPreferredWidth(10);
        listInvoiceExport.setRowHeight(30);


//        b----Hoa don nhap ---
        listInvoiceModelImport = new DefaultTableModel();
        listInvoiceModelImport.addColumn("ID");
        listInvoiceModelImport.addColumn("Ngày tạo");
        listInvoiceModelImport.addColumn("Tổng tiền");
        listInvoiceModelImport.addColumn("Người tạo");
        listInvoiceModelImport.addColumn("Trạng thái");
        listInvoiceModelImport.addColumn("#");


        //thu nghiem them vai hang du lieu vao ban
        listInvoiceModelImport.addRow(new Object[]{"HDN001","13-12-2022","120.000 Đ","NV001","Da xu ly"});
        listInvoiceModelImport.addRow(new Object[]{"HDN001","13-12-2022","120.000 Đ","NV001","Da xu ly"});
        listInvoiceModelImport.addRow(new Object[]{"HDN001","13-12-2022","120.000 Đ","NV001","Da xu ly"});
        listInvoiceModelImport.addRow(new Object[]{"HDN001","13-12-2022","120.000 Đ","NV001","Da xu ly"});


        listInvoiceImport = new JTable();
        listInvoiceImport.setModel(listInvoiceModelImport);
        listInvoiceImport.getTableHeader().setPreferredSize(new Dimension(0,40));
        listInvoiceImport.getTableHeader().setFont(new Font("serif",Font.BOLD,17));
        listInvoiceImport.setRowHeight(30);





        listInvoiceScrollPane = new JScrollPane();

        JPanel containListInvoice = new JPanel(new GridLayout(1,1));
        containListInvoice.setPreferredSize(new Dimension(910,498));
        containListInvoice.add(listInvoiceScrollPane);

        titleContainShowListInvoice = new JLabel("Danh sach hoa don ban",JLabel.CENTER);
        titleContainShowListInvoice.setFont(new Font("serif",Font.BOLD,25));
        JPanel containTitleListInvoice = new JPanel(new GridLayout(1,1));
        containTitleListInvoice.add(titleContainShowListInvoice);



        JPanel containShowListInvoice = new JPanel(new FlowLayout(FlowLayout.CENTER,20,15));
        containShowListInvoice.setPreferredSize(new Dimension(945,495));
        containShowListInvoice.add(containTitleListInvoice);
        containShowListInvoice.add(containListInvoice);
//        2-------Body show list invoice-end-----


        managerInvoiceBody = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
        managerInvoiceBody.add(managerInvoiceFilter);
        managerInvoiceBody.add(containShowListInvoice);
//        managerInvoiceBody.setBorder(BorderFactory.createLineBorder(Color.red));
//        MANAGER BODY END

        managerInvoiceContentPane = new JPanel();
        managerInvoiceContentPane.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        sizeInComputer(managerInvoiceContentPane);
        managerInvoiceContentPane.setBorder(BorderFactory.createMatteBorder(0,2,2,2,new Color(42,121,255)));
        managerInvoiceContentPane.add(managerInvoiceHeader);
        managerInvoiceContentPane.add(managerInvoiceBody);
        this.getContentPane().add(managerInvoiceContentPane);
        this.setVisible(true);
    }



    public void event(){
        actionShowInvoiceImport.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                actionShowInvoiceImport.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(0,0,2,0,Color.WHITE),
                        BorderFactory.createEmptyBorder(50,0,5,0)
                ));
                actionShowInvoiceExport.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(0,0,0,1)),
                        BorderFactory.createEmptyBorder(50,0,5,0)
                ));

                titleContainShowListInvoice.setText("Danh sách hóa đơn nhập");
                computer.setEnabled(false);
                titleComputerFilter.setEnabled(false);
                titleContainAccountFilter.setEnabled(false);
                inputAccountToFilter.setEnabled(false);
            }
        });

        actionShowInvoiceExport.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                actionShowInvoiceExport.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(0,0,2,0,Color.WHITE),
                        BorderFactory.createEmptyBorder(50,0,5,0)
                ));
                actionShowInvoiceImport.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(0,0,0,1)),
                        BorderFactory.createEmptyBorder(50,0,5,0)
                ));

                titleContainShowListInvoice.setText("Danh sách hóa đơn bán");
                computer.setEnabled(true);
                titleComputerFilter.setEnabled(true);
                titleContainAccountFilter.setEnabled(true);
                inputAccountToFilter.setEnabled(true);
            }
        });


        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });


    }

    public static void main(String[] args){
        ManagerInvoice quanlyhoadon = new ManagerInvoice();
        quanlyhoadon.initManagerInvoice();
        quanlyhoadon.event();
    }
}
