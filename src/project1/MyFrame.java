package project1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 정현진
 */
public class MyFrame extends JFrame implements ActionListener{
    SubFrame sub;
    SubFrame1 sub2;
    Container contentPane;
    ImageIcon img;
    JLabel label = new JLabel();
    public MyFrame(){
        setTitle("유기견조");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color color = new Color(247,238,231); // 바탕색
        Color color2=new Color(252,195,192); // 분홍색
        
        contentPane = getContentPane();
        //contentPane.setLayout(new FlowLayout());
        contentPane.setBackground(color);
       
        label.setText("유기동물");
        label.setFont(new Font("배달의민족 도현",50,35));
        label.setForeground(color2);
        label.setSize(500,100);
        label.setLocation(200,0);
        contentPane.add(label);
        
        img = new ImageIcon("C:\\javaproject\\dog.jfif");
        
        //Image image = img.getImage();
        //setIconImage(image); // ?아이콘 바꿔줌 ;;
        
        JLabel image2= new JLabel(img);
        image2.setBounds(0, 75, 550, 645);
        contentPane.add(image2);
        
        contentPane.setLayout(null);
        
        
        JButton b = new JButton("유기동물조회");
        b.setFont(new Font("배달의민족 도현",Font.PLAIN,25));
        b.setBackground(color2);
        b.setForeground(Color.WHITE);
        b.setLocation(60,505);
        b.setSize(180,180);
        b.setBorderPainted(false); //외곽선 없애줌
        b.setFocusPainted(false); // 버튼이 선택되었을 때 생기는 테두리 사용안함
        contentPane.add(b);
        
        JButton b2 = new JButton("신고 게시판");
        b2.setFont(new Font("배달의민족 도현",Font.PLAIN,25));
        b2.setBackground(color2);
        b2.setForeground(Color.WHITE);
        b2.setLocation(325,505);
        b2.setSize(180,180);
        b2.setBorderPainted(false);
        b2.setFocusPainted(false);
        contentPane.add(b2);
        
        b.addActionListener(this);
        b2.addActionListener(this); // 이벤트 설정
        
        sub=new SubFrame();
        sub2 = new SubFrame1();
        
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sub.setVisible(true);
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sub2.setVisible(true);
            }
        });
        
        setSize(565,765); // 창크기
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(e);
    }
    
}
