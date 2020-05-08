/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author 정현진
 */
public class Execute extends JFrame {
     //private JTextField textField = new JTextField(30);
    //private JButton button = new JButton("검색");
    //private JPanel panel = new JPanel();
    private GoogleApi googleapi = new GoogleApi();
    private GoogleApi2 googleapi2 = new GoogleApi2();
    //private String location="서울";
    String[] loc={"서울","부산광역시","대구광역시"};
    //private String location = textField.getText();
    //private String location;
    //private JLabel googleMap;
    private JLabel googleMap = new JLabel();
    Container contentPane;
    JComboBox nameCombo = new JComboBox();
    JComboBox nameCombo2 = new JComboBox();
    String place;
    String place2;
    String x;
    String y;
    
    JLabel label = new JLabel();
    
    //ImageIcon image = new ImageIcon();

    public void setMap(String location,String location2){
        googleapi.downloadMap(location,location2);
        //googleMap = new JLabel(googleapi.getMap(location));
        googleMap.setIcon(googleapi.getMap(location,location2));
        googleapi.fileDelete(location,location2);
    }
    
    Execute(){
        
        contentPane = getContentPane();
        contentPane.setLayout(null);
        
        Color color = new Color(247,238,231);
        contentPane.setBackground(color);
        
        label.setText("유기동물 보호소 위치 조회");
        label.setFont(new Font("배달의민족 도현",50,35));
        label.setSize(500,100);
        label.setLocation(85,0);
        contentPane.add(label);
        
        try{
         String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upkind=417000&upr_cd=6260000&org_cd=3350000&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        Node current = null;
        String gumjeong = "금정구 보호소 : ";
        for(int i=0;i<1;i++){
            current = nodelist.item(i);
            NodeList testChildNodes = current.getChildNodes();
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="careAddr"){
                       place=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       place2=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                }
            }
        }
        nameCombo.addItem(gumjeong+place+place2);
        ///////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
        try{
            gangseoplace();
        }catch(Exception e){
          e.printStackTrace();
        }
        try{
            gijangplace();
        }catch(Exception e){
          e.printStackTrace();
        }
        try{
            namguplace();
        }catch(Exception e){
          e.printStackTrace();
        }
        try{
            dongguplace();
        }catch(Exception e){
          e.printStackTrace();
        }
        try{
            dongraeplace();
        }catch(Exception e){
          e.printStackTrace();
        }
        try{
            jinguplace();
        }catch(Exception e){
          e.printStackTrace();
        }
        try{
            bukguplace();
        }catch(Exception e){
          e.printStackTrace();
        }
        try{
            sasangplace();
        }catch(Exception e){
          e.printStackTrace();
        }
        try{
            sahaplace();
        }catch(Exception e){
          e.printStackTrace();
        }
        try{
            seoguplace();
        }catch(Exception e){
          e.printStackTrace();
        }
        try{
            suyeongplace();
        }catch(Exception e){
          e.printStackTrace();
        }
        try{
            yeonjeplace();
        }catch(Exception e){
          e.printStackTrace();
        }
        try{
            yeongdoplace();
        }catch(Exception e){
          e.printStackTrace();
        }
        try{
            jungguplace();
        }catch(Exception e){
          e.printStackTrace();
        }
        try{
            haeundaeplace();
        }catch(Exception e){
          e.printStackTrace();
        }
        
        nameCombo.setSelectedItem(null);
        nameCombo.setBounds(50, 80, 500, 25);
        contentPane.add(nameCombo);
       
        googleMap.setSize(600,700);
        googleMap.setLocation(0,100);
        contentPane.add(googleMap);
        
        //add(BorderLayout.NORTH,nameCombo);
        //add(BorderLayout.SOUTH,googleMap);
        
