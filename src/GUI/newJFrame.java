package GUI;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class newJFrame extends JFrame {
    public newJFrame(){
        this.setSize(700,300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    public void initComponent(){
        JLabel titleCreateInvoiceExport = new JLabel("Tạo hóa đơn bán",JLabel.CENTER);//tieu de cua khung tao hoa don
        titleCreateInvoiceExport.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(42,121,255)));
        titleCreateInvoiceExport.setFont(new Font("serif",Font.BOLD,25));
        titleCreateInvoiceExport.setPreferredSize(new Dimension(400,40));



        //JDateChooser
        JLabel lbDateCreateInvoice = new JLabel("Ngay tao");
        JDateChooser dateCreateInvoice = new JDateChooser();
        JPanel containDateCreateInvoice = new JPanel();
        containDateCreateInvoice.setBorder(BorderFactory.createLineBorder(Color.red));
        containDateCreateInvoice.add(lbDateCreateInvoice);
        containDateCreateInvoice.add(dateCreateInvoice);


        //Compobox de chon may(se lam vo hieu hoa khi ma hoa don la hoa don nhap hang)
        JLabel lbComputer = new JLabel("Tao cho may");
        JComboBox createComputerId = new JComboBox();
        JPanel containCreateComputerId = new JPanel();
        containCreateComputerId.add(lbComputer);
        containCreateComputerId.add(createComputerId);


        //Compobox de cho ten tai khoan ne(lam vo hieu hoa khi ma hoa don la hoa doen nhap hang)
        JLabel lbCreateAccount = new JLabel("Tao cho tai khoan");
        JComboBox createAccount = new JComboBox();
        JPanel containCreateAccount = new JPanel();
        containCreateAccount.add(lbCreateAccount);
        containCreateAccount.add(createAccount);


        JCheckBox products = new JCheckBox();
        JPanel containInputData = new JPanel();//chua nhung compunent de nhap thong tin hao don
        containInputData.setPreferredSize(new Dimension(700,100));
        containInputData.setBorder(BorderFactory.createLineBorder(Color.red));
        containInputData.add(containDateCreateInvoice);
        containInputData.add(containCreateComputerId);
        containInputData.add(containCreateAccount);
//        containInputData.add(products);


        JButton btnGoOut = new JButton("Thoat");//de thoat khoi mang hinh tao hao don
        JButton btnGoBack = new JButton("Quay lai");//de quay lai khung cho hoa don tao
        JButton btnRemove = new JButton("Loai bo");//de loai bo tat ca cac thogn tin vua nhap
        JButton btnGoTo = new JButton("Tiếp tục");//de xem thogn tin hao don vua tao
        JPanel containOperation = new JPanel(new FlowLayout(FlowLayout.CENTER));//chua nhung tac vu
        containOperation.add(btnGoOut);
        containOperation.add(btnGoBack);
        containOperation.add(btnRemove);
        containOperation.add(btnGoTo);


        JPanel createInvoiceExport = new JPanel();
        createInvoiceExport.setLayout(new FlowLayout(FlowLayout.CENTER,0,15));
        createInvoiceExport.add(titleCreateInvoiceExport);
        createInvoiceExport.add(containInputData);
        createInvoiceExport.add(containOperation);
        this.add(createInvoiceExport);
        this.setLayout(new GridLayout(1,1));
        this.setVisible(true);

    }

    public static void main(String[] args){
        newJFrame my = new newJFrame();
        my.initComponent();
    }
}
