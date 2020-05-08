/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import javax.swing.ImageIcon;
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
public class GoogleApi2 {
    String lat;
     String lng;
     public void downloadMap2(String location){
     try{
            String strUrl="http://maps.googleapis.com/maps/api/geocode/xml?address="+URLEncoder.encode(location,"UTF-8")+"&language=ko&sensor=false";
           
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(strUrl);
        Element rootElement = document.getDocumentElement();
        NodeList nodelist = rootElement.getElementsByTagName("location");
        
        Node current = null;
        
        for(int i=0;i<nodelist.getLength();i++){
            current = nodelist.item(i);
            
            NodeList testChildNodes = current.getChildNodes();
            
            for(int k=0;k<testChildNodes.getLength();k++){
                Node info = testChildNodes.item(k);
                if(info.getNodeType()==Node.ELEMENT_NODE){
                    Element element = (Element) info;
                    if(element.getTagName()=="lat"){
                        lat=element.getTextContent();
                    }
                    if(element.getTagName()=="lng"){
                        lng=element.getTextContent();
                    }
                }
            }
        }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