        //contentPane.add(googleMap);
        //add(googleMap);
       // nameCombo.setSeletedItem(null);
        nameCombo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ev) {
                //Object obj = ev.getItem(); 문자로 출력할 때 용이
                //System.out.println(obj);
                if(ev.getStateChange()==ItemEvent.SELECTED){
                 int index=nameCombo.getSelectedIndex();
                 String str=nameCombo.getSelectedItem().toString();
                 System.out.println(index);
                 /////
                 if(index==0){ // 콤보박스에서 선택한 값이 1이면
                    //System.out.println("서울특별시"); //콘손창에 서울특별시 출력
                    //setMap(str);
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 /////
                 else if(index==1){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==2){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==3){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==4){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==5){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==6){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==7){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==8){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==9){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==10){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==11){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==12){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==13){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==14){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==15){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==16){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==17){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==18){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==19){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==20){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==21){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==22){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==23){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                 else if(index==24){
                    googleapi2.downloadMap2(str);
                    x=googleapi2.lat;
                    y=googleapi2.lng;
                    setMap(x,y);
                 }
                }
            }
        });
        setTitle("Google Maps");
        //setResizable(false);
        //setVisible(true);
        setSize(600,800);
        
    }
    public void gangseoplace(){
        try{
         String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upkind=417000&upr_cd=6260000&org_cd=3360000&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        Node current = null;
        String gumjeong = "강서구 보호소 : ";
        for(int i=0;i<1;i++){
            current = nodelist.item(i);
            NodeList testChildNodes = current.getChildNodes();
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="careAddr"){
                       place=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       place2=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                }
            }
        }
        nameCombo.addItem(gumjeong+place+place2);
        ///////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
     public void gijangplace(){
        try{
         String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upkind=417000&upr_cd=6260000&org_cd=3400000&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        Node current = null;
        String gumjeong = "기장군 보호소 : ";
        for(int i=0;i<1;i++){
            current = nodelist.item(i);
            NodeList testChildNodes = current.getChildNodes();
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="careAddr"){
                       place=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       place2=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                }
            }
        }
        nameCombo.addItem(gumjeong+place+place2);
        ///////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
      public void namguplace(){
        try{
         String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upkind=417000&upr_cd=6260000&org_cd=3310000&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        Node current = null;
        String gumjeong = "남구 보호소 : ";
        for(int i=0;i<1;i++){
            current = nodelist.item(i);
            NodeList testChildNodes = current.getChildNodes();
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="careAddr"){
                       place=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       place2=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                }
            }
        }
        nameCombo.addItem(gumjeong+place+place2);
        ///////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
    public void dongguplace(){
        try{
         String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upkind=417000&upr_cd=6260000&org_cd=3270000&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        Node current = null;
        String gumjeong = "동구 보호소 : ";
        for(int i=0;i<1;i++){
            current = nodelist.item(i);
            NodeList testChildNodes = current.getChildNodes();
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="careAddr"){
                       place=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       place2=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                }
            }
        }
        String place3="부산광역시 동구 구청로 1 동구청";
        nameCombo.addItem(gumjeong+place+place2);
        nameCombo.addItem(gumjeong+place3);
        ///////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
     public void dongraeplace(){
        try{
         String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upkind=417000&upr_cd=6260000&org_cd=3300000&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        Node current = null;
        String gumjeong = "동래구 보호소 : ";
        for(int i=0;i<1;i++){
            current = nodelist.item(i);
            NodeList testChildNodes = current.getChildNodes();
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="careAddr"){
                       place=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       place2=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                }
            }
        }
        String place3="부산 연제구 온천천남로 4 청조동물병원";
        String place4="부산광역시 해운대구 해운대로 1252(송정동) 누리동물병원";
        nameCombo.addItem(gumjeong+place+place2);
        nameCombo.addItem(gumjeong+place3);
        nameCombo.addItem(gumjeong+place4);
        ///////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
     }
      public void jinguplace(){
        try{
         String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upkind=417000&upr_cd=6260000&org_cd=3290000&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        Node current = null;
        String gumjeong = "진구 보호소 : ";
        for(int i=0;i<1;i++){
            current = nodelist.item(i);
            NodeList testChildNodes = current.getChildNodes();
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="careAddr"){
                       place=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       place2=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                }
            }
        }
        String place3 = "부산광역시 강서구 대저2동 5443-14 부산동물보호센터";
        nameCombo.addItem(gumjeong+place+place2);
        nameCombo.addItem(gumjeong+place3);
        ///////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
       public void bukguplace(){
        try{
         String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upkind=417000&upr_cd=6260000&org_cd=3320000&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        Node current = null;
        String gumjeong = "북구 보호소 : ";
        for(int i=0;i<1;i++){
            current = nodelist.item(i);
            NodeList testChildNodes = current.getChildNodes();
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="careAddr"){
                       place=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       place2=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                }
            }
        }
        String place3 = "부산광역시 강서구 대저2동 5443-14 부산동물보호센터";
        nameCombo.addItem(gumjeong+place+place2);
        nameCombo.addItem(gumjeong+place3);
        ///////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
        public void sasangplace(){
        try{
         String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upkind=417000&upr_cd=6260000&org_cd=3390000&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        Node current = null;
        String gumjeong = "사상구 보호소 : ";
        for(int i=0;i<1;i++){
            current = nodelist.item(i);
            NodeList testChildNodes = current.getChildNodes();
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="careAddr"){
                       place=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       place2=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                }
            }
        }
        nameCombo.addItem(gumjeong+place+place2);
        ///////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
       public void sahaplace(){
        try{
         String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upkind=417000&upr_cd=6260000&org_cd=3340000&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        Node current = null;
        String gumjeong = "사하구 보호소 : ";
        for(int i=0;i<1;i++){
            current = nodelist.item(i);
            NodeList testChildNodes = current.getChildNodes();
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="careAddr"){
                       place=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       place2=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                }
            }
        }
        String place3 = "부산광역시 강서구 대저2동 5443-14 부산동물보호센터";
        nameCombo.addItem(gumjeong+place+place2);
        nameCombo.addItem(gumjeong+place3);
        ///////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
        public void seoguplace(){
        try{
         String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upkind=417000&upr_cd=6260000&org_cd=3260000&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        Node current = null;
        String gumjeong = "서구 보호소 : ";
        for(int i=0;i<1;i++){
            current = nodelist.item(i);
            NodeList testChildNodes = current.getChildNodes();
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="careAddr"){
                       place=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       place2=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                }
            }
        }
        nameCombo.addItem(gumjeong+place+place2);
        ///////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
         public void suyeongplace(){
        try{
         String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upkind=417000&upr_cd=6260000&org_cd=3380000&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        Node current = null;
        String gumjeong = "수영구 보호소 : ";
        for(int i=0;i<1;i++){
            current = nodelist.item(i);
            NodeList testChildNodes = current.getChildNodes();
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="careAddr"){
                       place=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       place2=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                }
            }
        }
        String place3="부산광역시 수영구 남천동로 100 수영구청";
        nameCombo.addItem(gumjeong+place+place2);
        nameCombo.addItem(gumjeong+place3);
        ///////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
         }
     public void yeonjeplace(){
        try{
         String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upkind=417000&upr_cd=6260000&org_cd=3370000&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        Node current = null;
        String gumjeong = "연제구 보호소 : ";
        for(int i=0;i<1;i++){
            current = nodelist.item(i);
            NodeList testChildNodes = current.getChildNodes();
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="careAddr"){
                       place=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       place2=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                }
            }
        }
        String place3="부산광역시 해운대구 해운대로 1252(송정동) 누리동물병원";
        String place4="부산광역시 부산진구 서면문화로 27 부산광역시수의사회";
        nameCombo.addItem(gumjeong+place+place2);
        nameCombo.addItem(gumjeong+place3);
        nameCombo.addItem(gumjeong+place4);
        ///////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
     public void yeongdoplace(){
        try{
         String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upkind=417000&upr_cd=6260000&org_cd=3280000&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        Node current = null;
        String gumjeong = "영도구 보호소 : ";
        for(int i=0;i<1;i++){
            current = nodelist.item(i);
            NodeList testChildNodes = current.getChildNodes();
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="careAddr"){
                       place=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       place2=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                }
            }
        }
        nameCombo.addItem(gumjeong+place+place2);
        ///////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
      public void jungguplace(){
        try{
         String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upkind=417000&upr_cd=6260000&org_cd=3250000&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        Node current = null;
        String gumjeong = "중구 보호소 : ";
        for(int i=0;i<1;i++){
            current = nodelist.item(i);
            NodeList testChildNodes = current.getChildNodes();
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="careAddr"){
                       place=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       place2=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                }
            }
        }
        nameCombo.addItem(gumjeong+place+place2);
        ///////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
       public void haeundaeplace(){
        try{
         String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upkind=417000&upr_cd=6260000&org_cd=3330000&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        Node current = null;
        String gumjeong = "해운대구 보호소 : ";
        for(int i=0;i<1;i++){
            current = nodelist.item(i);
            NodeList testChildNodes = current.getChildNodes();
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="careAddr"){
                       place=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       place2=element.getTextContent();
                       //nameCombo.addItem(element.getTextContent());
                    }
                }
            }
        }
        nameCombo.addItem(gumjeong+place+place2);
        ///////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
}
