/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLEncoder;
import javax.swing.ImageIcon;

/**
 *
 * @author 정현진
 */
public class GoogleApi{
     public void downloadMap(String location,String location2){
        try{
            String imageURL="https://maps.googleapis.com/maps/api/staticmap?center="
                    +URLEncoder.encode(location,"UTF-8")+","+URLEncoder.encode(location2,"UTF-8")+"&zoom=17&size=900x900&markers=color:blue%7Clabel:S%7C"+URLEncoder.encode(location,"UTF-8")+","+URLEncoder.encode(location2,"UTF-8")+"&key=AIzaSyAmXqZcDz-JgDGnzu6u4RyPRlYNt-daECo";
            URL url = new URL(imageURL);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(location);
            byte[] b = new byte[2048];
            int length;
            while((length=is.read(b))!=-1){
                os.write(b,0,length);
            }
            is.close();
            os.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        } // 구글 맵 api 받아오는 함수
    public ImageIcon getMap(String location,String location2){ // 얻어오는 함수
        return new ImageIcon(new ImageIcon(location,location2).getImage().getScaledInstance(612,612,java.awt.Image.SCALE_SMOOTH));
    }
    //해당 파일 삭제 함수 
    public void fileDelete(String fileName,String fileName2){
        File f = new File(fileName);
        File f2 = new File(fileName2);
        f.delete();
        f2.delete();
    }
}
