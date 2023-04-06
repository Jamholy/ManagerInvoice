package GUI;

import javax.swing.*;
import java.awt.*;

public class ListProduct extends JFrame {
    public ListProduct(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width,screen.height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void createCartProduct(String path){
        //path dung de chua duong link cua san pham
        //hinh anh san pham
        //ten san pham
    }

    public void initComponent(){
        JLabel titleListProduct = new JLabel("Cho san pham ban",JLabel.CENTER);
        titleListProduct.setFont(new Font("serif",Font.BOLD,30));
        titleListProduct.setPreferredSize(new Dimension(400,50));
        titleListProduct.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(42,121,255)));




        JPanel containProduct = new JPanel(new GridLayout(2,4,10,10));
        containProduct.setPreferredSize(new Dimension(700,350));
        for(int i = 0; i < 8; i++){
            JButton btn = new JButton("BUTTON" + i);
            containProduct.add(btn);
        }
//        JPanel containOperation = new JPanel();


        JPanel listProductContentPane = new JPanel(new FlowLayout(FlowLayout.CENTER,0,20));
        listProductContentPane.setPreferredSize(new Dimension(800,600));
        listProductContentPane.add(titleListProduct);
        listProductContentPane.add(containProduct);
        listProductContentPane.add(containProduct);
        this.add(listProductContentPane);
        this.setLayout(new GridLayout(1,1));
        this.setVisible(true);
    }
    public static  void main(String[] args){
        ListProduct danhsachsanpha = new ListProduct();
        danhsachsanpha.initComponent();
    }
}
