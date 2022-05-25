/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadWrite;

import DoiTuong.TheLoai;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell 7559
 */
public class TheLoaiFile {
    private static final String THELOAI_FILE_NAME = "theloai.txt";

    //Ghi file
    public void write(List<TheLoai> theLoaiList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(THELOAI_FILE_NAME));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(theLoaiList);
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }
    
    //Doc file
    public List<TheLoai> read(){
        List<TheLoai> theLoaiList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(THELOAI_FILE_NAME));
            ois = new ObjectInputStream(fis);
            theLoaiList = (List<TheLoai>) ois.readObject();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally{
            closeStream(fis);
            closeStream(ois);
        }
        return theLoaiList;
    }
    
    //Close InputStream
    private void closeStream(InputStream is){
        if(is != null){
            try {
                is.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    
    //Close OutputStream
    private void closeStream(OutputStream os){
        if(os != null){
            try {
                os.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
