/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

/**
 *
 * @author 정현진
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.*;
import org.w3c.dom.*;

import java.util.Vector;

public class SubFrame extends JFrame implements ActionListener{
    Container contentPane;
    String [] place;
    JLabel label = new JLabel();
    JLabel label2 = new JLabel();
    
    TextField text = new TextField(6);
    
    DefaultListModel listModel = new DefaultListModel();
    JList list= new JList();
    JScrollPane scrollpane = new JScrollPane();
   
    Execute execute;
    
    SubFrame(){
        setTitle("유기동물 조회");
        Color color = new Color(247,238,231);
        //setDefaultCloseOperation(SubFrame.EXIT_ON_CLOSE);
        contentPane = getContentPane();
        contentPane.setBackground(color);
        
        ////수정부분 flowLayout을 null로 바꿈
        contentPane.setLayout(null);
        
        label.setText("부산광역시 유기견 정보 조회");
        label2.setText("시/군/구");
        //label3.setText("보호소 선택");
        
        
       // text.setFont(new Font("배달의민족 도현",50,20));
        text.setSize(200,50);
        text.setLocation(250, 80);
        contentPane.add(text);
        
        Color color2=new Color(252,195,192);
        JButton b2 = new JButton("보호소 위치");
        b2.setFont(new Font("배달의민족 도현",50,25));
        b2.setBackground(color2);
        b2.setForeground(Color.WHITE);
        b2.setLocation(250,480);
        b2.setSize(200,50);
        b2.setBorderPainted(false);
        b2.setFocusPainted(false);
        contentPane.add(b2);
        
        b2.addActionListener(this); // 이벤트 설정
        
        
        label.setFont(new Font("배달의민족 도현",50,35));
        label.setSize(500,100);
        label.setLocation(120,0);
        contentPane.add(label);
        
        label2.setFont(new Font("배달의민족 도현",50,20));
        label2.setSize(200,100);
        label2.setLocation(150,50);
        contentPane.add(label2);
       
        
        scrollpane.setBounds(100, 150, 505, 300);
        contentPane.add(scrollpane);
        
        text.addActionListener(this);
         
        execute=new Execute();
        
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                execute.setVisible(true);
            }
        });
        
        text.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String busan = text.getText();
                String [] name ={"금정구","강서구","기장군","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구"};
                if(name[0].equals(busan)){
                     listModel.clear();
                     System.out.println("부산광역시 금정구");
                     DDog();
                   }
                else if(name[1].equals(busan)){
                     System.out.println("부산광역시 강서구");
                     listModel.clear();
                     listModel.addElement(name[1]);
                      GangSeo();
                    }
                else if(name[2].equals(busan)){
                     System.out.println("부산광역시 기장군");
                     listModel.clear();
                     gijang();
                   }
                 else if(name[3].equals(busan)){
                     System.out.println("부산광역시 남구");
                     listModel.clear();
                     namgu();
                    }
                 else if(name[4].equals(busan)){
                     System.out.println("부산광역시 동구");
                     listModel.clear();
                     dong();
                   }
                 else if(name[5].equals(busan)){
                     System.out.println("부산광역시 동래구");
                      listModel.clear();
                      dongrae();
                     }
                else if(name[6].equals(busan)){
                     System.out.println("부산광역시 부산진구");
                     listModel.clear();
                     jingu();
                   }
                else if(name[7].equals(busan)){
                     System.out.println("부산광역시 부산북구");
                     listModel.clear();
                     bukgu();
                    }
                else if(name[8].equals(busan)){
                     System.out.println("부산광역시 사상구");
                     listModel.clear();
                     sasang();
                   }
                else if(name[9].equals(busan)){
                     System.out.println("부산광역시 사하구");
                     listModel.clear();
                     saha();
                   }
                else if(name[10].equals(busan)){
                      System.out.println("부산광역시 서구");
                      listModel.clear();
                      seo();
                   }
                else if(name[11].equals(busan)){
                      System.out.println("부산광역시 수영구");
                      listModel.clear();
                      suyeong();
                 }
                 else if(name[12].equals(busan)){
                      System.out.println("부산광역시 연제구");
                      listModel.clear();
                      yeonje();
                   }
                else if(name[13].equals(busan)){
                  System.out.println("부산광역시 영도구");
                  listModel.clear();
                  yeongdo();
               }
                else if(name[14].equals(busan)){
                  System.out.println("부산광역시 중구");
                  listModel.clear();
                  jung();
                }
                else if(name[15].equals(busan)){
                  System.out.println("부산광역시 해운대구");
                    listModel.clear();
                    haeundae();
                  }
             }
        
        });
        
        setSize(730,600);
         
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
    
    
    public void GangSeo(){
        try{
        String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upr_cd=6260000&org_cd=3360000&state=null&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        
        Node current = null;
        
        for(int i=0;i<nodelist.getLength();i++){
            current = nodelist.item(i);
            
            NodeList testChildNodes = current.getChildNodes();
            
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="age"){
                       //str1=element.getTextContent();
                       String age = "나이 : ";
                       listModel.addElement(age+element.getTextContent());
                    }
                    if(element.getTagName()=="happenPlace"){
                       //str1=element.getTextContent();
                       String place = "발견 장소 : ";
                       listModel.addElement(place+element.getTextContent());
                    }
                    if(element.getTagName()=="kindCd"){
                       //str2=element.getTextContent();
                       String kind = "품종 : ";
                       listModel.addElement(kind+element.getTextContent());
                    }
                    if(element.getTagName()=="colorCd"){
                       //str4=element.getTextContent();
                       String color="색상 : ";
                      listModel.addElement(color+element.getTextContent());
                    }
                    if(element.getTagName()=="neuterYn"){
                       //str4=element.getTextContent();
                      String neuter="중성화 여부(U : 미상,Y : 아니오,N : 예) : ";
                      listModel.addElement(neuter+element.getTextContent());
                    }
                    if(element.getTagName()=="sexCd"){
                       //str4=element.getTextContent();
                      String sex="성별(M : 수컷,F : 암컷,Q : 미상) : ";
                      listModel.addElement(sex+element.getTextContent());
                    }
                    if(element.getTagName()=="specialMark"){
                       //str2=element.getTextContent();
                       String special="특징 : ";
                       listModel.addElement(special+element.getTextContent());
                    }
                    if(element.getTagName()=="weight"){
                       //str2=element.getTextContent();
                       String weight="몸무게 : ";
                       listModel.addElement(weight+element.getTextContent());
                    }
                     if(element.getTagName()=="noticeSdt"){
                       //str2=element.getTextContent();
                       String sdt="공고시작일 : ";
                       listModel.addElement(sdt+element.getTextContent());
                    }
                      if(element.getTagName()=="noticeEdt"){
                       //str2=element.getTextContent();
                       String edt="공고종료일 : ";
                       listModel.addElement(edt+element.getTextContent());
                    }
                    if(element.getTagName()=="careAddr"){
                       //str3=element.getTextContent();
                       String addr="보호소 주소 : ";
                       listModel.addElement(addr+element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       //str3=element.getTextContent();
                       String nm="보호소 이름 : ";
                       listModel.addElement(nm+element.getTextContent());
                    }
                     if(element.getTagName()=="careTel"){
                       //str3=element.getTextContent();
                       String tel="보호소 전화번호 : ";
                       listModel.addElement(tel+element.getTextContent());
                    }
                     if(element.getTagName()=="chargeNm"){
                       //str3=element.getTextContent();
                       String name="담당자 : ";
                       listModel.addElement(name+element.getTextContent());
                    }
                      if(element.getTagName()=="officetel"){
                       //str3=element.getTextContent();
                       String officetel="담당자 전화번호 : ";
                       listModel.addElement(officetel+element.getTextContent());
                    }
                    if(element.getTagName()=="processState"){
                       //str6=element.getTextContent();
                       String state = "상태 : ";
                       listModel.addElement(state+element.getTextContent());
                    }
                }
            }
            listModel.addElement(" ");
            listModel.addElement("==================================================================");
            listModel.addElement(" ");
        }
        list.setModel(listModel);
        scrollpane.setViewportView(list);
        //////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
   
    public void DDog(){
         try {

	/*File fXmlFile = new File("C:\\Users\\정현진\\Desktop\\과제\\JAVA 파싱\\유기동물_정보를_조회.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
        
	
	doc.getDocumentElement().normalize();

	NodeList nList = doc.getElementsByTagName("item");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);

		
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

                        nameCombo4.addItem(eElement.getElementsByTagName("careAddr").item(0).getTextContent()); // 부산에 해당하는 시/군/구 데이터 값을 두번째 콤보박스에 넣기

		}
	}*/
        /////////////////////////
        String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upr_cd=6260000&org_cd=3350000&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        
        Node current = null;
        
        for(int i=0;i<nodelist.getLength();i++){
            current = nodelist.item(i);
            
            NodeList testChildNodes = current.getChildNodes();
            
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="age"){
                       //str1=element.getTextContent();
                       String age = "나이 : ";
                       listModel.addElement(age+element.getTextContent());
                    }
                    if(element.getTagName()=="happenPlace"){
                       //str1=element.getTextContent();
                       String place = "발견 장소 : ";
                       listModel.addElement(place+element.getTextContent());
                    }
                    if(element.getTagName()=="kindCd"){
                       //str2=element.getTextContent();
                       String kind = "품종 : ";
                       listModel.addElement(kind+element.getTextContent());
                    }
                    if(element.getTagName()=="colorCd"){
                       //str4=element.getTextContent();
                       String color="색상 : ";
                      listModel.addElement(color+element.getTextContent());
                    }
                    if(element.getTagName()=="neuterYn"){
                       //str4=element.getTextContent();
                      String neuter="중성화 여부(U : 미상,Y : 아니오,N : 예) : ";
                      listModel.addElement(neuter+element.getTextContent());
                    }
                    if(element.getTagName()=="sexCd"){
                       //str4=element.getTextContent();
                      String sex="성별(M : 수컷,F : 암컷,Q : 미상) : ";
                      listModel.addElement(sex+element.getTextContent());
                    }
                    if(element.getTagName()=="specialMark"){
                       //str2=element.getTextContent();
                       String special="특징 : ";
                       listModel.addElement(special+element.getTextContent());
                    }
                    if(element.getTagName()=="weight"){
                       //str2=element.getTextContent();
                       String weight="몸무게 : ";
                       listModel.addElement(weight+element.getTextContent());
                    }
                     if(element.getTagName()=="noticeSdt"){
                       //str2=element.getTextContent();
                       String sdt="공고시작일 : ";
                       listModel.addElement(sdt+element.getTextContent());
                    }
                      if(element.getTagName()=="noticeEdt"){
                       //str2=element.getTextContent();
                       String edt="공고종료일 : ";
                       listModel.addElement(edt+element.getTextContent());
                    }
                    if(element.getTagName()=="careAddr"){
                       //str3=element.getTextContent();
                       String addr="보호소 주소 : ";
                       listModel.addElement(addr+element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       //str3=element.getTextContent();
                       String nm="보호소 이름 : ";
                       listModel.addElement(nm+element.getTextContent());
                    }
                     if(element.getTagName()=="careTel"){
                       //str3=element.getTextContent();
                       String tel="보호소 전화번호 : ";
                       listModel.addElement(tel+element.getTextContent());
                    }
                     if(element.getTagName()=="chargeNm"){
                       //str3=element.getTextContent();
                       String name="담당자 : ";
                       listModel.addElement(name+element.getTextContent());
                    }
                      if(element.getTagName()=="officetel"){
                       //str3=element.getTextContent();
                       String officetel="담당자 전화번호 : ";
                       listModel.addElement(officetel+element.getTextContent());
                    }
                    if(element.getTagName()=="processState"){
                       //str6=element.getTextContent();
                       String state = "상태 : ";
                       listModel.addElement(state+element.getTextContent());
                    }
                }
            }
            listModel.addElement(" ");
            listModel.addElement("==================================================================");
            listModel.addElement(" ");
        }
        list.setModel(listModel);
        scrollpane.setViewportView(list);
        //////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
    public void gijang(){
        try{
        String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upr_cd=6260000&org_cd=3400000&state=null&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        
        Node current = null;
        for(int i=0;i<nodelist.getLength();i++){
            current = nodelist.item(i);
            
            NodeList testChildNodes = current.getChildNodes();
            
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="age"){
                       //str1=element.getTextContent();
                       String age = "나이 : ";
                       listModel.addElement(age+element.getTextContent());
                    }
                    if(element.getTagName()=="happenPlace"){
                       //str1=element.getTextContent();
                       String place = "발견 장소 : ";
                       listModel.addElement(place+element.getTextContent());
                    }
                    if(element.getTagName()=="kindCd"){
                       //str2=element.getTextContent();
                       String kind = "품종 : ";
                       listModel.addElement(kind+element.getTextContent());
                    }
                    if(element.getTagName()=="colorCd"){
                       //str4=element.getTextContent();
                       String color="색상 : ";
                      listModel.addElement(color+element.getTextContent());
                    }
                    if(element.getTagName()=="neuterYn"){
                       //str4=element.getTextContent();
                      String neuter="중성화 여부(U : 미상,Y : 아니오,N : 예) : ";
                      listModel.addElement(neuter+element.getTextContent());
                    }
                    if(element.getTagName()=="sexCd"){
                       //str4=element.getTextContent();
                      String sex="성별(M : 수컷,F : 암컷,Q : 미상) : ";
                      listModel.addElement(sex+element.getTextContent());
                    }
                    if(element.getTagName()=="specialMark"){
                       //str2=element.getTextContent();
                       String special="특징 : ";
                       listModel.addElement(special+element.getTextContent());
                    }
                    if(element.getTagName()=="weight"){
                       //str2=element.getTextContent();
                       String weight="몸무게 : ";
                       listModel.addElement(weight+element.getTextContent());
                    }
                     if(element.getTagName()=="noticeSdt"){
                       //str2=element.getTextContent();
                       String sdt="공고시작일 : ";
                       listModel.addElement(sdt+element.getTextContent());
                    }
                      if(element.getTagName()=="noticeEdt"){
                       //str2=element.getTextContent();
                       String edt="공고종료일 : ";
                       listModel.addElement(edt+element.getTextContent());
                    }
                    if(element.getTagName()=="careAddr"){
                       //str3=element.getTextContent();
                       String addr="보호소 주소 : ";
                       listModel.addElement(addr+element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       //str3=element.getTextContent();
                       String nm="보호소 이름 : ";
                       listModel.addElement(nm+element.getTextContent());
                    }
                     if(element.getTagName()=="careTel"){
                       //str3=element.getTextContent();
                       String tel="보호소 전화번호 : ";
                       listModel.addElement(tel+element.getTextContent());
                    }
                     if(element.getTagName()=="chargeNm"){
                       //str3=element.getTextContent();
                       String name="담당자 : ";
                       listModel.addElement(name+element.getTextContent());
                    }
                      if(element.getTagName()=="officetel"){
                       //str3=element.getTextContent();
                       String officetel="담당자 전화번호 : ";
                       listModel.addElement(officetel+element.getTextContent());
                    }
                    if(element.getTagName()=="processState"){
                       //str6=element.getTextContent();
                       String state = "상태 : ";
                       listModel.addElement(state+element.getTextContent());
                    }
                }
            }
            listModel.addElement(" ");
            listModel.addElement("==================================================================");
            listModel.addElement(" ");
        }
        list.setModel(listModel);
        scrollpane.setViewportView(list);
        //////////////////////////////////
    }
        catch (Exception e) {
	e.printStackTrace();
}
}
    public void namgu(){
        try{
        String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upr_cd=6260000&org_cd=3310000&state=null&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        
        Node current = null;
        
        for(int i=0;i<nodelist.getLength();i++){
            current = nodelist.item(i);
            
            NodeList testChildNodes = current.getChildNodes();
            
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="age"){
                       //str1=element.getTextContent();
                       String age = "나이 : ";
                       listModel.addElement(age+element.getTextContent());
                    }
                    if(element.getTagName()=="happenPlace"){
                       //str1=element.getTextContent();
                       String place = "발견 장소 : ";
                       listModel.addElement(place+element.getTextContent());
                    }
                    if(element.getTagName()=="kindCd"){
                       //str2=element.getTextContent();
                       String kind = "품종 : ";
                       listModel.addElement(kind+element.getTextContent());
                    }
                    if(element.getTagName()=="colorCd"){
                       //str4=element.getTextContent();
                       String color="색상 : ";
                      listModel.addElement(color+element.getTextContent());
                    }
                    if(element.getTagName()=="neuterYn"){
                       //str4=element.getTextContent();
                      String neuter="중성화 여부(U : 미상,Y : 아니오,N : 예) : ";
                      listModel.addElement(neuter+element.getTextContent());
                    }
                    if(element.getTagName()=="sexCd"){
                       //str4=element.getTextContent();
                      String sex="성별(M : 수컷,F : 암컷,Q : 미상) : ";
                      listModel.addElement(sex+element.getTextContent());
                    }
                    if(element.getTagName()=="specialMark"){
                       //str2=element.getTextContent();
                       String special="특징 : ";
                       listModel.addElement(special+element.getTextContent());
                    }
                    if(element.getTagName()=="weight"){
                       //str2=element.getTextContent();
                       String weight="몸무게 : ";
                       listModel.addElement(weight+element.getTextContent());
                    }
                     if(element.getTagName()=="noticeSdt"){
                       //str2=element.getTextContent();
                       String sdt="공고시작일 : ";
                       listModel.addElement(sdt+element.getTextContent());
                    }
                      if(element.getTagName()=="noticeEdt"){
                       //str2=element.getTextContent();
                       String edt="공고종료일 : ";
                       listModel.addElement(edt+element.getTextContent());
                    }
                    if(element.getTagName()=="careAddr"){
                       //str3=element.getTextContent();
                       String addr="보호소 주소 : ";
                       listModel.addElement(addr+element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       //str3=element.getTextContent();
                       String nm="보호소 이름 : ";
                       listModel.addElement(nm+element.getTextContent());
                    }
                     if(element.getTagName()=="careTel"){
                       //str3=element.getTextContent();
                       String tel="보호소 전화번호 : ";
                       listModel.addElement(tel+element.getTextContent());
                    }
                     if(element.getTagName()=="chargeNm"){
                       //str3=element.getTextContent();
                       String name="담당자 : ";
                       listModel.addElement(name+element.getTextContent());
                    }
                      if(element.getTagName()=="officetel"){
                       //str3=element.getTextContent();
                       String officetel="담당자 전화번호 : ";
                       listModel.addElement(officetel+element.getTextContent());
                    }
                    if(element.getTagName()=="processState"){
                       //str6=element.getTextContent();
                       String state = "상태 : ";
                       listModel.addElement(state+element.getTextContent());
                    }
                }
            }
            listModel.addElement(" ");
            listModel.addElement("==================================================================");
            listModel.addElement(" ");
        }
        list.setModel(listModel);
        scrollpane.setViewportView(list);
         } catch (Exception e) {
	e.printStackTrace();
}
}
    public void dong(){
        try{
        String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=20170901&endde=20171231&pageNo=1&numOfRows=100000000&ServiceKey=D2jrBH0XS98%2FwPf9yMCjve29GyRyoTj8L26%2BsRYrWPJP5%2B1cbEJ0X6ID0%2BqSNmcCvy8Qw06M1kzfiKzTP82jEw%3D%3D&upr_cd=6260000&org_cd=3270000";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        
        Node current = null;
        
        for(int i=0;i<nodelist.getLength();i++){
            current = nodelist.item(i);
            
            NodeList testChildNodes = current.getChildNodes();
            
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="age"){
                       //str1=element.getTextContent();
                       String age = "나이 : ";
                       listModel.addElement(age+element.getTextContent());
                    }
                    if(element.getTagName()=="happenPlace"){
                       //str1=element.getTextContent();
                       String place = "발견 장소 : ";
                       listModel.addElement(place+element.getTextContent());
                    }
                    if(element.getTagName()=="kindCd"){
                       //str2=element.getTextContent();
                       String kind = "품종 : ";
                       listModel.addElement(kind+element.getTextContent());
                    }
                    if(element.getTagName()=="colorCd"){
                       //str4=element.getTextContent();
                       String color="색상 : ";
                      listModel.addElement(color+element.getTextContent());
                    }
                    if(element.getTagName()=="neuterYn"){
                       //str4=element.getTextContent();
                      String neuter="중성화 여부(U : 미상,Y : 아니오,N : 예) : ";
                      listModel.addElement(neuter+element.getTextContent());
                    }
                    if(element.getTagName()=="sexCd"){
                       //str4=element.getTextContent();
                      String sex="성별(M : 수컷,F : 암컷,Q : 미상) : ";
                      listModel.addElement(sex+element.getTextContent());
                    }
                    if(element.getTagName()=="specialMark"){
                       //str2=element.getTextContent();
                       String special="특징 : ";
                       listModel.addElement(special+element.getTextContent());
                    }
                    if(element.getTagName()=="weight"){
                       //str2=element.getTextContent();
                       String weight="몸무게 : ";
                       listModel.addElement(weight+element.getTextContent());
                    }
                     if(element.getTagName()=="noticeSdt"){
                       //str2=element.getTextContent();
                       String sdt="공고시작일 : ";
                       listModel.addElement(sdt+element.getTextContent());
                    }
                      if(element.getTagName()=="noticeEdt"){
                       //str2=element.getTextContent();
                       String edt="공고종료일 : ";
                       listModel.addElement(edt+element.getTextContent());
                    }
                    if(element.getTagName()=="careAddr"){
                       //str3=element.getTextContent();
                       String addr="보호소 주소 : ";
                       listModel.addElement(addr+element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       //str3=element.getTextContent();
                       String nm="보호소 이름 : ";
                       listModel.addElement(nm+element.getTextContent());
                    }
                     if(element.getTagName()=="careTel"){
                       //str3=element.getTextContent();
                       String tel="보호소 전화번호 : ";
                       listModel.addElement(tel+element.getTextContent());
                    }
                     if(element.getTagName()=="chargeNm"){
                       //str3=element.getTextContent();
                       String name="담당자 : ";
                       listModel.addElement(name+element.getTextContent());
                    }
                      if(element.getTagName()=="officetel"){
                       //str3=element.getTextContent();
                       String officetel="담당자 전화번호 : ";
                       listModel.addElement(officetel+element.getTextContent());
                    }
                    if(element.getTagName()=="processState"){
                       //str6=element.getTextContent();
                       String state = "상태 : ";
                       listModel.addElement(state+element.getTextContent());
                    }
                }
            }
            listModel.addElement(" ");
            listModel.addElement("==================================================================");
            listModel.addElement(" ");
        }
        list.setModel(listModel);
        scrollpane.setViewportView(list);
        //////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
    public void dongrae(){
        try{
        String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?serviceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&bgnde=20170901&upr_cd=6260000&org_cd=3300000&state=null&pageNo=1&startPage=1&numOfRows=100&pageSize=100";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        
        Node current = null;
        
         for(int i=0;i<nodelist.getLength();i++){
            current = nodelist.item(i);
            
            NodeList testChildNodes = current.getChildNodes();
            
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="age"){
                       //str1=element.getTextContent();
                       String age = "나이 : ";
                       listModel.addElement(age+element.getTextContent());
                    }
                    if(element.getTagName()=="happenPlace"){
                       //str1=element.getTextContent();
                       String place = "발견 장소 : ";
                       listModel.addElement(place+element.getTextContent());
                    }
                    if(element.getTagName()=="kindCd"){
                       //str2=element.getTextContent();
                       String kind = "품종 : ";
                       listModel.addElement(kind+element.getTextContent());
                    }
                    if(element.getTagName()=="colorCd"){
                       //str4=element.getTextContent();
                       String color="색상 : ";
                      listModel.addElement(color+element.getTextContent());
                    }
                    if(element.getTagName()=="neuterYn"){
                       //str4=element.getTextContent();
                      String neuter="중성화 여부(U : 미상,Y : 아니오,N : 예) : ";
                      listModel.addElement(neuter+element.getTextContent());
                    }
                    if(element.getTagName()=="sexCd"){
                       //str4=element.getTextContent();
                      String sex="성별(M : 수컷,F : 암컷,Q : 미상) : ";
                      listModel.addElement(sex+element.getTextContent());
                    }
                    if(element.getTagName()=="specialMark"){
                       //str2=element.getTextContent();
                       String special="특징 : ";
                       listModel.addElement(special+element.getTextContent());
                    }
                    if(element.getTagName()=="weight"){
                       //str2=element.getTextContent();
                       String weight="몸무게 : ";
                       listModel.addElement(weight+element.getTextContent());
                    }
                     if(element.getTagName()=="noticeSdt"){
                       //str2=element.getTextContent();
                       String sdt="공고시작일 : ";
                       listModel.addElement(sdt+element.getTextContent());
                    }
                      if(element.getTagName()=="noticeEdt"){
                       //str2=element.getTextContent();
                       String edt="공고종료일 : ";
                       listModel.addElement(edt+element.getTextContent());
                    }
                    if(element.getTagName()=="careAddr"){
                       //str3=element.getTextContent();
                       String addr="보호소 주소 : ";
                       listModel.addElement(addr+element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       //str3=element.getTextContent();
                       String nm="보호소 이름 : ";
                       listModel.addElement(nm+element.getTextContent());
                    }
                     if(element.getTagName()=="careTel"){
                       //str3=element.getTextContent();
                       String tel="보호소 전화번호 : ";
                       listModel.addElement(tel+element.getTextContent());
                    }
                     if(element.getTagName()=="chargeNm"){
                       //str3=element.getTextContent();
                       String name="담당자 : ";
                       listModel.addElement(name+element.getTextContent());
                    }
                      if(element.getTagName()=="officetel"){
                       //str3=element.getTextContent();
                       String officetel="담당자 전화번호 : ";
                       listModel.addElement(officetel+element.getTextContent());
                    }
                    if(element.getTagName()=="processState"){
                       //str6=element.getTextContent();
                       String state = "상태 : ";
                       listModel.addElement(state+element.getTextContent());
                    }
                }
            }
            listModel.addElement(" ");
            listModel.addElement("==================================================================");
            listModel.addElement(" ");
        }
        list.setModel(listModel);
        scrollpane.setViewportView(list);
        //////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
    public void jingu(){
        try{
        String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=20170901&endde=20171231&pageNo=1&numOfRows=100000000&ServiceKey=D2jrBH0XS98%2FwPf9yMCjve29GyRyoTj8L26%2BsRYrWPJP5%2B1cbEJ0X6ID0%2BqSNmcCvy8Qw06M1kzfiKzTP82jEw%3D%3D&upr_cd=6260000&org_cd=3290000";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        
        Node current = null;
        
         for(int i=0;i<nodelist.getLength();i++){
            current = nodelist.item(i);
            
            NodeList testChildNodes = current.getChildNodes();
            
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="age"){
                       //str1=element.getTextContent();
                       String age = "나이 : ";
                       listModel.addElement(age+element.getTextContent());
                    }
                    if(element.getTagName()=="happenPlace"){
                       //str1=element.getTextContent();
                       String place = "발견 장소 : ";
                       listModel.addElement(place+element.getTextContent());
                    }
                    if(element.getTagName()=="kindCd"){
                       //str2=element.getTextContent();
                       String kind = "품종 : ";
                       listModel.addElement(kind+element.getTextContent());
                    }
                    if(element.getTagName()=="colorCd"){
                       //str4=element.getTextContent();
                       String color="색상 : ";
                      listModel.addElement(color+element.getTextContent());
                    }
                    if(element.getTagName()=="neuterYn"){
                       //str4=element.getTextContent();
                      String neuter="중성화 여부(U : 미상,Y : 아니오,N : 예) : ";
                      listModel.addElement(neuter+element.getTextContent());
                    }
                    if(element.getTagName()=="sexCd"){
                       //str4=element.getTextContent();
                      String sex="성별(M : 수컷,F : 암컷,Q : 미상) : ";
                      listModel.addElement(sex+element.getTextContent());
                    }
                    if(element.getTagName()=="specialMark"){
                       //str2=element.getTextContent();
                       String special="특징 : ";
                       listModel.addElement(special+element.getTextContent());
                    }
                    if(element.getTagName()=="weight"){
                       //str2=element.getTextContent();
                       String weight="몸무게 : ";
                       listModel.addElement(weight+element.getTextContent());
                    }
                     if(element.getTagName()=="noticeSdt"){
                       //str2=element.getTextContent();
                       String sdt="공고시작일 : ";
                       listModel.addElement(sdt+element.getTextContent());
                    }
                      if(element.getTagName()=="noticeEdt"){
                       //str2=element.getTextContent();
                       String edt="공고종료일 : ";
                       listModel.addElement(edt+element.getTextContent());
                    }
                    if(element.getTagName()=="careAddr"){
                       //str3=element.getTextContent();
                       String addr="보호소 주소 : ";
                       listModel.addElement(addr+element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       //str3=element.getTextContent();
                       String nm="보호소 이름 : ";
                       listModel.addElement(nm+element.getTextContent());
                    }
                     if(element.getTagName()=="careTel"){
                       //str3=element.getTextContent();
                       String tel="보호소 전화번호 : ";
                       listModel.addElement(tel+element.getTextContent());
                    }
                     if(element.getTagName()=="chargeNm"){
                       //str3=element.getTextContent();
                       String name="담당자 : ";
                       listModel.addElement(name+element.getTextContent());
                    }
                      if(element.getTagName()=="officetel"){
                       //str3=element.getTextContent();
                       String officetel="담당자 전화번호 : ";
                       listModel.addElement(officetel+element.getTextContent());
                    }
                    if(element.getTagName()=="processState"){
                       //str6=element.getTextContent();
                       String state = "상태 : ";
                       listModel.addElement(state+element.getTextContent());
                    }
                }
            }
            listModel.addElement(" ");
            listModel.addElement("==================================================================");
            listModel.addElement(" ");
        }
        list.setModel(listModel);
        scrollpane.setViewportView(list);
        //////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
    public void bukgu(){
        try{
        String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=20170901&endde=20171231&pageNo=1&numOfRows=100000000&ServiceKey=D2jrBH0XS98%2FwPf9yMCjve29GyRyoTj8L26%2BsRYrWPJP5%2B1cbEJ0X6ID0%2BqSNmcCvy8Qw06M1kzfiKzTP82jEw%3D%3D&upr_cd=6260000&org_cd=3320000";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        
        Node current = null;
        
         for(int i=0;i<nodelist.getLength();i++){
            current = nodelist.item(i);
            
            NodeList testChildNodes = current.getChildNodes();
            
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="age"){
                       //str1=element.getTextContent();
                       String age = "나이 : ";
                       listModel.addElement(age+element.getTextContent());
                    }
                    if(element.getTagName()=="happenPlace"){
                       //str1=element.getTextContent();
                       String place = "발견 장소 : ";
                       listModel.addElement(place+element.getTextContent());
                    }
                    if(element.getTagName()=="kindCd"){
                       //str2=element.getTextContent();
                       String kind = "품종 : ";
                       listModel.addElement(kind+element.getTextContent());
                    }
                    if(element.getTagName()=="colorCd"){
                       //str4=element.getTextContent();
                       String color="색상 : ";
                      listModel.addElement(color+element.getTextContent());
                    }
                    if(element.getTagName()=="neuterYn"){
                       //str4=element.getTextContent();
                      String neuter="중성화 여부(U : 미상,Y : 아니오,N : 예) : ";
                      listModel.addElement(neuter+element.getTextContent());
                    }
                    if(element.getTagName()=="sexCd"){
                       //str4=element.getTextContent();
                      String sex="성별(M : 수컷,F : 암컷,Q : 미상) : ";
                      listModel.addElement(sex+element.getTextContent());
                    }
                    if(element.getTagName()=="specialMark"){
                       //str2=element.getTextContent();
                       String special="특징 : ";
                       listModel.addElement(special+element.getTextContent());
                    }
                    if(element.getTagName()=="weight"){
                       //str2=element.getTextContent();
                       String weight="몸무게 : ";
                       listModel.addElement(weight+element.getTextContent());
                    }
                     if(element.getTagName()=="noticeSdt"){
                       //str2=element.getTextContent();
                       String sdt="공고시작일 : ";
                       listModel.addElement(sdt+element.getTextContent());
                    }
                      if(element.getTagName()=="noticeEdt"){
                       //str2=element.getTextContent();
                       String edt="공고종료일 : ";
                       listModel.addElement(edt+element.getTextContent());
                    }
                    if(element.getTagName()=="careAddr"){
                       //str3=element.getTextContent();
                       String addr="보호소 주소 : ";
                       listModel.addElement(addr+element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       //str3=element.getTextContent();
                       String nm="보호소 이름 : ";
                       listModel.addElement(nm+element.getTextContent());
                    }
                     if(element.getTagName()=="careTel"){
                       //str3=element.getTextContent();
                       String tel="보호소 전화번호 : ";
                       listModel.addElement(tel+element.getTextContent());
                    }
                     if(element.getTagName()=="chargeNm"){
                       //str3=element.getTextContent();
                       String name="담당자 : ";
                       listModel.addElement(name+element.getTextContent());
                    }
                      if(element.getTagName()=="officetel"){
                       //str3=element.getTextContent();
                       String officetel="담당자 전화번호 : ";
                       listModel.addElement(officetel+element.getTextContent());
                    }
                    if(element.getTagName()=="processState"){
                       //str6=element.getTextContent();
                       String state = "상태 : ";
                       listModel.addElement(state+element.getTextContent());
                    }
                }
            }
            listModel.addElement(" ");
            listModel.addElement("==================================================================");
            listModel.addElement(" ");
        }
        list.setModel(listModel);
        scrollpane.setViewportView(list);
        //////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
    public void sasang(){
        try{
        String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=20170901&endde=20171231&pageNo=1&numOfRows=100000000&ServiceKey=D2jrBH0XS98%2FwPf9yMCjve29GyRyoTj8L26%2BsRYrWPJP5%2B1cbEJ0X6ID0%2BqSNmcCvy8Qw06M1kzfiKzTP82jEw%3D%3D&upr_cd=6260000&org_cd=3390000";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        
        Node current = null;
        
         for(int i=0;i<nodelist.getLength();i++){
            current = nodelist.item(i);
            
            NodeList testChildNodes = current.getChildNodes();
            
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="age"){
                       //str1=element.getTextContent();
                       String age = "나이 : ";
                       listModel.addElement(age+element.getTextContent());
                    }
                    if(element.getTagName()=="happenPlace"){
                       //str1=element.getTextContent();
                       String place = "발견 장소 : ";
                       listModel.addElement(place+element.getTextContent());
                    }
                    if(element.getTagName()=="kindCd"){
                       //str2=element.getTextContent();
                       String kind = "품종 : ";
                       listModel.addElement(kind+element.getTextContent());
                    }
                    if(element.getTagName()=="colorCd"){
                       //str4=element.getTextContent();
                       String color="색상 : ";
                      listModel.addElement(color+element.getTextContent());
                    }
                    if(element.getTagName()=="neuterYn"){
                       //str4=element.getTextContent();
                      String neuter="중성화 여부(U : 미상,Y : 아니오,N : 예) : ";
                      listModel.addElement(neuter+element.getTextContent());
                    }
                    if(element.getTagName()=="sexCd"){
                       //str4=element.getTextContent();
                      String sex="성별(M : 수컷,F : 암컷,Q : 미상) : ";
                      listModel.addElement(sex+element.getTextContent());
                    }
                    if(element.getTagName()=="specialMark"){
                       //str2=element.getTextContent();
                       String special="특징 : ";
                       listModel.addElement(special+element.getTextContent());
                    }
                    if(element.getTagName()=="weight"){
                       //str2=element.getTextContent();
                       String weight="몸무게 : ";
                       listModel.addElement(weight+element.getTextContent());
                    }
                     if(element.getTagName()=="noticeSdt"){
                       //str2=element.getTextContent();
                       String sdt="공고시작일 : ";
                       listModel.addElement(sdt+element.getTextContent());
                    }
                      if(element.getTagName()=="noticeEdt"){
                       //str2=element.getTextContent();
                       String edt="공고종료일 : ";
                       listModel.addElement(edt+element.getTextContent());
                    }
                    if(element.getTagName()=="careAddr"){
                       //str3=element.getTextContent();
                       String addr="보호소 주소 : ";
                       listModel.addElement(addr+element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       //str3=element.getTextContent();
                       String nm="보호소 이름 : ";
                       listModel.addElement(nm+element.getTextContent());
                    }
                     if(element.getTagName()=="careTel"){
                       //str3=element.getTextContent();
                       String tel="보호소 전화번호 : ";
                       listModel.addElement(tel+element.getTextContent());
                    }
                     if(element.getTagName()=="chargeNm"){
                       //str3=element.getTextContent();
                       String name="담당자 : ";
                       listModel.addElement(name+element.getTextContent());
                    }
                      if(element.getTagName()=="officetel"){
                       //str3=element.getTextContent();
                       String officetel="담당자 전화번호 : ";
                       listModel.addElement(officetel+element.getTextContent());
                    }
                    if(element.getTagName()=="processState"){
                       //str6=element.getTextContent();
                       String state = "상태 : ";
                       listModel.addElement(state+element.getTextContent());
                    }
                }
            }
            listModel.addElement(" ");
            listModel.addElement("==================================================================");
            listModel.addElement(" ");
        }
        list.setModel(listModel);
        scrollpane.setViewportView(list);
        //////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
    public void saha(){
        try{
        String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=20170901&endde=20171231&pageNo=1&numOfRows=10000&ServiceKey=D2jrBH0XS98%2FwPf9yMCjve29GyRyoTj8L26%2BsRYrWPJP5%2B1cbEJ0X6ID0%2BqSNmcCvy8Qw06M1kzfiKzTP82jEw%3D%3D&upr_cd=6260000&org_cd=3340000";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        
        Node current = null;
        
         for(int i=0;i<nodelist.getLength();i++){
            current = nodelist.item(i);
            
            NodeList testChildNodes = current.getChildNodes();
            
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="age"){
                       //str1=element.getTextContent();
                       String age = "나이 : ";
                       listModel.addElement(age+element.getTextContent());
                    }
                    if(element.getTagName()=="happenPlace"){
                       //str1=element.getTextContent();
                       String place = "발견 장소 : ";
                       listModel.addElement(place+element.getTextContent());
                    }
                    if(element.getTagName()=="kindCd"){
                       //str2=element.getTextContent();
                       String kind = "품종 : ";
                       listModel.addElement(kind+element.getTextContent());
                    }
                    if(element.getTagName()=="colorCd"){
                       //str4=element.getTextContent();
                       String color="색상 : ";
                      listModel.addElement(color+element.getTextContent());
                    }
                    if(element.getTagName()=="neuterYn"){
                       //str4=element.getTextContent();
                      String neuter="중성화 여부(U : 미상,Y : 아니오,N : 예) : ";
                      listModel.addElement(neuter+element.getTextContent());
                    }
                    if(element.getTagName()=="sexCd"){
                       //str4=element.getTextContent();
                      String sex="성별(M : 수컷,F : 암컷,Q : 미상) : ";
                      listModel.addElement(sex+element.getTextContent());
                    }
                    if(element.getTagName()=="specialMark"){
                       //str2=element.getTextContent();
                       String special="특징 : ";
                       listModel.addElement(special+element.getTextContent());
                    }
                    if(element.getTagName()=="weight"){
                       //str2=element.getTextContent();
                       String weight="몸무게 : ";
                       listModel.addElement(weight+element.getTextContent());
                    }
                     if(element.getTagName()=="noticeSdt"){
                       //str2=element.getTextContent();
                       String sdt="공고시작일 : ";
                       listModel.addElement(sdt+element.getTextContent());
                    }
                      if(element.getTagName()=="noticeEdt"){
                       //str2=element.getTextContent();
                       String edt="공고종료일 : ";
                       listModel.addElement(edt+element.getTextContent());
                    }
                    if(element.getTagName()=="careAddr"){
                       //str3=element.getTextContent();
                       String addr="보호소 주소 : ";
                       listModel.addElement(addr+element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       //str3=element.getTextContent();
                       String nm="보호소 이름 : ";
                       listModel.addElement(nm+element.getTextContent());
                    }
                     if(element.getTagName()=="careTel"){
                       //str3=element.getTextContent();
                       String tel="보호소 전화번호 : ";
                       listModel.addElement(tel+element.getTextContent());
                    }
                     if(element.getTagName()=="chargeNm"){
                       //str3=element.getTextContent();
                       String name="담당자 : ";
                       listModel.addElement(name+element.getTextContent());
                    }
                      if(element.getTagName()=="officetel"){
                       //str3=element.getTextContent();
                       String officetel="담당자 전화번호 : ";
                       listModel.addElement(officetel+element.getTextContent());
                    }
                    if(element.getTagName()=="processState"){
                       //str6=element.getTextContent();
                       String state = "상태 : ";
                       listModel.addElement(state+element.getTextContent());
                    }
                }
            }
            listModel.addElement(" ");
            listModel.addElement("==================================================================");
            listModel.addElement(" ");
        }
        list.setModel(listModel);
        scrollpane.setViewportView(list);
        //////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
    public void seo(){
        try{
        String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=20170901&endde=20171231&pageNo=1&numOfRows=100000000&ServiceKey=D2jrBH0XS98%2FwPf9yMCjve29GyRyoTj8L26%2BsRYrWPJP5%2B1cbEJ0X6ID0%2BqSNmcCvy8Qw06M1kzfiKzTP82jEw%3D%3D&upr_cd=6260000&org_cd=3260000";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        
        Node current = null;
        
        for(int i=0;i<nodelist.getLength();i++){
            current = nodelist.item(i);
            
            NodeList testChildNodes = current.getChildNodes();
            
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="age"){
                       //str1=element.getTextContent();
                       String age = "나이 : ";
                       listModel.addElement(age+element.getTextContent());
                    }
                    if(element.getTagName()=="happenPlace"){
                       //str1=element.getTextContent();
                       String place = "발견 장소 : ";
                       listModel.addElement(place+element.getTextContent());
                    }
                    if(element.getTagName()=="kindCd"){
                       //str2=element.getTextContent();
                       String kind = "품종 : ";
                       listModel.addElement(kind+element.getTextContent());
                    }
                    if(element.getTagName()=="colorCd"){
                       //str4=element.getTextContent();
                       String color="색상 : ";
                      listModel.addElement(color+element.getTextContent());
                    }
                    if(element.getTagName()=="neuterYn"){
                       //str4=element.getTextContent();
                      String neuter="중성화 여부(U : 미상,Y : 아니오,N : 예) : ";
                      listModel.addElement(neuter+element.getTextContent());
                    }
                    if(element.getTagName()=="sexCd"){
                       //str4=element.getTextContent();
                      String sex="성별(M : 수컷,F : 암컷,Q : 미상) : ";
                      listModel.addElement(sex+element.getTextContent());
                    }
                    if(element.getTagName()=="specialMark"){
                       //str2=element.getTextContent();
                       String special="특징 : ";
                       listModel.addElement(special+element.getTextContent());
                    }
                    if(element.getTagName()=="weight"){
                       //str2=element.getTextContent();
                       String weight="몸무게 : ";
                       listModel.addElement(weight+element.getTextContent());
                    }
                     if(element.getTagName()=="noticeSdt"){
                       //str2=element.getTextContent();
                       String sdt="공고시작일 : ";
                       listModel.addElement(sdt+element.getTextContent());
                    }
                      if(element.getTagName()=="noticeEdt"){
                       //str2=element.getTextContent();
                       String edt="공고종료일 : ";
                       listModel.addElement(edt+element.getTextContent());
                    }
                    if(element.getTagName()=="careAddr"){
                       //str3=element.getTextContent();
                       String addr="보호소 주소 : ";
                       listModel.addElement(addr+element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       //str3=element.getTextContent();
                       String nm="보호소 이름 : ";
                       listModel.addElement(nm+element.getTextContent());
                    }
                     if(element.getTagName()=="careTel"){
                       //str3=element.getTextContent();
                       String tel="보호소 전화번호 : ";
                       listModel.addElement(tel+element.getTextContent());
                    }
                     if(element.getTagName()=="chargeNm"){
                       //str3=element.getTextContent();
                       String name="담당자 : ";
                       listModel.addElement(name+element.getTextContent());
                    }
                      if(element.getTagName()=="officetel"){
                       //str3=element.getTextContent();
                       String officetel="담당자 전화번호 : ";
                       listModel.addElement(officetel+element.getTextContent());
                    }
                    if(element.getTagName()=="processState"){
                       //str6=element.getTextContent();
                       String state = "상태 : ";
                       listModel.addElement(state+element.getTextContent());
                    }
                }
            }
            listModel.addElement(" ");
            listModel.addElement("==================================================================");
            listModel.addElement(" ");
        }
        list.setModel(listModel);
        scrollpane.setViewportView(list);
        //////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
    public void suyeong(){
        try{
        String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=20170901&endde=20171231&pageNo=1&numOfRows=100000000&ServiceKey=GHyzWCQL2OQf99J1I3WaDfnpLVG0xcnqeZrSBVYDrVAG4FR2OXDKz21fFNNDlVIF68YD3WG1VB%2B3kEAtOYjXlA%3D%3D&upr_cd=6260000&org_cd=3380000";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        
        Node current = null;
        
         for(int i=0;i<nodelist.getLength();i++){
            current = nodelist.item(i);
            
            NodeList testChildNodes = current.getChildNodes();
            
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="age"){
                       //str1=element.getTextContent();
                       String age = "나이 : ";
                       listModel.addElement(age+element.getTextContent());
                    }
                    if(element.getTagName()=="happenPlace"){
                       //str1=element.getTextContent();
                       String place = "발견 장소 : ";
                       listModel.addElement(place+element.getTextContent());
                    }
                    if(element.getTagName()=="kindCd"){
                       //str2=element.getTextContent();
                       String kind = "품종 : ";
                       listModel.addElement(kind+element.getTextContent());
                    }
                    if(element.getTagName()=="colorCd"){
                       //str4=element.getTextContent();
                       String color="색상 : ";
                      listModel.addElement(color+element.getTextContent());
                    }
                    if(element.getTagName()=="neuterYn"){
                       //str4=element.getTextContent();
                      String neuter="중성화 여부(U : 미상,Y : 아니오,N : 예) : ";
                      listModel.addElement(neuter+element.getTextContent());
                    }
                    if(element.getTagName()=="sexCd"){
                       //str4=element.getTextContent();
                      String sex="성별(M : 수컷,F : 암컷,Q : 미상) : ";
                      listModel.addElement(sex+element.getTextContent());
                    }
                    if(element.getTagName()=="specialMark"){
                       //str2=element.getTextContent();
                       String special="특징 : ";
                       listModel.addElement(special+element.getTextContent());
                    }
                    if(element.getTagName()=="weight"){
                       //str2=element.getTextContent();
                       String weight="몸무게 : ";
                       listModel.addElement(weight+element.getTextContent());
                    }
                     if(element.getTagName()=="noticeSdt"){
                       //str2=element.getTextContent();
                       String sdt="공고시작일 : ";
                       listModel.addElement(sdt+element.getTextContent());
                    }
                      if(element.getTagName()=="noticeEdt"){
                       //str2=element.getTextContent();
                       String edt="공고종료일 : ";
                       listModel.addElement(edt+element.getTextContent());
                    }
                    if(element.getTagName()=="careAddr"){
                       //str3=element.getTextContent();
                       String addr="보호소 주소 : ";
                       listModel.addElement(addr+element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       //str3=element.getTextContent();
                       String nm="보호소 이름 : ";
                       listModel.addElement(nm+element.getTextContent());
                    }
                     if(element.getTagName()=="careTel"){
                       //str3=element.getTextContent();
                       String tel="보호소 전화번호 : ";
                       listModel.addElement(tel+element.getTextContent());
                    }
                     if(element.getTagName()=="chargeNm"){
                       //str3=element.getTextContent();
                       String name="담당자 : ";
                       listModel.addElement(name+element.getTextContent());
                    }
                      if(element.getTagName()=="officetel"){
                       //str3=element.getTextContent();
                       String officetel="담당자 전화번호 : ";
                       listModel.addElement(officetel+element.getTextContent());
                    }
                    if(element.getTagName()=="processState"){
                       //str6=element.getTextContent();
                       String state = "상태 : ";
                       listModel.addElement(state+element.getTextContent());
                    }
                }
            }
            listModel.addElement(" ");
            listModel.addElement("==================================================================");
            listModel.addElement(" ");
        }
        list.setModel(listModel);
        scrollpane.setViewportView(list);
        //////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
    public void yeonje(){
        try{
        String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=20170901&endde=20171231&pageNo=1&numOfRows=100000000&ServiceKey=D2jrBH0XS98%2FwPf9yMCjve29GyRyoTj8L26%2BsRYrWPJP5%2B1cbEJ0X6ID0%2BqSNmcCvy8Qw06M1kzfiKzTP82jEw%3D%3D&upr_cd=6260000&org_cd=3370000";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        
        Node current = null;
        
         for(int i=0;i<nodelist.getLength();i++){
            current = nodelist.item(i);
            
            NodeList testChildNodes = current.getChildNodes();
            
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="age"){
                       //str1=element.getTextContent();
                       String age = "나이 : ";
                       listModel.addElement(age+element.getTextContent());
                    }
                    if(element.getTagName()=="happenPlace"){
                       //str1=element.getTextContent();
                       String place = "발견 장소 : ";
                       listModel.addElement(place+element.getTextContent());
                    }
                    if(element.getTagName()=="kindCd"){
                       //str2=element.getTextContent();
                       String kind = "품종 : ";
                       listModel.addElement(kind+element.getTextContent());
                    }
                    if(element.getTagName()=="colorCd"){
                       //str4=element.getTextContent();
                       String color="색상 : ";
                      listModel.addElement(color+element.getTextContent());
                    }
                    if(element.getTagName()=="neuterYn"){
                       //str4=element.getTextContent();
                      String neuter="중성화 여부(U : 미상,Y : 아니오,N : 예) : ";
                      listModel.addElement(neuter+element.getTextContent());
                    }
                    if(element.getTagName()=="sexCd"){
                       //str4=element.getTextContent();
                      String sex="성별(M : 수컷,F : 암컷,Q : 미상) : ";
                      listModel.addElement(sex+element.getTextContent());
                    }
                    if(element.getTagName()=="specialMark"){
                       //str2=element.getTextContent();
                       String special="특징 : ";
                       listModel.addElement(special+element.getTextContent());
                    }
                    if(element.getTagName()=="weight"){
                       //str2=element.getTextContent();
                       String weight="몸무게 : ";
                       listModel.addElement(weight+element.getTextContent());
                    }
                     if(element.getTagName()=="noticeSdt"){
                       //str2=element.getTextContent();
                       String sdt="공고시작일 : ";
                       listModel.addElement(sdt+element.getTextContent());
                    }
                      if(element.getTagName()=="noticeEdt"){
                       //str2=element.getTextContent();
                       String edt="공고종료일 : ";
                       listModel.addElement(edt+element.getTextContent());
                    }
                    if(element.getTagName()=="careAddr"){
                       //str3=element.getTextContent();
                       String addr="보호소 주소 : ";
                       listModel.addElement(addr+element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       //str3=element.getTextContent();
                       String nm="보호소 이름 : ";
                       listModel.addElement(nm+element.getTextContent());
                    }
                     if(element.getTagName()=="careTel"){
                       //str3=element.getTextContent();
                       String tel="보호소 전화번호 : ";
                       listModel.addElement(tel+element.getTextContent());
                    }
                     if(element.getTagName()=="chargeNm"){
                       //str3=element.getTextContent();
                       String name="담당자 : ";
                       listModel.addElement(name+element.getTextContent());
                    }
                      if(element.getTagName()=="officetel"){
                       //str3=element.getTextContent();
                       String officetel="담당자 전화번호 : ";
                       listModel.addElement(officetel+element.getTextContent());
                    }
                    if(element.getTagName()=="processState"){
                       //str6=element.getTextContent();
                       String state = "상태 : ";
                       listModel.addElement(state+element.getTextContent());
                    }
                }
            }
            listModel.addElement(" ");
            listModel.addElement("==================================================================");
            listModel.addElement(" ");
        }
        list.setModel(listModel);
        scrollpane.setViewportView(list);
        //////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
    public void yeongdo(){
        try{
        String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=20170901&endde=20171231&pageNo=1&numOfRows=100000000&ServiceKey=D2jrBH0XS98%2FwPf9yMCjve29GyRyoTj8L26%2BsRYrWPJP5%2B1cbEJ0X6ID0%2BqSNmcCvy8Qw06M1kzfiKzTP82jEw%3D%3D&upr_cd=6260000&org_cd=3280000";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        
        Node current = null;
        
         for(int i=0;i<nodelist.getLength();i++){
            current = nodelist.item(i);
            
            NodeList testChildNodes = current.getChildNodes();
            
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="age"){
                       //str1=element.getTextContent();
                       String age = "나이 : ";
                       listModel.addElement(age+element.getTextContent());
                    }
                    if(element.getTagName()=="happenPlace"){
                       //str1=element.getTextContent();
                       String place = "발견 장소 : ";
                       listModel.addElement(place+element.getTextContent());
                    }
                    if(element.getTagName()=="kindCd"){
                       //str2=element.getTextContent();
                       String kind = "품종 : ";
                       listModel.addElement(kind+element.getTextContent());
                    }
                    if(element.getTagName()=="colorCd"){
                       //str4=element.getTextContent();
                       String color="색상 : ";
                      listModel.addElement(color+element.getTextContent());
                    }
                    if(element.getTagName()=="neuterYn"){
                       //str4=element.getTextContent();
                      String neuter="중성화 여부(U : 미상,Y : 아니오,N : 예) : ";
                      listModel.addElement(neuter+element.getTextContent());
                    }
                    if(element.getTagName()=="sexCd"){
                       //str4=element.getTextContent();
                      String sex="성별(M : 수컷,F : 암컷,Q : 미상) : ";
                      listModel.addElement(sex+element.getTextContent());
                    }
                    if(element.getTagName()=="specialMark"){
                       //str2=element.getTextContent();
                       String special="특징 : ";
                       listModel.addElement(special+element.getTextContent());
                    }
                    if(element.getTagName()=="weight"){
                       //str2=element.getTextContent();
                       String weight="몸무게 : ";
                       listModel.addElement(weight+element.getTextContent());
                    }
                     if(element.getTagName()=="noticeSdt"){
                       //str2=element.getTextContent();
                       String sdt="공고시작일 : ";
                       listModel.addElement(sdt+element.getTextContent());
                    }
                      if(element.getTagName()=="noticeEdt"){
                       //str2=element.getTextContent();
                       String edt="공고종료일 : ";
                       listModel.addElement(edt+element.getTextContent());
                    }
                    if(element.getTagName()=="careAddr"){
                       //str3=element.getTextContent();
                       String addr="보호소 주소 : ";
                       listModel.addElement(addr+element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       //str3=element.getTextContent();
                       String nm="보호소 이름 : ";
                       listModel.addElement(nm+element.getTextContent());
                    }
                     if(element.getTagName()=="careTel"){
                       //str3=element.getTextContent();
                       String tel="보호소 전화번호 : ";
                       listModel.addElement(tel+element.getTextContent());
                    }
                     if(element.getTagName()=="chargeNm"){
                       //str3=element.getTextContent();
                       String name="담당자 : ";
                       listModel.addElement(name+element.getTextContent());
                    }
                      if(element.getTagName()=="officetel"){
                       //str3=element.getTextContent();
                       String officetel="담당자 전화번호 : ";
                       listModel.addElement(officetel+element.getTextContent());
                    }
                    if(element.getTagName()=="processState"){
                       //str6=element.getTextContent();
                       String state = "상태 : ";
                       listModel.addElement(state+element.getTextContent());
                    }
                }
            }
            listModel.addElement(" ");
            listModel.addElement("==================================================================");
            listModel.addElement(" ");
        }
        list.setModel(listModel);
        scrollpane.setViewportView(list);
        //////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
    public void jung(){
        try{
        String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=20170901&endde=20171231&pageNo=1&numOfRows=100000000&ServiceKey=D2jrBH0XS98%2FwPf9yMCjve29GyRyoTj8L26%2BsRYrWPJP5%2B1cbEJ0X6ID0%2BqSNmcCvy8Qw06M1kzfiKzTP82jEw%3D%3D&upr_cd=6260000&org_cd=3250000";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        
        Node current = null;
        
         for(int i=0;i<nodelist.getLength();i++){
            current = nodelist.item(i);
            
            NodeList testChildNodes = current.getChildNodes();
            
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="age"){
                       //str1=element.getTextContent();
                       String age = "나이 : ";
                       listModel.addElement(age+element.getTextContent());
                    }
                    if(element.getTagName()=="happenPlace"){
                       //str1=element.getTextContent();
                       String place = "발견 장소 : ";
                       listModel.addElement(place+element.getTextContent());
                    }
                    if(element.getTagName()=="kindCd"){
                       //str2=element.getTextContent();
                       String kind = "품종 : ";
                       listModel.addElement(kind+element.getTextContent());
                    }
                    if(element.getTagName()=="colorCd"){
                       //str4=element.getTextContent();
                       String color="색상 : ";
                      listModel.addElement(color+element.getTextContent());
                    }
                    if(element.getTagName()=="neuterYn"){
                       //str4=element.getTextContent();
                      String neuter="중성화 여부(U : 미상,Y : 아니오,N : 예) : ";
                      listModel.addElement(neuter+element.getTextContent());
                    }
                    if(element.getTagName()=="sexCd"){
                       //str4=element.getTextContent();
                      String sex="성별(M : 수컷,F : 암컷,Q : 미상) : ";
                      listModel.addElement(sex+element.getTextContent());
                    }
                    if(element.getTagName()=="specialMark"){
                       //str2=element.getTextContent();
                       String special="특징 : ";
                       listModel.addElement(special+element.getTextContent());
                    }
                    if(element.getTagName()=="weight"){
                       //str2=element.getTextContent();
                       String weight="몸무게 : ";
                       listModel.addElement(weight+element.getTextContent());
                    }
                     if(element.getTagName()=="noticeSdt"){
                       //str2=element.getTextContent();
                       String sdt="공고시작일 : ";
                       listModel.addElement(sdt+element.getTextContent());
                    }
                      if(element.getTagName()=="noticeEdt"){
                       //str2=element.getTextContent();
                       String edt="공고종료일 : ";
                       listModel.addElement(edt+element.getTextContent());
                    }
                    if(element.getTagName()=="careAddr"){
                       //str3=element.getTextContent();
                       String addr="보호소 주소 : ";
                       listModel.addElement(addr+element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       //str3=element.getTextContent();
                       String nm="보호소 이름 : ";
                       listModel.addElement(nm+element.getTextContent());
                    }
                     if(element.getTagName()=="careTel"){
                       //str3=element.getTextContent();
                       String tel="보호소 전화번호 : ";
                       listModel.addElement(tel+element.getTextContent());
                    }
                     if(element.getTagName()=="chargeNm"){
                       //str3=element.getTextContent();
                       String name="담당자 : ";
                       listModel.addElement(name+element.getTextContent());
                    }
                      if(element.getTagName()=="officetel"){
                       //str3=element.getTextContent();
                       String officetel="담당자 전화번호 : ";
                       listModel.addElement(officetel+element.getTextContent());
                    }
                    if(element.getTagName()=="processState"){
                       //str6=element.getTextContent();
                       String state = "상태 : ";
                       listModel.addElement(state+element.getTextContent());
                    }
                }
            }
            listModel.addElement(" ");
            listModel.addElement("==================================================================");
            listModel.addElement(" ");
        }
        list.setModel(listModel);
        scrollpane.setViewportView(list);
        //////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
    public void haeundae(){
        try{
        String strUrl="http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=20170901&endde=20171231&pageNo=1&numOfRows=100000000&ServiceKey=D2jrBH0XS98%2FwPf9yMCjve29GyRyoTj8L26%2BsRYrWPJP5%2B1cbEJ0X6ID0%2BqSNmcCvy8Qw06M1kzfiKzTP82jEw%3D%3D&upr_cd=6260000&org_cd=3330000";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("item");
        
        Node current = null;
        
         for(int i=0;i<nodelist.getLength();i++){
            current = nodelist.item(i);
            
            NodeList testChildNodes = current.getChildNodes();
            
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="age"){
                       //str1=element.getTextContent();
                       String age = "나이 : ";
                       listModel.addElement(age+element.getTextContent());
                    }
                    if(element.getTagName()=="happenPlace"){
                       //str1=element.getTextContent();
                       String place = "발견 장소 : ";
                       listModel.addElement(place+element.getTextContent());
                    }
                    if(element.getTagName()=="kindCd"){
                       //str2=element.getTextContent();
                       String kind = "품종 : ";
                       listModel.addElement(kind+element.getTextContent());
                    }
                    if(element.getTagName()=="colorCd"){
                       //str4=element.getTextContent();
                       String color="색상 : ";
                      listModel.addElement(color+element.getTextContent());
                    }
                    if(element.getTagName()=="neuterYn"){
                       //str4=element.getTextContent();
                      String neuter="중성화 여부(U : 미상,Y : 아니오,N : 예) : ";
                      listModel.addElement(neuter+element.getTextContent());
                    }
                    if(element.getTagName()=="sexCd"){
                       //str4=element.getTextContent();
                      String sex="성별(M : 수컷,F : 암컷,Q : 미상) : ";
                      listModel.addElement(sex+element.getTextContent());
                    }
                    if(element.getTagName()=="specialMark"){
                       //str2=element.getTextContent();
                       String special="특징 : ";
                       listModel.addElement(special+element.getTextContent());
                    }
                    if(element.getTagName()=="weight"){
                       //str2=element.getTextContent();
                       String weight="몸무게 : ";
                       listModel.addElement(weight+element.getTextContent());
                    }
                     if(element.getTagName()=="noticeSdt"){
                       //str2=element.getTextContent();
                       String sdt="공고시작일 : ";
                       listModel.addElement(sdt+element.getTextContent());
                    }
                      if(element.getTagName()=="noticeEdt"){
                       //str2=element.getTextContent();
                       String edt="공고종료일 : ";
                       listModel.addElement(edt+element.getTextContent());
                    }
                    if(element.getTagName()=="careAddr"){
                       //str3=element.getTextContent();
                       String addr="보호소 주소 : ";
                       listModel.addElement(addr+element.getTextContent());
                    }
                    if(element.getTagName()=="careNm"){
                       //str3=element.getTextContent();
                       String nm="보호소 이름 : ";
                       listModel.addElement(nm+element.getTextContent());
                    }
                     if(element.getTagName()=="careTel"){
                       //str3=element.getTextContent();
                       String tel="보호소 전화번호 : ";
                       listModel.addElement(tel+element.getTextContent());
                    }
                     if(element.getTagName()=="chargeNm"){
                       //str3=element.getTextContent();
                       String name="담당자 : ";
                       listModel.addElement(name+element.getTextContent());
                    }
                      if(element.getTagName()=="officetel"){
                       //str3=element.getTextContent();
                       String officetel="담당자 전화번호 : ";
                       listModel.addElement(officetel+element.getTextContent());
                    }
                    if(element.getTagName()=="processState"){
                       //str6=element.getTextContent();
                       String state = "상태 : ";
                       listModel.addElement(state+element.getTextContent());
                    }
                }
            }
            listModel.addElement(" ");
            listModel.addElement("==================================================================");
            listModel.addElement(" ");
        }
        list.setModel(listModel);
        scrollpane.setViewportView(list);
        //////////////////////////////////
     } catch (Exception e) {
	e.printStackTrace();
     }
    }
    
    
}
    

