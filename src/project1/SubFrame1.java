/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;


/**
 *
 * @author 태건
 */

import java.awt.Canvas;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class SubFrame1 extends JFrame implements ActionListener{   //
    
    Container contentPane;
    String [] place;
    
 Vector<Vector<String>> rowData;
 JTable table;
 JTextField tf01;  //텍스트에 적을값 3가지로 선언
 JTextField tf02;
 JTextField tf03;
 
    JLabel text = new JLabel();
    JLabel text2 = new JLabel();
    JLabel text3 = new JLabel();
    
 
    SubFrame1(){
        setTitle("신고게시판");
        contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        Color color = new Color(247,238,231);
        contentPane.setBackground(color);
        
        text.setText("     고유번호 : ");
        text.setFont(new Font("배달의민족 도현",50,37));
        text.setSize(100,150);
        
        text2.setText("     품종 : ");
        text2.setFont(new Font("배달의민족 도현",50,37));
        text2.setSize(100,150);
        
        text3.setText(" 발견한 날짜 : ");
        text3.setFont(new Font("배달의민족 도현",50,37));
        text3.setSize(100,150);
        
        setSize(500,500);
        setLayout(new GridLayout(2, 1));
  
  rowData = new Vector<Vector<String>>();
  Vector<String> colData = new Vector<String>();
  
  colData.add("고유번호");//dno
  colData.add("품종");//dname
  colData.add("발견한날");//dloc
  
  table = new JTable(rowData,colData);
  JScrollPane jsp = new JScrollPane(table);
  table.setRowHeight(25);
  add(jsp);
  
  JPanel p1 = new JPanel(); //p1의 JPanel생성   
  p1.setLayout(new GridLayout(3, 2));   //
  tf01 = new JTextField(10);
  tf02 = new JTextField(10);
  tf03 = new JTextField(10);
  p1.setBackground(color);
   
  p1.add(text);
  p1.setLocation(100, 500);
  p1.add(tf01);
  p1.add(text2);
  p1.add(tf02);
  p1.add(text3);
  p1.add(tf03);  
  
  JPanel p2 = new JPanel();
  p2.setLayout(new FlowLayout());
  p2.setBackground(color);
  
  JButton btn01 = new JButton("목록");
  Color color2=new Color(252,195,192);
        
        btn01.setFont(new Font("배달의민족 도현",50,25));
        btn01.setBackground(color2);
        btn01.setForeground(Color.WHITE);
        btn01.setLocation(250,700);
        btn01.setSize(50,50);
        btn01.setBorderPainted(false);
        btn01.setFocusPainted(false);
        
  JButton btn02 = new JButton("등록");
        btn02.setFont(new Font("배달의민족 도현",50,25));
        btn02.setBackground(color2);
        btn02.setForeground(Color.WHITE);
        btn02.setLocation(300,700);
        btn02.setSize(50,50);
        btn02.setBorderPainted(false);
        btn02.setFocusPainted(false);
  JButton btn03 = new JButton("수정");
        btn03.setFont(new Font("배달의민족 도현",50,25));
        btn03.setBackground(color2);
        btn03.setForeground(Color.WHITE);
        btn03.setLocation(350,700);
        btn03.setSize(50,50);
        btn03.setBorderPainted(false);
        btn03.setFocusPainted(false);
  JButton btn04 = new JButton("삭제");
        btn04.setFont(new Font("배달의민족 도현",50,25));
        btn04.setBackground(color2);
        btn04.setForeground(Color.WHITE);
        btn04.setLocation(400,700);
        btn04.setSize(50,50);
        btn04.setBorderPainted(false);
        btn04.setFocusPainted(false);
        
  p2.add(btn01);
  p2.add(btn02);
  p2.add(btn03);
  p2.add(btn04);
  
  btn01.addActionListener(this);//목록보여주기
  btn02.addActionListener(this);//등록하기
  btn03.addActionListener(this);//수정하기
  btn04.addActionListener(this);//삭제하기
  
  
  JPanel p = new JPanel();
  p.setLayout(new BorderLayout());
  p.add(p1, BorderLayout.CENTER);
  p.add(p2, BorderLayout.SOUTH);
  
  add(p);
  

  
  
  
  table.addMouseListener(new MouseListener() {
      
      @Override
      public void mouseReleased(MouseEvent e) {
       // TODO Auto-generated method stub
       
      }
      
      @Override
      public void mousePressed(MouseEvent e) {
       
    
      }
      
     
      @Override
      public void mouseExited(MouseEvent e) {
       // TODO Auto-generated method stub
       
      }
      
      @Override
      public void mouseEntered(MouseEvent e) {
       // TODO Auto-generated method stub
       
      }
      
      @Override
      public void mouseClicked(MouseEvent e) {
      //마우스로 클릭한 행의 정보를 텍스트 필드로 가져오기 위해서 
       
       int selection=table.getSelectedRow();
       
       Vector<String> vc=rowData.get(selection);
       tf01.setText(vc.get(0));
      tf02.setText(vc.get(1));
      tf03.setText(vc.get(2));
        
      }
     });
     
  
  
 }
 
 @Override
 public void actionPerformed(ActionEvent e) {
  // TODO Auto-generated method stub
  
  String cmd = e.getActionCommand();
  
  switch(cmd)
  {
   case "목록":listDept();break;
   case "등록":insertDept();listDept();break;
   case "수정":updateDept();listDept();break;  
   case "삭제":deleteDept();listDept();break;
  }                                                          
 }
 
 
 
 //삭제하기
 private void deleteDept() {
 
  String no=tf01.getText();
  String name=tf02.getText();
  String deptno=tf03.getText();
  
  String sql="delete yougi where deptno=?";

  
  try{

      
   Connection conn = ConnectionProvider.getConnection();
   PreparedStatement psmt = conn.prepareStatement(sql);
   
   psmt.setString(1, deptno);

   
   
   int re = psmt.executeUpdate();
   
   
    if(re>0)
    {
     JOptionPane.showMessageDialog(this, " 정보를 삭제하였습니다");
     
    }
    else
    {
     
     JOptionPane.showMessageDialog(this, "삭제를 실패하였습니다");
    }
   
   
  }catch(Exception eee){ System.out.println(eee);}
  
 }

 
 
 //수정하기
 private void updateDept() {
  
 
  String no = tf01.getText();
  String name = tf02.getText();
  String deptno = tf03.getText();
  

  
  String sql="update yougi set no=?,name=? where deptno=?";
  
  
 try{
   
   Connection conn = ConnectionProvider.getConnection();
   PreparedStatement psmt = conn.prepareStatement(sql);
   
 
   psmt.setString(1, no);
   psmt.setString(2, name);
   psmt.setString(3, deptno);

    

   
   int re = psmt.executeUpdate();
   
   
    if(re>0)
    {
     JOptionPane.showMessageDialog(this, "정보를 수정하였습니다");
     
    }
    else
    {
     
     JOptionPane.showMessageDialog(this, "수정을 실패하였습니다");
     
    }
   
 }catch(Exception ea){
  
  System.out.println(ea);
 }
 
 //System.out.println(dno);
// System.out.println(dname);
//System.out.println(dloc);
 
 
 table.updateUI();

}
 
 
 //등록하기
 private void insertDept() {
  
  
  String dno = tf01.getText();
  String dname = tf02.getText();
  String dloc = tf03.getText();
  
  String sql = "insert into yougi values(?,?,?)";
  
  try{
   
   Connection conn = ConnectionProvider.getConnection();


   PreparedStatement psmt = conn.prepareStatement(sql);
//Statement를 통하여 sql문장을 실행한다.   
   psmt.setString(1, dno);
   psmt.setString(2, dname);
   psmt.setString(3, dloc);
   
   int re = psmt.executeUpdate();
   
   if(re==1)
   {
    JOptionPane.showMessageDialog(this, "정보를 등록하였습니다");
    
   }
   else{
    
    JOptionPane.showMessageDialog(this, "등록을 실패하였습니다");
    
   }
  
   ConnectionProvider.coles(null, psmt, conn);
   
   tf01.setText("");
   tf02.setText("");
   tf03.setText("");
   
  
  }catch(Exception e){
   
   
  }
 }
 

  //목록 보여주기
 private void listDept() {
  // TODO Auto-generated method stub
  
  String sql = "select * from yougi";
  try{  
   rowData.clear();
   
   Connection conn = ConnectionProvider.getConnection();
   Statement stmt =conn.createStatement();
   ResultSet rs = stmt.executeQuery(sql);
   while(rs.next())////검색한 레코드가 있는 만큼 반복수행하기 위하여(질의문이 select일 때 사용)
   {
    Vector<String> v = new Vector<String>();
    v.add(rs.getString(1));
    v.add(rs.getString(2));
    v.add(rs.getString(3));
    
    rowData.add(v);
   }
   table.updateUI();
   ConnectionProvider.coles(rs, stmt, conn);
   
  }catch(Exception e)
  {
   System.out.println(e);
  }
  
 }
        
}
    
    
    
    
